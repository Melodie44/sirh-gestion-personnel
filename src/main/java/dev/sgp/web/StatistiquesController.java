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
		
		int compteur = 0;
		
		List<VisiteWeb> visites = visiteService.listerVisites();
		for (VisiteWeb vw : visites) {
			if(visites.contains(vw.getChemin())) {
				compteur += 1;
			}else {
				compteur = 0;
			}
		}
		
		req.setAttribute("compteur", compteur);
		req.setAttribute("visites", visites);

		req.getRequestDispatcher("/WEB-INF/views/stats/statistiques.jsp").forward(req, resp);
	}
}
