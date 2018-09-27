package com.ik.service.callrobot.conf;

import com.ik.crm.commons.starter.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({ "com.ik.service.callrobot" })
@MapperScan({ "com.ik.service.callrobot.mapper" })
//@EnableIkBaseConfigure
@EnableIkLogConfigure
@EnableIkBaseAsyncExecutorConfigure
@EnableIkContextAwareSchedulerConfigure
@EnableAsync
@EnableScheduling
@EnableIkMonitorConfigure
@EnableIkErrorConfigure
@EnableIkCacheConfigure
public class BootConfig {
}
