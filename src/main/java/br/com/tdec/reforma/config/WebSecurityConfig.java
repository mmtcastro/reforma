package br.com.tdec.reforma.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

private LdapProperties ldapProperties;
	
	public WebSecurityConfig(LdapProperties ldapProperties) {
		this.ldapProperties = ldapProperties;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/sw.js").permitAll().anyRequest().fullyAuthenticated().and().formLogin()
				.and().csrf().disable()
				.httpBasic();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.anyRequest()
//				.authenticated().and()
//				.csrf().disable()
//				.httpBasic();
//a
//	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//System.out.println("LDAP url eh " + ldapProperties.getUrl());
		
		auth.ldapAuthentication().userSearchFilter(ldapProperties.getUserSearchFilter())// 
		.contextSource()//
		.url(ldapProperties.getUrl())//
		.port(ldapProperties.getPort()).managerDn(ldapProperties.getManagerDn())//
		.managerPassword(ldapProperties.getManagerPassword());

		
		/* deixei o código abaixo pois pode servir para alguma melhoria futura
		
		auth.ldapAuthentication().userSearchFilter("(uid={0})")// .userSearchBase("o=TDec")
				// .groupRoleAttribute("cn").groupSearchFilter("(member={0})")

				// .userDnPatterns("uid={0}")
				// .groupSearchBase("ou=groups")
				.contextSource()//
				.url("ldap://lexapro.tdec.com.br:389/O=TDec")//
				.port(389).managerDn("CN=Marcelo Castro, O=TDec")//
				.managerPassword("Hodge$404");
		// .and()
		// .passwordCompare()
		// .passwordEncoder(new
		// BCryptPasswordEncoder()).passwordAttribute("userpassword");
		
		*/
		
		
		
	}


//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication().userDnPatterns("cn={0}")
//				// .groupSearchBase("ou=groups")
//				.contextSource().url("ldap://prozac.tdec.com.br:389/DC=tdec,DC=com,DC=br").port(389)
//				.managerDn("CN=Marcelo Castro,OU=Diretoria,OU=SaoPaulo,OU=TDec,DC=tdec,DC=com,DC=br")
//				.managerPassword("Hodge$404tdec").and().passwordCompare().passwordEncoder(new BCryptPasswordEncoder())
//				.passwordAttribute("userpassword");
//	}
	
	/**
	 * Allows access to static resources, bypassing Spring security.
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(
				// client-side JS code
				"/VAADIN/**",

				// the standard favicon URI
				"/favicon.ico",

				// the robots exclusion standard
				"/robots.txt",

				// web application manifest
				"/manifest.webmanifest",
				"/sw.js",
				"/offline-page.html",

				// icons and images
				"/icons/**",
				"/images/**",

				// (development mode) H2 debugging console
				"/h2-console/**", 
				
				// Faltava este...
				"/sw-runtime-resources-precache.js"
	
		);
	}

	public LdapProperties getLdapProperties() {
		return ldapProperties;
	}

	public void setLdapProperties(LdapProperties ldapProperties) {
		this.ldapProperties = ldapProperties;
	}

}
