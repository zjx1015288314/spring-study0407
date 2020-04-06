package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan(basePackages = "com.itzjx")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("jdbcConfig.properties")  //导入资源文件
@EnableTransactionManagement      //开启注解事务的支持
public class SpringConfiuration {
}
