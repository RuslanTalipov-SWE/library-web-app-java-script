package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IssueBookBean;
import dao.BookDao;

@WebServlet("/servlets.ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа	
                response.setContentType("text/html; charset=UTF-8");
                // Поток для данных ответа
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Return Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
                
                // Вызов содержимого страницы adminhome
		request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Получение параметров из формы возврата книг
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		String sstudentid=request.getParameter("studentid");
		int studentid=Integer.parseInt(sstudentid);
		
		int i=BookDao.returnBook(callno,studentid);
		if(i>0) {
			out.println("<h3>Книга успешно возвращена</h3>");
		} else {
			out.println("<h3>Извините, книга не может быть возвращена</h3>");
		}
		out.println("</div>");
		
                // Вызов содержимого страницы issuebookform
		request.getRequestDispatcher("ReturnBookForm.html").include(request, response);
		
		// Закрытие потока		 
		out.close();
	}
}