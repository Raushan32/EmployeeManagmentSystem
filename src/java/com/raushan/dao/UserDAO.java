/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raushan.dao;

import com.raushan.bean.EmpBean;
import com.raushan.bean.UserBean;
import com.raushan.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author rkhjp
 */
public class UserDAO {
 
    Connection conn=null;
    public int registerUSer(UserBean ub) throws ClassNotFoundException{
        int r=0;
    conn=ConnectionPool.connectDB();
        //step3
        String sql="insert into user(uid,name,username,password)values('"+ub.getUid()+"','"+ub.getName()+"','"+ub.getUserName()+"','"+ub.getPassword()+"')";
        try{
            Statement stmt=conn.createStatement();
            //step4 call executeUpdate method;
            r=stmt.executeUpdate(sql);
            //step 5 close the connection
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,ex);  
        }
        
        if(r>0){
            System.out.println("Registration success");
        }else{
            System.out.println("Registration Failed");
        }
        return r;
    }
    
    public int loginCheck(String username ,String password) throws SQLException, ClassNotFoundException{
        int id=0;
      
        conn=ConnectionPool.connectDB();
        String sql="select uid from user where username ='"+username+"'and password ='"+password+"'"; 
        try{
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                id=rs.getInt("uid");
            }
        }catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,ex);  
        }
            
        return id;
    }
    public UserBean forgotPwd(String name ,String password) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
       
       String sql="Select * from user where name ='"+name+"'and password ='"+password+"'"; 
      Statement stmt=conn.createStatement();
       UserBean ub =new UserBean();
      ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()){
        ub.setName(rs.getString("username"));
          
      }
        
       return ub;
            
        
      
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
         UserDAO ud=new UserDAO();
//          UserBean b=new UserBean();
//        b.setName("Raushan");
//        b.setUserName("R123");
//        b.setPassword("1111");
          int x=ud.loginCheck("R123", "1111");
        if(x>0){
            System.out.println("Login success");
        }
        else{
            System.out.println("Login fail");
        }
    }
    }

