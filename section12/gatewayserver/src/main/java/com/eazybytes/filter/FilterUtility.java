package com.eazybytes.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;


@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "eazybank-correlation-Id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if(requestHeaders.get(CORRELATION_ID) != null) {
            List<String> correlationIds = requestHeaders.get(CORRELATION_ID);
            return correlationIds.stream().findFirst().get();
        } else {
            return null;
        }
    }

    public ServerWebExchange setRequestHeaders(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeaders(exchange, CORRELATION_ID, correlationId);
    }
}
