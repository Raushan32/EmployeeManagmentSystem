/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raushan.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkhjp
 */
public class ConnectionPool{
    static Connection conn;

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static Connection connectDB() throws ClassNotFoundException{
        try {
            //step1
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aug1db","root","123456789");
            System.out.println("Database Connected succesfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        connectDB();
    }
}