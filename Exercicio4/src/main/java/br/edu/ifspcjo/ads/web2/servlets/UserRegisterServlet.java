package br.edu.ifspcjo.ads.web2.servlets;

import java.io.IOException;

import br.edu.ifsp.ads.web2.utils.DataSourceSearcher;
import br.edu.ifspcjo.ads.web2.dao.UserDao;
import br.edu.ifspcjo.ads.web2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));

		UserDao dao = new UserDao(DataSourceSearcher.getInstance().getDataSource());
		
		RequestDispatcher dispatcher = null;
		
		if(dao.save(user)) {
			req.setAttribute("result", "registered");
			dispatcher = req.getRequestDispatcher("loginUser.jsp");
		}else {
			req.setAttribute("result", "notRegistered");
			dispatcher = req.getRequestDispatcher("registerUser.jsp");
		}
		
		dispatcher.forward(req, resp);
	}
}
