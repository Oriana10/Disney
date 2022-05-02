package com.disney.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.disney.app.servicios.impl.UsuarioServicioImpl;

@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UsuarioServicioImpl UsuarioServicioImpl;
/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UsuarioServicioImpl).passwordEncoder(new BCryptPasswordEncoder());
	}
*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin().and().authorizeRequests()
				.antMatchers("/css/*", "/js/*", "/img/*", "/**").permitAll().and().formLogin().loginPage("/auth/login")
				.loginProcessingUrl("/auth/login").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/").permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
				.permitAll().and().csrf().disable();
		// .and().httpBasic();
	}

}
