package com.market.center.marketcenter.config;


import com.market.center.marketcenter.security.BoilSecurityDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final BoilSecurityDetails boilSecurity;
    private final PasswordEncoder passwordEncoder;


    public ApplicationSecurityConfiguration(BoilSecurityDetails boilSecurity, PasswordEncoder passwordEncoder) {
        this.boilSecurity = boilSecurity;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http

                .authorizeRequests()
                .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
                .antMatchers("/", "/users/login", "/users/register", "/reset/password", "/reset",
                        "/search/all-articles", "/home", "/datenschutz", "/kontakt").permitAll()
                .antMatchers(
                        "/digitale-produkte/blick-digitale-produkte", "/online/win",
                        "/view/all-win-produkte", "/article/detail/{id}",
                        "/view/all-psychologie", "/view/psychologie",
                        "/online/recht-und-gesetz", "/view/recht-gesetz",
                        "/online/dating-und-beziehungen", "/view/dating",
                        "/online/sprache-lernen", "/view/sprache",
                        "/online/forex-bitcoin", "/view/forex",
                        "/online/wettsysteme", "/view/wettsysteme", "/amazon/schuhe", "/show/amazon_schuhe",
                        "/details/artikles/{id}", "/online/ebook", "/show/e_book", "/amazon/e_book", "/view/ebook",
                        "/online/essen","/show/essen","/view/essen"
                ).permitAll()
                .antMatchers("/articles/add", "/update/article/{id}", "/log-stat/alll",
                        "/add/amazon", "/details/remove/{id}", "/update/amazon{id}",
                        "/add/mt-digitale-produkte").hasRole("ADMIN")
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/")
                .failureForwardUrl("/users/login-error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(this.boilSecurity)
                .passwordEncoder(this.passwordEncoder);
    }
}
