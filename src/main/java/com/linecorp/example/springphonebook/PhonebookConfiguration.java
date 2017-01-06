
package com.linecorp.example.springphonebook;

import java.net.URISyntaxException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class PhonebookConfiguration
{
	@Bean
    public DataSource getDataSource()
    {
        String dbUrl=System.getenv("JDBC_DATABASE_URL");
        String username=System.getenv("JDBC_DATABASE_USERNAME");
        String password=System.getenv("JDBC_DATABASE_PASSWORD");
        
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(dbUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        
        return ds;
    }
    
    @Bean
    public PersonDao getPersonDao()
    {
        return new PersonDaoImpl(getDataSource());
    }
};
