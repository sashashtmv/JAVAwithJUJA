package com.sashashtmv;

import com.sashashtmv.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AplicationInitializer implements WebApplicationInitializer {

    private final static String DISPATCHER = "dispatcher";//имя, на основе которого наш диспетчер будет зарегистрирован

    //говорит о том, что мы должны выполнить какие-то действия перед тем или во время того, как мы будем разворачивать наш servlet-контекст
    public void onStartup(ServletContext servletContext) throws ServletException {

        //создаём наш контекст
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //регистрируем контекст в сервлете
        context.register(WebConfig.class);

        //подгружаем контекст в сервлет
        servletContext.addListener(new ContextLoaderListener(context));
        // в диспетчер сервлетов добавим наш контекст
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(context));

        //указываем, по какому контекст руту будет доступно наше приложение
        servlet.addMapping("/");
        //указываем порядок инициализации сервлетов, необязательно в данном случае
        servlet.setLoadOnStartup(1);

    }
}
