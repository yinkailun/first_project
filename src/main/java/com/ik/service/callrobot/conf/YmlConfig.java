package com.ik.service.callrobot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 加载yaml配置文件的方法
 *
 * @author Yinkl
 * @PropertySource注解只可以加载proprties文件,无法加载yaml文件
 * 故现在把数据放到application.yml文件中,spring-boot启动时会加载
 */
@Component
@ConfigurationProperties(prefix = "baseSettings")
public class YmlConfig {

    /**
     * 每页显示记录条数
     */
    private int perPage ;

    /**
     * 每页最大显示记录条数
     */
    private int maxPerPage ;

    /**
     * 默认加载页码
     */
    private int page ;

    /**
     * 一次查询阿里云数据的最大pageNumber
     */
    private int maxRemoteSearchPage;

    /**
     * 发起一次外呼计划最多的条数
     */
    private int maxCallNumber;

    /**
     * 阿里云发起一次外呼计划最多的条数
     */
    private int maxCallNumberOnceAliyun;

    /**
     * 呼叫超时时间
     */
    private int callTimeOutSeconds;

    /**
     * 数据库数据超时时间
     */
//    private int sqlTimeOutSeconds;

    /**
     * 线程超时时间
     */
    private int threadTimeOutSeconds;

    /**
     * 是否使用阿里云外呼
     */
    private Boolean useAliyun;

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPerPage() {
        return maxPerPage;
    }

    public void setMaxPerPage(int maxPerPage) {
        this.maxPerPage = maxPerPage;
    }

    public int getMaxRemoteSearchPage() {
        return maxRemoteSearchPage;
    }

    public void setMaxRemoteSearchPage(int maxRemoteSearchPage) {
        this.maxRemoteSearchPage = maxRemoteSearchPage;
    }

    public int getMaxCallNumber() {
        return maxCallNumber;
    }

    public void setMaxCallNumber(int maxCallNumber) {
        this.maxCallNumber = maxCallNumber;
    }


    public int getMaxCallNumberOnceAliyun() {
        return maxCallNumberOnceAliyun;
    }

    public void setMaxCallNumberOnceAliyun(int maxCallNumberOnceAliyun) {
        this.maxCallNumberOnceAliyun = maxCallNumberOnceAliyun;
    }

    public int getCallTimeOutSeconds() {
        return callTimeOutSeconds;
    }

    public void setCallTimeOutSeconds(int callTimeOutSeconds) {
        this.callTimeOutSeconds = callTimeOutSeconds;
    }

    public int getThreadTimeOutSeconds() {
        return threadTimeOutSeconds;
    }

    public void setThreadTimeOutSeconds(int threadTimeOutSeconds) {
        this.threadTimeOutSeconds = threadTimeOutSeconds;
    }

    public Boolean getUseAliyun() {
        return useAliyun;
    }

    public void setUseAliyun(Boolean useAliyun) {
        this.useAliyun = useAliyun;
    }
}
