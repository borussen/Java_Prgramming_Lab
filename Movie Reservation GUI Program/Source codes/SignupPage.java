import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Class name is SignupPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's sign-up page.
 * It generates valid ID and password.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class SignupPage extends JFrame {
	
	private String type = "";  // Class variable that stores the area in which the error were occurred in the program
	
	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel userNameLabel;  // JLabel for inform user where to enter the ID
	private JTextField userNameTextField;  // JTextField for entering the ID
	private JLabel passwordLabel;  // JLabel for inform user where to enter the password
	private JPasswordField passwordTextField;  // JPasswordField for entering the password
	private JLabel repeatPasswordLabel;  // JLabel for inform user where to enter the password once more
	private JPasswordField repeatPasswordTextField;  // JPasswordField for entering the password once more
	private JLabel phoneLabel;  // JLabel for inform user where to enter the phone number
	private JTextField phoneTextField;  // JTextField for entering the phone number
	private JButton backButton;  // JButton for move back to the login page
	private JButton createButton;  // JButton for create the account

	/**
	 * Create the frame.
	 */
	public SignupPage() {
		
		// Set the panel and panel layout
		setTitle("Sign Up");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		imageLabel.setIcon(new ImageIcon(SignupPage.class.getResource("signup.png"))); 
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 2;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 0);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'userNameLabel' and add it to the panel
		userNameLabel = new JLabel("USER NAME");
		userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.anchor = GridBagConstraints.WEST;
		gbc_userNameLabel.insets = new Insets(10, 10, 5, 10);
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 5;
		contentPane.add(userNameLabel, gbc_userNameLabel);
		
		// Set font on 'userNameTextField' and add it to the panel
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_userNameTextField = new GridBagConstraints();
		gbc_userNameTextField.insets = new Insets(0, 10, 5, 10);
		gbc_userNameTextField.gridwidth = 2;
		gbc_userNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameTextField.gridx = 0;
		gbc_userNameTextField.gridy = 6;
		contentPane.add(userNameTextField, gbc_userNameTextField);
		userNameTextField.setColumns(10);
		
		// Set text and font on 'passwordLabel' and add it to the panel
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 10, 5, 10);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 7;
		contentPane.add(passwordLabel, gbc_passwordLabel);
		
		// Set font on 'passwordLabel' and add it to the panel
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordTextField.setEchoChar('*');  // For security purpose, convert the input value to * mark
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.insets = new Insets(0, 10, 5, 10);
		gbc_passwordTextField.gridwidth = 2;
		gbc_passwordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordTextField.gridx = 0;
		gbc_passwordTextField.gridy = 8;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		passwordTextField.setColumns(10);
		
		// Set text and font on 'repeatPasswordLabel' and add it to the panel
		repeatPasswordLabel = new JLabel("REPEAT PASSWORD");
		repeatPasswordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_repeatPasswordLabel = new GridBagConstraints();
		gbc_repeatPasswordLabel.anchor = GridBagConstraints.WEST;
		gbc_repeatPasswordLabel.insets = new Insets(0, 10, 5, 10);
		gbc_repeatPasswordLabel.gridx = 0;
		gbc_repeatPasswordLabel.gridy = 9;
		contentPane.add(repeatPasswordLabel, gbc_repeatPasswordLabel);
		
		// Set font on 'repeatPasswordTextField' and add it to the panel
		repeatPasswordTextField = new JPasswordField();
		repeatPasswordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		repeatPasswordTextField.setEchoChar('*');  // For security purpose, convert the input value to * mark
		GridBagConstraints gbc_repeatPasswordTextField = new GridBagConstraints();
		gbc_repeatPasswordTextField.insets = new Insets(0, 10, 5, 10);
		gbc_repeatPasswordTextField.gridwidth = 2;
		gbc_repeatPasswordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatPasswordTextField.gridx = 0;
		gbc_repeatPasswordTextField.gridy = 10;
		contentPane.add(repeatPasswordTextField, gbc_repeatPasswordTextField);
		repeatPasswordTextField.setColumns(10);
		
		// Set text and font on 'phoneLabel' and add it to the panel
		phoneLabel = new JLabel("PHONE NUMBER");
		phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneLabel.insets = new Insets(0, 10, 5, 10);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 11;
		contentPane.add(phoneLabel, gbc_phoneLabel);
		
		// Set font on 'phoneTextField' and add it to the panel
		phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_phoneTextField = new GridBagConstraints();
		gbc_phoneTextField.gridwidth = 2;
		gbc_phoneTextField.insets = new Insets(0, 10, 5, 10);
		gbc_phoneTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneTextField.gridx = 0;
		gbc_phoneTextField.gridy = 12;
		contentPane.add(phoneTextField, gbc_phoneTextField);
		phoneTextField.setColumns(10);
		
		// Set text and font on 'backButton' and add it to the panel
		backButton = new JButton("BACK");
		backButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_backButton.insets = new Insets(25, 10, 5, 5);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 13;
		contentPane.add(backButton, gbc_backButton);
		
		// 'backButton' events handling by ActionListener
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();  // After user presses the 'backButton', program switches from the sign-up page to the login page
                setVisible(false);  // Close the sign-up page
			}
		});
		
		// Set text and font on 'backButton' and add it to the panel
		createButton = new JButton("CREATE");
		createButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_createButton.insets = new Insets(25, 5, 5, 10);
		gbc_createButton.gridx = 1;
		gbc_createButton.gridy = 13;
		contentPane.add(createButton, gbc_createButton);
		
		// 'createButton' events handling by ActionListener
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String userName = userNameTextField.getText();
					type = "user name";
					// Checking for non-empty user name field
					if (userName.trim().isEmpty()) {
						// Generate error if the user name field is empty
						throw new EmptyFieldException ("Empty user name text field error");
					}
					
					String password = passwordTextField.getText();
					type = "password";
					// Checking for non-empty password field
					if (password.trim().isEmpty()) {
						// Generate error if the password field is empty
						throw new EmptyFieldException ("Empty password text field error");
					}
					// Checking for valid password length
					else if ((password.trim().length() < 5) || (password.trim().length() > 9)) {
						// Generate error if the password length is too short or too long
						throw new PasswordLengthException ("Invalid password length error");
					}
					
					String repeatPassword = repeatPasswordTextField.getText();
					type = "repeat password";
					// Checking for non-empty repeat password field
					if (repeatPassword.trim().isEmpty()) {
						// Generate error if the password field is empty
						throw new EmptyFieldException ("Empty repeat password text field error");
					}
					// Checking for matching with password
					else if (!(password.equals(repeatPassword))) {
						// Generate error if the password is inconsistency
						throw new PasswordMismatchException ("Password mismatch error");
					}
					
					String phone = phoneTextField.getText();
					type = "phone number";
					// Checking for non-empty phone number field
					if (phone.trim().isEmpty()) {
						// Generate error if the phone number field is empty
						throw new EmptyFieldException ("Empty phone text field error");
					}
					// Phone number checking for integer
					int phoneNumber = Integer.parseInt(phone);
					// phone number checking for positive value
					if (phoneNumber < 0) {
						// Generate error if the phone number is not a positive number
						throw new NumberFormatException ("Invalid phone number format error");
					}
					
					// Open the file to write user information
					File file = new File("userDB.txt");  
					try {
						// Write the file in units of lines
						FileWriter filewriter = new FileWriter(file, true);
						if(file.isFile() && file.canWrite()) {
							filewriter.append(userName);
							filewriter.append("\t");
							filewriter.append(password);
							filewriter.append("\t");
							filewriter.append(phone);
							filewriter.append("\n");
						}
						// Close the file
						filewriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// After user presses the 'createButton', program creates the new account and switches from the sign-up page to login page if there is no problem
					JOptionPane.showMessageDialog(null, "The membership registration has been successfully completed.", "Application Status", JOptionPane.INFORMATION_MESSAGE);
					new LoginPage();
	                setVisible(false);
				}
				// Error handling thrown by EmptyFieldException
				catch (EmptyFieldException error) {
					// Display warning message to the user to fill the blank field
					JOptionPane.showMessageDialog(null, "You forgot to fill " + type + " text field, Please fill it!", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				// Error handling thrown by PasswordLengthException
				catch (PasswordLengthException error) {
					// Display warning message to the user to notice valid password length
					JOptionPane.showMessageDialog(null, "Password length must be 5 to 8. Please try again!", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				// Error handling thrown by PasswordMissmatchException
				catch (PasswordMismatchException error) {
					// Display warning message to the user to notice password inconsistency
					JOptionPane.showMessageDialog(null, "Repeat password is not same with password. Please try again!", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				// Error handling thrown by NumberFormatException
				catch (NumberFormatException error) {
					// Display warning message to the user to enter the proper input
					JOptionPane.showMessageDialog(null, "Please enter proper input for " + type + "!\nIt should be positive integer number.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}