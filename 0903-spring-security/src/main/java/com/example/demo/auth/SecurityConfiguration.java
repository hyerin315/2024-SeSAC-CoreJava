package com.example.demo.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfiguration {
	@Bean //필요로 하는 객체를 의존성을 주입해서 넣어줌 (Bean 아래는 Getter 메소드형태로 만들어줌), API 클래스를 만들때 주로 사용
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration)
	throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//보안 관련 설정 메소드 추가
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception {
		http.httpBasic(HttpBasicConfigurer::disable) //기본 설정 disable
			.csrf(CsrfConfigurer::disable) //쓰기 작업 막은 것을 해제 - post, put...요청 기능
			.cors(Customizer.withDefaults()) //네트워크 설정 - 도메인, ip 허용, 코드에 작성한 내용 적용
			//어떤 요청에 대해 인증을 요구할 것인가에 대한 설정
			.authorizeHttpRequests((authz)->authz
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/", "/join", "/autherror", "/loginForm", "/login").permitAll()
					.requestMatchers("/auth/**", "/index_**").authenticated()) ///auth/** : auth로 시작하는 모든 URL, /index_** : index_바로 시작하는 모든 URL
			//로그인 폼 설정
			.formLogin((login)->login
					.loginPage("/loginform")  //로그인 폼을 주는 요청 url
					.loginProcessingUrl("/login") //로그인 처리 요청 url : Spring Security가 자동으로 알아서 처리하지만, 처리 url을 알려주는 것 (단, 이렇게 설정할 경우, loginForm action을 설정한 /login으로 해줘야함)
					.usernameParameter("id")  //id 입력양식의 이름
					.passwordParameter("pwd") //pwd 입력양식의 이름
					.defaultSuccessUrl("/", true).permitAll() //성공시 기본 이동 경로 (허용하도록 설정)
					.successHandler(new MySuccessHandler())  //성공시 실행될 핸들러
					.failureHandler(new MyFailureHandler()) //실패시 실행될 핸들러
					
			);
			return http.build(); //설정된 객체를 return
	}
}
