package br.com.ifspcjo.ads.web2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class RegisterStudent extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	//construtor
	public RegisterStudent() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//codificação de caracteres
		req.setCharacterEncoding("UTF-8");
		
		//obter nome
		String name = req.getParameter("name");
		
		//obter emails
		String[] emails = req.getParameterValues("email");
		String selectedEmails = "";
		if(emails != null)
		{
			for(String option : emails)
			{
				selectedEmails += option + " ";
			}
		}
		
		//obter opções do checkbox
		String[] options = req.getParameterValues("options");
		String selectedOptions = "";
		if(options != null)
		{
			for(String option : options)
			{
				selectedOptions += option + " ";
			}
		}
		
		//gerar resposta
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html lang=\"pt-BR\">");
		
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title> Dados Informados </title>");
		writer.println("</head>");
		
		writer.println("<body>");
		writer.println("\t<h1>Dados do Aluno: </h1>");
		writer.println("\t<h4>Nome: " + name + "</h4>");
		writer.println("\t<h4>E-mail: " + selectedEmails + "</h4>");
		writer.println("\t<h4>Cursos de Interesse: " + selectedOptions + "</h4>");
		writer.println("</body>");
		
		writer.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}
}

