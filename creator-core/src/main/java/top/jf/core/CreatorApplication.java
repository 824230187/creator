package top.jf.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"top.jf"})
@MapperScan(basePackages = {"top.jf.mapper"})
@EnableTransactionManagement
public class CreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatorApplication.class, args);
	}
}
