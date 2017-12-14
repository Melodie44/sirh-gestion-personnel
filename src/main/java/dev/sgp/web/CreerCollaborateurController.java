package dev.sgp.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
		
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String dateNaissance = req.getParameter("dateNaissance");
		String adresse = req.getParameter("adresse");
		String numSecuSociale = req.getParameter("numSecuSociale");
		boolean erreur = false;
		
		Properties prop = new Properties();
		prop.load(this.getClass().getResourceAsStream("/sirth-gestion-personnel.properties"));
		String suffixe = prop.getProperty("appli.suffixeEmailPro");
		
		if (numSecuSociale.length() != 15 ) {
			erreur = true;
			resp.getWriter().write("<h1>Erreur 400</h1>");
			resp.getWriter().write("<p>Le Numéro de sécurité sociale doit être de longueur 15</p>");
		}
		
		try {
			LocalDate.parse(dateNaissance);
		}catch(DateTimeParseException d) {
			
			if (erreur == false) {
				resp.getWriter().write("<h1>Erreur 400</h1>");
			}
			erreur = true;
			resp.getWriter().write("<p>La date de naissance n'est pas dans le bon format</p>");
		}
		
		Collaborateur collab = new Collaborateur();
		
		if(erreur == false) {
			collab.setNom(nom);
			collab.setPrenom(prenom);
			collab.setDateNaissance(LocalDate.parse(dateNaissance));
			collab.setAdresse(adresse);
			collab.setNumSecuSociale(numSecuSociale);
			collab.setActif(true);
			collab.setDateHeureCreation(ZonedDateTime.now());
			collab.setMatricule("M"+numSecuSociale.substring(13, 15));
			collab.setEmailPro(prenom+"."+nom+"@"+suffixe);
			collab.setPhoto(req.getContextPath()+"/img/logo_img.jpg");
			
			collabService.sauvegarderCollaborateur(collab);
			collabService.listerCollaborateurs();
			
			req.setAttribute("listeNoms", collabService.listerCollaborateurs());
			req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
		}
		
		if(erreur == true) {
			resp.setStatus(400);
		}
	}
}
