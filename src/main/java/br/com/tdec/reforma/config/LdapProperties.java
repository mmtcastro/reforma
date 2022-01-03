package br.com.tdec.reforma.config;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


import lombok.Data;

@Data
@Validated

@Configuration
@ConfigurationProperties("ldap.properties")
public class LdapProperties {
	@NotNull
	@NotEmpty
	private String userSearchFilter;
	@NotNull
	@NotEmpty
	private String userSearchBase;
	@NotNull
	@NotEmpty
	private String url;
	@NotNull
	private int port;
	@NotNull
	@NotEmpty
	private String managerDn;
	@NotNull
	@NotEmpty
	private String managerPassword;

}
