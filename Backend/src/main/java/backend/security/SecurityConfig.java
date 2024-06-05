package backend.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
        configurer
            .requestMatchers(HttpMethod.GET, "/items/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/orders/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/rentals/**").permitAll()

            .requestMatchers(HttpMethod.PUT, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/rentals/**").hasRole("ADMIN")

            .requestMatchers(HttpMethod.DELETE, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/rentals/**").hasRole("ADMIN")

            .requestMatchers(HttpMethod.POST, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/orders/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/rentals/**").permitAll()
    );

    http.httpBasic(Customizer.withDefaults());

    return http.build();
  }

}
