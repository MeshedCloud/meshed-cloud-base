package cn.meshed.cloud.code.generate.utils;

import cn.meshed.cloud.code.generate.factory.TemplateFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */

public class FreemarkerUtils {

    private static final String TEMPLATE_PATH = "D:\\Code\\project\\meshed-cloud\\meshed-cloud-dependencies\\meshed-cloud-code-generate\\src\\main\\resources\\templates\\";
    private static final String CLASS_PATH = "D://Temp//t";

    private final TemplateFactory templateFactory;

    public FreemarkerUtils() {
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(PathUtils.getTemplatePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        templateFactory = new TemplateFactory(configuration);
    }

    public void generateCode(String templateFtl,Map<String, Object> map, File toFile) {
        Writer out = null;
        try{
            Template template = templateFactory.getTemplate(templateFtl);

            out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(toFile.toPath())));
            // step6 输出文件
            template.process(map, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public LinkedHashMap<String, Object> readYamlMapWithTemplate(String templateFtl, Map<String, Object> map) {
        String yamlContent = readYamlWithTemplate(templateFtl, map);
        return YamlUtils.ymlToPorperties(yamlContent);


    }

    public String readYamlWithTemplate(String templateFtl, Map<String, Object> map) {
        try{
            Template template = templateFactory.getTemplate(templateFtl);

            //最关键在这里，不使用与文件相关的Writer
            StringWriter stringWriter=new StringWriter();
            // step6 输出文件
            template.process(map, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    public static void main(String[] args) {

        // step3 创建数据模型
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("classPackage", "cn.meshed.cloud");
        dataMap.put("systemName", "meshed-cloud");
        dataMap.put("domainName", "cxxx");
        dataMap.put("version", "1.0");
        dataMap.put("author", "Id");

        // step5 生成数据
        File docFile = new File(CLASS_PATH + "\\" + "package-info.java");
        FreemarkerUtils freemarkerUtils = new FreemarkerUtils();
        //freemarkerUtils.generateCode("package-info.java.ftl",dataMap,docFile);
        Map<String, Object> dataMap2 = new HashMap<String, Object>();
        dataMap2.put("name", "vv");

        LinkedHashMap<String, Object> stringObjectLinkedHashMap =
            freemarkerUtils.readYamlMapWithTemplate("package.yaml.ftl", dataMap2);
        System.out.println(stringObjectLinkedHashMap);
    }

}
