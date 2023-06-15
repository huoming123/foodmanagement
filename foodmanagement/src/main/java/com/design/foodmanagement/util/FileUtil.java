package com.design.foodmanagement.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class FileUtil {
    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    //文件类型
    public static String IMG_TYPE_PNG = "PNG";
    public static String IMG_TYPE_JPG = "JPG";

    /**
     * 文件后缀名分隔符
     */
    public static final String SUFFIX_SPLIT = ".";

    /**
     * 获取文件名的后缀，如 jpg/txt等
     *
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        if (fileName!=null){
            return fileName.substring(fileName.lastIndexOf(SUFFIX_SPLIT) + 1);
        }
        return null;
    }

    /**
     * 上传文件 可随机命名或者使用原名
     * @param file
     * @param filePath 存储地址
     * @param repetition  是否使用原名 建议不要使用中文路径会有bug
     * @return 返回文件名（不包括文件路径）
     */
    public static String  saveFile(MultipartFile file, String filePath, boolean repetition) throws IOException, NullPointerException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            if (!repetition){
                String uuid = UUID.randomUUID().toString();
                uuid = uuid.replace("-", "");
                fileName = uuid + "." +FileUtil.getSuffix(fileName);
            }
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return fileName;
        }else{
            throw new NullPointerException("不能上传空文件");
        }
    }

    /**
     * 上传文件 自定义文件名
     * @param file
     * @param filePath 路径名
     * @param fileName 文件名
     * @return
     * @throws IOException
     * @throws NullPointerException
     */
    public static String  saveFile(MultipartFile file, String filePath, String fileName) throws IOException, NullPointerException {
        if (!file.isEmpty()) {
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return fileName;
        }else{
            throw new NullPointerException("不能上传空文件");
        }
    }


    /*public static void main(String[] args) {
        File oldName = new File("D:\\opt\\java\\cms\\temporary\\default.jpg");
        File newName = new File("D:\\opt\\java\\cms\\StockStore2\\public\\images\\EBook\\FW2022\\cover\\en\\default.jpg");
        System.out.println(oldName.renameTo(newName));//E:\\java task\\zhl.txt移动至E:\\java task\\zhlll

    }*/
    /**
     * 移动文件
     *
     * @param originalFilePath 原文件
     * @param destinationFloderUrl 目标地址
     * @param destName 文件名需要带后缀名
     */
    public static boolean removeFile(String originalFilePath, String destinationFloderUrl, String destName) {

        File file = new File(originalFilePath);
        File destFloder = new File(destinationFloderUrl);
        //检查目标路径是否合法
        if (destFloder.exists()) {
            if (destFloder.isFile()) {
                return false;
            }
        } else {
            if (!destFloder.mkdirs()) {
                return false;
            }
        }
        //检查源文件是否合法
        if (file.isFile() && file.exists()) {
            String destinationFile = destinationFloderUrl + destName;
            File destFile = new File(destinationFile);
            if (!file.renameTo(destFile)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 匹配文件类型
     *忽略大小写
     * @param fileType jpg,png
     * @param fileName
     * @return
     */
    public static boolean isNumType(String fileType, String fileName) {
        if (fileType != null && fileName != null) {
            String substring = fileName.substring(fileName.lastIndexOf(".")+1);  //获取文件后缀名（判断类型）
            String[] str = fileType.split(",");                     //截取出来后缀名 也就是要匹配什么类型
            for (String s : str) {//遍历是否符合后缀
                if (substring.toLowerCase().equals(s)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    /**
     * 解压zip
     * @param zipFilePath 待解压文件的路径 D:/test/java.zip
     * @param unzipFilePath 解压后的文件存储路径 D:/test/
     * @throws Exception
     */
    public static void unzip(String zipFilePath, String unzipFilePath) throws Exception {
        File zipFile = new File(zipFilePath);


        //创建解压缩文件保存的路径
        File unzipFileDir = new File(unzipFilePath);
        if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
            unzipFileDir.mkdirs();
        }

        //开始解压
        ZipEntry entry = null;
        String entryFilePath = null, entryDirPath = null;
        File entryFile = null, entryDir = null;
        int index = 0, count = 0;
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();
        //循环对压缩包里的每一个文件进行解压
        while(entries.hasMoreElements()) {
            entry = entries.nextElement();
            String entryName = entry.getName();
            entryName = entryName.replace("/",File.separator);
            //构建压缩包中一个文件解压后保存的文件全路径
            entryFilePath = unzipFilePath  + entryName;
            //构建解压后保存的文件夹路径
            index = entryFilePath.lastIndexOf(File.separator);
            if (index != -1) {
                entryDirPath = entryFilePath.substring(0, index);
            }
            else {
                entryDirPath = "";
            }
            entryDir = new File(entryDirPath);
            //如果文件夹路径不存在，则创建文件夹
            if (!entryDir.exists() || !entryDir.isDirectory()) {
                entryDir.mkdirs();
            }

            //创建解压文件
            entryFile = new File(entryFilePath);
            if (entryFile.exists()&&entryFile.isFile()) {
                //检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
                SecurityManager securityManager = new SecurityManager();
                securityManager.checkDelete(entryFilePath);
//                删除已存在的目标文件
                entryFile.delete();
            }
            if(entryFile.isDirectory()){
                continue;
            }
            //写入文件
            bos = new BufferedOutputStream(new FileOutputStream(entryFile));
            bis = new BufferedInputStream(zip.getInputStream(entry));
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                bos.write(buffer, 0, count);
            }
            bos.flush();
            bos.close();
            bis.close();
        }
    }
    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名(包括路径)
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.info("文件删除成功{}",fileName);
                return true;
            } else {
                logger.error("文件删除失败{}",fileName);

                return false;
            }
        } else {
            logger.error("文件删除失败{} 不存在",fileName);

            return false;
        }
    }


    //复制文件
    public static void copyFile(File fromFile, File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        if (!toFile.getParentFile().exists()) {
            toFile.getParentFile().mkdirs();
        }
        if (!toFile.exists()){
            toFile.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n = 0;
        while ((n = ins.read(b)) != -1) {
            out.write(b, 0, n);
        }
        ins.close();
        out.close();
    }

    /**
     * 校验文件名字、以及后缀
     * @param file
     * @return
     */
    public static Boolean isCorrectFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        // 判断后缀
        if(!(IMG_TYPE_PNG.equals(suffix.toUpperCase()) || IMG_TYPE_JPG .equals(suffix.toUpperCase()))){
            return  false;
        }
        // 判断文件名是否有不符合规则字符
        if (fileName == null || fileName.length() > 255){
            return false;
        }
        // 校验文件名是否有中文，有中文就返回false，代表不符合规矩
        /*Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(fileName);
        if (m.find()) {
            return false;
        }*/
        Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
        Matcher matcher = pattern.matcher(fileName);
        boolean matches = matcher.matches();// 是否属于违规名字
        return !matches;
    }

    /**
     * 判断文件是否存在
     * @param fileFullPath
     * @return
     */
    public static Boolean isFileExit(String fileFullPath) {
        File file = new File(fileFullPath);
        if (file.exists() && file.isFile()){
            return true;
        }else {
            return false;
        }
    }

}
