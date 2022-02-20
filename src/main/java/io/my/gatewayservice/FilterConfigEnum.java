package io.my.gatewayservice;

import lombok.val;

public enum FilterConfigEnum {
    GATEWAY_REQUEST("gateway-request"),
    GATEWAY_RESPONSE("gateway-response"),
    URI("http://dev.mysend.co.kr"),
    REPLACEMENT("/$\\{segment}")
    ;
    private String value;

    FilterConfigEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
