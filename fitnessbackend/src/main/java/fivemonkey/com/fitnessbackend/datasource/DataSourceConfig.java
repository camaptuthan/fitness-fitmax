package fivemonkey.com.fitnessbackend.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
public class DataSourceConfig {
	@Autowired
    private final Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    public DataSource dataSourceConfig(String pass) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty(pass));
        return dataSource;
    }


    @Bean
    public DataSource dataSourceBuilder() {
        List<String> passList = new ArrayList<>(Arrays.asList("spring.huydt.password", "spring.haph.password",
                "spring.tuandb.password", "spring.ducnv.password","spring.anhcv.password"));
        for (String pass : passList) {
            try (Connection connection = dataSourceConfig(pass).getConnection()) {
                return dataSourceConfig(pass);
            } catch (SQLException ignored) {
            }
        }
        return null;
    }

}
