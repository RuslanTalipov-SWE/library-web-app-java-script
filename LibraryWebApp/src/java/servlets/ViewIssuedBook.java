package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import beans.IssueBookBean;
import dao.BookDao;

@WebServlet("/servlets.ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Установка MIME-типа содержания ответа
                response.setContentType("text/html; charset=UTF-8");
		// Поток для данных ответа
                PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                // Вызов содержимого страницы adminhome
                request.getRequestDispatcher("adminhome.html").include(request, response);
		
                // Промотр данных выданных книг в виде таблицы
		out.println("<div class='container'>");
		List<IssueBookBean> list=BookDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>№</th><th>№ студента</th><th>Имя студента</th><th>Телефон студента</th><th>Дата выдачи</th><th>Статус возврата</th></tr>");
		for(IssueBookBean bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		// Закрытие потока 
		out.close();
	}
}