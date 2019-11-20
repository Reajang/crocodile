package goodnews.crocodile.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

import static goodnews.crocodile.Utils.AppProps.inst;

@Configuration
//@EnableTransactionManagement
@ComponentScan()
@EnableJpaRepositories(basePackages = "goodnews.crocodile.repository")
public class AppConfig {

    @Bean
    //Бин соединения с базой
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(inst().getProperty("db.url"));
        dataSource.setDriverClassName(inst().getProperty("db.driver"));
        dataSource.setUsername(inst().getProperty("db.username"));
        dataSource.setPassword(inst().getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        //Пакет с моделями (@Entity)
        entityManager.setPackagesToScan("goodnews.crocodile.model");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        //entityManager.setJpaDialect();
        return entityManager;
    }

}
