package com.imooc.utils;

import java.util.Random;

/**
 * Created by jason on 2019/4/24.
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式 时间+随机数
     */

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        String key = System.currentTimeMillis() + String.valueOf(num);
        return key;

    }
}
