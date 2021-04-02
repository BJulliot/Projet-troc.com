/**
 * 
 */
package fr.eni.projet.troc.dal;

import fr.eni.projet.troc.bo.Enchere;


/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:39:04
 */
public interface EnchereDAO {
	
	public void create(Enchere enchere) throws Exception;

}