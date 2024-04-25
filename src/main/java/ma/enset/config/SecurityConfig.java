package ma.enset.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	//return http.build();
	
	return http.authorizeHttpRequests(auth -> { 
		auth.requestMatchers("/admin").hasRole("ADMIN");
		auth.requestMatchers("/user").hasRole("USER");
		auth.requestMatchers("/supprimer/**").hasRole("ADMIN");
		auth.requestMatchers("/ajouter").hasRole("USER, ADMIN");
		auth.requestMatchers("/modifier/**").hasRole("ADMIN");
		auth.requestMatchers("/liste").hasRole("USER, ADMIN");
		auth.anyRequest().authenticated();
		
	}).formLogin(Customizer.withDefaults()).build();

	
	
	
}
	


@Bean
public UserDetailsService user() {
    UserDetails user = User.builder()
            .username("user") // Remplacez par le nom d'utilisateur souhaité
            .password("{noop}user") // Remplacez par le mot de passe souhaité
            .roles("USER")
            .build();

    UserDetails admin = User.builder()
            .username("admin") // Remplacez par un autre nom d'utilisateur souhaité
            .password("{noop}admin") // Remplacez par un autre mot de passe souhaité
            .roles("USER", "ADMIN")
            .build();

    return new InMemoryUserDetailsManager(user, admin);
}



/*
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}password").roles("ADMIN") 
            .and()
            .withUser("user").password("{noop}password").roles("USER");
    }
*/




}
