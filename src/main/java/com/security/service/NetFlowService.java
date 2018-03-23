package com.security.service;

import com.security.bean.NetFlowDO;

import java.util.List;

/**
 * Created by zhangcheng on 2018/3/14.
 */
public interface NetFlowService {

    List<NetFlowDO> listNetFlowBySourceIP(String sourceIP);

    void insertNetFlow(int num);
}
