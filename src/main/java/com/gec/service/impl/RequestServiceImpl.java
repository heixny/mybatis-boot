package com.gec.service.impl;

import com.gec.domain.*;
import com.gec.mapper.*;
import com.gec.service.it.RequestService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Autowired(required = false)
    private TaskMapper taskMapper;

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private ProcConfigMapper configMapper;
    @Autowired(required = false)
    private WareTaskMapper wareTaskMapper;
    //写完security弄User入参
    @Override
    public void startproc(InWareOrder order,String procName) {
        List<ProcConfig> configs = configMapper
                .getProcByName(procName);
        configs.forEach(item-> System.out.println(item));
        //获取登录的用户..
        System.out.println("procName:"+procName);
        User user = getUser(procName);
        List<OrderTask> list = covertTask(user, configs,order.getOrderNo());
        int count = taskMapper.initTask(list);
        commitTask(order.getOrderNo(),2);
        System.out.println("count="+ count);
        System.out.println(order);
        //添加入order表
        getleaderId(order);
        if (procName.equals("入库申请流程")){
            orderMapper.addOrder(order);
        }else if (procName.equals("入库流程")){
            OrderTask task = taskMapper.getTask(order.getOrderNo(), 3);
            String receiverId=task.getAssigneeId();
            InWareTask wareTask=new InWareTask(order);
            wareTask.setReceiverId(receiverId);
            wareTask.setStep(3);
            wareTaskMapper.addWareTask(wareTask);
        }else{
            System.out.println("没有该流程");
        }
    }

    @Override
    public void commitTask( String orderNo, Integer step) {
        OrderTask task = taskMapper.getTask(
                orderNo, step+1 );
        if( task==null ){
            System.out.println("{PROC} 已经到达到最终节点..");
            return;
        }
        taskMapper.updateStatus( orderNo, step, "已完成", "true" );
        String ndType = task.getNodeType();
        String status = "进行中";
        String receiverId=task.getAssigneeId();
        String setTime="false";
        Integer s=step+1;

        if( "end".equals(ndType) ){
            status = "已完成";   //判断下一个节点是不是 end ---> 已完成
//            onFinished();
            receiverId=null;
            setTime="true";
            s=null;
        }
        int c=orderMapper.updateReceiver(orderNo,receiverId,s,setTime);
        System.out.printf("receiverId:%s,nstep:%s,orderNo:%s,count:%s",receiverId,s,orderNo,c);
        taskMapper.updateStatus( orderNo, step+1, status, setTime );
    }

//    private OrderTask getTask(InWareOrder order) {
//        OrderTask task = new OrderTask();
//        task.setInwareOrderNo(order.getOrderNo());
//        task.setStep(order.getStep());
//        task.setStatus("已完成");
//        return task;
//    }
    public User getUser(String procName){
        //可以去数据库读取User
        if (procName.equals("入库申请流程")){
            User user = new User("u01,andy,安迪,男,no1");
            Dept dept=new Dept("d08","采购部");
            user.setDept(dept);
            Role role = new Role("r05", "职员");
            user.addRole(role);
            System.out.println(user);
            System.out.println(user.getDept());
            System.out.println(user.PrimaryRole());
            return user;
        }else if (procName.equals("入库流程")){
            User user = new User("u07,tony,托尼,男,no1");
            Dept dept=new Dept("d07","物流部");
            user.setDept(dept);
            Role role = new Role("r05", "职员");
            user.addRole(role);
            System.out.println(user);
            System.out.println(user.getDept());
            System.out.println(user.PrimaryRole());
            return user;
        }
        System.out.println("User为空");
        return null;
    }
    private void getleaderId(InWareOrder order) {
        User user=userMapper.getUserById(order.getInputerId());
        User leader=userMapper.getLeader(user.getDeptId(),"r02");
        order.setReceiverId(leader.getId());
    }
    //初始化任务
    private List<OrderTask> covertTask(User user, List<ProcConfig> configs,String orderNo){
        //如果把获取User写活，记得写成getDeptId
        String deptId = user.getDept().getId();
        List list=new ArrayList();
        for (ProcConfig c : configs) {
            OrderTask task;
            String assingee = "sys";
            if (c.getNodeType().equals("userTask")) {
                assingee = getAssingee(c, deptId, user.getId());
            }
            task = c.toOrderTask(assingee, orderNo);
            System.out.println(task);
            list.add(task);
        }
        return list;
    }
    private String getAssingee(
            ProcConfig config,
            String deptId, String initatorId) {
        String selectDept = config.getDeptId();
        if ( config.getStep()==2 ){
            return initatorId;
        }
        if ( selectDept.equals("follow") ){
            selectDept = deptId;
        }
        User user=userMapper.getLeader(
                selectDept, config.getRoleId() );
        return user.getId();
    }
}
