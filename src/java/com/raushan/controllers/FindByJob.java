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
public class FindByJob extends HttpServlet {

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
            out.println("<title>Servlet FindByJob</title>");            
            out.println("</head>");
            
            
            
            out.println("<body>");
            out.println("<center>");
            out.println("<table border='2px' width='50%'>");
            out.println("<tr>");
            out.println("<th>Empno</th>");
            out.println("<th>Ename</th>");
            out.println("<th>Job</th>");
            out.println("<th>Mgr</th>");
            out.println("<th>Hiredate</th>");
            out.println("<th>Sal</th>");
            out.println("<th>Comm</th>");
            out.println("<th>Deptno</th>");
            out.println("</tr>");
            String job =request.getParameter("job");
            
            EmpDAO ed =new EmpDAO();
            ArrayList<EmpBean> al =ed.findByJob(job);
            for(EmpBean eb :al){
                out.println("<tr>");
                out.println("<td>"+eb.getEname()+"</td>");
                out.println("<td>"+eb.getEmpno()+"</td>");
                out.println("<td>"+eb.getHiredate()+"</td>");
                out.println("<td>"+eb.getComm()+"</td>");
                out.println("<td>"+eb.getMgr()+"</td>");
                out.println("<td>"+eb.getJob()+"</td>");
                out.println("<td>"+eb.getSal()+"</td>");
                out.println("<td>"+eb.getDeptno()+"</td>");
                out.println("</tr>");
            }
//            out.println("<h1>Servlet FindByJob at " + request.getContextPath() + "</h1>");
            out.println("</table>");
            out.println("</center>");
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
            Logger.getLogger(FindByJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FindByJob.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FindByJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FindByJob.class.getName()).log(Level.SEVERE, null, ex);
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
