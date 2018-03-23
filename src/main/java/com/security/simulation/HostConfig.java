package com.security.simulation;

import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 主机配置信息
 * Created by zhangcheng on 2018/3/6.
 */
public class HostConfig implements CSVoperation{
    private String[] csvHeaders = {"host_name","os","install_time","start_time","bios_version","core_type","memory_size","patch"};
    private String[] system = {"Windows","Linux","Unix"};
    private Double[] systemRatio = {0.4,0.5,0.1};
    private String[] bios = {"Award BIOS","AMI BIOS","Phoenix BIOS","Insyde","BYOSOFT"};
    private Double[] biosRatio = {0.5,0.2,0.1,0.1,0.1};
    private String[] processor = {"Core i3-540","Core i3-550","Core i5-670","Core i5-750","Core i7-920","Core i7-950","Core i7-975EE","Core i7-990XEE","Sempron LE-1100","Sempron LE-1200","Athlon 3500+","Athlon LE-1660","Athlon X2 4600+","Athlon X2 5000+BE","Phenom X3 8250e","Phenom X4 9950 BE","Pentium D925"};
    private Integer[] memory = {2,4,8,12};
    private Double[] memoryRatio = {0.1,0.4,0.4,0.1};


    @Override
    public void writeCSV(String csvFilePath, long num) {
        try {
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            csvWriter.writeRecord(csvHeaders);
            String str="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder pcName = new StringBuilder();
            pcName.append("PC-");
            Random random = new Random(47);
            //设置system权重
            List<Double> listSystemRatio = Arrays.asList(systemRatio);
            RandomOnScale random_system = new RandomOnScale();
            random_system.setList(listSystemRatio);
            //设置bios权重
            List<Double> listBiosRatio = Arrays.asList(biosRatio);
            RandomOnScale random_bios = new RandomOnScale();
            random_bios.setList(listBiosRatio);
            //设置内存权重
            List<Double> listMemoryRatio = Arrays.asList(memoryRatio);
            RandomOnScale random_memory = new RandomOnScale();
            random_memory.setList(listMemoryRatio);

            int count = 0;
            while(count < num)
            {
                for(int i=0;i<5;++i){
                    pcName.append(str.charAt(random.nextInt(str.length())));
                }

                String[] csvContent = {pcName.toString(),system[random_system.getRandomOrder()],DateRandom.randomDate("2014-01-01","2016-05-05"),
                                        DateRandom.randomDate("2018-03-16","2018-03-20"),bios[random_bios.getRandomOrder()],
                                        processor[random.nextInt(processor.length)],memory[random_memory.getRandomOrder()]+"G","无"};

                ++count;
                csvWriter.writeRecord(csvContent);
                pcName.delete(pcName.indexOf("-")+1,pcName.length());
            }
            csvWriter.close();
            System.out.println("--------主机配置信息生成完毕--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
