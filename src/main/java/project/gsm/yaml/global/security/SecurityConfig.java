package project.gsm.yaml.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import project.gsm.yaml.global.filter.JwtRequestFilter;
import project.gsm.yaml.global.security.handler.CustomAccessDeniedHandler;
import project.gsm.yaml.global.security.handler.CustomAuthenticationEntryPointHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf().disable();

        http.
            authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/auth/redirect").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
                .antMatchers(HttpMethod.DELETE, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/major/**").permitAll()
                .antMatchers(HttpMethod.POST, "/major/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/major/**", "/major/**/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/major/**", "/major/**/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/humanities/**").permitAll()
                .antMatchers(HttpMethod.POST, "/humanities/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/humanities/**", "/humanities/**/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/humanities/**", "/humanities/**/{id}").permitAll();


        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler());

        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
