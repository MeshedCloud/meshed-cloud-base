package cn.meshed.cloud.code.generate.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.regex.Matcher;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
public class PackageUtils {

    /**
     * 包转目录路径
     * cn.meshed.cloud => cn/meshed/cloud
     * 注意 / 斜杠根据系统而定
     * @param packageName 包名称
     * @return URI
     */
    public static String packageToDirectoryURI(String packageName){
        return packageName.replaceAll("\\.",  Matcher.quoteReplacement(File.separator));
    }

    public static String packageToURI(String regex,String packageName){
        return packageName.replaceAll(regex,  "").replaceAll("\\.",  "/");
    }

    public static void mkdirPackageDirectory(String rootPath,String packageURI){
        FileUtil.mkdir(rootPath+File.separator + packageURI);
    }

}
