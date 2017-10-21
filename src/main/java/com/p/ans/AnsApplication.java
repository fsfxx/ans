package com.p.ans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class AnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnsApplication.class, args);

    }
}
