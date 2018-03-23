package com.security.dao;

import com.security.bean.NetFlowDO;
import java.util.List;


public interface NetFlowDOMapper {
    List<NetFlowDO> listNetFlowBySourceIP(String sourceIP);

    void insertNetFlow(List<String[]> list);
}