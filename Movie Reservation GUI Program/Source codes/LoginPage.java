import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Class name is LoginPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's login page.
 * It determines whether the ID and password entered from the user are correct.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class LoginPage extends JFrame {
	
	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel userNameLabel;  // JLabel for inform user where to enter the ID
	private JTextField userNameTextField;  // JTextField for entering the ID
	private JLabel passwordLabel;  // JLabel for inform user where to enter the password
	private JPasswordField passwordTextField;  // JPasswordField for entering the password
	private JButton loginButton;  // JButton for login
	private JButton signUpButton;  // JButton for sign up membership

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					
					// Create a file to store user information
					File file = new File("userDB.txt");
					FileWriter filewriter = new FileWriter(file, true);
					filewriter.close();
					
					// Create a file to store the movie theater seat information
					File file_2 = new File("seatDB.txt");
					FileWriter filewriter_2 = new FileWriter(file_2, true);
					filewriter_2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		
		// Set the panel and panel layout
		setTitle("Movie Reservation Program");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		imageLabel.setIcon(new ImageIcon(LoginPage.class.getResource("movie.png"))); 
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 2;
		gbc_imageLabel.insets = new Insets(20, 0, 0, 0);
		gbc_imageLabel.fill = GridBagConstraints.BOTH;
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'userNameLabel' and add it to the panel
		userNameLabel = new JLabel("USER NAME");
		userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.insets = new Insets(50, 10, 0, 10);
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 4;
		contentPane.add(userNameLabel, gbc_userNameLabel);
		
		// Set font on 'userNameTextField' and add it to the panel
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_userNameTextField = new GridBagConstraints();
		gbc_userNameTextField.gridwidth = 2;
		gbc_userNameTextField.insets = new Insets(5, 10, 5, 10);
		gbc_userNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameTextField.gridx = 0;
		gbc_userNameTextField.gridy = 5;
		contentPane.add(userNameTextField, gbc_userNameTextField);
		userNameTextField.setColumns(10);
		
		// Set text and font on 'passwordLabel' and add it to the panel
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(10, 10, 0, 10);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 6;
		contentPane.add(passwordLabel, gbc_passwordLabel);
		
		// Set font on 'passwordTextField' and add it to the panel
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordTextField.setEchoChar('*');  // For security purpose, convert the input value to * mark
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.gridwidth = 2;
		gbc_passwordTextField.insets = new Insets(5, 10, 10, 10);
		gbc_passwordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordTextField.gridx = 0;
		gbc_passwordTextField.gridy = 7;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		passwordTextField.setColumns(10);
		
		// Set text and font on 'loginButton' and add it to the panel
		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginButton.gridwidth = 2;
		gbc_loginButton.insets = new Insets(80, 10, 5, 10);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 9;
		contentPane.add(loginButton, gbc_loginButton);
		
		// 'loginButton' events handling by ActionListener
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String userID = userNameTextField.getText();  // String variable for storing the ID input by user
					String userPW = passwordTextField.getText();  // String variable for storing the password input by user
					String userPhoneNumber = "";  // String variable for storing user's phone number
					int pass = 0;  // Variables to determine whether login is successful
					
					// Checking for non-empty userNameTextField
					if (userID.trim().isEmpty()) {
						// Generate error if the userNameTextField is empty
						throw new EmptyFieldException ("Empty user name text field error");
					}
					// Checking for non-empty passwordTextField
					else if (userPW.trim().isEmpty()) {
						// Generate error if the passwordTextField is empty
						throw new EmptyFieldException ("Empty password text field error");
					}
			
					File file = new File("userDB.txt");  // Open the file to read user information
					try {
						FileReader filereader = new FileReader(file);
						BufferedReader bufReader = new BufferedReader(filereader);
						String line = "";
						try {
							// Read the file to the end in units of lines
							while((line = bufReader.readLine()) != null) {
								String[] array = line.split("\t");
								
								// Check if there is the same ID and password as the entered ID and password 
								if ((userID.equals(array[0])) && (userPW.equals(array[1]))) {
									userPhoneNumber = array[2];
									pass = 1;  // If the same ID and password exist, change the variable 'pass' to 1
								}
							}
						} 
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// Generate error if the same ID or password does not exist
						if (pass == 0) {
							throw new LoginFailureException ("Login failure error");
						}
						else {
							User user = new User(userID, userPW, userPhoneNumber, null);  // Instantiate User object
							new MainSelectionPage(user);  // After user presses the 'loginButton', program switches from the login page to main selection page if the ID and password are matched
							setVisible(false);  // Close the login page
						}
					} 
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// Error handling thrown by EmptyFieldException
				catch (EmptyFieldException error) {
					// Display warning message to the user to fill the blank field
					JOptionPane.showMessageDialog(null, "You forgot to fill the text field, Please fill it!", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				// Error handling thrown by LoginFailureException
				catch (LoginFailureException error) {
					// Display warning message to the user to notice the login is failed
					JOptionPane.showMessageDialog(null, "Login is failed, Try Again!", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Set text and font on 'signUpButton' and add it to the panel
		signUpButton = new JButton("SIGN UP");
		signUpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_signUpButton = new GridBagConstraints();
		gbc_signUpButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_signUpButton.gridwidth = 2;
		gbc_signUpButton.insets = new Insets(5, 10, 0, 10);
		gbc_signUpButton.gridx = 0;
		gbc_signUpButton.gridy = 10;
		contentPane.add(signUpButton, gbc_signUpButton);
		
		// 'signUpButton' events handling by ActionListener
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignupPage();  // After user presses the 'signUpButton', program switches from the login page to the sign-up page
                setVisible(false);  // Close the login page
			}
		});
	}
}