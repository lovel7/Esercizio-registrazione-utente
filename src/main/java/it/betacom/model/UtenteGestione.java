package it.betacom.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteGestione {

	// metodo che controlla eventuale doppia ragistrazione tramite codice fiscale
	public boolean isUtenteRegistrato(String codiceFiscale) throws Exception {
		// Verifica se il codice fiscale è già presente nel database
		String query = "SELECT COUNT(*) FROM utente WHERE Codice_fiscale = ?";

		Connection connection = DBHandlerUtente.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, codiceFiscale);

		try (ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				// Estrae il valore nella prima colonna del risultato della query e lo attribuisce a count
				// se count è maggiore a 0, il metodo ritorna true e quindi c'è già un registro con quel codice fiscale
				int count = resultSet.getInt(1);
				return count > 0;
			}
		}

		return false;
	}

	public void inserisciUtente(Utente utente) {

		DBHandlerUtente dbHandler = DBHandlerUtente.getInstance();
		Connection connection = dbHandler.getConnection();

		// Query di inserimento
		String query = "INSERT INTO esercizioutentiservlet.utente (Nome, Cognome, Sesso, Luogo_di_nascita, Provincia, Data_di_nascita, Codice_fiscale, SitoProvenienza, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// Imposta i parametri della query con i valori dell'utente
			preparedStatement.setString(1, utente.getNome());
			preparedStatement.setString(2, utente.getCognome());
			preparedStatement.setString(3, utente.getSesso());
			preparedStatement.setString(4, utente.getLuogoDiNascita());
			preparedStatement.setString(5, utente.getProvincia());
			preparedStatement.setString(6, utente.getDataDiNascita());
			preparedStatement.setString(7, utente.getCodiceFiscale());
			preparedStatement.setString(8, utente.getSitoProvenienza());
			preparedStatement.setString(9, utente.getPassword());

			// Esegui l'inserimento
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Errore durante l'inserimento dell'utente nel database");
			e.printStackTrace();
		}
	}
}