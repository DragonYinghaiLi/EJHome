package com.okami.apps.ej.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.okami.apps.ej.dao")
public class MybatisConfig {

}
