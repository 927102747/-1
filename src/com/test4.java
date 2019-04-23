package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test4 {
    private static final String ACCESS_SECRET = "accessSecret"; //公钥： "123456"

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("accessKey","key");
        params.put("name","xhr");

        String sign = createSign(params, "123456");
        System.out.println("sign = " + sign);
    }

    private static String createSign(Map<String, Object> params, String accessSecret){
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        //把key从小到大排序
        Arrays.sort(keys);
        StringBuilder temp = new StringBuilder();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            temp.append(valueString);
        }
        temp.append("&").append(ACCESS_SECRET).append("=").append(accessSecret);
        return MD5.md5(temp.toString()).toUpperCase();
    }
}
