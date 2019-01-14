package com.alimama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhangshuman on 2018/5/7.
 */

/**
 * Created by zhangshuman on 2018/5/7.
 */
@SpringBootApplication(scanBasePackages = "com")
//@MapperScan("com.alimama.dao")
@ImportResource({"classpath:/spring/spring-config.xml"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class, ElasticsearchAutoConfiguration.class })
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}