package cn.meshed.cloud.code.generate.utils;

import java.io.File;
import java.net.URL;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
public class PathUtils {

    public static File getTemplatePath(){
        URL templates = ClassLoader.getSystemResource("templates");
        if (templates == null || templates.getFile() == null){
            throw new RuntimeException("模板资源不存在");
        }
        return new File(templates.getFile());
    }
}
