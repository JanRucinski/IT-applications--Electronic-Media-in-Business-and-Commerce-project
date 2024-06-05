package backend.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {

    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    jdbcUserDetailsManager.setUsersByUsernameQuery(
        "SELECT username, password, active FROM users WHERE username = ?");

    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
        "SELECT username, role FROM users WHERE username = ?");

    return jdbcUserDetailsManager;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
        configurer
            // Permit all GET requests
            .requestMatchers(HttpMethod.GET, "/users/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/items/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/orders/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/rentals/**").permitAll()

            // Permit POST requests to /items
            .requestMatchers(HttpMethod.POST, "/items").hasRole("ADMIN")
            // Authorize POST requests to orders and rentals
            .requestMatchers(HttpMethod.POST, "/orders/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/rentals/**").permitAll()

            // Restrict PUT requests to ADMIN role
            .requestMatchers(HttpMethod.PUT, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/rentals/**").hasRole("ADMIN")

            // Restrict DELETE requests to ADMIN role
            .requestMatchers(HttpMethod.DELETE, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/rentals/**").hasRole("ADMIN")
    );

    http.httpBasic(Customizer.withDefaults());
    http.csrf(csrf -> csrf.disable());

    return http.build();
  }


}
