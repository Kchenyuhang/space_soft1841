package com.scs.web.space_soft1841.until;


import com.aliyun.oss.OSSClient;

import java.io.File;
import java.util.UUID;

/**
 * 阿里云OOS测试程序
 */
public class AliOSSUtil {
    /**
     * 将本地file上传到阿里云指定域名的目录下，并用UUID重命名
     *
     * @param file
     * @return String
     */
    public static String ossUpload(File file) {
        String bucketDomain = "https://student-manage99.oss-cn-hangzhou.aliyuncs.com/";
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI41PGLwQKBcVF";
        String accessKeySecret = "DBUGgiRLZqycwd6i4I5XfmeI47IpcB";
        String bucketName = "student-manage99";
        String filedir = "logo/";
        String fileName = file.getName();
        String fileKey = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, filedir + fileKey, file);
        StringBuffer url = new StringBuffer();
        url.append(bucketDomain).append(filedir).append(fileKey);
        ossClient.shutdown();
        return url.toString();
    }

    public static void main(String[] args) {
        File file = new File("D:/code.jpg");
        String url = ossUpload(file);
        System.out.println(url);
    }
}