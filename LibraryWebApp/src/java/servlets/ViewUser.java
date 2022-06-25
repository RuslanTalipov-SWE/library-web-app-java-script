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

@WebServlet("/servlets.ViewUser")
public class ViewUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View User</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Промотр данных пользователей в виде таблицы
                out.println("<div class='container'>");
		List<UserBean> list=UserDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>№</th><th>Имя</th><th>Email</th><th>Пароль</th><th>Телефон</th><th>Изменить</th><th>Удалить</th></tr>");
		for(UserBean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='servlets.EditUserForm?id="+bean.getId()+"'>Изменить</a></td><td><a href='servlets.DeleteUser?id="+bean.getId()+"'>Удалить</a></td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
                // Закрытие потока
		out.close();
	}
}