package com.chuong.emsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.chuong.emsbackend")
public class EmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsBackendApplication.class, args);
    }

}
