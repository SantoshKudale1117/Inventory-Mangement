package com.cg.inventorygatewayserver.config;

import com.cg.inventorygatewayserver.security.CustomAuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.servlet.Filter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import com.cg.inventorygatewayserver.service.implementation.JwtUserDetailsServiceImpl;
import com.cg.inventorygatewayserver.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	private JwtUserDetailsServiceImpl userDetailsService;

	protected void configure(final HttpSecurity http) throws Exception {
		((HttpSecurity) ((HttpSecurity) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((HttpSecurity) http
				.csrf().disable())
						.authorizeRequests()
						.antMatchers(new String[] { "/inventory-auth-service/**", "/actuator/**", "/**/h2/**",
								"/**/swagger*/**", "/**/v2/api-docs"})).permitAll()
										.antMatchers(new String[] { "/h2" })).permitAll().anyRequest()).authenticated()
												.and()).sessionManagement()
														.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and())
																.exceptionHandling().authenticationEntryPoint(
																		this.authenticationEntryPoint());
		http.addFilterBefore((Filter) this.jwtAuthenticationFilter, (Class) UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return (PasswordEncoder) new BCryptPasswordEncoder();
	}

	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService((UserDetailsService) this.userDetailsService).passwordEncoder(this.passwordEncoder());
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	public AuthenticationEntryPoint authenticationEntryPoint() {
		return (AuthenticationEntryPoint) new CustomAuthenticationEntryPoint();
	}

	public SecurityConfig(final JwtAuthenticationFilter jwtAuthenticationFilter,
			final JwtUserDetailsServiceImpl userDetailsService) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.userDetailsService = userDetailsService;
	}
}