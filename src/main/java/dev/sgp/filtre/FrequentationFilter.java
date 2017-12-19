package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {

	private FilterConfig config = null;
	private static VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	@Override
	public void init(FilterConfig config) throws ServletException {

		this.config = config;
		config.getServletContext().log("FrequentationFilter initialized");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		config.getServletContext().log(path + " : " + (after - before));	
		visiteService.sauvegarderVisite(new VisiteWeb(path, (int)(after - before)));
	}

	@Override
	public void destroy() {
		
	}
	
}
