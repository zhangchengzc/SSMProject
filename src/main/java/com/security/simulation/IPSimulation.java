package com.security.simulation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 随机生成IP
 * Created by zhangcheng on 2018/3/6.
 */
public class IPSimulation {

    //各省IP占比
    public static Double[] ipScale = {0.061642488, 0.032978933, 0.028366847, 0.033610698, 0.02355292, 0.033158572, 0.03081317, 0.021197427, 0.003612968, 0.018702662, 0.01016879, 0.007209789, 0.020717043, 0.007952567, 0.058402927, 0.020176107, 0.00142904, 0.043899584, 0.014278289, 0.00278138, 0.021286237, 0.007270342, 1.93768E-4, 0.034575501, 0.015182541, 0.059213322, 0.011504983, 0.009970985, 0.037223666, 0.125697994, 0.001715655, 0.201512804};
    //各省ip前缀
    public static String[] ip = {"27.192", "112.111", "120.0", "115.48", "42.50", "27.16", "223.144", "106.224", "233.198", "1.56", "117.8", "1.204", "1.80", "49.112", "49.64", "117.57", "101.248", "180.160", "122.136", "14.134", "223.8", "59.76", "183.182", "182.128", "222.218", "183.128", "182.240", "1.24", "175.160", "60.205", "223.220", "202.112"};
    //各省名称
    public static String[] location = {"山东", "福建", "河北", "河南", "重庆", "湖北", "湖南", "江西", "海南", "黑龙江", "天津", "贵州", "陕西", "新疆", "江苏", "安徽", "西藏", "上海", "吉林", "宁夏", "山西", "甘肃", "香港", "四川", "广西", "浙江", "云南", "内蒙古", "辽宁", "广东", "青海", "北京"};
    /**
     * 生成IP
     * @return
     */
    public static String getIP()
    {
        //省名
        List<String> listLoaction = Arrays.asList(location);

        List<Double> listIPscale = Arrays.asList(ipScale);
        List<String> listIP = Arrays.asList(ip);
        RandomOnScale randomOnScale = new RandomOnScale();
        randomOnScale.setList(listIPscale);
        int num = randomOnScale.getRandomOrder();
        Random random = new Random();
        return listIP.get(num) + "." + random.nextInt(100) + "." + random.nextInt(100);

    }

}
