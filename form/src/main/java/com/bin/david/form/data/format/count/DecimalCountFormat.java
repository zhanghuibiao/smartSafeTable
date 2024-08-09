package com.bin.david.form.data.format.count;

import java.math.BigDecimal;

/**
 * Created by huang on 2017/11/6.
 */

public class DecimalCountFormat<T> implements ICountFormat<T,Double> {

    private double  totalDoubleCount =0;


    @Override
    public void count(T t) {
         Number number = (Number) t;
         if(number instanceof Double){
            totalDoubleCount+=number.doubleValue();
        }else if(number instanceof Float){
            totalDoubleCount+=number.floatValue();
        }
    }

    @Override
    public Double getCount() {

        return totalDoubleCount;
    }


    @Override
    public String getCountString() {
        BigDecimal b = new BigDecimal(totalDoubleCount);
        //保留2位小数
        double result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(result);
    }

    @Override
    public void clearCount() {
        totalDoubleCount = 0.0;
    }
}
