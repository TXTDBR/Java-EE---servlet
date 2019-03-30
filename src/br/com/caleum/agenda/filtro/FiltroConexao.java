package br.com.caleum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caleum.jdbc.FabricaDeConexoes;

@WebFilter("/*")
public class FiltroConexao implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		Connection connection;
		try {
			connection = new FabricaDeConexoes().getConnetion();
			
			req.setAttribute("connection", connection);
			
			chain.doFilter(req, resp);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void destroy() {
	}

}
