package br.com.caleum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caleum.dao.ContatoDAO;
import br.com.caleum.modelo.Contato;

public class RemoverContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Long id =  Long.parseLong(req.getParameter("id"));
		Connection connection = (Connection) req.getAttribute("connection");
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDAO dao = new ContatoDAO(connection);
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		return "mvc?logica=ListaContatoLogica";
	}

	
}
