package com.gec;

import com.gec.domain.*;
import com.gec.mapper.*;
import com.gec.service.impl.InboundServiceImpl;
import com.gec.service.impl.MeterialTypeServiceImpl;
import com.gec.service.it.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MybatisTest {
//    @Autowired(required = false)
//    private DeptMapper mapper;
    @Autowired(required = false)
    private RequestService service;
    @Autowired(required = false)
    private ProcConfigMapper configMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private TaskMapper taskMapper;
    @Autowired(required = false)
    private TaskDetailMapper mapper;
    @Autowired(required = false)
    private InboundServiceImpl IBservice;
    @Autowired(required = false)
    private MeterialTypeServiceImpl mtservice;
    @Test
    public void test(){
//        InWareOrder order =getOrder();
//        service.commitTask(order);
//        testProc();
//        commitTask("订单号",2);
//        service.commitTask("订单号",4);
//        TaskDetail taskDetail=new TaskDetail(getDetail());
//        int c=mapper.addTaskDetail(taskDetail);
//        System.out.println("已完成,"+c);
//        service.startproc(getOrder(),"入库流程");
//        RandomNo();
//        InWareTask order=takeTask();
//        IBservice.commitTask(order);
//        int[] a={9,3,4,8,15,2,6,4};
//        Insertsort(a);
//        mtservice.delMeterialType("9");
    }

    private MeterialType takeTask() {
        MeterialType order =new MeterialType();
//        order.setId("8");
//        order.setTypeNo("MT0008");
        order.setTypeName("sssxxx");
        order.setRuleNo("SX");
        return order;
    }
    private void Insertsort(int[] a){
        //从第二个到最后一个
        for(int i=1;i<a.length;i++){
            //index和value
            int v=a[i];
            int j=i;
            //一直向前比较
            while(j>=1){
                if(v<a[j-1]){
                    a[j]=a[j-1];
                    j--;
                }else{
                    break;
                }
            }
            a[j]=v;
            System.out.println(Arrays.toString(a)+"   "+j);
        }
    }
    public static void main(String[] args) {

    }
    private String RandomNo() {
        String code="";
        for (int i=0;i<5;i++){
            int c= (int) Math.floor(Math.random()*9);
            code+=c;
            System.out.println("code"+code);
        }
        String orderNo="IWT"+code;
        System.out.println("orderNo:"+orderNo);
        return orderNo;
    }
    private InWareDetail getDetail(){
        InWareDetail detail=new InWareDetail();
        detail.setOrderNo("IWSD00002");
        detail.setMeterialNo("MT000051");
        detail.setCount("60");
        detail.setUnit("卷");
        return detail;
    }

    private InWareOrder getOrder(){
        InWareOrder order = new InWareOrder();
        order.setId("7");
        order.setOrderNo("IWOND0002");
        order.setReceiverId("u02");
        order.setStep(3);

        return order;
    }
    public void commitTask(
            String orderNo, Integer step ){
        OrderTask task = taskMapper.getTask(
                orderNo, step+1 );
        if( task==null ){
            System.out.println("{PROC} 已经到达到最终节点..");
            return;
        }
        taskMapper.updateStatus( orderNo, step, "已完成", "true" );
        String ndType = task.getNodeType();
        String status = "进行中";
        if( "end".equals(ndType) ){
            status = "已完成";   //判断下一个节点是不是 end ---> 已完成
//            onFinished();
        }
        taskMapper.updateStatus( orderNo, step+1, status, "false" );
    }
    private List<OrderTask> covertTask(User user, List<ProcConfig> configs){
        String deptId = user.getDept().getId();
        List list=new ArrayList();
        for (ProcConfig c : configs) {
            OrderTask task;
            String assingee = "sys";
            if (c.getNodeType().equals("userTask")) {
                assingee = getAssingee(c, deptId, user.getId());
                System.out.println("deptId:"+deptId+",config:"+c.getRoleId());
            }
            task = c.toOrderTask(assingee, "订单号");
            System.out.println(task);
            list.add(task);
        }
        return list;
    }
    @Test
    void testProc(){
        List<ProcConfig> configs = configMapper
                .getProcByName("入库流程");
        User user = getUser();     //获取登录的用户..
        List<OrderTask> list = covertTask(user, configs);
        list.forEach(item-> System.out.println(item));
//        int count = taskMapper.initTask(list);
//        System.out.println("count="+ count);
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
    public User getUser(){
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
}
