package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/servlets.LogoutUser")
public class LogoutUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Закрытие сеанса для пользователя
        request.getSession().invalidate();
        // Поток для данных ответа
        response.sendRedirect("index.html; charset=UTF-8");
    }
}