package cn.meshed.cloud.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * <h1>Json 工具</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper DEFAULT_MAPPER = buildMapper();
    private static final TypeReference<Map<String, String>> TYPE_STRING_MAP = new TypeReference<Map<String, String>>() {
    };
    private static final TypeReference<Map<String, Object>> TYPE_OBJECT_MAP = new TypeReference<Map<String, Object>>() {
    };
    private static final TypeReference<List<String>> TYPE_STRING_LIST = new TypeReference<List<String>>() {
    };

    public JsonUtils() {
    }

    public static ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        // 注意是否开启
//        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return mapper;
    }

    public static ObjectMapper objectMapper() {
        return DEFAULT_MAPPER;
    }

    public static String toJson(Object obj) {
        try {
            return DEFAULT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException var2) {
            log.warn(var2.getMessage());
            return "";
        }
    }

    public static <T> T fromJson(String s, Class<T> clazz) {
        try {
            return s == null ? null : DEFAULT_MAPPER.readValue(s, clazz);
        } catch (JsonProcessingException var3) {
            log.warn(var3.getMessage());
            return null;
        }
    }

    public static <T> T fromJson(String s, TypeReference<T> type) {
        try {
            return s == null ? null : DEFAULT_MAPPER.readValue(s, type);
        } catch (JsonProcessingException var3) {
            log.warn(var3.getMessage());
            return null;
        }
    }

    public static <T> T fromJson(String s, Type type) {
        try {
            if (s == null) {
                return null;
            } else {
                JavaType javaType = DEFAULT_MAPPER.constructType(type);
                return DEFAULT_MAPPER.readValue(s, javaType);
            }
        } catch (JsonProcessingException var3) {
            log.warn(var3.getMessage());
            return null;
        }
    }

    public static Map<String, Object> objToMap(Object obj) {

        return (Map)fromJson(toJson(obj), TYPE_OBJECT_MAP);
    }

    public static Map<String, String> toStringMap(String s) {
        return (Map)fromJson(s, TYPE_STRING_MAP);
    }

    public static List<String> toStringList(String s) {
        return (List)fromJson(s, TYPE_STRING_LIST);
    }

}
