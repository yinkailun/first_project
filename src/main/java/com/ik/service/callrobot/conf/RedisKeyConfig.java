package com.ik.service.callrobot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redisKey")
public class RedisKeyConfig {

    private String surveyContextKey;

    private String testSurveyContextKey;

    private String ivrCallStatusKey;

    private String fsguiTokenKey;

    public String getSurveyContextKey() {
        return surveyContextKey;
    }

    public void setSurveyContextKey(String surveyContextKey) {
        this.surveyContextKey = surveyContextKey;
    }

    public String getTestSurveyContextKey() {
        return testSurveyContextKey;
    }

    public void setTestSurveyContextKey(String testSurveyContextKey) {
        this.testSurveyContextKey = testSurveyContextKey;
    }

    public String getIvrCallStatusKey() {
        return ivrCallStatusKey;
    }

    public void setIvrCallStatusKey(String ivrCallStatusKey) {
        this.ivrCallStatusKey = ivrCallStatusKey;
    }

    public String getFsguiTokenKey() {
        return fsguiTokenKey;
    }

    public void setFsguiTokenKey(String fsguiTokenKey) {
        this.fsguiTokenKey = fsguiTokenKey;
    }
}

