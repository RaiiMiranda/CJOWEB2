package br.com.ifspcjo.ads.web2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formTask")
public class TaskServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	//construtor
	public TaskServlet() {
		super();
	}
	
	private List<Task> tasks = new ArrayList<>();
	private int nextId = 1;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		
		String description = req.getParameter("description");
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		
		Task task = new Task(nextId++, description, date);
		tasks.add(task);
		
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("taskList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("taskList.jsp").forward(req, resp);
	}
}
