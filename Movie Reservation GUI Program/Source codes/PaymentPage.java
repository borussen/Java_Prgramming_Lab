import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Class name is PaymentPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's payment page.
 * The program provides the user with a price for the selected movie.
 * The user enters the card number and password to proceed with the payment.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class PaymentPage extends JFrame {
	
	private int payment;  // Class variable for storing the final payment
	
	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel movieLabel;  // JLabel for inform user where to find out selected movie title
	private JLabel movieTitleLabel;   // JLabel for inform selected movie title to user
	private JLabel seatLabel;  // JLabel for inform user where to find out selected seat information
	private JLabel seatInfoLabel;  // JLabel for inform selected seat information to user
	private JLabel paymentLabel;  // JLabel for inform user where to find out payment information
	private JLabel paymentInfoLabel;  // JLabel for inform payment to user
	private JLabel discountLabel;  // JLabel for inform user where to find out discount information
	private JComboBox discountComboBox;  // JComboBox for inform discount information to user
	private JLabel finalPaymentLabel;  // JLabel for inform user where to find out final payment information
	private JLabel finalPaymentInfoLabel;  // JLabel for inform final payment to user
	private JLabel cardNumberLabel;  // JLabel for inform user where to enter the card number
	private JTextField cardNumberTextField_1;  // JTextField for entering the card number
	private JTextField cardNumberTextField_2;  // JTextField for entering the card number
	private JPasswordField cardNumberTextField_3;  // JPasswordField for entering the card number
	private JPasswordField cardNumberTextField_4;  // JPasswordField for entering the card number
	private JLabel cardPasswordLabel;  // JLabel for inform user where to enter the card password
	private JPasswordField cardPasswordTextField;  // JPasswordField for entering the card password
	private JButton paymentButton;  // JButton to proceed with the payment
	private JButton backButton;  // JButton for move back to the previous page


	/**
	 * Create the frame.
	 */
	public PaymentPage(User user, List<String> seatList) {
		
		int ticketPrice = 10000;  // Variable for storing initial price per ticket
		payment = ticketPrice * user.getMovieInfo().getNumber();  // Calculate the initial amount to which the discount is not applied
		
		// Set the panel and panel layout
		setTitle("Payment");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(PaymentPage.class.getResource("movie.png"))); 
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 5;
		gbc_imageLabel.insets = new Insets(10, 0, 5, 0);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'movieLabel' and add it to the panel
		movieLabel = new JLabel("Movie");
		movieLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_movieLabel = new GridBagConstraints();
		gbc_movieLabel.insets = new Insets(30, 0, 5, 5);
		gbc_movieLabel.gridx = 0;
		gbc_movieLabel.gridy = 4;
		contentPane.add(movieLabel, gbc_movieLabel);
		
		// Set text and font on 'movieTitleLabel' and add it to the panel
		movieTitleLabel = new JLabel(user.getMovieInfo().getTitle());
		movieTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_movieTitleLabel = new GridBagConstraints();
		gbc_movieTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_movieTitleLabel.gridwidth = 4;
		gbc_movieTitleLabel.insets = new Insets(30, 0, 5, 10);
		gbc_movieTitleLabel.gridx = 1;
		gbc_movieTitleLabel.gridy = 4;
		contentPane.add(movieTitleLabel, gbc_movieTitleLabel);
		
		// Set text and font on 'seatLabel' and add it to the panel
		seatLabel = new JLabel("Seats");
		seatLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_seatLabel = new GridBagConstraints();
		gbc_seatLabel.insets = new Insets(5, 0, 5, 5);
		gbc_seatLabel.gridx = 0;
		gbc_seatLabel.gridy = 5;
		contentPane.add(seatLabel, gbc_seatLabel);
		
		// Set text and font on 'seatInfoLabel' and add it to the panel
		seatInfoLabel = new JLabel(seatList.toString());
		seatInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_seatInfoLabel = new GridBagConstraints();
		gbc_seatInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_seatInfoLabel.gridwidth = 4;
		gbc_seatInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_seatInfoLabel.gridx = 1;
		gbc_seatInfoLabel.gridy = 5;
		contentPane.add(seatInfoLabel, gbc_seatInfoLabel);
		
		// Set text and font on 'paymentLabel' and add it to the panel
		paymentLabel = new JLabel("Payment");
		paymentLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_paymentLabel = new GridBagConstraints();
		gbc_paymentLabel.insets = new Insets(5, 0, 5, 5);
		gbc_paymentLabel.gridx = 0;
		gbc_paymentLabel.gridy = 6;
		contentPane.add(paymentLabel, gbc_paymentLabel);
		
		// Set text and font on 'paymentInfoLabel' and add it to the panel
		paymentInfoLabel = new JLabel(10000 + " won ¡¿ " + user.getMovieInfo().getNumber());
		paymentInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_paymentInfoLabel = new GridBagConstraints();
		gbc_paymentInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_paymentInfoLabel.gridwidth = 4;
		gbc_paymentInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_paymentInfoLabel.gridx = 1;
		gbc_paymentInfoLabel.gridy = 6;
		contentPane.add(paymentInfoLabel, gbc_paymentInfoLabel);
		
		// Set text and font on 'discountLabel' and add it to the panel
		discountLabel = new JLabel("Discount");
		discountLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_discountLabel = new GridBagConstraints();
		gbc_discountLabel.insets = new Insets(5, 0, 5, 5);
		gbc_discountLabel.gridx = 0;
		gbc_discountLabel.gridy = 7;
		contentPane.add(discountLabel, gbc_discountLabel);
		
		// Set text and font on 'discountComboBox' and add it to the panel
		String discountCB[]= {"Not Applicate (0 won)", "Special Coupon (1000 won)", "Membership Discount (2000 won)"};
		discountComboBox = new JComboBox(discountCB);
		discountComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_discountComboBox = new GridBagConstraints();
		gbc_discountComboBox.gridwidth = 4;
		gbc_discountComboBox.insets = new Insets(5, 0, 5, 10);
		gbc_discountComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_discountComboBox.gridx = 1;
		gbc_discountComboBox.gridy = 7;
		contentPane.add(discountComboBox, gbc_discountComboBox);
		
		// 'discountComboBox' events handling by ActionListener
		discountComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start(user.getMovieInfo());  // // proceed the program by using multithreading
			}
		});
		
		// Set text and font on 'finalPaymentLabel' and add it to the panel
		finalPaymentLabel = new JLabel("Final Payment");
		finalPaymentLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_finalPaymentLabel = new GridBagConstraints();
		gbc_finalPaymentLabel.insets = new Insets(5, 0, 5, 5);
		gbc_finalPaymentLabel.gridx = 0;
		gbc_finalPaymentLabel.gridy = 8;
		contentPane.add(finalPaymentLabel, gbc_finalPaymentLabel);
		
		// Set text and font on 'finalPaymentInfoLabel' and add it to the panel
		finalPaymentInfoLabel = new JLabel(10000 * user.getMovieInfo().getNumber() + " won");
		finalPaymentInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_finalPaymentInfoLabel = new GridBagConstraints();
		gbc_finalPaymentInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_finalPaymentInfoLabel.gridwidth = 4;
		gbc_finalPaymentInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_finalPaymentInfoLabel.gridx = 1;
		gbc_finalPaymentInfoLabel.gridy = 8;
		contentPane.add(finalPaymentInfoLabel, gbc_finalPaymentInfoLabel);
		
		// Set text and font on 'carNumberLabel' and add it to the panel
		cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_cardNumberLabel = new GridBagConstraints();
		gbc_cardNumberLabel.insets = new Insets(5, 0, 5, 5);
		gbc_cardNumberLabel.gridx = 0;
		gbc_cardNumberLabel.gridy = 9;
		contentPane.add(cardNumberLabel, gbc_cardNumberLabel);
		
		// Set font on 'cardNumberTextField_1' and add it to the panel
		cardNumberTextField_1 = new JTextField();
		cardNumberTextField_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_cardNumberTextField_1 = new GridBagConstraints();
		gbc_cardNumberTextField_1.insets = new Insets(5, 0, 5, 5);
		gbc_cardNumberTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNumberTextField_1.gridx = 1;
		gbc_cardNumberTextField_1.gridy = 9;
		contentPane.add(cardNumberTextField_1, gbc_cardNumberTextField_1);
		cardNumberTextField_1.setColumns(10);
		
		// 'cardNumberTextField_1' events handling by KeyAdapter
		cardNumberTextField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// If it is not numeric input, program do not receive it
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
				// If input goes over 4 digits, program do not receive it
				if (((JTextField) e.getSource()).getText().length() == 4) {
					e.consume();
					return;
				}
			}
		});
		
		// Set font on 'cardNumberTextField_2' and add it to the panel
		cardNumberTextField_2 = new JTextField();
		cardNumberTextField_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_cardNumberTextField_2 = new GridBagConstraints();
		gbc_cardNumberTextField_2.insets = new Insets(5, 0, 5, 5);
		gbc_cardNumberTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNumberTextField_2.gridx = 2;
		gbc_cardNumberTextField_2.gridy = 9;
		contentPane.add(cardNumberTextField_2, gbc_cardNumberTextField_2);
		cardNumberTextField_2.setColumns(10);
		
		// 'cardNumberTextField_2' events handling by KeyAdapter
		cardNumberTextField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// If it is not numeric input, program do not receive it
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
				// If input goes over 4 digits, program do not receive it
				if (((JTextField) e.getSource()).getText().length() == 4) {
					e.consume();
					return;
				}
			}
		});
		
		// Set font on 'cardNumberTextField_3' and add it to the panel
		cardNumberTextField_3 = new JPasswordField();
		cardNumberTextField_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cardNumberTextField_3.setEchoChar('*');
		GridBagConstraints gbc_cardNumberTextField_3 = new GridBagConstraints();
		gbc_cardNumberTextField_3.insets = new Insets(5, 0, 5, 5);
		gbc_cardNumberTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNumberTextField_3.gridx = 3;
		gbc_cardNumberTextField_3.gridy = 9;
		contentPane.add(cardNumberTextField_3, gbc_cardNumberTextField_3);
		cardNumberTextField_3.setColumns(10);
		
		// 'cardNumberTextField_3' events handling by KeyAdapter
		cardNumberTextField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// If it is not numeric input, program do not receive it
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
				// If input goes over 4 digits, program do not receive it
				if (((JTextField) e.getSource()).getText().length() == 4) {
					e.consume();
					return;
				}
			}
		});
		
		// Set font on 'cardNumberTextField_4' and add it to the panel
		cardNumberTextField_4 = new JPasswordField();
		cardNumberTextField_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cardNumberTextField_4.setEchoChar('*');
		GridBagConstraints gbc_cardNumberTextField_4 = new GridBagConstraints();
		gbc_cardNumberTextField_4.insets = new Insets(5, 0, 5, 10);
		gbc_cardNumberTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNumberTextField_4.gridx = 4;
		gbc_cardNumberTextField_4.gridy = 9;
		contentPane.add(cardNumberTextField_4, gbc_cardNumberTextField_4);
		cardNumberTextField_4.setColumns(10);
		
		// 'cardNumberTextField_4' events handling by KeyAdapter
		cardNumberTextField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// If it is not numeric input, program do not receive it
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
				// If input goes over 4 digits, program do not receive it
				if (((JTextField) e.getSource()).getText().length() == 4) {
					e.consume();
					return;
				}
			}
		});
		
		// Set text and font on 'cardPasswordLabel' and add it to the panel
		cardPasswordLabel = new JLabel("Card Password");
		cardPasswordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_cardPasswordLabel = new GridBagConstraints();
		gbc_cardPasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_cardPasswordLabel.insets = new Insets(5, 0, 5, 5);
		gbc_cardPasswordLabel.gridx = 0;
		gbc_cardPasswordLabel.gridy = 10;
		contentPane.add(cardPasswordLabel, gbc_cardPasswordLabel);
		
		// Set font on 'cardPasswordTextField' and add it to the panel
		cardPasswordTextField = new JPasswordField();
		cardPasswordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cardPasswordTextField.setEchoChar('*');
		GridBagConstraints gbc_cardPasswordTextField = new GridBagConstraints();
		gbc_cardPasswordTextField.gridwidth = 4;
		gbc_cardPasswordTextField.insets = new Insets(5, 0, 5, 10);
		gbc_cardPasswordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardPasswordTextField.gridx = 1;
		gbc_cardPasswordTextField.gridy = 10;
		contentPane.add(cardPasswordTextField, gbc_cardPasswordTextField);
		cardPasswordTextField.setColumns(10);
		
		// Set text and font on 'paymentButton' and add it to the panel
		paymentButton = new JButton("Payment");
		paymentButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_paymentButton = new GridBagConstraints();
		gbc_paymentButton.insets = new Insets(50, 10, 5, 10);
		gbc_paymentButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentButton.gridwidth = 5;
		gbc_paymentButton.gridx = 0;
		gbc_paymentButton.gridy = 13;
		contentPane.add(paymentButton, gbc_paymentButton);
		
		// 'paymentButton' events handling by ActionListener
		paymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// If the user has entered valid card number and password, save reserved seat information to file and go to the next page
					if ((cardNumberTextField_1.getText().length() == 4) && (cardNumberTextField_2.getText().length() == 4) && (cardNumberTextField_3.getText().length() == 4) && (cardNumberTextField_4.getText().length() == 4) && !(cardPasswordTextField.getText().trim().isEmpty())) {
						// Open the file to write reserved seat information
						File file = new File("seatDB.txt");
						try {
							// Write the file in units of lines
							FileWriter filewriter = new FileWriter(file, true);
							if(file.isFile() && file.canWrite()) {
								filewriter.append(user.getMovieInfo().getDate());
								filewriter.append("\t");
								filewriter.append(user.getMovieInfo().getTime());
								filewriter.append("\t");
								filewriter.append(user.getMovieInfo().getTitle());
								filewriter.append("\t");
								filewriter.append(seatList.toString());
								filewriter.append("\n");
							}
							// Close the file
							filewriter.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						new CheckReservationPage(user, seatList, payment);  // Program switches from the payment page to reservation check page
		                setVisible(false);  // Close the payment page
					}
					// Generate error if the user has entered invalid card number or password
					else {
						throw new InvalidCardException ("Invalid Card Error");
					}
				}
				// Error handling thrown by InvalidCardException
				catch (InvalidCardException e1) {
					// Display warning message to the user to notice invalid inputs
					JOptionPane.showMessageDialog(null, "Invalid Card! Please try again.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Set text and font on 'backButton' and add it to the panel
		backButton = new JButton("Back");
		backButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 10, 0, 10);
		gbc_backButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_backButton.gridwidth = 5;
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 14;
		contentPane.add(backButton, gbc_backButton);
		
		// 'backButton' events handling by ActionListener
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeatSelectionPage(user);  // After user presses the 'backButton', program switches from the payment page to seat selection page
                setVisible(false);  // Close the payment page
			}
		});
	}
	
	
	private void start(MovieInformation movieInfo) {
	
		// First argument is the thread result, returned when processing finished.
		// Second argument is the value to update the GUI with via publish() and process()
		SwingWorker worker = new SwingWorker<Integer, Integer>() {

			@Override
			protected Integer doInBackground() throws Exception {
				String discount = discountComboBox.getSelectedItem().toString();  // String variable for storing selected discount option
				int discountType = 1;  // Variable for distinguishing selected discount option
				
				// Different value is assigned to each discount option
				if (discount == "Not Applicate (0 won)") {
					discountType = 1;
				}
				else if (discount == "Special Coupon (1000 won)") {
					discountType = 2;
				}
				else {
					discountType = 3;
				}
				
				// Send value to process() and use them to update the GUI
				publish(discountType);
				
				// Send value to done() and use it to update variable 'payment'
				return discountType;
			}

			// This will be called if you call publish() from doInBackground()
			protected void process(List<Integer> chunks) {
				// Save the values received from public() in doInBackground() to each variable for using it to update GUI
				int discountType = chunks.get(chunks.size()-1);
				
				// If user choose 'Not Applicate' option, the program will provide user with final payment that did not apply the discount
				if (discountType == 1) {
					finalPaymentInfoLabel.setText(10000 * movieInfo.getNumber() + " won");
				}
				// If user choose 'Special Coupon' option, the program will provide user with final payment that applied the 10% discount
				else if (discountType == 2) {
					finalPaymentInfoLabel.setText(9000 * movieInfo.getNumber() + " won");
				}
				// If user choose 'Membership Discount' option, the program will provide user with final payment that applied the 20% discount
				else {
					finalPaymentInfoLabel.setText(8000 * movieInfo.getNumber() + " won");
				}				
			}

			@Override
			// This is called when the thread finishes.
			protected void done() {
				try {
					// Get the value returned from doInBackground()
					int discountType = get();
					
					// If user choose 'Not Applicate' option, calculate 'payment' that did not apply the discount
					if (discountType == 1) {
						payment = 10000 * movieInfo.getNumber();	
					}
					// If user choose 'Special Coupon' option, calculate 'payment' that applied the 10% discount
					else if (discountType == 2) {
						payment = 9000 * movieInfo.getNumber();					
					}
					// If user choose 'Membership Discount' option, calculate 'payment' that applied the 20% discount
					else {
						payment = 8000 * movieInfo.getNumber();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		worker.execute();  // Execute the SwingWorker
	}
}