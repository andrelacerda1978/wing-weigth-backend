package br.com.wingweight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WingWeightApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                WingWeightApplication.class,
                args
        );

    }
}