package goodnews.crocodile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/goodnews/crocodile/register",
                        "/goodnews/crocodile",
                        "/goodnews/crocodile/login").permitAll()//к этим урлам допускаются все без регистрации
                .anyRequest().authenticated()//для остальных нужна авторизация
                    .and()
                .formLogin()
                .loginPage("/goodnews/crocodile/login")//урл логина
                .defaultSuccessUrl("/goodnews/crocodile")//на этот урл будет направлен пользователь после успешной аутентификации
                .failureUrl("/goodnews/crocodile/login?error=true")//на этот после неуспешной
                .permitAll()
                    .and()
                .logout()//к форме logout также допускаются все
                .permitAll();
    }

/*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                .username("u")
                .password("1")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select userName")
                .authoritiesByUsernameQuery("select u.username, ")
    }*/
}
