package com.adu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

/*
* */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Log logger = LogFactory.getLog(JsonUtil.class);

    public static String toJson(Object object) {
        String res = null;
        try {
            res = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("[ERROR-toJson]", e);
        }
        return res;
    }

    public static <T> T toObject(String s, Class<T> t) {
        try {
            return objectMapper.readValue(s, t);
        } catch (Exception e) {
            logger.error("[ERROR-toObject]", e);
        }
        return null;
    }
}