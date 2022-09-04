package cn.meshed.cloud.code.generate.utils;

import cn.meshed.cloud.code.generate.config.ProjectConfig;
import cn.meshed.cloud.code.generate.data.TableEntity;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>模块工具</h1>
 *
 * @author hougq
 * @version 1.0
 */
public class ModuleUtils {
    public static FreemarkerUtils freemarkerUtils = new FreemarkerUtils();

    public static void genDir(ProjectConfig config,String outPath){
        File templatePath = PathUtils.getTemplatePath();
        String rootPath = templatePath + File.separator + "project" + File.separator;

        File moduleConfigures = new File(rootPath + "modules");
        if (!moduleConfigures.exists() || moduleConfigures.isDirectory()){
            throw new RuntimeException("生成代码模块配置不存在");
        }
        List<String> modules = FileUtil.readLines(moduleConfigures, StandardCharsets.UTF_8);
        StringBuilder peoject = getPeojectName(config);
        File projectDir = new File(outPath + File.separator + peoject + File.separator);

        genPom("project/pom.xml.ftl",config, projectDir);

        for (String module : modules) {
            String moduleDirName = getModuleDirName(peoject, module);

            //构建模块POM文件
            genModulePom(config, projectDir, module, moduleDirName);
            //获取SRC目录路径
            String srcDirPath = getSrcDirPath(moduleDirName);

            //获取主目录带基本包路径
            String mainDir = getMainDir(config, srcDirPath);
            //获取测试目录
            String testDir = getTestDir(srcDirPath);

            //构建项目目录
            mkProjectDir(projectDir, mainDir, testDir);

            // 输出根目录包信息
            genRootPackageInfo(config, projectDir, mainDir);

            //生成代码
            genCodes(config, outPath, projectDir, module, mainDir);
        }
    }

    private static StringBuilder getPeojectName(ProjectConfig config) {
        return new StringBuilder().append(config.getSystemName()).append("-").append(config.getModuleName());
    }

    private static String getModuleDirName(StringBuilder peoject, String module) {
        return new StringBuilder().append(peoject).append("-").append(module).toString();
    }

    private static void genModulePom(ProjectConfig config, File projectDir, String module, String moduleDirName) {
        String moduleDir = projectDir + File.separator + moduleDirName;
        File modulePom = new File(moduleDir);
        genPom("project/" + module +"/pom.xml.ftl", config, modulePom);
    }

    /**
     * 构建项目目录
     * @param projectDir
     * @param mainDir
     * @param testDir
     */
    private static void mkProjectDir(File projectDir, String mainDir, String testDir) {
        FileUtil.mkdir(projectDir + File.separator + mainDir);
        FileUtil.mkdir(projectDir + File.separator + testDir);
    }

    private static String getSrcDirPath(String moduleDirName) {
        //构建目录
        String srcDirName =
            new StringBuilder().append(moduleDirName).append(File.separator)
                .append("src").append(File.separator).toString();
        return srcDirName;
    }

    private static String getMainDir(ProjectConfig config, String srcDirName) {
        //基本包名
        String packageUri = PackageUtils.packageToDirectoryURI(config.getBasePackage());

        //main 目录
        String mainDir = new StringBuilder().append(srcDirName)
            .append("main").append(File.separator)
            .append("java").append(File.separator)
            .append(packageUri).append(File.separator)
            .toString();
        return mainDir;
    }

    private static String getTestDir(String srcDirName) {
        String testDir = new StringBuilder().append(srcDirName)
            .append("test").append(File.separator)
            .append("java").append(File.separator)
            .toString();
        return testDir;
    }

    /**
     * 生成根目录和领域目录包信息
     * @param config
     * @param projectDir
     * @param mainDir
     */
    private static void genRootPackageInfo(ProjectConfig config, File projectDir, String mainDir) {
        String basePackage = projectDir + File.separator + mainDir + File.separator;
        genPackageInfo(config, new File(basePackage));
        genPackageInfo(config,
            new File(basePackage + File.separator + config.getDomainName() + File.separator));
    }

    /**
     * 生成代码
     * @param config
     * @param outPath
     * @param projectDir
     * @param module
     * @param mainDir
     */
    private static void genCodes(ProjectConfig config, String outPath, File projectDir, String module,
        String mainDir) {
        LinkedHashMap<String, Object> classGenListMap = getClassGenListMap(config, module);

        Map<String, List<String>> genClassMapList = buildClass(classGenListMap);

        for (Map.Entry<String, List<String>> entry : genClassMapList.entrySet()) {
            String key = entry.getKey();

            for (String clazz : entry.getValue()) {

                String templatePack = PackageUtils.packageToURI(config.getDomainName(), key);
                String directoryURI = PackageUtils.packageToDirectoryURI(key);
                if ("Application.java".equals(clazz)){
                    directoryURI = directoryURI.substring(0,directoryURI.lastIndexOf(config.getDomainName()));
                }

                String classNameUpper = StrUtils.convertInitialUpper(config.getClazz());
                String classNameLower = StrUtils.convertInitialLower(config.getClazz());
                String classPath = mainDir + directoryURI + File.separator ;

                if ("package-info.java".equals(clazz)){
                    // 输出根目录包信息
                    genPackageInfo(config, new File(outPath +classPath));
                    continue;
                }
                //输出文件名，部分现有特殊处理
                String classFileName = getClassFileName(clazz, classNameUpper);

                //输出代码文件，如果不存在不进行处理
                File classOutFile = new File(projectDir + File.separator + classPath + classFileName);
                if (classOutFile.exists()){
                    continue;
                }
                FileUtil.mkParentDirs(classOutFile);

                //生成代码
                genCode(config, module, clazz, templatePack, classNameUpper, classNameLower, classOutFile);

            }
        }
    }

    /**
     * 生成代码
     * @param config
     * @param module
     * @param clazz
     * @param templatePack
     * @param classNameUpper
     * @param classNameLower
     * @param classOutFile
     */
    private static void genCode(ProjectConfig config, String module, String clazz, String templatePack,
        String classNameUpper, String classNameLower, File classOutFile) {
        String templateFtl = "project/" + module + templatePack + "/" + clazz + ".ftl";
        Map<String, Object> pomMap = new HashMap<String, Object>();
        pomMap.put("classPackage", config.getBasePackage());
        pomMap.put("systemName", config.getSystemName());
        pomMap.put("domainName", config.getDomainName());
        pomMap.put("domainTip", config.getDomainTip());
        pomMap.put("Class", classNameUpper);
        pomMap.put("class", classNameLower);
        pomMap.put("moduleName", config.getModuleName());
        pomMap.put("groupId", config.getGroupId());
        pomMap.put("tableName", config.getTableName());
        pomMap.put("tableIdField", config.getTableIdField());
        pomMap.put("entitys", config.getEntitys());

        freemarkerUtils.generateCode(templateFtl,pomMap, classOutFile);
    }

    private static String getClassFileName(String clazz, String classNameUpper) {
        String classFileName =  classNameUpper + clazz;
        if ("entity.java".equals(clazz)){
            classFileName = classNameUpper + ".java";
        }
        return classFileName;
    }

    private static Map<String, List<String>> buildClass(LinkedHashMap<String, Object> classGenListMap) {
        Map<String,List<String>> genClassMapList = new HashMap<>();
        for (Map.Entry<String, Object> entry : classGenListMap.entrySet()) {
            addClassMap(genClassMapList, entry.getKey(),entry.getValue());
        }

        return genClassMapList;
    }

    private static void addClassMap(Map<String,  List<String>> genClassMap, String key, Object value) {
        if (value instanceof String){
            if (genClassMap.containsKey(key)){
                List<String> list = genClassMap.get(key);
                list.add((String)value);
            } else {
                List list = new ArrayList<>();
                list.add(value);
                genClassMap.put(key, list);
            }
        } else if (value instanceof Map){
            ((Map<String, Object>)value).entrySet()
                .stream().forEach(entry->addClassMap(genClassMap,key +"."+ entry.getKey() , entry.getValue()));
        } else if (value instanceof List){
            ((List)value).stream().forEach(item -> addClassMap(genClassMap,key,item));
        }
    }

    private static LinkedHashMap<String, Object> getClassGenListMap(ProjectConfig config, String module) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("classPackage", config.getBasePackage());
        dataMap.put("systemName", config.getSystemName());
        dataMap.put("domainName", config.getDomainName());
        dataMap.put("domainTip", config.getDomainTip());
        dataMap.put("version", config.getVersion());
        dataMap.put("author", config.getAuthor());
        LinkedHashMap<String, Object> classGenListMap =
            freemarkerUtils.readYamlMapWithTemplate("project/" + module + "/package.yaml.ftl", dataMap);
        return classGenListMap;
    }

    private static void genPackageInfo(ProjectConfig config, File dir) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("classPackage", config.getBasePackage());
        dataMap.put("systemName", config.getSystemName());
        dataMap.put("domainName", config.getDomainName());
        dataMap.put("domainTip", config.getDomainTip());
        dataMap.put("version", config.getVersion());
        dataMap.put("author", config.getAuthor());
        File infoFile = new File(dir + File.separator + "package-info.java");
        FileUtil.mkParentDirs(infoFile);
        freemarkerUtils.generateCode("package-info.java.ftl",dataMap,infoFile);
    }

    private static void genPom(String templateFtl,ProjectConfig config, File projectDir) {
        // 输出根目录包信息
        Map<String, Object> pomMap = new HashMap<String, Object>();
        pomMap.put("classPackage", config.getBasePackage());
        pomMap.put("systemName", config.getSystemName());
        pomMap.put("domainName", config.getDomainName());
        pomMap.put("domainTip", config.getDomainTip());
        pomMap.put("moduleName", config.getModuleName());
        pomMap.put("groupId", config.getGroupId());

        File rootPom = new File(projectDir + File.separator + "pom.xml");
        FileUtil.mkParentDirs(rootPom);
        freemarkerUtils.generateCode(templateFtl,pomMap,rootPom);
    }

    public static void main(String[] args) {
        ProjectConfig config = new ProjectConfig();
        config.setSystemName("meshed-cloud");
        config.setModuleName("work");
        config.setDomainName("work");
        config.setBasePackage("cn.meshed.cloud");
        config.setVersion("1.0");
        config.setAuthor("Vincent Vic");
        config.setTableName("tb_work");
        List<TableEntity> entitys = new ArrayList<>();
        TableEntity tableEntity = new TableEntity();
        tableEntity.setJavaField("doc");
        tableEntity.setJavaType("String");
        tableEntity.setSqlField("doc");
        tableEntity.setTip("文章");
        entitys.add(tableEntity);
        config.setEntitys(entitys);
//        config.setTableIdField("id");
        config.setDomainTip("找工作");

        ModuleUtils.genDir(config,"D:\\Temp\\OUT");
    }
}
