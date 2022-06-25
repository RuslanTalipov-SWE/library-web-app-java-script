package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDao;

@WebServlet("/servlets.EditUserForm")
public class EditUserForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse 
                response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа
                response.setContentType("text/html; charset=UTF-8");
		
                // Поток для данных ответа
                PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit User Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
                // Промотр пользователей
		UserBean bean=UserDao.viewById(id);
		
		out.print("<form action='servlets.EditUser' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		out.print("<label for='name1'>Имя</label>");
		out.print("<input type='text' class='form-control' value='"+
                        bean.getName()+"' name='name' id='name1' placeholder='Имя'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email</label>");
		out.print("<input type='email' class='form-control' value='"+
                        bean.getEmail()+"'  name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='password1'>Пароль</label>");
		out.print("<input type='password' class='form-control' value='"+
                        bean.getPassword()+"'  name='password' id='password1' placeholder='Пароль'/>");
		out.print("</div>  ");
		out.print("<div class='form-group'>");
		out.print("<label for='mobile1'>Тел.</label>");
		out.print("<input type='number' class='form-control' value='"+
                        bean.getMobile()+"'name='mobile' id='mobile1' placeholder='Тел.'/>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary'>Применить</button>");
		out.print("</form>"); 
		out.println("</div>");
		 
                // Закрытие потока
		out.close();	
	}
}