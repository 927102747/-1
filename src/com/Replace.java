package com;

import java.io.*;
import java.util.Map;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2019/4/11.
 */
public class Replace {

    public static void main(String[] args) {
        String guidFile = "C:\\Users\\Administrator\\Desktop\\guid.txt";
        String jsonFile = "C:\\Users\\Administrator\\Desktop\\27.txt";
        boolean b = writeFile(guidFile,jsonFile);
        System.out.println("b = " + b);
    }

    public static boolean writeFile(String guidFile,String jsonFile){
        File f = new File("newFile.txt");
        BufferedWriter bw = null;

        try {
            bw =new BufferedWriter(new FileWriter(f));
            bw.write(replace(guidFile, jsonFile));
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String replace(String guidFile,String jsonFile){
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        String json = "";
        String str1 = null;
        String str2 = null;

        try {
            br1 = new BufferedReader(new FileReader(guidFile));
            br2 = new BufferedReader(new FileReader(jsonFile));


            while ((str1 = br1.readLine()) != null && (str2 = br2.readLine()) != null) {
                Map<String, Object> parse = JSONObject.fromObject(str2);
                Map<String, Object> agent = (Map<String, Object>) parse.get("agent");
                String agentName = agent.get("name") + "";
                String replace = str2.replace(agentName, str1);
                json = json + replace + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件异常");
        } finally {
            try {
                br1.close();
                br2.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关流异常");
            }
        }
        return json;
    }
}










