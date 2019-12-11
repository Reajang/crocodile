
package goodnews.crocodile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override//Метод объявляет "пустые" методы контроллера, которые только окрывают нужную страницу/view
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/goodnews/crocodile/game").setViewName("game");
        //registry.addViewController("/goodnews/crocodile/login").setViewName("login");
        registry.addViewController("/goodnews/crocodile").setViewName("main");
        //Почему не работает? Проблема в том что там post-метод?
        //registry.addViewController("/goodnews/crocodile/register").setViewName("register");
    }
}

