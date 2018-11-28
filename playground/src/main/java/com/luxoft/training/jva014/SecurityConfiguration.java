/*
 * Copyright 2018 skrymets.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.luxoft.training.jva014;

import static com.luxoft.training.jva014.Roles.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author skrymets
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/hello");
//    }
    @Autowired
    // Global - setting up the global AuthenticationManager
    public void initialize(AuthenticationManagerBuilder builder) throws Exception {

        // PasswordEncoderFactories.createDelegatingPasswordEncoder();
        builder.inMemoryAuthentication()
                .withUser(User.builder().username("admin").password("secret").roles(ROLE_SUPER, ROLE_USER, ROLE_GUEST).build())
                .withUser(User.builder().username("guest").password("secret").roles(ROLE_GUEST).build())
                .withUser(User.builder().username("employee").password("secret").roles(ROLE_USER).build())
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/inventory/**")
                .authenticated()
                //.hasAnyRole(ROLE_SUPER, ROLE_USER)
                .antMatchers("/version*")
                .permitAll()
                .antMatchers("/public/**")
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout();
    }

}
