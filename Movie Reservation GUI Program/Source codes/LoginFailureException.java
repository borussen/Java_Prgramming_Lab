/**
 * Class name is LoginFailureException. This is about Movie Reservation Program of Final Project.
 * It is user defined exception to deal with error caused by invalid user name and password.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class LoginFailureException extends Exception {
	public LoginFailureException (String message) {
		super(message);
	}
}
