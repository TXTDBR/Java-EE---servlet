package br.com.caleum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caleum.dao.ContatoDAO;
import br.com.caleum.modelo.Contato;

public class AdicionarContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Connection connection = (Connection) req.getAttribute("connection");
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar cal = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			cal = Calendar.getInstance();
			cal.setTime(data);
		}catch(ParseException e) {
			System.out.println("erro ao converte data");
		}
		contato.setDataNascimento(cal);
		
		new ContatoDAO(connection).adicionar(contato);
		
		return "WEB-INF/jsp/contato-adicionado.jsp";
	}

}
