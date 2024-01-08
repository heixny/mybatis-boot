package com.gec.controller;

import com.gec.domain.Option;
import com.gec.mapper.OptionMapper;
import com.gec.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Option")
public class OptionController extends BaseController<Option>{
    @Autowired(required = false)
    private OptionMapper mapper;

    @RequestMapping(value="/getMS")
    public Map getMS() {
        List<Option> list=null;
        Option option=null;
        try {
            System.out.println("+----------27");
            list=mapper.getmsOptions();
            for (Option op:list
                 ) {
                System.out.println(op);
            }
            return sendData(list);
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping(value="/getMG")
    public Map getMG() throws Exception {
        List<Option> list=null;
        try {
            list=mapper.getmgOptions();
            return sendData(list);
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping(value="/getMT")
    public Map getMT() throws Exception {
        List<Option> list=null;
        try {
            list=mapper.getmtOptions();
            return sendData(list);
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getwaretype")
    public Map getwaretypeOptions() throws Exception {
        List<Option> list=null;
        try {
            list=mapper.getwaretypeOptions();
            return sendData(list);
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getware")
    public Map getwareOptions() throws Exception{
        List<Option> list=null;
        try{
            list = mapper.getwareOptions();
            return sendData(list);
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getarea")
    public Map getareaOptions() throws Exception{
        List<Option> list=null;
        try{
            list = mapper.getareaOptions();
            return sendData(list);
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getposition")
    public Map getpositionOptions() throws Exception{
        List<Option> list=null;
        try{
            list = mapper.getpositionOptions();
            return sendData(list);
        }catch(Exception e){
            e.printStackTrace();
            return sendError(e);
        }
    }
    @Override
    protected BaseService<Option> getService() {
        return null;
    }
}
