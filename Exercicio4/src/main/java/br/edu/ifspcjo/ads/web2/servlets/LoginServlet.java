package br.edu.ifspcjo.ads.web2.servlets;

import java.io.IOException;
import java.util.Optional;

import br.edu.ifsp.ads.web2.utils.DataSourceSearcher;
import br.edu.ifspcjo.ads.web2.dao.UserDao;
import br.edu.ifspcjo.ads.web2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");

	    UserDao userDao = new UserDao(DataSourceSearcher.getInstance().getDataSource());
	    Optional<User> optional = userDao.getUserByEmailAndPassword(email, password);
	    
	    RequestDispatcher dispatcher;

	    if(optional.isPresent()) 
	    {
	        Cookie cookie = new Cookie("loggedUser", email);
	        cookie.setMaxAge(60 * 60 * 24);
	        resp.addCookie(cookie);
	        
	        req.setAttribute("name", optional.get().getName());
	        dispatcher = req.getRequestDispatcher("registerNewTask.jsp");
	    } 
	    else 
	    {
	        Cookie[] cookies = req.getCookies();
	        if(cookies != null) 
	        {
	            for(Cookie c : cookies) 
	            {
	                if(c.getName().equals("loggedUser")) 
	                {
	                    c.setMaxAge(0);
	                    resp.addCookie(c);
	                }
	            }
	        }
	        
	        req.setAttribute("result", "loginError");
	        dispatcher = req.getRequestDispatcher("loginUser.jsp");
	    }

	    dispatcher.forward(req, resp);
	}
}
