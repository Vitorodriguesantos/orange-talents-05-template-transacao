package br.com.zupacademy.transacao.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/transacoes/**").hasAuthority("SCOPE_transacoes:read")
                .anyRequest().authenticated().and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}
