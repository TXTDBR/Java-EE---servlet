package br.com.caleum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caleum.dao.ContatoDAO;
import br.com.caleum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionandoContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		PrintWriter out = resp.getWriter();
//		pegando	os	parâmetros	do	request
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmText = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		//fazendo conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmText);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch(ParseException e) {
			out.println("Erro de conversão de data");
			return;
		}
		
		//	monta	um	objeto	contato
		Contato	contato	=	new	Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		//	salva	o	contato
		ContatoDAO dao;
		try {
			dao = new	ContatoDAO(connection);
			dao.adicionar(contato);
			//	imprime	o	nome	do	contato	que	foi	adicionado
			
			RequestDispatcher	rd	=	req.getRequestDispatcher("/contato-adicionado.jsp");
			rd.forward(req,resp);
		} catch (ClassNotFoundException e) {
			out.println("Não foi possível encontrar a classe Driver");
		
		
		}
	}
}
