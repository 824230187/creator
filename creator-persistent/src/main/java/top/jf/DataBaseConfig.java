package top.jf;/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/10
 * @time 14:35
 */
@Configuration
@EnableTransactionManagement
@MapperScan("top.*.mapper")
public class DataBaseConfig implements EnvironmentAware{

	/**
	 * springBoot整合mybatis。配置数据源 sqlMapper
	 * */
	private final Logger logger = LoggerFactory.getLogger (DataBaseConfig.class);
	
	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment (Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver (environment,"spring.datasource.");
	}
	
	@Bean
	@Primary
	public DruidDataSource dataSource(){
		DruidDataSource datasource = new DruidDataSource ();
//		datasource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8");
//		datasource.setDriverClassName("com.mysql.jdbc.Driver");
//		datasource.setUsername("root");
//		datasource.setPassword("111111");
		datasource.setUrl(propertyResolver.getProperty ("url"));
		datasource.setDriverClassName(propertyResolver.getProperty ("driver-class-name"));
		datasource.setUsername(propertyResolver.getProperty ("username"));
		datasource.setPassword(propertyResolver.getProperty ("password"));

		logger.info ("url-{}username-{}pwd-{}",datasource.getUrl (),datasource.getUsername (),datasource.getPassword ());
		logger.info ("dataSource数据源配置完成......");
		return datasource;
	}
	
	/*@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager (dataSource());
	}*/
	
	@Bean
	@ConditionalOnMissingBean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource ());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations
				(resolver.getResources("classpath:mybatis/sqlmap/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	
}
