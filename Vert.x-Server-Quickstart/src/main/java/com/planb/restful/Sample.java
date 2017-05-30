package com.planb.restful;

import com.planb.support.routing.Function;
import com.planb.support.routing.RESTful;
import com.planb.support.routing.Route;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

@Route(uri = "/sample", method = HttpMethod.POST)
@Function(name = "기능 이름", summary = "요약")
@RESTful(requestHeaders = "key : Type, key2 : Typ2", requestBody = "key : Type, key2 : Type2", successCode = 201, failureCode = 204)
public class Sample implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext ctx) {
		
	}
}
