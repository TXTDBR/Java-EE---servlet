package br.com.caleum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caleum.dao.ContatoDAO;
import br.com.caleum.modelo.Contato;

public class BuscarContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Connection connection = (Connection) req.getAttribute("connection");
		Contato contato = new ContatoDAO(connection).bucarContatoById(Long.parseLong(req.getParameter("id")));
		req.setAttribute("contato", contato);
		return "altera-contato.jsp";
	}

}
