/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raushan.controllers;

import com.raushan.bean.EmpBean;
import com.raushan.dao.EmpDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkhjp
 */
public class UpdateEmp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession hs = request.getSession();
//            String u = (String)hs.getAttribute("user");
String u = "Raushan Kumar";          
out.println("<h1 align='center'>Welcome : "+u+"</h1>");
           
                             
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("nav.html");
        dispatcher.include(request, response);
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmp</title>");            
            out.println("</head>");
            
             
            
            out.println("<body>");
             String ename=request.getParameter("ename");
                    String job=request.getParameter("job");
                    int mgr=Integer.parseInt(request.getParameter("mgr"));
                     String hiredate=request.getParameter("hiredate");
                     int sal=Integer.parseInt(request.getParameter("sal"));
                     int comm=Integer.parseInt(request.getParameter("comm"));
                     int deptno=Integer.parseInt(request.getParameter("deptno"));
                      EmpBean eb=new EmpBean();
                     //step 3 set properties of EmpBean
                     eb.setEname(ename);
                     eb.setJob(job);
                     eb.setMgr(mgr);
                     eb.setHiredate(hiredate);
                     eb.setSal(sal);
                     eb.setComm(comm);
                     eb.setDeptno(deptno);
                     //step 4 create object of EmpDAO
                     EmpDAO ed=new EmpDAO();
                     //step 5 call AddEmp Method
                     int r=ed.updateEmp(eb);
                     if(r>0){
              response.sendRedirect("ViewEmployee");
            out.println("<h1><font color='green'>Category Added successs</font></h1>");
            }
            else
            {
                 response.sendRedirect("ViewEmployee");
                out.println("<h1><font color='red'>Category Not Added</font></h1>");
            }
            out.println("<h1>Servlet UpdateEmp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateEmp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateEmp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
