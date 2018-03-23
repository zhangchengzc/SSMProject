package com.security.simulation;

import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 网络资产信息
 * Created by zhangcheng on 2018/3/6.
 */
public class NetAsset implements CSVoperation{

    private String[] csvHeaders = {"country","city","device_type","os","online_time","last_update","link_state"};
    private String[] city = {"北京","上海","广州","深圳","天津","杭州","南京","济南","重庆","青岛","大连","宁波","厦门","成都","武汉","哈尔滨","沈阳","西安","石家庄","苏州","东莞","无锡","太原","长沙"};
    private String[] device = {"服务器","主机"};
    private Double[] deviceRatio = {0.2,0.8};
    private String[] system = {"Windows","Linux","Unix"};
    private Double[] systemRatio = {0.4,0.5,0.1};
    private String[] state = {"可访问","不可访问"};
    private Double[] stateRatio = {0.9,0.1};


    public static void main(String[] args) {
    }
    @Override
    public void writeCSV(String csvFilePath, long num) {
        try{
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            csvWriter.writeRecord(csvHeaders);
            List<Double> listSystemRatio = Arrays.asList(systemRatio);
            List<Double> listDeviceRatio = Arrays.asList(deviceRatio);
            List<Double> listStateRatio = Arrays.asList(stateRatio);
            RandomOnScale randomOnScale_system = new RandomOnScale();
            randomOnScale_system.setList(listSystemRatio);
            RandomOnScale randomOnScale_device = new RandomOnScale();
            randomOnScale_device.setList(listDeviceRatio);
            RandomOnScale randomOnScale_state = new RandomOnScale();
            randomOnScale_state.setList(listStateRatio);
            Random random = new Random(47);
            long count = 0;
            while(count < num)
            {
                String[] csvContent = {"中国",city[random.nextInt(city.length)],device[randomOnScale_device.getRandomOrder()],system[randomOnScale_system.getRandomOrder()],
                                        DateRandom.randomDate("2015-01-01","2016-06-06"),DateRandom.randomDate("2016-10-10","2018-03-20"),
                                        state[randomOnScale_state.getRandomOrder()]};
                csvWriter.writeRecord(csvContent);
                ++count;
            }
            csvWriter.close();
            System.out.println("--------网络资产信息生成完毕--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
