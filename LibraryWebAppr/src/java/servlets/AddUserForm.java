package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/servlets.AddUserForm")
public class AddUserForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse 
                response) throws ServletException, IOException {
                
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add User Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страниц adminhome и adduserform
		request.getRequestDispatcher("adminhome.html").include(request, response);
		out.println("<div class='container'>");
		request.getRequestDispatcher("adduserform.html").include(request, response);
		out.println("</div>");
		
                // Закрытие потока
                out.close();
	}
} 