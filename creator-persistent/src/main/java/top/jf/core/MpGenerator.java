/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.core;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/5
 * @time 16:16
 */
public class MpGenerator {
	
	public static void main (String[] args) {
		/**
		 * <p>
		 * mybatis-plus 代码生成器
		 * </p>
		 */
		// 自定义需要填充的字段
		List<TableFill> tableFillList = new ArrayList<>();
		tableFillList.add (new TableFill ("create_time", FieldFill.INSERT_UPDATE));
		tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
		
		File file = new File("");
		String canonicalPath = null;
		try {
			canonicalPath = file.getCanonicalPath ();
		} catch (IOException e) {
			System.out.println ("找不到标准路径！");
		}
		
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
				//获取当前类的标准路径
		        //F:\workspace\creator
				// 全局配置
				new GlobalConfig()
						.setOutputDir(canonicalPath+"\\src\\main\\java")//输出目录
						.setFileOverride(true)// 是否覆盖文件
						.setActiveRecord(true)// 开启 activeRecord 模式
						.setEnableCache(false)// XML 二级缓存
						.setBaseResultMap(true)// XML ResultMap
						.setBaseColumnList(true)// XML columList
						.setAuthor("JF")
				// 自定义文件命名，注意 %s 会自动填充表实体属性！
						 .setMapperName("%sMapper")
						 .setXmlName("%sMapper")
						 .setServiceName("%sService")
						 .setServiceImplName("%sServiceImpl")
						 .setControllerName("%sController")
		).setDataSource(
				// 数据源配置
				new DataSourceConfig()
						.setDbType(DbType.MYSQL)// 数据库类型
						.setTypeConvert(new MySqlTypeConvert() {
							// 自定义数据库表字段类型转换【可选】
							@Override
							public DbColumnType processTypeConvert(String fieldType) {
								System.out.println("转换类型：" + fieldType);
								// if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
								//    return DbColumnType.BOOLEAN;
								// }
								return super.processTypeConvert(fieldType);
							}
						})
						.setDriverName("com.mysql.jdbc.Driver")
						.setUsername("root")
						.setPassword("111111")
						.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8")
		).setStrategy(
				// 策略配置
				new StrategyConfig()
						// .setCapitalMode(true)// 全局大写命名
						// .setDbColumnUnderline(true)//全局下划线命名
						// .setTablePrefix(new String[]{"bmd_", "mp_"})// 此处可以修改为您的表前缀
						.setNaming(NamingStrategy.underline_to_camel)// 表名生成策略,此处为下划线转驼峰
						.setInclude(new String[] { "user_test","bike_goods"}) // 需要生成的表
						// .setExclude(new String[]{"test"}) // 排除生成的表
						// 自定义实体父类
						// .setSuperEntityClass("com.baomidou.demo.TestEntity")
						// 自定义实体，公共字段
						.setSuperEntityColumns(new String[]{"test_id"})
						.setTableFillList(tableFillList)
				// 自定义 mapper 父类
				// .setSuperMapperClass("com.baomidou.demo.TestMapper")
				// 自定义 service 父类
				// .setSuperServiceClass("com.baomidou.demo.TestService")
				// 自定义 service 实现类父类
				// .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
				// 自定义 controller 父类
				// .setSuperControllerClass("com.baomidou.demo.TestController")
				// 【实体】是否生成字段常量（默认 false）
				// public static final String ID = "test_id";
				// .setEntityColumnConstant(true)
				// 【实体】是否为构建者模型（默认 false）
				// public User setName(String name) {this.name = name; return this;}
				// .setEntityBuilderModel(true)
				// 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
				 .setEntityLombokModel(true)
				// Boolean类型字段是否移除is前缀处理
				// .setEntityBooleanColumnRemoveIsPrefix(true)
				// .setRestControllerStyle(true)
				// .setControllerMappingHyphenStyle(true)
		).setPackageInfo(
				// 包配置
				new PackageConfig()
//						.setModuleName("src.main.java.top.jf")
						.setParent("top")// 自定义包路径
						.setController("controller")// 这里是控制器包名，默认 web
						.setEntity ("entity.mp")
		                .setMapper ("mapper.mp")
		                .setService ("service")
		                .setServiceImpl ("service.impl")
		)/*.setCfg(
				// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
				new InjectionConfig() {
					@Override
					public void initMap() {
						Map<String, Object> map = new HashMap<>();
						map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
						this.setMap(map);
					}
				}.setFileOutConfigList(
						Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
					// 自定义输出文件目录
					@Override
					public String outputFile(TableInfo tableInfo) {
						return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
					}
				}))
		)*/.setTemplate(
				// 关闭默认 xml 生成，调整生成 至 根目录
				new TemplateConfig().setXml(null)
				// 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
				// 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
				// .setController("...");
				// .setEntity("...");
				// .setMapper("...");
				// .setXml("...");
				// .setService("...");
				// .setServiceImpl("...");
		);
		
		// 执行生成
		mpg.execute();
		
		// 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
		System.err.println(mpg.getCfg().getMap().get("abc"));
		
	}
}
