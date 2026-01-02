package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"service"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"repo"})
public class JPAConfig {
    @Bean
    public DriverManagerDataSource getDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springwebmvc");
        dataSource.setUsername("root");
        dataSource.setPassword("i2coheCLo");
        return dataSource;
    }
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("entity");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);

        Properties prop = new Properties();
        prop.put("hibernate.hbm2ddl.auto","update");
        prop.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        prop.put("hibernate.format_sql",true);
        prop.put("show_sql", true);

        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setJpaProperties(prop);

        return factoryBean;
    }
    @Bean(name = "transactionManager")
    public JpaTransactionManager getTransaction(LocalContainerEntityManagerFactoryBean factoryBean){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factoryBean.getObject());
        return transactionManager;
    }
}
