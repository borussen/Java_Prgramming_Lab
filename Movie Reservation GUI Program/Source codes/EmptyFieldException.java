/**
 * Class name is EmptyFieldException. This is about Movie Reservation Program of Final Project.
 * It is user defined exception to deal with error caused by empty field.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class EmptyFieldException extends Exception {
	public EmptyFieldException (String message) {
		super(message);
	}
}