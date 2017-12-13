package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String matricule = req.getParameter("matricule");
		
		resp.setContentType("text/html");
		
		if (matricule == null) {
			resp.setStatus(400);
			resp.getWriter().write("<p>Erreur, Un matricule est attendu</p>");
		}else {
			resp.setStatus(200);
			resp.getWriter().write("<h1>Edition de collaborateur</h1>"+"<p>Matricule : "+matricule+"</p>");
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		resp.setContentType("text/html");
		
		if(matricule != null && titre != null && nom != null && prenom != null){
			resp.setStatus(201);
			resp.getWriter().write("<h1>Création d'un collaborateur avec les informations suivantes :</h1>"
									+"<p>matricule="+matricule+",titre="+titre+",nom="+nom+",prenom="+prenom+".</p>");
		}else {
			resp.setStatus(400);
			resp.getWriter().write("<h1>Les paramètres suivants sont incorrectes :</h1>");
			if(matricule == null) {
				resp.getWriter().write("<p>matricule</p>");
			}
			if(titre == null) {
				resp.getWriter().write("<p>titre</p>");
			}
			if(nom == null) {
				resp.getWriter().write("<p>nom</p>");
			}
			if(prenom == null) {
				resp.getWriter().write("<p>prenom</p>");
			}
		}
	}
}
