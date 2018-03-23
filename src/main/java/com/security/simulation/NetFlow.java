package com.security.simulation;


import com.csvreader.CsvWriter;
import com.security.bean.NetFlowDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 网络流量信息
 * Created by zhangcheng on 2018/3/6.
 */
public class NetFlow implements CSVoperation {

    private String[] csvHeaders = {"date","protocol_type","duration","source_ip","source_port","dest_ip","dest_port","source_send_byte","dest_send_byte"};
    private String[] protocolType = {"TCP","UDP","DCCP","TLS"};
    private Double[] protocolScale = {0.4,0.4,0.1,0.1};


    @Override
    public void writeCSV(String csvFilePath,long num)
    {
        try {
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            csvWriter.writeRecord(csvHeaders);
            List<Double> listProtocolScale = Arrays.asList(protocolScale);
            RandomOnScale randomOnScale = new RandomOnScale();
            randomOnScale.setList(listProtocolScale);
            long count = 0;
            Random random = new Random(47);

            while(count < num)
            {
                String[] csvContent = {DateRandom.randomDate("2016-01-01","2018-03-24"),protocolType[randomOnScale.getRandomOrder()],
                                        String.valueOf(random.nextInt(1000)),IPSimulation.getIP(),String.valueOf(random.nextInt(3796)+1024),
                                        IPSimulation.getIP(),String.valueOf(random.nextInt(3796)+1024),random.nextInt(1024)+"",random.nextInt(1024)+""};

                ++count;
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("--------网络流量信息生成完毕--------");


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
