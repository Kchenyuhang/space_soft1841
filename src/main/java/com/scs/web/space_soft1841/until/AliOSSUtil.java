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
    public static String upload(File file) {
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAIJF6wLhIIsqOO";
        String accessKeySecret = "SWi5Xp34hpFv9CZoa0yrbLSrJmFarl";
        String bucketName = "niit-soft";
        String filePath = "avatar/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }

    public static void main(String[] args) {
        String url = AliOSSUtil.upload(new File("D:/1.jpg"));
        System.out.println(url);
    }
}