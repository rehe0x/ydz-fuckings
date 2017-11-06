package com.ydz.fuckings.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;  
  
@Component()
public class TomcatConfig extends TomcatEmbeddedServletContainerFactory  
{  
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers)  
    {  
        //设置端口  
        this.setPort(1042);
    	//this.addAdditionalTomcatConnectors(httpConnector());
        return super.getEmbeddedServletContainer(initializers);  
    }  
      
    protected void customizeConnector(Connector connector)  
    {  
    	  super.customizeConnector(connector); 
    
       
      //  this.addAdditionalTomcatConnectors(connector);  
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();  
        //设置最大连接数  
        protocol.setMaxConnections(2000);  
        //设置最大线程数  
        protocol.setMaxThreads(2000);  
        protocol.setConnectionTimeout(30000);  
    } 
    
//    protected void postProcessContext(Context context) {
//  	  SecurityConstraint securityConstraint = new SecurityConstraint();
//  	  
//        securityConstraint.setUserConstraint("CONFIDENTIAL");
// 
//        SecurityCollection collection = new SecurityCollection();
// 
//        collection.addPattern("/*");
// 
//        securityConstraint.addCollection(collection);
// 
//        context.addConstraint(securityConstraint);
//    }
    
//  @Bean
//  public Connector httpConnector() {
//      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//      connector.setScheme("http");
//      connector.setPort(80);
//      connector.setRedirectPort(443);
//      connector.setSecure(false);
//      return connector;
//  }
    

} 
