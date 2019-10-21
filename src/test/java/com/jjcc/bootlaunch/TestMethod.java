package com.jjcc.bootlaunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className TestMethod.java
 * @createTime 2019年10月10日 23:28:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestMethod.class })
public class TestMethod {

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;

    @Test
    public void testMethod() throws Exception {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from user");
        ResultSet resultSet = prepareStatement.executeQuery();

    }
}
