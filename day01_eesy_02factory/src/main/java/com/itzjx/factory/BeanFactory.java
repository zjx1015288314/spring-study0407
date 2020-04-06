package com.itzjx.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean:可重用组件
 * JavaBean:>实体类 ,java语言编写的实体类,这里用来创建service和dao对象
 *
 * 第一步：需要一个配置文件来配置我们的service和dao,配置的内容 ：唯一标识=全限定类名(key=value)
 * 第二步：读取配置文件，反射创建对象
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个Map，用于存放我们要创建的对象。我们把它称之为容器 -----使用单例模式:因为业务层和持久层很少包含可修改的类变量
    private static Map<String,Object> beans;
    //使用静态代码块为properties为对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象,以防配置文件位置变更，所以不采用FileInputStream
            InputStream in =  BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //通过key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }
    //根据bean的名称获取单例对象
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

//    /**
//     * 根据Bean的名称获取bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try{
//            String beanPath = props.getProperty(beanName);
////            System.out.println(beanPath);
//            bean = Class.forName(beanPath).newInstance();  //每次都会调用默认构造函数创建对象
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }


}
