package com.sashashtmv.myTestServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//будет инициализировать spring-context
@Controller//говорит о том, что этот класс контроллер
@RequestMapping("/hello")//аннотация для обращения к контроллеру по имени - hello

public class MyController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)//GET - вызывается, когда мы переходим по определённому url
    @ResponseBody// говорит, что в качестве ответа метода мы хотим вернуть строку
    public String getFirstMethod(){
        return "My first method";
    }
}
