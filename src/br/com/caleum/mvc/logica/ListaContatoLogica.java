package br.com.caleum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caleum.dao.ContatoDAO;
import br.com.caleum.modelo.Contato;

public class ListaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Connection connection = (Connection) req.getAttribute("connection");
		List<Contato> contatos = new ContatoDAO(connection).getList();
		
		req.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos-jstl.jsp";
	}

}
