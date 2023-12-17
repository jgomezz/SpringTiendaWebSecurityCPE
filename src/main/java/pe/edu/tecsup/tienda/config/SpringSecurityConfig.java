package pe.edu.tecsup.tienda.config;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


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
}

