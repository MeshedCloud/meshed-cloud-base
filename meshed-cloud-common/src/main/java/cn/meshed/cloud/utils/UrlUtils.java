package cn.meshed.cloud.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <h1>URL 工具</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UrlUtils {

    /**
     * GET 保存URL文件
     *
     * @param filePath 文件将要保存的目录
     * @param url      请求的路径
     * @return
     * @从制定URL下载文件并保存到指定目录
     */
    public static File saveUrlAsGet(String url, String filePath, String fileName) {
        return saveUrlAs(url, filePath, fileName, "GET");
    }

    /**
     * Post 保存URL文件
     * @param filePath 文件将要保存的目录
     * @param url      请求的路径
     * @return
     * @从制定URL下载文件并保存到指定目录
     */
    public static File saveUrlAsPost(String url, String filePath, String fileName) {
        return saveUrlAs(url, filePath, fileName, "POST");
    }

    /**
     * @param filePath 文件将要保存的目录
     * @param method   请求方法，包括POST和GET
     * @param url      请求的路径
     * @return
     * @从制定URL下载文件并保存到指定目录
     */
    private static File saveUrlAs(String url, String filePath, String fileName, String method) {
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {
                filePath += "/";
            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;

    }
}
