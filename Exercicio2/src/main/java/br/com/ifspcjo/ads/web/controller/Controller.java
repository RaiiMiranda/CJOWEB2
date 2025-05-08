package br.com.ifspcjo.ads.web.controller;

import java.io.IOException;

import br.com.ifspcjo.ads.web2.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet
{	
	private static final long serialVersionUID = 1L;
	
	//construtor
	public Controller() {
		super();
	}
	
	//declarando os atributos email e senha
	private static final String email_valido = "email@gmail.com";
	private static final String senha_valida = "404senha";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String senha = req.getParameter("password");
		
		Model usuario = new Model();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		if(email_valido.equals(email) && senha_valida.equals(senha))
		{
			req.setAttribute("usuario", usuario);
			req.getRequestDispatcher("/welcome.html").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/error.html").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("/index.html").forward(req, resp);
	}
}
