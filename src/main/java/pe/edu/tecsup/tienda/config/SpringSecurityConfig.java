package pe.edu.tecsup.tienda.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
  
	@Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }   
  
	
   /*
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		
		users.add(User.withUsername("user")
					  .password(passwordEncoder().encode("user"))
					  .roles("USER")
					  .build());
		users.add(User.withUsername("admin")
				      .password(passwordEncoder().encode("admin"))
				      .roles("USER","ADMIN")
				      .build());
		
		return new InMemoryUserDetailsManager(users);
	}
	//*/
	
	//*
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth)
			throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	//*/


	// Autorization

	//* 
		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			
	       http
	       // Configure authorizations
	        .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/" , "/**").permitAll()
//		        .requestMatchers("/home/**").authenticated()
//		        .requestMatchers("/admin/**").hasAnyAuthority("Administrador")	       
	    	)
	       // Change login
		   	.formLogin((form) -> form
		       	.loginPage("/login")  // la peticion para iniciar sesion
		       	.loginProcessingUrl("/authenticate")
		       	.defaultSuccessUrl("/")
		       	.failureUrl("/login?error")
		       	.usernameParameter("username").passwordParameter("password")
		   	)
		   	// Change logout
		   	.logout((logout) -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
		    )
		   	// Change csrf
		   	.csrf( (csrf) -> csrf.disable());
	      
			return http.build();
		}
		//*/




}

