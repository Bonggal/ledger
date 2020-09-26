package com.prometheus.ledger.core.model.request;

import com.prometheus.ledger.core.model.BaseModel;
import com.prometheus.ledger.core.model.EnvInfo;
import com.sun.istack.NotNull;

import java.util.Map;

public class BaseRequest extends BaseModel {
    private Map<String, String> extParams;
    @NotNull
    private EnvInfo envInfo;

    public Map<String, String> getExtParams() {
        return extParams;
    }

    public void setExtParams(Map<String, String> extParams) {
        this.extParams = extParams;
    }

    /**
     * Getter method for property envInfo.
     *
     * @return property value of envInfo
     */
    public EnvInfo getEnvInfo() {
        return envInfo;
    }

    /**
     * Setter method for property envInfo.
     *
     * @param envInfo value to be assigned to property envInfo
     */
    public void setEnvInfo(EnvInfo envInfo) {
        this.envInfo = envInfo;
    }
}
