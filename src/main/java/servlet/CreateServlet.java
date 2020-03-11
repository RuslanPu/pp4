package servlet;

import model.User;
import services.UserJDBCService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("page/create.jsp").forward(request, response);

//        getServletContext().getRequestDispatcher("page/create.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = UserService.getInstance();
        try {
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            String email = request.getParameter("email");

            User user = new User(name, pass,email);

                service.addUser(user);
                response.sendRedirect(request.getContextPath()+"/index");


        }
        catch(Exception ex) {

//            getServletContext().getRequestDispatcher("page/create.jsp").forward(request, response);
            request.getRequestDispatcher("page/create.jsp").forward(request, response);
        }
    }
}
