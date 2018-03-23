package com.security.service.impl;

import com.security.bean.NetFlowDO;
import com.security.dao.NetFlowDOMapper;
import com.security.service.NetFlowService;
import com.security.simulation.DateRandom;
import com.security.simulation.IPSimulation;
import com.security.simulation.RandomOnScale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangcheng on 2018/3/14.
 */
@Service
public class NetFlowServiceImpl implements NetFlowService {
    @Autowired
    NetFlowDOMapper netFlowDOMapper;

    private String[] csvHeaders = {"date","protocol_type","duration","source_ip","source_port","dest_ip","dest_port","source_send_byte","dest_send_byte"};
    private String[] protocolType = {"TCP","UDP","DCCP","TLS"};
    private Double[] protocolScale = {0.4,0.4,0.1,0.1};

    @Override
    public List<NetFlowDO> listNetFlowBySourceIP(String sourceIP) {
        return netFlowDOMapper.listNetFlowBySourceIP(sourceIP);
    }

    @Override
    public void insertNetFlow(int num) {
        List<Double> listProtocolScale = Arrays.asList(protocolScale);
        RandomOnScale randomOnScale = new RandomOnScale();
        randomOnScale.setList(listProtocolScale);
        long count = 0;
        Random random = new Random(47);

        List<String[]> list = new ArrayList<>();
        while(count < num)
        {
           /* NetFlowDO netFlowDO = new NetFlowDO();
            netFlowDO.setDate(DateRandom.randomDate("2016-01-01","2018-03-24"));
            netFlowDO.setProtocolType(protocolType[randomOnScale.getRandomOrder()]);
            netFlowDO.setDuration(String.valueOf(random.nextInt(1000)));
            netFlowDO.setSourceIp(IPSimulation.getIP());
            netFlowDO.setSourcePort(String.valueOf(random.nextInt(3796)+1024));
            netFlowDO.setDestIp(IPSimulation.getIP());
            netFlowDO.setDestPort(String.valueOf(random.nextInt(3796)+1024));
            netFlowDO.setSourceSendByte(random.nextInt(1024)+"");
            netFlowDO.setDestSendByte(random.nextInt(1024)+"");*/
            String[] csvContent = {DateRandom.randomDate("2016-01-01","2018-03-24"),protocolType[randomOnScale.getRandomOrder()],
                                    String.valueOf(random.nextInt(1000)),IPSimulation.getIP(),String.valueOf(random.nextInt(3796)+1024),
                                    IPSimulation.getIP(),String.valueOf(random.nextInt(3796)+1024),random.nextInt(1024)+"",random.nextInt(1024)+""};
            list.add(csvContent);
            ++count;
            //csvWriter.writeRecord(csvContent);
        }
        netFlowDOMapper.insertNetFlow(list);
    }
}
