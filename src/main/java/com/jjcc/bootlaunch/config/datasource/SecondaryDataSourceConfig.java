package com.jjcc.bootlaunch.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 加载次数据源
 * @author Jjcc
 * @version 1.0.0
 * @className SecondaryDataSourceConfig.java
 * @createTime 2019年10月10日 11:09:00
 */
@Configuration
@MapperScan(basePackages = "com.jjcc.bootlaunch.generator.test2*",
        sqlSessionTemplateRef = "secondarySqlSessionTemplate")
public class SecondaryDataSourceConfig {

//    @Autowired
//    private Environment env;

//    @Bean(name = "secondaryDataSource")
////    @ConfigurationProperties(prefix = "spring.datasource.druid.secondary")
//    public DataSource testDataSource() {
//        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//        Properties prop = build(env, "spring.datasource.druid.secondary.");
//        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
//        ds.setUniqueResourceName("secondary");
//        ds.setPoolSize(5);
//        ds.setXaProperties(prop);
//
//        return ds;
//    }

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis-plus.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis-plus.configuration.map-underscore-to-camel-case}")
    private boolean mapUnderscoreToCamelCase;

    @Bean(name = "secondarySqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        bean.setDataSource(dataSource);
        //指定mapper.xml路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(mapperLocations));
        //增加驼峰配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);
        //别名
        bean.setTypeAliasesPackage(typeAliasesPackage);

        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    /**
     * 添加单数据源事务
     * @title testTransactionManager
     * @author Jjcc
     * @param dataSource
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @createTime 2019/10/11 21:13
     */
    /*@Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    /**
     * SqlSessionTemplate 是 SqlSession接口的实现类，是spring-mybatis中的，实现了SqlSession线程安全
     * @title testSqlSessionTemplate
     * @author Jjcc
     * @param sqlSessionFactory
     * @return org.mybatis.spring.SqlSessionTemplate
     * @createTime 2019/10/13 15:50
     */
    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
