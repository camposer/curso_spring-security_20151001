package config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String USERS_BY_USERNAME_QUERY = "select nombre_usuario as username, clave as password, true as enabled from usuario where nombre_usuario = ? and estatus = 'ACTIVO'";
	private static final String AUTHORITIES_BY_USERNAME_QUERY = "select nombre_usuario as username, r.nombre as authority from rol r inner join usuario u on r.usuario_id = u.id where u.nombre_usuario = ?";
	@Autowired
	private DataSource dataSource;
	
	class CustomAuthenticationProvider implements AuthenticationProvider {

		@Override
		public Authentication authenticate(Authentication arg0) throws AuthenticationException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean supports(Class<?> clazz) {
			return clazz.equals(Authentication.class);
		}
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
//			.authenticationProvider(new CustomAuthenticationProvider())
//			.inMemoryAuthentication()
//				.withUser("user").password("user").roles("USER").and()
//				.withUser("admin").password("admin").roles("ADMIN", "USER");
			.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(new ShaPasswordEncoder())
				.usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
				.authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/articulos/admin**", "/admin**").hasRole("ADMIN")
				.and()
			.formLogin()
				.usernameParameter("usuario")
				.passwordParameter("clave") 
				.loginProcessingUrl("/autenticar") // Recibe parámetros por POST
				.loginPage("/login.do"); // Página de login
	}	
}


