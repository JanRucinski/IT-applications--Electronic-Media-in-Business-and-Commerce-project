package backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final UserDetailsService userDetailsService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  private final JwtAuthorizationFilter jwtAuthorizationFilter;

  public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, JwtAuthorizationFilter jwtAuthorizationFilter) {
    this.userDetailsService = userDetailsService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.jwtAuthorizationFilter = jwtAuthorizationFilter;
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    return authenticationManagerBuilder.build();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(configurer -> configurer
            // Permit all GET requests
            .requestMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/items/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/orders/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/rentals/**").permitAll()
            // Permit POST requests to /items
            .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/items").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/orders").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.POST, "/rentals").hasAnyRole("ADMIN", "USER")
            // Restrict PUT requests to ADMIN role
            .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/rentals/**").hasRole("ADMIN")
            // Restrict DELETE requests to ADMIN role
            .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/items/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/rentals/**").hasRole("ADMIN")

            .requestMatchers("/auth/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/auth/users").permitAll()
            .anyRequest().authenticated()
    )
        .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }
}
