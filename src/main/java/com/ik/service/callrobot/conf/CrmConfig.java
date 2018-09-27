package com.ik.service.callrobot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author :yangsj
 */
@Component
@ConfigurationProperties(prefix = "crmurl")
public class CrmConfig {
    private String leadPath;

    private String leadsImport;

    private String getLeads;

    private String ucAuth;

    private String ucInfo;

    private String crmUserTokenPath;

    private String getUserIdPathPc;

    private String getUserIdPathLiXiao;

    private String getUserIdPathDingDing;

    private String getUserIdToken;

    public String getLeadPath() {
        return leadPath;
    }

    public void setLeadPath(String leadPath) {
        this.leadPath = leadPath;
    }

    public String getLeadsImport() {
        return leadsImport;
    }

    public void setLeadsImport(String leadsImport) {
        this.leadsImport = leadsImport;
    }

    public String getGetLeads() {
        return getLeads;
    }

    public void setGetLeads(String getLeads) {
        this.getLeads = getLeads;
    }

    public String getUcAuth() {
        return ucAuth;
    }

    public void setUcAuth(String ucAuth) {
        this.ucAuth = ucAuth;
    }

    public String getUcInfo() {
        return ucInfo;
    }

    public void setUcInfo(String ucInfo) {
        this.ucInfo = ucInfo;
    }

    public String getCrmUserTokenPath() {
        return crmUserTokenPath;
    }

    public void setCrmUserTokenPath(String crmUserTokenPath) {
        this.crmUserTokenPath = crmUserTokenPath;
    }

    public String getGetUserIdPathPc() {
        return getUserIdPathPc;
    }

    public void setGetUserIdPathPc(String getUserIdPathPc) {
        this.getUserIdPathPc = getUserIdPathPc;
    }

    public String getGetUserIdPathLiXiao() {
        return getUserIdPathLiXiao;
    }

    public void setGetUserIdPathLiXiao(String getUserIdPathLiXiao) {
        this.getUserIdPathLiXiao = getUserIdPathLiXiao;
    }

    public String getGetUserIdPathDingDing() {
        return getUserIdPathDingDing;
    }

    public void setGetUserIdPathDingDing(String getUserIdPathDingDing) {
        this.getUserIdPathDingDing = getUserIdPathDingDing;
    }

    public String getGetUserIdToken() {
        return getUserIdToken;
    }

    public void setGetUserIdToken(String getUserIdToken) {
        this.getUserIdToken = getUserIdToken;
    }
}
