package poly.datn.sd_41.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserService _userService;

    @Bean
    public JwtAuthenFilter jwtAuthenFilter() {
        return new JwtAuthenFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req -> req
                        .requestMatchers(
                                "/api/employee/**",
//                        "api/giohang/**",
//                        "api/thanhtoan/**",
                                "api/nguoidung/**"
                        ).hasAnyRole(
                        "ADMIN",
                        "EMPLOYEE",
                        "CUSTOMER")
                        .requestMatchers("/api/admin/**").hasAnyRole("ADMIN", "EMPLOYEE", "CUSTOMER")
                        .requestMatchers("/api/nhanvien/**").hasAnyRole("ADMIN", "EMPLOYEE", "CUSTOMER")
                        //   .requestMatchers("/api/crm/**").hasAnyRole("CRM","ADMIN")
                        .anyRequest().permitAll()
        )
                .csrf((csrf) -> csrf.disable())
                .cors(Customizer.withDefaults())
                .addFilterBefore(jwtAuthenFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(_userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }

}
