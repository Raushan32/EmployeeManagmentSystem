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
public class EmpBean {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;

    public EmpBean() {
    }

    public EmpBean(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public int getMgr() {
        return mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public int getSal() {
        return sal;
    }

    public int getComm() {
        return comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

   
    
    
}
