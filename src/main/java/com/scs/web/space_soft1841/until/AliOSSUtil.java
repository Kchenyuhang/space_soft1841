package com.scs.web.space_soft1841.until;

import com.aliyun.oss.OSSClient;
import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliOSSUtil
 * @Description TODO
 * @author yu_chen
 */
public class AliOSSUtil {
    static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    static final String accessKeyId = "LTAI41PGLwQKBcVF";
    static final String accessKeySecret = "DBUGgiRLZqycwd6i4I5XfmeI47IpcB";
    static final String bucketName = "student-manage99";
    /**
     * 将本地file上传到阿里云指定域名的目录下，并用UUID重命名
     *
     * @param file
     * @return String
     */
    public static String avatarUpload(File file) {
        String filePath = "avatar/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://student-manage99.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }
    public static String photoUpload(File file) {
        String filePath = "photo/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://student-manage99.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }
}