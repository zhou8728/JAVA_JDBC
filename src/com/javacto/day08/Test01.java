package com.javacto.day08;

import javax.management.Query;
import java.sql.*;

public class Test01 {
//    jdbc出错只有两个地方
//    1 没有连接成功
//    2 sql语句有错
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.加载驱动  DriverManager
//            Class.forName("");  //如果换数据库只需要改两处  这是第一处
        Class.forName("com.mysql.jdbc.Driver");
//        2.建立连接   Connection
//        Connection conn = DriverManager.getConnection("每个数据库不一样",user:"用户名",password:"") //如果换数据库只需要改两处  这是第二处
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3360/mysql",user:"root",password:"123456");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=GMT","root","123456");
//        需要先测试一下
        System.out.print(conn);
//        3.创建Statement对象 主要负责操作SQL语句
        Statement stm = conn.createStatement();
//        4.通过Statement对象 操作数据库 并返回结果集
//        这里的语句在外部测试完成后放入语句
//        a.如果是查询返回的是ResultSet 只有查询才返回ResultSet
//        ResultSet rs = stm.executeQuery(sql:"SELECT * FROM tuser");
        ResultSet rs= stm.executeQuery("SELECT * FROM tuser");//数据库语句，不能有;
        while (rs.next()){//循环每一条数据
            //System.out.print(rs.getInt(1));
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.println(rs.getString(6));
        }
//        b.如果是DML 增删改返回的是int类型  受影响的行数
//        5.如果是查询就有这一步，不是查询没有
//        循环结果集 ResultSet 因为这是一个集合所以需要循环
//        6.释放资源
        rs.close();
        stm.close();
        conn.close();
    }
}
