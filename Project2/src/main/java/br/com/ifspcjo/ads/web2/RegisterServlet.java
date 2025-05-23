package br.com.ifspcjo.ads.web2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//construtor - botao direito -> source -> generate constructors from superclass 
	public RegisterServlet() {
		super();
	}
	
	//getter - escreve doGet e aperta ctrl + space e da enter
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//codificação de caracteres
		req.setCharacterEncoding("UTF-8");
		
		//obter dados
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		String[] options = req.getParameterValues("options");
		String selectedOptions = ""; //pra obter os dados do checkbox
		if(options != null)
		{
			for(String option : options) //das opções ele joga uma opção por vez 
			{
				selectedOptions += option + " "; //+ "" pra não ficar grudado
			}
		}
		
		//gerar resposta
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html");
		writer.println("<html lang=\"pt-BR\">");
		
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title>Página Principal</title>");
		writer.println("</head>");
		
		writer.println("<body>");
		writer.println("\t<h1>Cadastro realizado com sucesso</h1>");
		writer.println("\t<h2>Nome: " + name + "</h2>");
		writer.println("\t<h2>E-mail: " + email + "</h2>");
		writer.println("\t<h2>Interesses: " + selectedOptions + "</h2>");
		writer.println("</body>");
		
		writer.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}
}







