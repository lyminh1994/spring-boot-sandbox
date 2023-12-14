package dev.hobie.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.time.Duration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager(
      final AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
    return http.cors((AbstractHttpConfigurer::disable))
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers(
                        "/login",
                        "/register",
                        "/css/**",
                        "/img/**",
                        "/js/**",
                        "/plugins/**",
                        "/favicon.ico")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(
            form ->
                form.loginPage("/login").usernameParameter("email").failureUrl("/login?error=true"))
        .logout(
            logout -> logout.logoutSuccessUrl("/login?success=true").deleteCookies("JSESSIONID"))
        .rememberMe(
            rememberMeConfig ->
                rememberMeConfig
                    .key("S3cr3t")
                    .rememberMeParameter("rememberMe")
                    .tokenValiditySeconds((int) Duration.ofDays(7).toSeconds()))
        .exceptionHandling(
            exception ->
                exception.authenticationEntryPoint(
                    new LoginUrlAuthenticationEntryPoint("/login?required=true")))
        .sessionManagement(
            sessionManagementConfig ->
                sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
        .build();
  }
}
