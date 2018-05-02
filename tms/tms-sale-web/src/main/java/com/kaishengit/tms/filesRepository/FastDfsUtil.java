package com.kaishengit.tms.filesRepository;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 *@Description:文件上传下载工具类
 *@Author: 邱志辉
 *@Date 2016/4/27 0027下午 5:28
 */
@Component
public class FastDfsUtil {


    public String uploadFile(InputStream inputStream, String extName) throws IOException, MyException {
        return uploadFile(inputStream,extName,null);
    }

    public String uploadFile(InputStream inputStream, String extName,Map<String,String> map) throws IOException, MyException {
        try {
            //客户端初始化通过一个peoperties用ClientGlobal的initbyproperties方法告诉ClientGlobal知道tracker的位置
            Properties properties = new Properties();
            properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,"192.168.42.244:22122");
            ClientGlobal.initByProperties(properties);

            //文件上传
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);

            NameValuePair[] nameValuePairs = null;
            if(map != null&&!map.isEmpty()){
                nameValuePairs = new NameValuePair[map.size()];

                int i = 0;
                for(Map.Entry<String,String> entry : map.entrySet()){
                    NameValuePair nameValuePair = new NameValuePair();
                    nameValuePair.setName(entry.getKey());
                    nameValuePair.setValue(entry.getValue());
                    nameValuePairs[i] = nameValuePair;
                    i++;
                }

            }

            String[] results = storageClient.upload_file(IOUtils.toByteArray(inputStream),extName,nameValuePairs);

            StringBuffer buffer = new StringBuffer();
            for(String str : results){
                buffer.append(str).append("/");
            }

            return buffer.toString().substring(0,buffer.toString().lastIndexOf("/"));
        }catch (IOException | MyException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public static void main(String[] args) throws IOException, MyException {
        InputStream input = new FileInputStream("E:/picture/1.jpg");

        FastDfsUtil fastDfsUtil = new FastDfsUtil();
        String name = fastDfsUtil.uploadFile(input,"jpg",null);
        System.out.println(name);
    }

}
