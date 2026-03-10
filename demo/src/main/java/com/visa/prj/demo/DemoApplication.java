package com.visa.prj.demo;

import com.visa.prj.demo.service.AppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
       ApplicationContext ctx =  SpringApplication.run(DemoApplication.class, args);

        AppService service = ctx.getBean("app", AppService.class);
        service.insert();

        String[] beans = ctx.getBeanDefinitionNames();
        for(String bean: beans) {
            System.out.println(bean);
        }
    }

}
