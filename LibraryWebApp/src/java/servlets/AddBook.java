package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import dao.*;
@WebServlet("/servlets.AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
		// Поток для данных ответа
                PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страницы adminhome
                request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Получение параметров из формы для добавления данных книги
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		
                // Создание нового объекта BookBean и сохранение в БД
                BookBean bean=new BookBean(callno,name,author,publisher,quantity);
		int i=BookDao.save(bean);
		
                if(i>0){
			out.println("<h3>Книга успешно добавлена</h3>");
		}
                
                // Вызов содержимого страницы adduserform
		request.getRequestDispatcher("addbookform.html").include(request, response);
		out.println("</div>");
                
                // Закрытие потока
		out.close();
	}
}