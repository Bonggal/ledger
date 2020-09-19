package com.prometheus.ledger.service.facade.member.request;

import com.prometheus.ledger.core.model.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class CheckLoginRequest extends BaseRequest {
    private String username;
    private String password;

    public CheckLoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
