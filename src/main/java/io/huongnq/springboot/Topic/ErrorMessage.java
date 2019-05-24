package io.huongnq.springboot.Topic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorMessage {

    public static final String SUCCESSFUL = "SUCCESSFUL";
    public static final String FAIL = "FAIL";

    // LOGIN
    public static final String LOGIN_FAIL = "LOGIN_FAIL";

    // CRUD User-Report-Rule
    public static final String OBJECT_CREATE_EMPTY_FIELD = "OBJECT_CREATE_EMPTY_FIELD";

    public static final String USER_CREATE_EXISTING = "USER_CREATE_EXISTING";
    public static final String USER_NOT_EXISTED = "USER_NOT_EXISTED";

    private static final Map MESSAGES = new HashMap<String, List>() {{

        put(SUCCESSFUL, Arrays.asList(0, "success"));
        put(FAIL, Arrays.asList(1, "failure"));

        put(LOGIN_FAIL, Arrays.asList(1, "Login failed"));

        put(OBJECT_CREATE_EMPTY_FIELD, Arrays.asList(1, "Fields are not empty"));

        put(USER_CREATE_EXISTING, Arrays.asList(1, "User existed"));
        put(USER_NOT_EXISTED, Arrays.asList(1, "User not existed"));

    }};

    public static Integer getCode(String key) {
        return Integer.parseInt(ServiceUtils.parseStringToList(MESSAGES, key).get(0));
    }

    public static String getMessage(String key) {
        return ServiceUtils.parseStringToList(MESSAGES, key).get(1);
    }
}
