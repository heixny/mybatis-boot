package com.gec.controller;

import com.gec.domain.Dept;
import com.gec.domain.PageParam;
import com.gec.service.impl.BaseService;
import com.gec.service.it.DeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Dept")
public class DeptController extends BaseController<Dept>{
    @Autowired
    private DeptService service;

    @Override
    public Map list(Map map) {
        return super.list(map);
    }

    @Override
    protected BaseService<Dept> getService() {
        return service;
    }
}
