/**
 * Class name is PasswordMismatchException. This is about Movie Reservation Program of Final Project.
 * It is user defined exception to deal with error caused by inconsistency between password and repeated password.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class PasswordMismatchException extends Exception {
	public PasswordMismatchException (String message) {
		super(message);
	}
}
