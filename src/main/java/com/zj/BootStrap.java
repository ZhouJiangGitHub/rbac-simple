package com.zj;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * spring项目的启动器
 * @author zj
 *
 */
@SpringBootApplication
@EnableTransactionManagement//开启事务支持
@MapperScan(value="com.zj.dao")
@EnableScheduling
public class BootStrap {
	
	public static void main(String[] args) {	
		SpringApplication.run(BootStrap.class, args); 
	}

}
