package com.lzh.util;

import java.sql.*;
public class DBhelper {
    Connection conn = null;
    ResultSet rs = null;
    //连接数据库
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","LIANqq74148");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            System.out.println("数据库驱动加载失败！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
        
    }
    
    //查询
    public ResultSet Search(String sql, String str[]){
        connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if(str != null){
                for(int i=0;i<str.length-1;i++){
                    pst.setString(i+1, str[i]);
                }
                pst.setInt(str.length, Integer.parseInt(str[str.length-1]));
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    //增删修改
    public int AddU(String sql, String str[]){
        int a =0;
        connect();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if(str != null){
                for(int i=0;i<str.length-1;i++){
                    pst.setString(i+1, str[i]);
                }
                pst.setInt(str.length, Integer.parseInt(str[str.length-1]));
            }
            a = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }
    
    
}
