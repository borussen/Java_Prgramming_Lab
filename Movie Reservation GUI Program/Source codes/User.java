/**
 * Class name is User. This is about Movie Reservation Program of Final Project.
 * It contains the user information provided when signing up for membership.
 * It also contains reserved movie information by using inheritance.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class User {
	private String userName;
	private String password;
	private String phoneNumber;
	private MovieInformation movieInfo;
	/**
	 * @param userName - Instance variable for storing user id
	 * @param password - Instance variable for storing user password
	 * @param phoneNumber - Instance variable for storing user phone number
	 * @param movieInfo -  Instantiate MovieInformation object
	 */
	
	public User(String userName, String password, String phoneNumber, MovieInformation movieInfo) {
		super();
		setUserName(userName);
		setPassword(password);
		setPhoneNumber(phoneNumber);
		setMovieInfo(movieInfo);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public MovieInformation getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(MovieInformation movieInfo) {
		this.movieInfo = movieInfo;
	}
}