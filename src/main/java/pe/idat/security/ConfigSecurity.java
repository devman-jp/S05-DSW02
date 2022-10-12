package pe.idat.security;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jesus").password(Encoder().encode("123456")).roles("USER","ADMIN");
		auth.inMemoryAuthentication().withUser("angel").password(Encoder().encode("123456")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET).hasRole("USER")
		 	.antMatchers("/productos/v1/*").hasRole("ADMIN")
		 	.and()
		 	.httpBasic()
		 	.and()
		 	.csrf()
		 	.disable();
	}
	
	@Bean public PasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	 }
	
	/*
	 * @Bean public UserDetailsService userDetail() { InMemoryUserDetailsManager
	 * manager = new InMemoryUserDetailsManager(); manager.createUser( User
	 * .withUsername("jesus") .password(Encoder().encode("123456"))
	 * .roles("ADMIN").build() ); return manager; }
	 * 
	 * 
	 * 
	 * 
	 * public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 * http.authorizeRequests()
	 * .antMatchers("/productos/v1/*").access("hasRoles('ADMIN')") .and()
	 * .httpBasic() .and() .csrf().disable(); return http.build(); }
	 */
	
	
	
	
	
}
