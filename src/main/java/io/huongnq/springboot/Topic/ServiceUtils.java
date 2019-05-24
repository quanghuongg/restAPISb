package io.huongnq.springboot.Topic;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServiceUtils {

    public static final String getStringStream(ServletInputStream stream, int length) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(stream, "UTF-8");
        for (;;) {
            int index = in.read(buffer, 0, length);
            if (index < 0) break;
            out.append(buffer, 0, index);
        }
        return out.toString();
    }

    public static String encodePassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

        return bCryptPasswordEncoder.encode(password);
    }

    public static List<String> parseStringToList(Map messages, String key) {
        String parser = String.valueOf(messages.get(key));

        return Arrays.asList(parser
                .replace("[", "")
                .replace("]", "")
                .split("\\s*, \\s*"));
    }
}
