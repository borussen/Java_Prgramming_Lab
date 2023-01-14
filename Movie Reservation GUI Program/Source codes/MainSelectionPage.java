import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import javax.swing.SwingWorker;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

/**
 * Class name is MainSelectionPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's main selection page.
 * User selects date, movie, time and number of people in this page.
 * Program provides brief movie information that user selected.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class MainSelectionPage extends JFrame {
	
	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel dateLabel;  // JLabel for inform user where to select the date
	private JComboBox dateComboBox;  // JComboBox for selecting the date
	private JLabel movieLabel;  // JLabel for inform user where to select the movie
	private JComboBox movieComboBox;  // JComboBox for selecting the movie
	private JLabel timeLabel;  // JLabel for inform user where to select the time
	private JComboBox timeComboBox;  // JComboBox for selecting the time
	private JLabel numberLabel;  // JLabel for inform user where to select the number of people
	private JComboBox numberComboBox;  // JComboBox for selecting the number of people
	private JLabel informationLabel;  // JLabel for inform user where to read movie information
	private JTextArea informationTextArea;  // JTextArea for providing the movie information
	private JButton nextButton;  // JButton to move on to the next page
	
	/**
	 * Create the frame.
	 */
	public MainSelectionPage(User user) {
		
		// Set the panel and panel layout
		setTitle("Movie Selection");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(LoginPage.class.getResource("movie.png"))); 
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 2;
		gbc_imageLabel.insets = new Insets(10, 0, 5, 0);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'dateLabel' and add it to the panel
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.insets = new Insets(10, 0, 5, 5);
		gbc_dateLabel.gridx = 0;
		gbc_dateLabel.gridy = 3;
		contentPane.add(dateLabel, gbc_dateLabel);
		
		// Set text and font on 'dateComboBox' and add it to the panel
		String dateCB[]= {"2021/12/13 (Monday)","2021/12/14 (Tuesday)","2021/12/15 (Wednesday)","2021/12/16 (Thursday)", "2021/12/17 (Friday)","2021/12/18 (Saturday)", "2021/12/20 (Sunday)"};
		dateComboBox = new JComboBox(dateCB);
		dateComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_dateComboBox = new GridBagConstraints();
		gbc_dateComboBox.insets = new Insets(10, 0, 5, 0);
		gbc_dateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateComboBox.gridx = 1;
		gbc_dateComboBox.gridy = 3;
		contentPane.add(dateComboBox, gbc_dateComboBox);
		
		// Set text and font on 'movieLabel' and add it to the panel
		movieLabel = new JLabel("Movie");
		movieLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_movieLabel = new GridBagConstraints();
		gbc_movieLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieLabel.gridx = 0;
		gbc_movieLabel.gridy = 4;
		contentPane.add(movieLabel, gbc_movieLabel);
		
		// Set text and font on 'movieComboBox' and add it to the panel
		String movieCB[]= {"Spider-Man: No Way Home","Dune","Eternals","Encanto", "House of Gucci"};
		movieComboBox = new JComboBox(movieCB);
		movieComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_movieComboBox = new GridBagConstraints();
		gbc_movieComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_movieComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_movieComboBox.gridx = 1;
		gbc_movieComboBox.gridy = 4;
		contentPane.add(movieComboBox, gbc_movieComboBox);
		
		// 'movieComboBox' events handling by ActionListener
		movieComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();  // proceed the program by using multithreading
			}
		});
		
		// Set text and font on 'timeLabel' and add it to the panel
		timeLabel = new JLabel("Time");
		timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_timeLabel = new GridBagConstraints();
		gbc_timeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_timeLabel.gridx = 0;
		gbc_timeLabel.gridy = 5;
		contentPane.add(timeLabel, gbc_timeLabel);
		
		// Set text and font on 'timeComboBox' and add it to the panel
		String timeSpiderManCB[]= {"10:30 ~ 13:00 (Auditorium 1)","15:00 ~ 17:30 (Auditorium 1)", "18:00 ~ 20:30 (Auditorium 1)", "21:10 ~ 23:40 (Auditorium 1)"};
		timeComboBox = new JComboBox(timeSpiderManCB);
		timeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_timeComboBox = new GridBagConstraints();
		gbc_timeComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_timeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeComboBox.gridx = 1;
		gbc_timeComboBox.gridy = 5;
		contentPane.add(timeComboBox, gbc_timeComboBox);
		
		// Set text and font on 'numberLabel' and add it to the panel
		numberLabel = new JLabel("Number");
		numberLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_numberLabel = new GridBagConstraints();
		gbc_numberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numberLabel.gridx = 0;
		gbc_numberLabel.gridy = 6;
		contentPane.add(numberLabel, gbc_numberLabel);
		
		// Set text and font on 'numberComboBox' and add it to the panel
		String numberCB[]= {"1","2","3","4"};
		numberComboBox = new JComboBox(numberCB);
		numberComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_numberComboBox = new GridBagConstraints();
		gbc_numberComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_numberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_numberComboBox.gridx = 1;
		gbc_numberComboBox.gridy = 6;
		contentPane.add(numberComboBox, gbc_numberComboBox);
		
		// Set text and font on 'informationLabel' and add it to the panel
		informationLabel = new JLabel("Information");
		informationLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_informationLabel = new GridBagConstraints();
		gbc_informationLabel.gridheight = 5;
		gbc_informationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_informationLabel.gridx = 0;
		gbc_informationLabel.gridy = 7;
		contentPane.add(informationLabel, gbc_informationLabel);
		
		// Set text and font on 'informationTextArea' and add it to the panel
		informationTextArea = new JTextArea();
		informationTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		informationTextArea.setEditable(false);
		informationTextArea.setLineWrap(true);
		informationTextArea.setText("Director: Jon Watts\n");
		informationTextArea.append("Actor: Tom Holland\n");
		informationTextArea.append("Genre: Action\n");
		informationTextArea.append("Age: 12+\n");
		informationTextArea.append("Attendance: 3.2M\n");
		informationTextArea.append("Fan Rating: 4.6 / 5.0\n");
		informationTextArea.append("Expert Rating: 4.1 / 5.0\n");
		GridBagConstraints gbc_informationTextArea = new GridBagConstraints();
		gbc_informationTextArea.gridheight = 5;
		gbc_informationTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_informationTextArea.fill = GridBagConstraints.BOTH;
		gbc_informationTextArea.gridx = 1;
		gbc_informationTextArea.gridy = 7;
		contentPane.add(informationTextArea, gbc_informationTextArea);
		
		// Set text and font on 'nextButton' and add it to the panel
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.insets = new Insets(10, 10, 5, 10);
		gbc_nextButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_nextButton.gridwidth = 3;
		gbc_nextButton.gridx = 0;
		gbc_nextButton.gridy = 12;
		contentPane.add(nextButton, gbc_nextButton);
		
		// 'nextButton' events handling by ActionListener
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = dateComboBox.getSelectedItem().toString();  // String variable for storing user's reservation date
				String movie = movieComboBox.getSelectedItem().toString();  // String variable for storing user's reservation movie
				String time = timeComboBox.getSelectedItem().toString();  // String variable for storing user's reservation time
				String num = numberComboBox.getSelectedItem().toString();  // String variable for storing number of people
				int number = Integer.parseInt(num);
				
				MovieInformation movieInfo = new MovieInformation(date, movie, time, number);  // Instantiate MovieInformation object
				user.setMovieInfo(movieInfo);  // Set User object
				new SeatSelectionPage(user);  // After user presses the 'nextButton', program switches from the main selection page to seat selection page
				setVisible(false);  // Close the main selection page
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	private void start() {
		
		// First argument is the thread result, returned when processing finished.
		// Second argument is the value to update the GUI with via publish() and process()
		SwingWorker worker = new SwingWorker<Void, Integer>() {

			@Override
			protected Void doInBackground() throws Exception {
				String movie = movieComboBox.getSelectedItem().toString();  // String variable for storing selected movie
				int movieType = 1;  // Variable for distinguishing selected movie
				
				// Different value is assigned to each movie
				if (movie == "Spider-Man: No Way Home") {
					movieType = 1;
				}
				else if (movie == "Dune") {
					movieType = 2;
				}
				else if (movie == "Eternals") {
					movieType = 3;
				}
				else if (movie == "Encanto") {
					movieType = 4;
				}
				else {
					movieType = 5;
				}
			
				// Send values to process() and use them to update the GUI
				publish(movieType);		
				
				return null;
			}
			
			// This will be called if you call publish() from doInBackground()
			protected void process(List<Integer> chunks) {
				// Save the values received from public() in doInBackground() to each variable for using it to update GUI	
				int movieType = chunks.get(chunks.size()-1);
				
				// If user choose 'Spider-Man: No Way Home', the program will provide user with information related to that
				if (movieType == 1) {
					timeComboBox.removeAllItems();
					timeComboBox.addItem("10:30 ~ 13:00 (Auditorium 1)");
					timeComboBox.addItem("15:00 ~ 17:30 (Auditorium 1)");
					timeComboBox.addItem("18:00 ~ 20:30 (Auditorium 1)");
					timeComboBox.addItem("21:30 ~ 23:40 (Auditorium 1)");
					
					informationTextArea.setText("");
					informationTextArea.append("Director: Jon Watts\n");
					informationTextArea.append("Actor: Tom Holland\n");
					informationTextArea.append("Genre: Action\n");
					informationTextArea.append("Age: 12+\n");
					informationTextArea.append("Attendance: 3.2M\n");
					informationTextArea.append("Fan Rating: 4.6 / 5.0\n");
					informationTextArea.append("Expert Rating: 4.1 / 5.0\n");
				}
				
				// If user choose 'Dune', the program will provide user with information related to that
				else if (movieType == 2) {
					timeComboBox.removeAllItems();
					timeComboBox.addItem("12:40 ~ 15:10 (Auditorium 2)");
					timeComboBox.addItem("15:30 ~ 18:00 (Auditorium 2)");
					timeComboBox.addItem("19:10 ~ 21:40 (Auditorium 2)");
					
					informationTextArea.setText("");
					informationTextArea.append("Director: Denis Villeneuve\n");
					informationTextArea.append("Actor: Timothee Chalamet\n");
					informationTextArea.append("Genre: Adventure, Drama, SF\n");
					informationTextArea.append("Age: 12+\n");
					informationTextArea.append("Attendance: 1.5M\n");
					informationTextArea.append("Fan Rating: 4.5 / 5.0\n");
					informationTextArea.append("Expert Rating: 4.2 / 5.0\n");
				}
				
				// If user choose 'Eternals', the program will provide user with information related to that
				else if (movieType == 3) {
					timeComboBox.removeAllItems();
					timeComboBox.addItem("11:50 ~ 14:20 (Auditorium 3)");
					timeComboBox.addItem("15:30 ~ 18:00 (Auditorium 3)");
					timeComboBox.addItem("20:00 ~ 22:30 (Auditorium 3)");
					
					informationTextArea.setText("");
					informationTextArea.append("Director: Chloe Zhao\n");
					informationTextArea.append("Actor: Angelina Jolie\n");
					informationTextArea.append("Genre: Action, Drama, Fantasy\n");
					informationTextArea.append("Age: 12+\n");
					informationTextArea.append("Attendance: 3.0M\n");
					informationTextArea.append("Fan Rating: 3.9 / 5.0\n");
					informationTextArea.append("Expert Rating: 2.4 / 5.0\n");
				}
				
				// If user choose 'Encanto', the program will provide user with information related to that
				else if (movieType == 4) {
					timeComboBox.removeAllItems();
					timeComboBox.addItem("8:40 ~ 10:20 (Auditorium 4)");
					timeComboBox.addItem("13:15 ~ 14:55 (Auditorium 4)");
					timeComboBox.addItem("18:10 ~ 19:50 (Auditorium 4)");
					timeComboBox.addItem("20:10 ~ 21:50 (Auditorium 4)");
					
					informationTextArea.setText("");
					informationTextArea.append("Director: Byron Howard\n");
					informationTextArea.append("Actor: Stephanie Beatriz\n");
					informationTextArea.append("Genre: Animation\n");
					informationTextArea.append("Age: ALL\n");
					informationTextArea.append("Attendance: 454K\n");
					informationTextArea.append("Fan Rating: 4.7 / 5.0\n");
					informationTextArea.append("Expert Rating: 4.5 / 5.0\n");
				}
				
				// If user choose 'House of Gucci', the program will provide user with information related to that
				else {
					timeComboBox.removeAllItems();
					timeComboBox.addItem("11:20 ~ 14:00 (Auditorium 5)");
					timeComboBox.addItem("21:10 ~ 23:50 (Auditorium 5)");
					
					informationTextArea.setText("");
					informationTextArea.append("Director: Ridley Scott\n");
					informationTextArea.append("Actor: Lady Gaga\n");
					informationTextArea.append("Genre: Thriller, Drama, Crime\n");
					informationTextArea.append("Age: 15+\n");
					informationTextArea.append("Attendance: 311K\n");
					informationTextArea.append("Fan Rating: 4.1 / 5.0\n");
					informationTextArea.append("Expert Rating: 3.1 / 5.0\n");
				}
			}

			@Override
			// This is called when the thread finishes.
			protected void done() {
				return;
			}
		};
		worker.execute();  // Execute the SwingWorker
	}
}