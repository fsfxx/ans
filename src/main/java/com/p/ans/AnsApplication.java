package com.p.ans;

import com.p.ans.domain.Goods;
import com.p.ans.domain.User;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnsApplication.class, args);
	}

	UserRepository ur;
	GoodsRepository gr;

	public AnsApplication(UserRepository ur) {
		this.ur = ur;
	}

	@Bean
	ApplicationRunner runner() {
		return args -> {

        };
	}
}
