/**
 * Class name is InvalidCardException. This is about Movie Reservation Program of Final Project.
 * It is user defined exception to deal with error caused by invalid card number and card password.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class InvalidCardException extends Exception {
	public InvalidCardException (String message) {
		super(message);
	}
}