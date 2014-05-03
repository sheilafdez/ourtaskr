package net.javaloping.ourtaskr.web.context;

import static org.dozer.loader.api.TypeMappingOptions.*;
import static org.springframework.beans.factory.config.BeanDefinition.*;

import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.business.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author victormiranda
 */

@Configuration
@ComponentScan({
	"net.javaloping.ourtaskr.web.controller",
	"net.javaloping.ourtaskr.business.service",
	"net.javaloping.ourtaskr.business.dao"
})
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurationSupport {

	@Bean
	@Scope(SCOPE_SINGLETON)
	public DozerBeanMapperFactoryBean dozerFactoryBean() {
		DozerBeanMapperFactoryBean dozerBean = new DozerBeanMapperFactoryBean();
		return dozerBean;
	}

	@Bean(name = "dozerMapper")
	@Scope(SCOPE_SINGLETON)
	public DozerBeanMapper dozerMapper() {
		DozerBeanMapper dozerMapper = new DozerBeanMapper();

		dozerMapper.addMapping(new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(User.class, UserDTO.class,
						TypeMappingOptions.oneWay(),
						mapId("A"),
						mapNull(true)
				);
			}
		});

		return dozerMapper;
	}

}