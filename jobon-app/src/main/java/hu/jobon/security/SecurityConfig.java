package hu.jobon.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

//@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
 
    //@Autowired
    //private UserDetailsService userDetailsService;
 //
    ////@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsService(userDetailsService);
    //}
 
    //@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		.formLogin(form -> form
			.loginPage("/login")
			.permitAll()
		);
	// ...
    }
}