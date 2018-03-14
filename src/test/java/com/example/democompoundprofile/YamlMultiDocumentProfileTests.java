package com.example.democompoundprofile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author Tommy Ludwig
 */
public class YamlMultiDocumentProfileTests {

	private final StandardEnvironment environment = new StandardEnvironment();

	private final SpringApplication application = new SpringApplication();

	private final ConfigFileApplicationListener listener = new ConfigFileApplicationListener();

	@Test
	public void multiDocYamlProfileInProfiledFileLoads() {
		this.listener.setSearchNames("profiledmultidoc");
//		this.environment.setActiveProfiles("dev", "cloud"); // this works
		this.environment.setActiveProfiles("cloud", "dev"); // this does not
		this.listener.postProcessEnvironment(this.environment, this.application);
		String property = this.environment.getProperty("my.prop");
		assertThat(property).isEqualTo("hi");
	}
}
