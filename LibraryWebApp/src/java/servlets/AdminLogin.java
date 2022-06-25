package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/servlets.AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                // Установка MIME-типа содержания ответа
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
	
                // Считывание данных формы авторизации администратора
		String email=request.getParameter("email");
		String password=request.getParameter("password");
                
                // Email и пароль администратора по умолчанию
                String adminEmail = "admin@tusur.com";
                String adminPassword ="admin";
                
                // Если email и пароль введены правильно, переходим на страницу администратора adminhome.html
		if(email.equals(adminEmail)&&password.equals(adminPassword)){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			request.getRequestDispatcher("adminhome.html").include(request, response);
		}
                
                // Если пароль неправильный, выводим соответствующее сообщение  
                else if (email.equals(adminEmail)){
                    request.getRequestDispatcher("index.html").include(request, response);
                    out.println("<h3>Введен неверный пароль</h3>");
                
                // Если email неправильный, выводим соответствующее сообщение 
                } else if (password.equals(adminPassword)){
                    request.getRequestDispatcher("index.html").include(request, response);
                    out.println("<h3>Введен неверный email</h3>");
                
                // Если email и пароль неправильные, выводим соответствующее сообщение  
                } else {
                    request.getRequestDispatcher("index.html").include(request, response);
                    out.println("<h3>Введенные email и пароль в системе не зарегистрированы</h3>");
                }
		// Закрытие потока
                out.close();
	}
}