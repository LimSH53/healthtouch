package com.jaspa.healthtouch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jaspa.healthtouch.handler.LoginFailHandler;
import com.jaspa.healthtouch.handler.LoginSuccessHandler;
import com.jaspa.healthtouch.login.model.service.MemberService;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public SpringSecurityConfiguration(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
				/* 관리자 페이지는 관리자만 */
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/trainer/**").hasRole("TRAINER")
			.and()
				.formLogin()
				.loginPage("/member/login")
				.successHandler(loginSuccessHandler(memberService))
				.failureHandler(loginFailHandler())
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/member/login")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/common/denied");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public LoginSuccessHandler loginSuccessHandler(MemberService memberService) {
		return new LoginSuccessHandler(memberService);
	}
	
	@Bean
	public LoginFailHandler loginFailHandler() {
		return new LoginFailHandler();
	}
}
