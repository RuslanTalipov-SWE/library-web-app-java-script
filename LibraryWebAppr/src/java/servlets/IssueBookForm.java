package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlets.IssueBookForm")
public class IssueBookForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Issue Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
                
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Вызов содержимого страницы issuebookform
		out.println("<div class='container'>");            
		request.getRequestDispatcher("issuebookform.html").include(request, response);
		out.println("</div>");
		
		// Закрытие потока 
		out.close();
	}
}