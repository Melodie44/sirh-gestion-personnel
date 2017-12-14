package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService departService = Constantes.DEPART_SERVICE;
	
	{
		departService.sauvegarderDepartement(new Departement(1,"Tous"));
		departService.sauvegarderDepartement(new Departement(2,"Comptabilité"));
		departService.sauvegarderDepartement(new Departement(3,"Ressources Humaines"));
		departService.sauvegarderDepartement(new Departement(4,"Informatique"));
		departService.sauvegarderDepartement(new Departement(5,"Administratif"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		List<Departement> departements = departService.listerDepartements();

		req.setAttribute("listeNoms", collaborateurs);
		req.setAttribute("departements", departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	
	}

}
