package com.company.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Filter class executes just before any servlet 
@Configuration  // This configuration should be defined in spring boot 2.7.0 onwards
@EnableWebSecurity
public class SecurityConfiguration {

	 @Autowired
	    private DataSource dataSource;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/admin/**").hasRole("ADMIN") // means  who as admin access he can access /admin/add , /admin/delete 
            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // means who as admin and user access  he can access /admin/add , /admin/delete  , /user/view , 
             .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll();       
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**", "/js/**");
    }
    
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails developer = User.builder()
                .username("jiya")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build();
        UserDetails manager = User.builder()
                .username("Kapil")
                .password(encoder.encode("admin123"))
                .roles("ADMIN", "USER")
                .build();
        
        UserDetails tester = User.builder()
                .username("niti")
                .password(encoder.encode("test123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(developer, manager,tester);
    }
    
    
   

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//      throws Exception {
//        auth.jdbcAuthentication()
//          .dataSource(dataSource)
//          .withDefaultSchema()
//          .withUser(User.withUsername("jiya")
//            .password(passwordEncoder().encode("password"))
//            .roles("ADMIN"))
//        .withUser(User.withUsername("Kapil")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN", "USER"))
//        .withUser(User.withUsername("niti")
//                .password(passwordEncoder().encode("test123"))
//                .roles("USER"));
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
