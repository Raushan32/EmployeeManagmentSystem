/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raushan.bean;

/**
 *
 * @author rkhjp
 */
public class UserBean {
     private int uid;
    private String Name;
     private String UserName; 
      private String Password; 

    public UserBean() {
    }

    public UserBean(int uid, String Name, String UserName, String Password) {
        this.uid = uid;
        this.Name = Name;
        this.UserName = UserName;
        this.Password = Password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
      
     
}
