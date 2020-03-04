package attendance.manas.edu.kg.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:property/security.properties")
public class AppConfig {

    Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }


    @Bean
    public DataSource bcryptDataSource() {
        return DataSourceBuilder
                .create()
                .username(env.getProperty("database.username"))
                .password(env.getProperty("database.password"))
                .url(env.getProperty("database.url"))
                .driverClassName(env.getProperty("database.driver"))
                .build();
    }

}
