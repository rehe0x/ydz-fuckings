package com.ydz.fuckings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 *http://blog.csdn.net/baidu_24237655/article/details/72772402
 *nohup java -Xms1500m -Xmx1500m -jar ydz.jar > logs.log 2>&1 &
*/

@SpringBootApplication
public class Application extends SpringBootServletInitializer 
{
	
	  
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
        System.out.println( "Hello World!" );
    }

    
//      @Bean
//	  public EmbeddedServletContainerFactory servletContainer() {
//
//	      TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//
//	          @Override
//	          protected void postProcessContext(Context context) {
//	        	  SecurityConstraint securityConstraint = new SecurityConstraint();
//	        	  
//	              securityConstraint.setUserConstraint("CONFIDENTIAL");
//	       
//	              SecurityCollection collection = new SecurityCollection();
//	       
//	              collection.addPattern("/*");
//	       
//	              securityConstraint.addCollection(collection);
//	       
//	              context.addConstraint(securityConstraint);
//	          }
//	      };
//	      tomcat.addAdditionalTomcatConnectors(httpConnector());
//	      return tomcat;
//	  }
//	  
//      @Bean
//      public Connector httpConnector() {
//	      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	      connector.setScheme("http");
//	      connector.setPort(80);
//	      connector.setRedirectPort(443);
//	      connector.setSecure(false);
//	      return connector;
//	  }
//	
	
}
