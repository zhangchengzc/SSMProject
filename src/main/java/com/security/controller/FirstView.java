package com.security.controller;

import com.security.bean.NetFlowDO;
import com.security.service.NetFlowService;
import com.security.simulation.NetFlow;
import com.security.simulation.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangcheng on 2018/2/8.
 */
@Controller
public class FirstView {

    @Autowired
    NetFlowService netFlowService;

    NetFlow netFlow;

    @RequestMapping("/index")
    public void index() throws InterruptedException {

        Date date = new Date();
        netFlowService.insertNetFlow(10000);
        Date date1 = new Date();
        System.out.println(date1.getTime() - date.getTime() + "ms");

        //return new ModelAndView("/index");
    }
}
