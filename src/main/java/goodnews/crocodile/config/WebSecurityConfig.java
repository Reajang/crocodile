package goodnews.crocodile.config;

import goodnews.crocodile.config.authProviders.CrocAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("goodnews.crocodile.config")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private CrocAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/goodnews/crocodile/register",
                        "/goodnews/crocodile", "/js/**").permitAll()//к этим урлам допускаются все без регистрации
                .anyRequest().authenticated()//для остальных нужна авторизация
                    .and()
                .formLogin()
                //.loginPage("/goodnews/crocodile/login")//урл логина
                .defaultSuccessUrl("/goodnews/crocodile")//на этот урл будет направлен пользователь после успешной аутентификации
                //.failureUrl("/goodnews/crocodile")//на этот после неуспешной
                .permitAll()
                    .and()
                .logout()//к форме logout также допускаются все
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver(){
        return new AuthenticationPrincipalArgumentResolver();
    }*/

    /*@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
