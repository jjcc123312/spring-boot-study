package com.jjcc.bootlaunch.config.datasource;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 加载主数据源
 * @author Jjcc
 * @version 1.0.0
 * @className PrimaryDataSourceConfig.java
 * @createTime 2019年10月10日 10:48:00
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.jjcc.bootlaunch.generator.test1", sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDataSourceConfig {



    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis-plus.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource,
                                                   @Qualifier("mybatisConfiguration") MybatisConfiguration configuration,
                                                   @Qualifier("globalConfig") GlobalConfig globalConfig) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        //指定mapper.xml路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(mapperLocations));
//
        bean.setTypeAliasesPackage(typeAliasesPackage);

        bean.setConfiguration(configuration);

        bean.setGlobalConfig(globalConfig);

        return bean.getObject();
    }


//    /**
//     * 添加单数据源事务
//     * @title testTransactionManager
//     * @author Jjcc
//     * @param dataSource
//     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
//     * @createTime 2019/10/11 21:13
//     */
//    @Bean(name = "primaryTransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * SqlSessionTemplate 是 SqlSession接口的实现类，是spring-mybatis中的，实现了SqlSession线程安全
     * @title testSqlSessionTemplate
     * @author Jjcc
     * @param sqlSessionFactory
     * @return org.mybatis.spring.SqlSessionTemplate
     * @createTime 2019/10/13 15:50
     */
    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
