package cn.guxiangfly.foodsellsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.guxiangfly.foodsellsystem.domain.mapper")
public class FoodsellsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodsellsystemApplication.class, args);
	}
}
