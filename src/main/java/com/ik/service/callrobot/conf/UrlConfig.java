package com.ik.service.callrobot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author :yangsj
 */
@Component
@ConfigurationProperties(prefix = "fsgui")
public class UrlConfig {
    private String login;

    private String call;

    /**
     * 主动挂断的接口url
     */
    private String hangup;

    private String cdr;

    private String event;

    private String robotPath;

    private String fsguiPath;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRobotPath() {
        return robotPath;
    }

    public void setRobotPath(String robotPath) {
        this.robotPath = robotPath;
    }

    public String getFsguiPath() {
        return fsguiPath;
    }

    public void setFsguiPath(String fsguiPath) {
        this.fsguiPath = fsguiPath;
    }

    public String getHangup() {
        return hangup;
    }

    public void setHangup(String hangup) {
        this.hangup = hangup;
    }
}
