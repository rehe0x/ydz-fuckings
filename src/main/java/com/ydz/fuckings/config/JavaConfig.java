package com.ydz.fuckings.config;

import java.io.File;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置默认路径
* @ClassName: JavaConfig 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年5月19日 下午5:03:11 
*
 */
@Configuration
public class JavaConfig {
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		return(ConfigurableEmbeddedServletContainer container) ->{
			container.addInitializers();
			container.setDocumentRoot(new File(System.getProperty("user.dir")));
		};
	}
}
