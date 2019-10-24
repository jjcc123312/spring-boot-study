package com.jjcc.bootlaunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootLaunchApplicationTests {

    @Test
    public void contextLoads() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);

        int month = now.getMonthValue();
        System.out.println("month: " + month);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        String format = dateTimeFormatter.format(now);
        System.out.println("format： " + format);


        Instant now1 = Instant.now();


    }

}
