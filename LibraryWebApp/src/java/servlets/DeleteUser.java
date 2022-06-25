package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

@WebServlet("/servlets.DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                // Удаление пользователя
                String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		UserDao.delete(id);
                
                // Переадресация на ViewUser.java
		response.sendRedirect("servlets.ViewUser");
	}
}