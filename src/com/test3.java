package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test3 {

    public static void main(String[] args) {
        String temp = "accessKey=key&accessSecret=123456";
        String s = MD5.md5(temp.toString()).toUpperCase();
        System.out.println("s = " + s);
    }

    public static void main1(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("timestamp","1555985399");
        params.put("accessKey","key");
        params.put("sign","xuhaoran");

        Set<String> keysSet = params.keySet();
        System.out.println(keysSet);
        Object[] keys = keysSet.toArray();
        System.out.println(Arrays.toString(keys));
        Arrays.sort(keys);
        System.out.println(Arrays.toString(keys));


    }
}
