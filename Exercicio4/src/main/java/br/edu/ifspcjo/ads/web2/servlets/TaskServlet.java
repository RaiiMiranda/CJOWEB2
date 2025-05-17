package br.edu.ifspcjo.ads.web2.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import br.edu.ifsp.ads.web2.utils.DataSourceSearcher;
import br.edu.ifspcjo.ads.web2.dao.TaskDao;
import br.edu.ifspcjo.ads.web2.dao.UserDao;
import br.edu.ifspcjo.ads.web2.model.Task;
import br.edu.ifspcjo.ads.web2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerTask")
public class TaskServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String description = req.getParameter("description");
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		
		Optional<User> optional = Optional.empty();
		for (Cookie cookie : req.getCookies()) 
		{
			if (cookie.getName().equals("loggedUser")) 
			{
				UserDao userDao = new UserDao(DataSourceSearcher.getInstance().getDataSource());
				optional = userDao.getUserByEmail(cookie.getValue());
			}
		}
		
		RequestDispatcher dispatcher = null;

		if (optional.isPresent()) 
		{
			Task task = new Task();
			task.setDescription(description);
			task.setDate(date);
			task.setUser(optional.get());

			TaskDao dao = new TaskDao(DataSourceSearcher.getInstance().getDataSource());
			dao.save(task);
			req.setAttribute("result", "success");
		} 
		else 
		{
			req.setAttribute("result", "fail");
		}
		
		req.getRequestDispatcher("/registerNewTask.jsp").forward(req, resp);
	}
}
