/**
 * Class name is MovieInformation. This is about Movie Reservation Program of Final Project.
 * It contains the movie information reserved by the user.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class MovieInformation {
	private String Date;
	private String Title;
	private String Time;
	private int number;
	/**
	 * @param date - Instance variable for storing movie date
	 * @param title - Instance variable for storing movie title
	 * @param time - Instance variable for storing movie time
	 * @param number - Instance variable for storing the number of reservations
	 */
	
	public MovieInformation(String date, String title, String time, int number) {
		super();
		setDate(date);
		setTitle(title);
		setTime(time);
		setNumber(number);
	}
	
	public String getDate() {
		return Date;
	}
	
	public void setDate(String date) {
		this.Date = date;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		this.Title = title;
	}
	
	public String getTime() {
		return Time;
	}
	
	public void setTime(String time) {
		this.Time = time;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}