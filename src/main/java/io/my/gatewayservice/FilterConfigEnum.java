package io.my.gatewayservice;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;

public enum FilterConfigEnum {
    GATEWAY_REQUEST("gateway-request"),
    GATEWAY_RESPONSE("gateway-response"),
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
