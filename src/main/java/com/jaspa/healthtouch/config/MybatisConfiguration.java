package com.jaspa.healthtouch.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.jaspa.healthtouch", annotationClass=Mapper.class)
public class MybatisConfiguration {

}
