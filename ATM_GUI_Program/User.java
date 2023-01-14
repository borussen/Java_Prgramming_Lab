/**
 * Class name is User. This is about project 1 of Midterm Assignment.
 * It contains the name of User. 
 * 
 * @version JavaSE-16 25 October 2021
 * @author KIM HOJIN (2016314786)
 */
public class User {
	private String name;
	/**
	 * @param name - Instance variable for storing user name
	 */

	public User(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}