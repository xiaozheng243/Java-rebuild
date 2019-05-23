package online.suiyu.utils;

import javax.servlet.http.Cookie;

/**
 * 处理cookie相关问题
 */
public class CookieUtils {
    public Cookie getCookieByName(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
