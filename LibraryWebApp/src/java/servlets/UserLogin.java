package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
@WebServlet("/servlets.UserLogin")
public class UserLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>User Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Считывание данных формы авторизации пользователя
		String userEmail=request.getParameter("email");
		String userPassword=request.getParameter("password");
                
                // Если email и пароль введены правильно, переходим на страницу пользователя userhome.html
		if(UserDao.authenticate(userEmail, userPassword)){
			HttpSession session=request.getSession();
			session.setAttribute("email",userEmail);
			request.getRequestDispatcher("userhome.html").include(request, response);			            
                    } else {
                            request.getRequestDispatcher("index.html").include(request, response);
                            out.println("<h3>Введенные email и пароль в системе не зарегистрированы</h3>");
                    }
                    
                    // Закрытие потока 
                    out.close();
	}
}