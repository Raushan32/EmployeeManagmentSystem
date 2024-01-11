/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raushan.dao;

import com.raushan.bean.EmpBean;
import com.raushan.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkhjp
 */
public class EmpDAO {
    //1
    Connection conn;
    public int addEmp(EmpBean em) throws ClassNotFoundException{
int r=0;
//step1
///step2
conn=ConnectionPool.connectDB();
//step3 write SQL Query
String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)values('"+em.getEmpno()+"','"+em.getEname()+"','"+em.getJob()+"','"+em.getMgr()+"','"+em.getHiredate()+"','"+em.getSal()+"','"+em.getComm()+"','"+em.getDeptno()+"')";
try {
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
r=stmt.executeUpdate(sql);
//step 5 close the connection
conn.close();
} catch (SQLException ex) {
Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return r;
}
    //2
    
    public int updateEmp(EmpBean em) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        //step3 
        String sql="update Emp set job='"+em.getJob()+"',ename='"+em.getEname()+"' ,sal='"+em.getSal()+"' ,hiredate='"+em.getHiredate()+"' ,mgr='"+em.getMgr()+"',deptno='"+em.getDeptno()+"' ,comm='"+em.getComm()+"'  where empno='"+em.getEmpno()+"'";
        Statement stmt=conn.createStatement();
        //step4
        r=stmt.executeUpdate(sql);
        //step5
        conn.close();
        return r;
    }
    
    //3
    
    public int deleteEmp(int empno) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="delete from emp where empno='"+empno+"'";
        Statement stmt=conn.createStatement();
        r=stmt.executeUpdate(sql);
        conn.close();
        return r;
    }
    
    //4
    

    public ArrayList<EmpBean> findAll() throws SQLException, ClassNotFoundException{
       conn=ConnectionPool.connectDB();
       ArrayList<EmpBean> al =new ArrayList();
        String sql="select * from emp ";
        Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(sql);
        System.out.println("=======================================================");
        while(rs.next()){
           // System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
            // System.out.println(""+rs.getInt(empno)+"\t\t\t"+rs.getString(ename)+"\t\t\t"+rs.getString(job)+"\t\t\t"+rs.getInt(mgr)+"\t\t\t"+rs.getString(hiredate)+"\t\t\t"+rs.getInt(sal)+"\t\t\t"+rs.getInt(comm)+"\t\t\t"+rs.getInt(deptno));
            EmpBean eb =new EmpBean();
            eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
        }

       
        return al;
    }
    
    //5
    
    public EmpBean findById(int empno) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="select * from emp where empno='"+empno+"'";
        Statement stmt;
        EmpBean eb =new EmpBean();
        stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
//              System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
// System.out.println(""+rs.getInt(empno)+"\t\t\t"+rs.getString(ename)+"\t\t\t"+rs.getString(job)+"\t\t\t"+rs.getInt(mgr)+"\t\t\t"+rs.getString(hiredate)+"\t\t\t"+rs.getInt(sal)+"\t\t\t"+rs.getInt(comm)+"\t\t\t"+rs.getInt(deptno));
        
            eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            
        }
        return eb;
    }
    
    //6
    
    public ArrayList<EmpBean> findAllByDeptno(int deptno) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        ArrayList<EmpBean> al=new ArrayList();
        String sql="select * from emp where deptno='"+deptno+"'";
        Statement stmt;
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
        EmpBean eb =new EmpBean();
        
        eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
        }
        return al;
    }
    //7
    
    public ArrayList<EmpBean> findByJob(String job) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="select * from emp where job='"+job+"'";
        ArrayList<EmpBean> al =new ArrayList();
        Statement stmt;
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
        EmpBean eb = new EmpBean();
        eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
        }
        return al;
    }
    
    //8
    
    public void sortEmpAscOrder(int sal) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        
        String sql="select * from emp order by sal asc ";
        Statement stmt;
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
        }
    }
    
    //9
    public ArrayList<EmpBean>  sortEmpAscOrder() throws ClassNotFoundException, SQLException{
      conn=ConnectionPool.connectDB();
        
        String sql="select * from emp order by ename asc ";
        Statement stmt;
         ArrayList<EmpBean> al =new ArrayList();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
           // System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
       EmpBean eb =new EmpBean();
            eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
        }  
        return al;
    }
    //10
    
    public ArrayList<EmpBean> sortEmpDesOrder() throws ClassNotFoundException, SQLException{
      conn=ConnectionPool.connectDB();
        
        String sql="select * from emp order by ename desc ";
        Statement stmt;
        stmt=conn.createStatement();
        ArrayList<EmpBean> al =new ArrayList();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            EmpBean eb =new EmpBean();
            eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
            //System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getInt(8));
        }  
        return al;
    }
    
    //11
    
    public double sumSal() throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="select sum(sal) as Total_Salaray from emp";
        Statement stmt;
        stmt=conn.createStatement();
       double ts=0;
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
         ts=rs.getInt(1);
        }
        System.out.println("Sum of Salary");
       
        conn.close();
         return ts;
    }
    
    //12 
    public double sumSalByDeptno(int deptno) throws ClassNotFoundException, SQLException{
       
        conn=ConnectionPool.connectDB();
        //String sql="insert into category(catname,catdetails)values('"+cb.getCatName()+"','"+cb.getCatDetails()+"')";
        String sql="select sum(sal) as total_salary from emp where deptno='"+deptno+"'";
       
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
 //r=stmt.executeUpdate(sql);
 double ts=0;
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
         ts=rs.getInt(1);
        }
        System.out.println("Sum of Salary of deptno :");
        conn.close();
       return ts;
        
//step 5 close the connection

    }
         
    //13
    
    public double sumSalByJob(String job) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="select sum(sal) as total_salaryByJob from emp where job='"+job+"'";
       
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
double ts=0;
ResultSet rs=stmt.executeQuery(sql);
//step 5 close the connection
if(rs.next()){
    ts=rs.getInt(1);
}
        System.out.println("Sum of Salary By Job :");
conn.close();
return ts;
}
    
    //14
    
    public double avgSal(String job) throws ClassNotFoundException, SQLException{
        double ts=0;
        conn=ConnectionPool.connectDB();
        String sql="select avg(sal) as avarage_salary from emp ";
       try {
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
 ResultSet rs=stmt.executeQuery(sql);
//step 5 close the connection
if(rs.next()){
    ts=rs.getInt(1);
}
           System.out.println("Avarag Salary : ");
conn.close();
} catch (SQLException ex) {
Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return ts;
}
    //15
    
    public double avgSalByDeptno(int deptno) throws ClassNotFoundException, SQLException{
        double ts=0;
        conn=ConnectionPool.connectDB();
        String sql="select avg(sal) as avarage_salaryByDeptno from emp where deptno='"+deptno+"'";
       try {
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
 ResultSet rs=stmt.executeQuery(sql);
//step 5 close the connection
if(rs.next()){
    ts=rs.getInt(1);
}
           System.out.println("Avarage Salary By Deptno :");
conn.close();
} catch (SQLException ex) {
Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return ts;
}
    //16
    
    public double avgSalByJob(String job) throws ClassNotFoundException, SQLException{
        double ts=0;
        conn=ConnectionPool.connectDB();
        String sql="select avg(sal) as total_salary from emp where job='"+job+"'";
       try {
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
 ResultSet rs=stmt.executeQuery(sql);
//step 5 close the connection
if(rs.next()){
    ts=rs.getInt(1);
}
           System.out.println("Avarage Salary By Job :");
conn.close();
} catch (SQLException ex) {
Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return ts;
}
    //17
    
 public ArrayList<EmpBean> higestSal() throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
       // String sql="select max(Sal) as Higest_salary from emp ";
        String sql="select * from emp ";
            // String sql="select * from emp order by sal desc ";
       ArrayList<EmpBean> al =new ArrayList();
Statement stmt=conn.createStatement();
//step4 call executeUpdate method
ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            
             EmpBean eb =new EmpBean();
           // int Sal=rs.getIntSal();
           // System.out.println("Higest Salary : "+rs.getInt(1));
           eb.setSal(rs.getInt("sal"));
            al.add(eb);
        }
        return al;
//step 5 close the connection

}
 //18
 public ArrayList<EmpBean> topFiveHigestsal() throws ClassNotFoundException, SQLException{
    conn=ConnectionPool.connectDB();
    String sql="select * from emp order by sal desc limit 5";
    Statement stmt=conn.createStatement();
    ArrayList<EmpBean> al=new ArrayList();
    ResultSet rs;
        rs = stmt.executeQuery(sql);
        while(rs.next()){
    EmpBean eb =new EmpBean();    
            //System.out.println(+rs.getInt("sal"));
        eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
        }
        return al;
 }
 
 //19
 
 public ArrayList<EmpBean> findLowestSalEmp() throws SQLException, ClassNotFoundException{
       
            conn=ConnectionPool.connectDB();
        
    // String sql="select min(sal) as Lowest_salary from emp ";
    String sql="select * from emp "; 
    Statement stmt=conn.createStatement();
     ArrayList<EmpBean> al =new ArrayList();
     ResultSet rs;
     rs=stmt.executeQuery(sql);
     while(rs.next()){
        // System.out.println("Lowest Salaray is : "+rs.getInt(1));
     EmpBean eb =new EmpBean();
     eb.setSal(rs.getInt("sal"));
     al.add(eb);
     }
     return al;
 }
    //20
 
 public ArrayList<EmpBean> topFiveLowestSalEmp() throws ClassNotFoundException, SQLException{
    conn=ConnectionPool.connectDB();
    String sql="select * from emp order by sal asc limit 5";
    ArrayList<EmpBean> al =new ArrayList();
    Statement stmt=conn.createStatement();
    ResultSet rs;
    rs=stmt.executeQuery(sql);
    while(rs.next()){
        //System.out.println(""+rs.getInt("sal"));
        EmpBean eb =new EmpBean();
        eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
    }
    return al;
 }
    //21
 
 public ArrayList<EmpBean> countNumberEmp() throws ClassNotFoundException, SQLException{
     conn=ConnectionPool.connectDB();
     String sql="select count(empno) from emp";
     ArrayList<EmpBean> al=new ArrayList();
     Statement stmt=conn.createStatement();
     ResultSet rs;
     rs=stmt.executeQuery(sql);
     while(rs.next()){
//         System.out.println(""+rs.getInt(1));
    EmpBean eb =new EmpBean();
    eb.setEmpno(rs.getInt("empno"));
     }
     return al;
 }
    //22
 
 public ArrayList<EmpBean> countEmployeeByJob(String job) throws ClassNotFoundException, SQLException{
     conn=ConnectionPool.connectDB();
//     String sql="select count(job) from emp where job ='"+job+"'";
 String sql="select * from emp where job ='"+job+"'";
     Statement stmt=conn.createStatement();
     ArrayList<EmpBean> al =new ArrayList();
    ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getInt(1));
            EmpBean eb =new EmpBean();
//           eb.setEmpno(rs.getInt("empno"));
//            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
//            eb.setMgr(rs.getInt("mgr"));
//            eb.setHiredate(rs.getString("hiredate"));
//            eb.setSal(rs.getInt("sal"));
//            eb.setComm(rs.getInt("comm"));
//            eb.setDeptno(rs.getInt("deptno"));
al.add(eb);
            
        }
        return al;
 }
    //23
 
 public ArrayList<EmpBean> findAllSal(int start,int end) throws ClassNotFoundException, SQLException{
     conn=ConnectionPool.connectDB();
     ArrayList<EmpBean> al =new ArrayList();
     String sql="select * from emp where sal>='"+start+"' and sal<='"+end+"'";
     Statement stmt=conn.createStatement();
     ResultSet rs=stmt.executeQuery(sql);
     while(rs.next()){
           // System.out.println(""+rs.getInt(1));
     EmpBean eb =new EmpBean();
      eb.setEmpno(rs.getInt("empno"));
            eb.setEname(rs.getString("ename"));
            eb.setJob(rs.getString("job"));
            eb.setMgr(rs.getInt("mgr"));
            eb.setHiredate(rs.getString("hiredate"));
            eb.setSal(rs.getInt("sal"));
            eb.setComm(rs.getInt("comm"));
            eb.setDeptno(rs.getInt("deptno"));
            al.add(eb);
     }
     return al;
 }
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
    
    
     //1 Add Emp
     
//     EmpBean b=new EmpBean();
//     b.setEmpno(1007);
//     b.setEname("Raushan");
//     b.setJob("Devloper");
//     b.setMgr(7839);
//     b.setSal(95000);
//     b.setHiredate("2023-10-25");
//     b.setComm(15000);
//     b.setDeptno(5);
//     
//     EmpDAO cd=new EmpDAO();
//     int x=cd.addEmp(b);
//     if(x>0){
//         System.out.println("Data Insert Succesfully");
//     }else{
//         System.out.println("Data Not Insert ");
//     }
     
     //2 UpdateEmp
     
//     EmpBean b=new EmpBean();
//     b.setEmpno(1007);
//     b.setEname("Null");
//     b.setJob("NULL");
//     b.setMgr(0);
//     b.setSal(0);
//     b.setHiredate("2000-10-15");
//     b.setComm(0);
//     b.setDeptno(1);
//     
//     EmpDAO cd=new EmpDAO();
//     int x=cd.updateEmp(b);
//     if(x>0){
//         System.out.println("Data Updated Succesfully");
//     }else{
//         System.out.println("Data Not Updated");
//     }

    //3 deleteEmp(int empno)
    
//    EmpDAO cd =new EmpDAO();
//    int x=cd.deleteEmp(1007);
//    if(x>0){
//        System.out.println("Data Deleted Succesfully");
//    }else{
//        System.out.println("Data Not Deleted");
//    }
     
    //4 findAll()
    
//    EmpDAO cd =new EmpDAO();
//    cd.findAll();
    
    //5 findById()
    
//    EmpDAO cd =new EmpDAO();
//    cd.findById(800);

    //6 findAllByDeptno
    
//    EmpDAO cd =new EmpDAO();
//    cd.findAllByDeptno(30);
    
    //7 findByJob()
    
//    EmpDAO cd=new EmpDAO();
//    cd.findByJob("Salesman");
    
    //8 sortEmpAscOrder(int sal)
    
//    EmpDAO cd=new EmpDAO();
//    cd.sortEmpAscOrder(0);
    
    //9 sortEmpAscOrder(String ename)
    
//    EmpDAO cd=new EmpDAO();
//    cd.sortEmpAscOrder("");
    
    //10 sortEmpDesOrder(int sal)
    
//    EmpDAO cd=new EmpDAO();
//    cd.sortEmpDesOrder(0);

    //11 sumSal() 
    
//  EmpDAO cd=new EmpDAO();
//    System.out.println("Total Salary : "+cd.sumSal());
    
    //12 sumSalByDeptno(int deptno)
    
//    EmpDAO cd=new EmpDAO();
//    System.out.println(""+cd.sumSalByDeptno(20));

//13 sumSalByJob(String job)

//EmpDAO cd=new EmpDAO();
//     System.out.println(""+cd.sumSalByJob("manager"));

//14 avgSal(String job)

//EmpDAO cd=new EmpDAO();
//     System.out.println(""+cd.avgSal("manager"));

//15 avgSalByDeptno(int deptno) 

//EmpDAO cd=new EmpDAO();
//     System.out.println(""+cd.avgSalByDeptno(20));

//16 avgSalByJob(String job)

EmpDAO cd=new EmpDAO();
     //System.out.println(""+cd.avgSalByJob("Salesman"));

//17 higestSal()

//cd.higestSal();

//18 topFiveHigestSalariedEmployee()
//     System.out.println("Top Five Salary ");
//     cd.topFiveHigestsal();

//19 findLowestSalariedEmployee()

//cd.findLowestSalEmp();

//20 topFiveLowestSalariedEmployee()

//System.out.println("Top Five Lowest Salary ");
//cd.topFiveLowestSalEmp();

//21 countNumberOfEmployee()

//System.out.println("Number Of Employees ");
//cd.countNumberEmp();

//22 countEmployeeByJob(String job)
//System.out.println("Number Of Employees By Job");
//cd.countEmployeeByJob("manager");

//23 findAllSal(int start,int end)

// cd.findAllSal(0, 4500);
 }

   
}


