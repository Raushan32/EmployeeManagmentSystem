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
public class lowestSalEmp extends HttpServlet {

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
            out.println("<title>Servlet lowestSalEmp</title>");            
            out.println("</head>");
            
            
            out.println("<body>");
            out.println("<center>");
            out.println("<table border='2px' width='20%'>");
            out.println("<tr>");
            out.println("<th> Lowest_Salary Employee </th>");
            out.println("</tr>");
            EmpDAO ed =new EmpDAO();
            
            ArrayList<EmpBean> al =ed.findLowestSalEmp();
            int max=0;
            for(EmpBean eb :al){

                int num=eb.getSal();
                if(max<num)
                    max=num;
            }
            int lowest=max;
           for(EmpBean eb :al){
               int num=eb.getSal();
               if(lowest>num)
                   lowest=num;
           }
            out.println("<tr>");
            out.println("<th>"+lowest+"</th>");
            out.println("</tr>");
            
            
            out.println("</table>");
            out.println("</center>");
//            out.println("<h1>Servlet lowestSalEmp at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(lowestSalEmp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lowestSalEmp.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(lowestSalEmp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lowestSalEmp.class.getName()).log(Level.SEVERE, null, ex);
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
