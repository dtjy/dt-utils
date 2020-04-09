package com.dt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author jiangyao
 * @Date 2019/6/27 9:35
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.dt.utils"})
@MapperScan(basePackages = "com.dt.utils.mapper")
@EnableScheduling
public class UtilsApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(UtilsApplication.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(UtilsApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);

        LOGGER.info("dt-utils start Success");
    }
}
