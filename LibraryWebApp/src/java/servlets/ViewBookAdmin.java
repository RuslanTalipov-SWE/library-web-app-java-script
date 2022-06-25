package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import dao.*;

@WebServlet("/servlets.ViewBookAdmin")
public class ViewBookAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа
                response.setContentType("text/html; charset=UTF-8");
		// Поток для данных ответа
                PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
                
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);	
		
                // Промотр данных книг в виде таблицы
                out.println("<div class='container'>");
		List<BookBean> list=BookDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>№</th><th>Название</th><th>Автор</th><th>Издатель</th><th>Количество</th><th>Выдано</th><th>Удалить</th></tr>");
		for(BookBean bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallno()+"'>Удалить</a></td></tr>");
		}
		out.println("</table>");		
		out.println("</div>");
		
		// Закрытие потока		 
		out.close();
	}
}