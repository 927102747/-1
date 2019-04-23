package com;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class test2 {

     private static Map<String, String> map = new ConcurrentHashMap<>();

    static {
        // 加载key映射到内存里面
        try {
            InputStream data = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\xxx.properties")));
            Properties properties = new Properties();
            properties.load(data);
            for (Object key : properties.keySet()) {
                map.put(String.valueOf(key), properties.getProperty(String.valueOf(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("---------------------------------");
            }
            System.out.println(map.size());
            System.out.println(map.get("timestamp"));
    }
}
