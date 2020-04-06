package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 *      @Configuration:指定当前类是一个配置类
 *          当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可不写
 *      @ComponentScan:通过该注解指定spring在创建容器时要扫描的包
 *          属性：value，与basePackages的作用是一样的，都是用于指定创建容器时要扫描的包,
 *          我们使用此注解就等于在xml中配置了：<context:component-scan base-package="com.itzjx"></context:component-scan>
 *      @Bean:用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *          属性：name，指定bean的id。不写时，默认值是当前方法的名称
 *      当我们使用注解配置时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象，查找的方式和@Autowired的作用是一样的，
 *      即自动按照类型注入
 *      @Import:用于导入其他的配置类
 *          属性：指定其他配置类的字节码
 *          当我们使用@Import之后，有Import注解的类就是父配置类，而导入的都是子配置类。如果是同级别的配置类，可以在核心容器创建时导入
 *      相关的配置类。如果不想使用@Import，且需要父子配置类，则需要在父配置类中加@ComponentScan，子配置类中加@Configuration(不加
 *      该注解的话，即使包扫描也无法配置该类)
 *      @PropertySource
 *          指定properties文件的位置
 *          属性：
 *              value：指定文件的名称和路径。关键字：classpath,表示类路径下
 *
 */
//@Configuration
@Import(JdbcConfig.class)
@PropertySource("jdbcConfig.properties")
@ComponentScan("com.itzjx")   //如果注解的属性只有一个值，且是数组类型，那么就可以写为"com.itzjx"
public class SpringConfiguration {

}
