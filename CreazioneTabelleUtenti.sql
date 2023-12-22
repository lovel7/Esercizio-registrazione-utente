CREATE SCHEMA esercizioUtentiServlet;

CREATE TABLE `utente` (
  `ID_utente` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  `Cognome` varchar(255) NOT NULL,
  `Sesso` varchar(255) DEFAULT NULL,
  `Luogo_di_nascita` varchar(255) DEFAULT NULL,
  `Provincia` varchar(255) DEFAULT NULL,
  `Data_di_nascita` varchar(225) DEFAULT NULL,
  `Codice_fiscale` varchar(16) DEFAULT NULL,
  `SitoProvenienza` varchar(55) DEFAULT NULL,
  `Password` varchar(155) DEFAULT NULL,
  PRIMARY KEY (`ID_utente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci