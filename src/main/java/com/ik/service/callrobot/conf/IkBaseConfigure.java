package com.ik.service.callrobot.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.ik.crm.commons.util.ApplicationContextUtil;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.extend.page.interceptor.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Yinkl
 * 对mybatis返回map为空不显示的参数修改
 */
@Configuration
@ComponentScan({"com.ik.crm.commons.config.base", "com.ik.crm.services.commons"})
@MapperScan(
        basePackages = {"com.ik.crm.services.commons.mapper"},
        sqlSessionFactoryRef = "sqlSessionFactory"
)
@EnableTransactionManagement
public class IkBaseConfigure {
    @Autowired
    protected ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(IkBaseConfigure.class);

    public IkBaseConfigure() {
    }

    @PostConstruct
    public void initConfig() {
        ApplicationContextUtil.setApplicationContext(this.applicationContext);
    }

    @Bean
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    @Primary
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.dataSource());
        bean.setTypeAliasesPackage("com.ik.crm.services.*.model");
        bean.setPlugins(new Interceptor[]{new PageInterceptor()});
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:com/ik/**/mapper/**/*Mapper.xml"));

        //配置mybatis的Configuration
        org.apache.ibatis.session.Configuration  config = new org.apache.ibatis.session.Configuration();
        //为空显示null
        config.setCallSettersOnNulls(true);
        logger.info("##################CallSettersOnNulls启动！！！");
        bean.setConfiguration(config);
        return bean.getObject();
    }
}

