package cn.meshed.cloud.code.generate.utils;

import cn.hutool.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */

public class YamlUtils {


    public static void main(String[] args) {
        String path = "D:\\Code\\project\\meshed-cloud\\meshed-cloud-workflow\\meshed-cloud-workflow-start\\src\\main\\resources\\bootstrap.yml";

        LinkedHashMap<String, Object> result = ymlToPorperties(path);

        System.out.println(new JSONObject(result));
    }

    public static LinkedHashMap<String, Object> ymlToPorperties(String yamlContent) {
        Yaml yaml = new Yaml();
        LinkedHashMap<String, Object> m = yaml.load(yamlContent);
        return mapToPorperties(m);
    }

    public static LinkedHashMap<String, Object> mapToPorperties(LinkedHashMap<String, Object> m) {
        final LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        mapToPorperties(null, resultMap, m);
        return resultMap;
    }

    private static void mapToPorperties(String key, final LinkedHashMap<String, Object> toMap, LinkedHashMap<String, Object> fromMap) {
        Iterator<Map.Entry<String, Object>> it = fromMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            Object value = entry.getValue();
            if (value instanceof Map) {
                String relKey = entry.getKey();
                if (key != null) {
                    relKey = key + "." + entry.getKey();
                }
                mapToPorperties(relKey, toMap, (LinkedHashMap<String, Object>) value);
            } else {
                String relKey = entry.getKey();
                if (key != null) {
                    relKey = key + "." + entry.getKey();
                }
                toMap.put(relKey, entry.getValue());
            }
        }
    }

}
