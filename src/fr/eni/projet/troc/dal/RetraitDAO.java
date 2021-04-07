/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:14:46
 */
public interface RetraitDAO {

	public List<Retrait> selectById(int id) throws Exception;

	public Retrait selectRetraitById(int idArticle);

	/**
	 * Permet de supprimer tous les retraits li�s � un m�me utilisateur
	* {@inheritDoc}
	*/
	void deleteBynoUtilisateur(int noUtilisateur) throws BusinessException;

}
