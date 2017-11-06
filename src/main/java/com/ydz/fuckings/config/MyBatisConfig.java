package com.ydz.fuckings.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;
/**
 * mybatis配置文件
 * @author Administrator
 *
 */
@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
public class MyBatisConfig  implements TransactionManagementConfigurer {
	private static final String TYPE_ALIASES_PACKAGE = "com.ydz.fucking.business.model"; 
	private static final String MAPPER_LOCATION = "classpath:/mapper/*.xml";

	@Autowired
    private DataSource dataSource;
	
	
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(PageHelper pageHelper) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //自定义数据库配置的时候，需要将pageHelper的bean注入到Plugins中，
        //如果采用系统默认的数据库配置，则只需要定义pageHelper的bean，会自动注入。 
        
        bean.setPlugins(new Interceptor[] {pageHelper});
        
        /**mybatis.typeAliasesPackage：指定domain类的基包，
         * 即指定其在*Mapper.xml文件中可以使用简名来代替全类名
         * （看后边的UserMapper.xml介绍）*/
        bean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
    	/* mybatis.mapperLocations：指定*Mapper.xml的位置 如果不加会报
    	 * org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): 
    	 * com.blog.mapper.MessageMapper.findMessageInfo异常 
    	 * 因为找不到*Mapper.xml，也就无法映射mapper中的接口方法。 */
    	 bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml")); 
        try {
        
        
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	
	@Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }
	
	
}
