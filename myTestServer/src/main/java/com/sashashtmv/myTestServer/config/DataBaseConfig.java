package com.sashashtmv.myTestServer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories()
@ComponentScan("com.sashashtmv.myTestServer.repository")//TODO


public class DataBaseConfig {
}
