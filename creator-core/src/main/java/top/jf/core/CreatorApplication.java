package top.jf.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"top.jf"})
@MapperScan(basePackages = {"top.jf.mapper"})
@EnableTransactionManagement
public class CreatorApplication extends SpringBootServletInitializer{

	/**
	 * spring boot项目无需配置web.xml, 开发阶段使用其内嵌的Tomcat容器。
	 * 当需要上线，在外部Tomcat容器进行部署的时候，将入口类继承SpringBootServletInitializer并覆写configure()方法
	 * */
	public static void main(String[] args) {
		SpringApplication.run(CreatorApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources (CreatorApplication.class);
	}
}
