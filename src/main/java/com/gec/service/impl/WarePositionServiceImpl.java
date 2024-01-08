package com.gec.service.impl;

import com.gec.domain.WarePosition;
import com.gec.domain.Workarea;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.WarePositionMapper;
import com.gec.mapper.WorkareaMapper;
import com.gec.service.it.WarePositionService;
import com.gec.service.it.WorkareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarePositionServiceImpl implements WarePositionService {
    @Autowired(required = false)
    private WarePositionMapper mapper;

    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }

    @Override
    public void saveWarePosition(WarePosition pos) {
        String id=pos.getId();
        if (id!=null&&id.length()!=0){
            mapper.updateWarePosition(pos);
        }else{
            int ID = mapper.getWarePositionById();
            String gp = getno(ID + 1, 4, "WPOS");
            pos.setPositionNo(gp);
            mapper.addWarePosition(pos);
        }
    }

    @Override
    public void delWarePosition(String id) {
        if(id!=null&&id.length()!=0) {
            int c=mapper.delWarePosition(id);
        }else {
            throw new RuntimeException("删除失败");
        }
    }
}
