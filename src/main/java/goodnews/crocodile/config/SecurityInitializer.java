package goodnews.crocodile.config;

import org.springframework.security.web.context.*;

//Спринг в вебе для использования security наследует DelegatingFilterProxy.
//чтобы это зарегистрировать в контейнере и описать в конфигурации (?) ипользуется AbstractSecurityWebApplicationInitializer
//далее springSecurityFilterChain
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
