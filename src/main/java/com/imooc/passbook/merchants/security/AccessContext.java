package com.imooc.passbook.merchants.security;

/**
 * 用 ThreadLocal 去单独存储每一个线程携带的Token信息
 * SpingBoot支持多线程并发
 */
public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<>();
    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
