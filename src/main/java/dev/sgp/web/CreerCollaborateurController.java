package dev.sgp.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class CreerCollaborateurController extends HttpServlet{

	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String dateNaissance = req.getParameter("dateNaissance");
		String adresse = req.getParameter("adresse");
		String numSecuSociale = req.getParameter("numSecuSociale");
		
		Properties prop = new Properties();
		prop.load(this.getClass().getResourceAsStream("/sirth-gestion-personnel.properties"));
		String suffixe = prop.getProperty("appli.suffixeEmailPro");
		
		Collaborateur collab = new Collaborateur();
		collab.setNom(nom);
		collab.setPrenom(prenom);
		//collab.setDateNaissance(LocalDate.parse(dateNaissance));
		collab.setAdresse(adresse);
		collab.setNumSecuSociale(numSecuSociale);
		collab.setActif(true);
		collab.setDateHeureCreation(ZonedDateTime.now());
		//collab.setMatricule("M"+numSecuSociale.substring(10, 14));
		collab.setEmailPro(prenom+"."+nom+"@"+suffixe);
		
		collabService.sauvegarderCollaborateur(collab);
		
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateur.jsp").forward(req, resp);
	
	}

}
