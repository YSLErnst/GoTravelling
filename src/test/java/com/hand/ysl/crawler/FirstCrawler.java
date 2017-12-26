package com.hand.ysl.crawler;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ernst on 2017/12/14.
 */
public class FirstCrawler {
    private static HttpClient httpClient = new HttpClient();

    static {
        //httpClient.getHostConfiguration().setProxy("127.0.0.1",8080);
    }

    public static boolean downloadPage(String path) throws IOException{
        InputStream inputStream = null;
        OutputStream outputStream = null;
        //得到POST方法
        PostMethod postMethod = new PostMethod(path);
        //执行，返回状态码
        int statusCode = httpClient.executeMethod(postMethod);
        System.out.println("statusCode is:"+statusCode);
        if(statusCode== HttpStatus.SC_OK){
            inputStream = postMethod.getResponseBodyAsStream();
            //得到文件名
            String fileName = path.substring(path.indexOf('/')+1);
            outputStream = new FileOutputStream(fileName);
            //输出到文件
            int tempByte = -1;
            while ((tempByte=inputStream.read())>0){
                outputStream.write(tempByte);
            }

            if(inputStream!=null){
                inputStream.close();
            }

            if(outputStream!=null){
                outputStream.close();
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            FirstCrawler.downloadPage("https://www.zhihu.com/");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
