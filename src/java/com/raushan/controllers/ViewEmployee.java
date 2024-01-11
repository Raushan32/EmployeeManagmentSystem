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
import java.util.ArrayList;
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
public class ViewEmployee extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession hs = request.getSession();
            String u = "Raushan Kumar";
            out.println("<h1 align='center'>Welcome : "+u+"</h1>");
            
            
            // Set the content type of the response
        response.setContentType("text/html");
     // Create a RequestDispatcher to include the navigation bar HTML
        RequestDispatcher dispatcher = request.getRequestDispatcher("nav.html");
         // Include the navigation bar in the response
        dispatcher.include(request, response);
        
     
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewEmployee</title>");            
            out.println("</head>");
            
             
            
            out.println("<body>");
            out.println("<center>");
//            out.println("<a href='index.html'>Add Employee</a>");
            out.println("<table border='1' width='50%'>");
                out.println("<tr>");
              out.println("<th>Empno</th>");
              out.println("<th>Ename</th>");
              out.println("<th>Job</th>");
              out.println("<th>Mgr</th>");
              out.println("<th>Hiredate</th>");
              out.println("<th>Sal</th>");
              out.println("<th>Comm</th>");
              out.println("<th>Deptno</th>");
              out.println("<th>EDIT</th>");
               out.println("<th>DELETE</th>");
            out.println("</tr>");
            EmpDAO ed =new EmpDAO();
            ArrayList<EmpBean> al=ed.findAll();
            for(EmpBean eb :al){
                out.println("<tr>");
                out.println("<td>"+eb.getEmpno()+"</td>");
                out.println("<td>"+eb.getEname()+"</td>");
                out.println("<td>"+eb.getJob()+"</td>");
                out.println("<td>"+eb.getMgr()+"</td>");
                out.println("<td>"+eb.getHiredate()+"</td>");
                out.println("<td>"+eb.getSal()+"</td>");
                out.println("<td>"+eb.getComm()+"</td>");
                out.println("<td>"+eb.getDeptno()+"</td>");
                out.println("<td><a href='UpdateEmpForm?empno="+eb.getEmpno()+"'>EDIT</a></td>");
                out.println("<td><a href='DeleteEmp?empno="+eb.getEmpno()+"'>DELETE</a></td>");
                
                out.println("</tr>");
            }
  
            out.println("</table>");
            out.println("</center");
//            out.println("<h1>Servlet ViewEmployee at " + request.getContextPath() + "</h1>");
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
