package com.planb.support.utilities;

import io.vertx.ext.web.Cookie;
import io.vertx.ext.web.RoutingContext;

public class SessionUtil {
	public static void createCookie(RoutingContext ctx, String key, String value) {
		Cookie cookie = Cookie.cookie(key, value);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 365);
		ctx.addCookie(cookie);
	}

	public static void createSession(RoutingContext ctx, String key, String value) {
		ctx.session().put(key, value);
	}

	public static void removeCookieOrSession(RoutingContext ctx, String key) {
		if (ctx.session().get(key) != null) {
			ctx.session().remove(key);
		}

		if (ctx.getCookie(key) != null) {
			ctx.getCookie(key).setMaxAge(0);
		}
	}

	public static String getSessionId(RoutingContext ctx, String key) {
		String value = null;

		if (ctx.session().get(key) != null) {
			value = ctx.session().get(key);
		} else if (ctx.getCookie(key) != null) {
			value = ctx.getCookie(key).getValue();
		}

		return value;
	}
}
