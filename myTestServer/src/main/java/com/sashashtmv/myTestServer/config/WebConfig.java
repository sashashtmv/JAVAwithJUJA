package com.sashashtmv.myTestServer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration// - говорит о том, что данный класс является конфигурацией, которую нужно выполнить перед тем, как разворачивать контекст спринга
@EnableWebMvc// - говорит о том, что мы должны включить режим mvc, что даст нам возможность использования контроллеров и REST-контроллеров
@ComponentScan("com.sashashtmv")// - говорит о том, где мы должны искать все наши бины(bins)- классы, компоненты, сервисы, репозитории

public class WebConfig extends WebMvcConfigurerAdapter {
}
