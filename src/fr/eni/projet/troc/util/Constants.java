package fr.eni.projet.troc.util;

public interface Constants {
	String PATTERN_TEL = "^(\\+33|0|0033)[0-9]{9}$";
	String PATTERN_PWD = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+.;,=]).*$";
	String PATTERN_EMAIL = "^(.+)@(.+)$";
}
