package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeanHandler;
import model.UserBean;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		
		if (httpSession.getAttribute("isLoggedIn") !=null) {
			RequestDispatcher rd = request.getRequestDispatcher("views/Profile.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("./index .jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession httpSession = request.getSession();
		
		UserBean userBean = new UserBean();
		
		userBean.setUserName(user);
		userBean.setPassWord(password);
		
		if (BeanHandler.users(user, password)) {
			httpSession.setAttribute("isLoggedIn", userBean);
			RequestDispatcher rd = request.getRequestDispatcher("views/Profile.jsp");
			rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h3>Wrong username or password</h3>");
		out.print("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		}
	}

}
