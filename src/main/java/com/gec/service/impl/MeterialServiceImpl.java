package com.gec.service.impl;

import com.gec.domain.Meterial;
import com.gec.domain.PageParam;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.DeptMapper;
import com.gec.mapper.MeterialMapper;
import com.gec.service.it.DeptService;
import com.gec.service.it.MeterialService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MeterialServiceImpl implements MeterialService {
    @Autowired(required = false)
    private MeterialMapper mapper;


    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }

    @Override
    public void saveMeterial(Meterial meterial) {
        String id=meterial.getId();
        System.out.println("id:"+id+",length:"+id.length());
        if(id!=null&&id.length()!=0) {
            mapper.updateMeterial(meterial);
        }else {
//            meterial.setId(createUUID(8));
            String nid= String.valueOf(mapper.getlastIndex()+1);
            System.out.println(nid);
            meterial.setId(nid);
            int c=mapper.addMeterial(meterial);
        }
    }

    @Override
    public void delMeterial(String id) {
        if(id!=null) {
            int c=mapper.delMeterial(id);
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public PageInfo<Meterial> getMeterialList(PageParam param, Map map) {
        System.out.println(map.get("service:userName:"));
        Page<Meterial> page= PageHelper.startPage(param.getPage(),param.getLimit(),true);
        List<Meterial> list=mapper.getMeterialList(map);
        PageInfo info = new PageInfo(list);
        info.setTotal(page.getTotal());
        return info;
    }

}
