package com.prometheus.ledger.core.util;

import com.prometheus.ledger.core.model.BaseModel;
import com.prometheus.ledger.service.common.session.model.SessionObject;
import org.springframework.beans.BeanUtils;

/**
 * @author bonggal.siahaan
 * @version $Id: MainContextHolder.java, v 0.1 2020‐09‐25 19.54 bonggal.siahaan Exp $$ */
public class MainContextHolder extends BaseModel {

    private static SessionObject sessionObject;

    public static boolean saveSessionObjectToContextHolder(SessionObject createdSessionObject){
        sessionObject = new SessionObject();
        BeanUtils.copyProperties(createdSessionObject, sessionObject);
        return true;
    }

    public static String getCurrentUserId(){
        if (sessionObject == null){
            return null;
        }
        return sessionObject.getUserId();
    }
}
