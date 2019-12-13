package com.scs.web.space_soft1841.until;

import com.aliyun.oss.OSSClient;
import com.scs.web.space_soft1841.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @author yu_chen
 * @ClassName AliOSSUtil
 * @Description TODO
 */
public class AliOSSUtil {
    static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    static final String accessKeyId = "LTAI41PGLwQKBcVF";
    static final String accessKeySecret = "DBUGgiRLZqycwd6i4I5XfmeI47IpcB";
    static final String bucketName = "student-manage99";
    static String fileName = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 将本地file上传到阿里云指定域名的目录下，并用UUID重命名
     *
     * @param file
     * @return String
     */
    public static String avatarUpload(File file) {
        String filePath = "avatar/";
        fileName = file.getName();
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

    public static String downloadPicture(String urlList) {
        URL url = null;
        String imageName = "D:/img/" + UUID.randomUUID().toString() + ".jpg";
        int imageNumber = 0;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context = output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageName;
    }

    public static Result upload(MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(ResultCode.FILE_NOT_EXIST);
        }
        String fileName = file.getOriginalFilename();
        String filePath1 = "/D:/img";
        File dest = new File(filePath1 + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = "avatar/";
        String newFileName = UUID.randomUUID().toString() + dest.getName().substring(dest.getName().indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, dest);
        // 拼接URL
        String url = "https://student-manage99.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return Result.success(url);
    }
}