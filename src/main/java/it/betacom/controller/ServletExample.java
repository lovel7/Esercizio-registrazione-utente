package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.model.Utente;
import it.betacom.model.UtenteGestione;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet(description = "Servlet di registrazione", urlPatterns = { "/Registrazione" })
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// attribuisco gli attributi a ciò che viene inserito come input nella
		// registrazione utente
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String sesso = request.getParameter("sesso");
		String luogoDiNascita = request.getParameter("luogoNascita");
		String provincia = request.getParameter("provincia");
		String dataDiNascita = request.getParameter("dataNascita");
		String codiceFiscale = request.getParameter("codiceFiscale");
		String sitoProvenienza = request.getParameter("sitoProvenienza");
		String password = request.getParameter("password");

		// creazione nuovo utente e assegnazione attributi appena registrati
		Utente utente = new Utente(nome, cognome, sesso, luogoDiNascita, provincia, dataDiNascita, codiceFiscale,
				sitoProvenienza, password);

		UtenteGestione utenteGestione = new UtenteGestione();

		// inserimento utente registrato nel database
		try {
			if (utenteGestione.isUtenteRegistrato(codiceFiscale)) {
				System.out.println("Utente già registrato con questo codice fiscale");
				System.out.println(utente.toString());
				response.getWriter().append(
						"Spiacente, sembra che tu abbia già effettuato la registrazione con questo codice fiscale.");
			}

			else {
				utenteGestione.inserisciUtente(utente);
				response.getWriter().append("Complimenti, hai effettuato correttamente la registrazione");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.setContentType("text/html");
		// printWriter.append("<html><body>Welcome to my Servlet</body></html>");
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
