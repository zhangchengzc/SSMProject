package com.security.simulation;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by zhangcheng on 2017/12/6.
 */
public interface CSVoperation {


    /**
     * 写入CSV
     * @param csvFilePath csv保存路径
     * @param num 模拟数据个数
     */
    void writeCSV(String csvFilePath, long num);

    /**
     * 读取CSV
     */
    static void readCSV(String csvFilePath, Map<String, String> map) {
        try {
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            //reader.readHeaders();
            // 逐行读入除表头的数据
            while (reader.readRecord()) {
                String raw = reader.getRawRecord();
                map.put(raw.substring(0,raw.indexOf(',')),raw.substring(raw.indexOf(',')+1,raw.length()));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
