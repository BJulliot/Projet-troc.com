/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.Retrait;

/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:14:46
 */
public interface RetraitDAO {

	public List<Retrait> selectById(int id) throws Exception;

	
}
