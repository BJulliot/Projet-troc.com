package fr.eni.projet.troc.util;

public interface Constants {
	String PATTERN_TEL = "^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$\r\n";
	String PATTERN_PWD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	String PATTERN_EMAIL = "^(.+)@(.+)$";
}
