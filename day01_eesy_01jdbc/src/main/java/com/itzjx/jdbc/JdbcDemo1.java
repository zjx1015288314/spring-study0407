package com.itzjx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 耦合：程序间的依赖关系，包括：类之间的依赖，方法间的依赖
 * 解耦：降低程序间的依赖关系
 * 实际开发中，应该做到编译期不依赖，运行时才依赖
 * 解耦思路：
 *      第一步：使用反射来创建对象，而避免使用new关键字
 *      第二步：读取配置文件来获取要创建的对象全限定类名,防止后期变更数据库时不方便
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC",
                "root","zjx19950426.");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();

    }

}
