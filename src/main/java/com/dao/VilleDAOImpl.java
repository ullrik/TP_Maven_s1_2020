package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection con = JDBCConfiguration.getConnection();

		ResultSet resultSet = null;
		String requete = "SELECT * FROM ville_france";

		try {
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery(requete);

			
			
			while (resultSet.next()) {
				Ville ville = new Ville();

				ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne(resultSet.getString("Ligne_5"));

				listVille.add(ville);
			}

		} catch (SQLException e) {
			// traitement de l'exception
		}
		return listVille;
	}
}
