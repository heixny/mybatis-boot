package com.gec.service.impl;

import com.gec.domain.*;
import com.gec.mapper.*;
import com.gec.service.it.ReceiptService;
import com.gec.service.it.RequestService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired(required = false)
    private DetailMapper detailMapper;
    @Autowired(required = false)
    private TaskMapper taskMapper;
    @Autowired(required = false)
    private WareTaskMapper wareTaskMapper;
    @Autowired(required = false)
    private TaskDetailMapper tdMapper;
    @Autowired
    private RequestService requestService;
    @Override
    public BaseMapper getBaseMap() {
        return orderMapper;
    }

    @Override       //InWareOrder order
    public void commitTask(InWareOrder order) {
        String orderNo=order.getOrderNo();
        Integer step=order.getStep();
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
            //创建入库任务
            initwareTask(order);
        }
        int c=orderMapper.updateReceiver(orderNo,receiverId,s,setTime);
        System.out.printf("receiverId:%s,nstep:%s,orderNo:%s,count:%s\n",receiverId,s,orderNo,c);
        taskMapper.updateStatus( orderNo, step+1, status, setTime );
    }

    private void initwareTask(InWareOrder order) {
        List<InWareDetail> list = detailMapper.getDetail(order.getOrderNo());

        order.setOrderNo(RandomNo());
//        InWareTask wareTask=new InWareTask(order);
//        System.out.println(wareTask);
//        int c=wareTaskMapper.addWareTask(wareTask);
//        System.out.printf("{InWareTask}完成%d条记录\n",c);
        for (InWareDetail detail:list) {
            detail.setOrderNo(order.getOrderNo());
            TaskDetail taskDetail=new TaskDetail(detail);
            tdMapper.addTaskDetail(taskDetail);
        }
        //创建任务
        requestService.startproc(order,"入库流程");
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

    @Override
    public void refuseTask(String orderNo, Integer step) {
        taskMapper.updateStatus( orderNo, step, "已拒绝", "true" );
        orderMapper.updateReceiver(orderNo,null,null,"false");
    }

    @Override
    public PageInfo<InWareOrder> getMyorderList(PageParam param, Map map) {
//        System.out.println(map.get("service:userName:"));
        Page<InWareOrder> page= PageHelper.startPage(param.getPage(),param.getLimit(),true);
        List<InWareOrder> list= orderMapper.getMyorderList(map);
        PageInfo info = new PageInfo(list);
        info.setTotal(page.getTotal());
        return info;
    }

}
