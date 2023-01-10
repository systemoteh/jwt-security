package ru.systemoteh.jwtsecurity.common;

public class Constants {
    public static final String USER_ROLE = "USER_ROLE";
    public static final String ADMIN_ROLE = "ADMIN_ROLE";
    public static final String[] USER_ADMIN_ROLE = {USER_ROLE, ADMIN_ROLE};
    public static final String[] ANONYMOUS_ENDPOINTS = { "/jwtsecurity/auth/login", "/jwtsecurity/admin/health"};
    public static final String[] USER_ADMIN_ENDPOINTS = {"/jwtsecurity/index"};

    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final String DOT = "\\.";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String SLASH = "/";
    public static final String LINE_BREAK = "\r\n";
    public static final String COMMA = ",";
    public static final String COMMA_AND_SPACE = ", ";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String HASH = "#";
    public static final String TILDA = "~";
    public static final String DASH = "-";
    public static final String UNDERLINE = "_";
    public static final String QUESTION = "?";
    public static final String EQUALS = "=";
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String BACK_SLASH_REGEX = "\\\\";
    public static final String DEFAULT = "default";
    public static final String JSESSIONID = "JSESSIONID";
    public static final String CP_1251 = "Cp1251";
    public static final String WINDOWS_1251 = "windows-1251";
    public static final String UTF_8 = "UTF-8";
    public static final String PUNCTUATION_AND_SPACE_REGEX = "(?U)[\\pP\\s]";

}