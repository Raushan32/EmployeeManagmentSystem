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
import static java.sql.DriverManager.println;
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
public class UpdateEmpForm extends HttpServlet {

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
//            String u = (String)hs.getAttribute("user");
String u = "Raushan Kumar";          
out.println("<h1 align='center'>Welcome : "+u+"</h1>");
            
                             
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("nav.html");
        dispatcher.include(request, response);
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmpForm</title>");            
            out.println("</head>");
          
           
            out.println("<body>");
            
            out.println("<form action='UpdateEmp' method='post'>");
            int empno = Integer.parseInt(request.getParameter("empno"));
            
            EmpDAO ed = new EmpDAO();
    EmpBean eb = ed.findById(empno);
    out.println("<table>");
        out.println("<tr>");
            out.println("<td><input type='hidden' name='empno' value="+eb.getEmpno()+"></td>");                   
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Name</td>");
            out.println("<td><input type='text' name='name' value="+eb.getEname()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Job</td>");
            out.println("<td><input type='text' name='ejob' value="+eb.getJob()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Manager No.</td>");
            out.println("<td><input type='text' name='emgr' value="+eb.getMgr()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Hire Date</td>");
            out.println("<td><input type='text' name='hd' value="+eb.getHiredate()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Salary</td>");
            out.println("<td><input type='text' name='esal' value="+eb.getSal()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Commission</td>");
            out.println("<td><input type='text' name='ecomm' value="+eb.getComm()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>Emp Dept No</td>");
            out.println("<td><input type='text' name='edept' value="+eb.getDeptno()+"></td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td><input type='submit' value='Update Employee'></td>");
        out.println("</tr>");
    out.println("</table>");
out.println("</form>");
            
//out.println("<h1>Servlet UpdateEmpForm at " + request.getContextPath() + "</h1>");
    
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
            Logger.getLogger(UpdateEmpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateEmpForm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateEmpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateEmpForm.class.getName()).log(Level.SEVERE, null, ex);
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
