package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDao;

@WebServlet("/servlets.EditUser")
public class EditUser extends HttpServlet {

    // Получение параметров из формы для редактирования данных пользователя
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
                
                // Обновление данных пользователя в БД
		UserBean bean=new UserBean(id,name, email, password, mobile);
		UserDao.update(bean);
                
                // Переадресация на ViewUser.java
		response.sendRedirect("servlets.ViewUser");
	}
}