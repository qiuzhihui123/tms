package com.kaishengit.tms.util;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *@Description: 生成七牛云上传凭证
 *@Author: 邱志辉
 *@Date 2016/4/20 0020下午 7:26
 */
@Component
public class QiNiuCloudTokenUtil {

    @Value("${qiniu.ak}")
    private  String accessKey;
    @Value("${qiniu.sk}")
    private  String secretKey;
    @Value("${qiniu.bucket}")
    private  String bucket;

    public  String getToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        return  upToken;
    }

}

class test{
    public static void main(String[] args) {
        String accessKey = "kVyV3UKnlcH1MRN5E_YQNXc9-i4HwCyGEQXBYcDr";
        String secretKey = "DOFszU7Y2amf2QjgxQGb6WOOAFkGL-Q5hmRRgIPY";
        String bucket = "qiuhui-tms";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }
}