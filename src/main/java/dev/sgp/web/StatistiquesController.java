package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class StatistiquesController extends HttpServlet{

	private static VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<VisiteWeb> visites = visiteService.listerVisites();
		Integer compteur = (Integer) req.getSession().getServletContext().getAttribute("compteur");
		
		req.setAttribute("compteur", compteur);
		req.setAttribute("visites", visites);

		req.getRequestDispatcher("/WEB-INF/views/stats/statistiques.jsp").forward(req, resp);
	}
}
