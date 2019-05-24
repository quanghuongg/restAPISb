package io.huongnq.springboot.Topic;

public final class SecurityConstant {

    // You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
    public static final String JWT_SECRET = "nZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeThWmYq3t6w9z$C&F)J@NcRf";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 864000000;
    public static final String AUTHORITIES_KEY = "auth";
}