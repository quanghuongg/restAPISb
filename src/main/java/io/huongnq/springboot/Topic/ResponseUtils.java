package io.huongnq.springboot.Topic;

import java.util.HashMap;

public class ResponseUtils {

    public static HashMap<String, Object> buildResponse(String msgCode, Object data) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("code", ErrorMessage.getCode(msgCode));
        response.put("message", ErrorMessage.getMessage(msgCode));
        response.put("data", data);

        return response;
    }

    public static HashMap<String, Object> buildResponse(String msgCode) {
        return buildResponse(msgCode, null);
    }
}
