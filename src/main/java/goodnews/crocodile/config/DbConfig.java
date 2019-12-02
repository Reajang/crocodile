package goodnews.crocodile.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("goodnews.crocodile.services")
@EnableJpaRepositories(basePackages = "goodnews.crocodile.repository")
@PropertySource("classpath:app.properties")
public class DbConfig {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    //Бин соединения с базой
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        //Через singleton класс доступа к пропертям. Работает
        /*dataSource.setDriverClassName(inst().getProperty("db.driver"));
        dataSource.setUrl(inst().getProperty("db.url"));
        dataSource.setUsername(inst().getProperty("db.username"));
        dataSource.setPassword(inst().getProperty("db.password"));*/

        //Задание напрямую. Работает
        /*dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/croc");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");*/

        //Через аннотации. Работает
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        //Пакет с моделями (@Entity)
        entityManager.setPackagesToScan("goodnews.crocodile.model");
        //Входит в hibernate-core. Добавлять в POM
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(additionalProperties());
        //entityManager.setJpaDialect();
        return entityManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    //Свойства для Hibernate
    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        //Создание таблиц на основе сущностей
        //validate : проверить схему, не вносить изменения в базу данных.
        //update : обновить схему.
        //create : создает схему, уничтожая предыдущие данные.
        //create-drop : отказаться от схемы, когда SessionFactory закрывается явно, обычно, когда приложение остановлено.
        //properties.setProperty("hibernate.hbm2ddl.auto", "create");
        return properties;
    }

}
