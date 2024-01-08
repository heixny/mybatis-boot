package com.gec.service.impl;

import com.gec.domain.*;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.TaskDetailMapper;
import com.gec.mapper.TaskMapper;
import com.gec.mapper.WareTaskMapper;
import com.gec.service.it.InboundService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InboundServiceImpl implements InboundService {
    @Autowired(required = false)
    private WareTaskMapper wareTaskMapper;
    @Autowired(required = false)
    private TaskDetailMapper tdMapper;
    @Autowired(required = false)
    private TaskMapper taskMapper;
    @Override
    public BaseMapper getBaseMap() {
        return wareTaskMapper;
    }
    @Override
    public PageInfo<TaskDetail> getTaskDetailList(PageParam param, Map map) {
//        System.out.println(map.get("service:userName:"));
        Page<TaskDetail> page= PageHelper.startPage(param.getPage(),param.getLimit(),true);
        List<TaskDetail> list=tdMapper.getList(map);
        PageInfo info = new PageInfo(list);
        info.setTotal(page.getTotal());
        return info;
    }

    @Override
    public void commitTask(InWareTask order) {
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
        }
        int c=wareTaskMapper.updateReceiver(orderNo,receiverId,s,setTime);
        updateDetail(orderNo,step);
        System.out.printf("receiverId:%s,nstep:%s,orderNo:%s,count:%s\n",receiverId,s,orderNo,c);
        taskMapper.updateStatus( orderNo, step+1, status, setTime );
        System.out.println("已完成");
    }
    //修改taskdetail的状态
    private void updateDetail(String orderNo, Integer step) {
        List<String> list=new ArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("已打标签");
        list.add("已检验");
        list.add("已上架");
        if (step>2&&step<6){
            String status=list.get(step);
            int c=tdMapper.updateStatus(orderNo,status);
            System.err.println(c);
        }else{
            System.out.println("+------updateDetail-----+");
            System.out.println("WaretaskDetail不在范围内");
            System.out.println("+-----------------------+");
            return;
        }
    }
}
