package com.fishfight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ServerMain {

    public static void main(String[] args){
        SpringApplication.run(ServerMain.class, args);
    }

}
