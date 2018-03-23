package com.security.simulation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 按比例随机生成数据
 * Created by zhangcheng on 2018/3/6.
 */
@Data
public class RandomOnScale {
    List<Double> list;

    /**
     * 按比例模拟数据
     * @return
     */
    public int getRandomOrder(){
        BigDecimal sum = new BigDecimal(0);
        BigDecimal random = BigDecimal.valueOf(Math.random());
        int i = 0;
        for(i = 0;i<list.size();++i)
        {
            if(sum.compareTo(random) <= 0 && sum.add(BigDecimal.valueOf(list.get(i))).compareTo(random) >0)
            {
                break;
            }
            sum = sum.add(BigDecimal.valueOf(list.get(i)));
        }
        return i;
    }
}
