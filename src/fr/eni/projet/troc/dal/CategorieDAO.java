/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.Categorie;

/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 30 mars 2021 - 10:39:50
 */
public interface CategorieDAO {

	public List<Categorie> selectAll() throws Exception;
}
