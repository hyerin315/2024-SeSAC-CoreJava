package com.example.demo.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {
	private final TokenProvider provider;
	
	@Bean //필요로 하는 객체를 의존성을 주입해서 넣어줌 (Bean 아래는 Getter 메소드형태로 만들어줌), API 클래스를 만들때 주로 사용
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//보안 관련 설정 메서드 추가
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.httpBasic(HttpBasicConfigurer::disable) //기본 설정 disable
        .csrf(CsrfConfigurer::disable)  //쓰기 작업 막은 것을 해제 - post, put...요청 기능
        .cors(Customizer.withDefaults()) //네트워크 설정 - 도메인, ip 허용, 코드에 작성한 내용 적용
        //어떤 요청에 대해 인증을 요구할 것인가에 대한 설정
		.authorizeHttpRequests((authz)-> authz
				//forward 요청 모두 허용
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() //forward 요청은 모두 허용
				.requestMatchers("/auth/**", "/board/**").authenticated()   //url이 /auth/로 시작하면 인증을 요구
				.requestMatchers("/", "/join", "/error", "/login", "/read-img/**").permitAll() ///auth/** : auth로 시작하는 모든 URL, /index_** : index_바로 시작하는 모든 URL
				.anyRequest().permitAll()
				)
		//토큰 처리하는 필터를 현재 필터 앞에 붙임
		.addFilterBefore(new JwtAuthenticationFilter(provider), UsernamePasswordAuthenticationFilter.class);
		//세션 정책을 stateless로 설정 -> 상태유지 안함.
		http.sessionManagement(configurer->configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build(); //설정된 객체를 return
	}
}
