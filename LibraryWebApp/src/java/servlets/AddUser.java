package servlets;

import beans.UserBean;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import beans.*;

@WebServlet("/servlets.AddUser")
public class AddUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse 
                response) throws ServletException, IOException {
            
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add User</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Получение параметров из формы для добавления данных пользователя
                out.println("<div class='container'>");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
                
                // Создание нового объекта UserBean и сохранение данных в БД
		UserBean bean=new UserBean(name, email, password, mobile);
		UserDao.save(bean);
                
		out.print("<h4>Пользователь успешно добавлен</h4>");
                
                // Вызов содержимого страницы adduserform
		request.getRequestDispatcher("adduserform.html").include(request, response);
		out.println("</div>");
                
                // Закрытие потока
		out.close();
	}
}