package br.com.tdec.reforma.config;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LocaleConfig {

	@PostConstruct
	public void init() {
		// TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		Locale.setDefault(new Locale("pt", "BR"));
		//DecimalFormat df = new java.text.DecimalFormat("###,####,##");
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		System.out.println("Config - LocaleConfig - TimeZone eh " + new Date().toString());
	}
}
