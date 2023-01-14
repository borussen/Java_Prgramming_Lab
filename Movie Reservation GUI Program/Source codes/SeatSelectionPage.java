import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.awt.Font;

/**
 * Class name is SeatSelectionPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's seat selection page.
 * Program identifies the status of seat reservations through file 'seatDB' and provides it to user.
 * The user selects seats according to the number of people based on the provided information.
 * The seat selected by the user is reflected in real time.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class SeatSelectionPage extends JFrame {
	
	private int number = 0;  // Class variable that represents the number of seats the user needs to select
	private String selectedSeat = "";  // Class variable that stores seats that have already been preempted
	
	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel screenLabel;  // JLabel for representing the screen
	private JLabel A1Label;  // JLabel for representing the seat A1
	private JLabel A2Label;  // JLabel for representing the seat A2
	private JLabel A3Label;  // JLabel for representing the seat A3
	private JLabel A4Label;  // JLabel for representing the seat A4
	private JLabel A5Label;  // JLabel for representing the seat A4
	private JLabel B1Label;  // JLabel for representing the seat B1
	private JLabel B2Label;  // JLabel for representing the seat B2
	private JLabel B3Label;  // JLabel for representing the seat B3
	private JLabel B4Label;  // JLabel for representing the seat B4
	private JLabel B5Label;  // JLabel for representing the seat B5
	private JLabel C1Label;  // JLabel for representing the seat C1
	private JLabel C2Label;  // JLabel for representing the seat C2
	private JLabel C3Label;  // JLabel for representing the seat C3
	private JLabel C4Label;  // JLabel for representing the seat C4
	private JLabel C5Label;  // JLabel for representing the seat C5
	private JLabel D1Label;  // JLabel for representing the seat D1
	private JLabel D2Label;  // JLabel for representing the seat D2
	private JLabel D3Label;  // JLabel for representing the seat D3
	private JLabel D4Label;  // JLabel for representing the seat D4
	private JLabel D5Label;  // JLabel for representing the seat D5
	private JLabel E1Label;  // JLabel for representing the seat E1
	private JLabel E2Label;  // JLabel for representing the seat E2
	private JLabel E3Label;  // JLabel for representing the seat E3
	private JLabel E4Label;  // JLabel for representing the seat E4
	private JLabel E5Label;  // JLabel for representing the seat E5
	private JLabel informLabel;  // JLabel for guiding the user
	private JLabel seatInfoLabel;  // JLabel for informing the seat information selected by the user
	private JButton nextButton;  // JButton for move on to the next page
	private JButton backButton;  // JButton for move back to the previous page

	/**
	 * Create the frame.
	 */
	public SeatSelectionPage(User user) {
		
		number = user.getMovieInfo().getNumber();  // Find out the number of seats user need to select through the information stored in the User object
		List<String> seatList = new ArrayList<String>();  // List for storing seat information selected by the user
		
		File file = new File("seatDB.txt");  // Open the file to read seat reservation information
		try {
			String date = user.getMovieInfo().getDate();  // String variable for storing user's reservation date
			String time = user.getMovieInfo().getTime();  // String variable for storing user's reservation time
			String movie = user.getMovieInfo().getTime();  // String variable for storing user's reservation date
			int pass = 0;  // Variables to check whether it is same movie that plays at the same time on the same day
			
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			try {
				// Read the file to the end in units of lines
				while((line = bufReader.readLine()) != null) {
					int idDate = line.indexOf(date);  // Check if there is the same date as the user selected
					int idTime = line.indexOf(time);  // Check if there is the same time as the user selected
					int idMovie = line.indexOf(movie);  // Check if there is the same movie as the user selected
					
					// If all three are same, add the preempted seat information and change the variable 'pass' to 1
					if (idDate != -1 && idTime != -1 && idMovie != -1) {
						String[] array = line.split("\t");
						selectedSeat = selectedSeat + array[3];
						pass = 1;
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Set the panel and panel layout
		setTitle("Seat Selection");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		imageLabel.setIcon(new ImageIcon(LoginPage.class.getResource("movie.png")));
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 6;
		gbc_imageLabel.insets = new Insets(10, 0, 5, 5);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'screenLabel' and add it to the panel
		screenLabel = new JLabel("Screen");
		screenLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_screenLabel = new GridBagConstraints();
		gbc_screenLabel.gridwidth = 5;
		gbc_screenLabel.insets = new Insets(20, 0, 20, 10);
		gbc_screenLabel.gridx = 1;
		gbc_screenLabel.gridy = 3;
		contentPane.add(screenLabel, gbc_screenLabel);
		
		
		/**
		 * Since the implementation method from "A1Label" to "E5Label" are the same, 
		 * I will explain only about "A1Label" as a representative.
		 */
		
		// Set text, font and background color on 'A1Label' and add it to the panel
		A1Label = new JLabel("   A1   ");
		A1Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		A1Label.setOpaque(true);
		A1Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_A1Label = new GridBagConstraints();
		gbc_A1Label.insets = new Insets(0, 0, 5, 5);
		gbc_A1Label.gridx = 1;
		gbc_A1Label.gridy = 4;
		contentPane.add(A1Label, gbc_A1Label);
		
		// If the seat is preempted, make it unable to select 
		if(selectedSeat.contains("A1")) {
			A1Label.setEnabled(false);
		}
		// If the seat is preempted, make it able to select 
		else {
			A1Label.setEnabled(true);
		}
		// 'signUpButton' events handling by MouseAdapter
		A1Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(A1Label.isEnabled()) {
					// If user press the seat selected by the user again, select will be canceled 
					if(A1Label.getBackground() == Color.RED) {
						A1Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("A1");  // Remove the selected seat to the "seatList"
						number++;  // the number of seats user need to select is increased
					}
					else {
						// If user selects unoccupied seats within the number of people, the selection will proceed successfully
						if(number > 0) {
							A1Label.setBackground(Color.RED);
							seatList.add("A1");  // Add the selected seat to the "seatList"
							number--;  // the number of seats user need to select is decreased
						}
						// If user selects seats to exceed the number of people, the program displays warning message to the user to notice
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				// If the user selects seats that is occupied, the program displays warning message to the user to notice
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());  // proceed the program by using multithreading.
			}
		});
		
		// Set text, font and background color on 'A2Label' and add it to the panel
		A2Label = new JLabel("   A2   ");
		A2Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		A2Label.setOpaque(true);
		A2Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_A2Label = new GridBagConstraints();
		gbc_A2Label.insets = new Insets(0, 0, 5, 5);
		gbc_A2Label.gridx = 2;
		gbc_A2Label.gridy = 4;
		contentPane.add(A2Label, gbc_A2Label);
		
		if(selectedSeat.contains("A2")) {
			A2Label.setEnabled(false);
		}
		else {
			A2Label.setEnabled(true);
		}
		A2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(A2Label.isEnabled()) {
					if(A2Label.getBackground() == Color.RED) {
						A2Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("A2");
						number++;
					}
					else {
						if(number > 0) {
							A2Label.setBackground(Color.RED);
							seatList.add("A2");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'A3Label' and add it to the panel
		A3Label = new JLabel("   A3   ");
		A3Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		A3Label.setOpaque(true);
		A3Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_A3Label = new GridBagConstraints();
		gbc_A3Label.insets = new Insets(0, 0, 5, 5);
		gbc_A3Label.gridx = 3;
		gbc_A3Label.gridy = 4;
		contentPane.add(A3Label, gbc_A3Label);
		
		if(selectedSeat.contains("A3")) {
			A3Label.setEnabled(false);
		}
		else {
			A3Label.setEnabled(true);
		}
		A3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(A3Label.isEnabled()) {
					if(A3Label.getBackground() == Color.RED) {
						A3Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("A3");
						number++;
					}
					else {
						if(number > 0) {
							A3Label.setBackground(Color.RED);
							seatList.add("A3");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'A4Label' and add it to the panel
		A4Label = new JLabel("   A4   ");
		A4Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		A4Label.setOpaque(true);
		A4Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_A4Label = new GridBagConstraints();
		gbc_A4Label.insets = new Insets(0, 0, 5, 5);
		gbc_A4Label.gridx = 4;
		gbc_A4Label.gridy = 4;
		contentPane.add(A4Label, gbc_A4Label);
		
		if(selectedSeat.contains("A4")) {
			A4Label.setEnabled(false);
		}
		else {
			A4Label.setEnabled(true);
		}
		A4Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(A4Label.isEnabled()) {
					if(A4Label.getBackground() == Color.RED) {
						A4Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("A4");
						number++;
					}
					else {
						if(number > 0) {
							A4Label.setBackground(Color.RED);
							seatList.add("A4");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'A5Label' and add it to the panel
		A5Label = new JLabel("   A5   ");
		A5Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		A5Label.setOpaque(true);
		A5Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_A5Label = new GridBagConstraints();
		gbc_A5Label.insets = new Insets(0, 0, 5, 5);
		gbc_A5Label.gridx = 5;
		gbc_A5Label.gridy = 4;
		contentPane.add(A5Label, gbc_A5Label);
		
		if(selectedSeat.contains("A5")) {
			A5Label.setEnabled(false);
		}
		else {
			A5Label.setEnabled(true);
		}
		A5Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(A5Label.isEnabled()) {
					if(A5Label.getBackground() == Color.RED) {
						A5Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("A5");
						number++;
					}
					else {
						if(number > 0) {
							A5Label.setBackground(Color.RED);
							seatList.add("A5");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'B1Label' and add it to the panel
		B1Label = new JLabel("   B1   ");
		B1Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		B1Label.setOpaque(true);
		B1Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_B1Label = new GridBagConstraints();
		gbc_B1Label.insets = new Insets(0, 0, 5, 5);
		gbc_B1Label.gridx = 1;
		gbc_B1Label.gridy = 5;
		contentPane.add(B1Label, gbc_B1Label);
		
		if(selectedSeat.contains("B1")) {
			B1Label.setEnabled(false);
		}
		else {
			B1Label.setEnabled(true);
		}
		B1Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(B1Label.isEnabled()) {
					if(B1Label.getBackground() == Color.RED) {
						B1Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("B1");
						number++;
					}
					else {
						if(number > 0) {
							B1Label.setBackground(Color.RED);
							seatList.add("B1");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'B2Label' and add it to the panel
		B2Label = new JLabel("   B2   ");
		B2Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		B2Label.setOpaque(true);
		B2Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_B2Label = new GridBagConstraints();
		gbc_B2Label.insets = new Insets(0, 0, 5, 5);
		gbc_B2Label.gridx = 2;
		gbc_B2Label.gridy = 5;
		contentPane.add(B2Label, gbc_B2Label);
		
		if(selectedSeat.contains("B2")) {
			B2Label.setEnabled(false);
		}
		else {
			B2Label.setEnabled(true);
		}
		B2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(B2Label.isEnabled()) {
					if(B2Label.getBackground() == Color.RED) {
						B2Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("B2");
						number++;
					}
					else {
						if(number > 0) {
							B2Label.setBackground(Color.RED);
							seatList.add("B2");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'B3Label' and add it to the panel
		B3Label = new JLabel("   B3   ");
		B3Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		B3Label.setOpaque(true);
		B3Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_B3Label = new GridBagConstraints();
		gbc_B3Label.insets = new Insets(0, 0, 5, 5);
		gbc_B3Label.gridx = 3;
		gbc_B3Label.gridy = 5;
		contentPane.add(B3Label, gbc_B3Label);
		
		if(selectedSeat.contains("B3")) {
			B3Label.setEnabled(false);
		}
		else {
			B3Label.setEnabled(true);
		}
		B3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(B3Label.isEnabled()) {
					if(B3Label.getBackground() == Color.RED) {
						B3Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("B3");
						number++;
					}
					else {
						if(number > 0) {
							B3Label.setBackground(Color.RED);
							seatList.add("B3");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'B4Label' and add it to the panel
		B4Label = new JLabel("   B4   ");
		B4Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		B4Label.setOpaque(true);
		B4Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_B4Label = new GridBagConstraints();
		gbc_B4Label.insets = new Insets(0, 0, 5, 5);
		gbc_B4Label.gridx = 4;
		gbc_B4Label.gridy = 5;
		contentPane.add(B4Label, gbc_B4Label);
		
		if(selectedSeat.contains("B4")) {
			B4Label.setEnabled(false);
		}
		else {
			B4Label.setEnabled(true);
		}
		B4Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(B4Label.isEnabled()) {
					if(B4Label.getBackground() == Color.RED) {
						B4Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("B4");
						number++;
					}
					else {
						if(number > 0) {
							B4Label.setBackground(Color.RED);
							seatList.add("B4");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'B5Label' and add it to the panel
		B5Label = new JLabel("   B5   ");
		B5Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		B5Label.setOpaque(true);
		B5Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_B5Label = new GridBagConstraints();
		gbc_B5Label.insets = new Insets(0, 0, 5, 5);
		gbc_B5Label.gridx = 5;
		gbc_B5Label.gridy = 5;
		contentPane.add(B5Label, gbc_B5Label);
		
		if(selectedSeat.contains("B5")) {
			B5Label.setEnabled(false);
		}
		else {
			B5Label.setEnabled(true);
		}
		B5Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(B5Label.isEnabled()) {
					if(B5Label.getBackground() == Color.RED) {
						B5Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("B5");
						number++;
					}
					else {
						if(number > 0) {
							B5Label.setBackground(Color.RED);
							seatList.add("B5");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'C1Label' and add it to the panel
		C1Label = new JLabel("   C1   ");
		C1Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		C1Label.setOpaque(true);
		C1Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_C1Label = new GridBagConstraints();
		gbc_C1Label.insets = new Insets(0, 0, 5, 5);
		gbc_C1Label.gridx = 1;
		gbc_C1Label.gridy = 6;
		contentPane.add(C1Label, gbc_C1Label);
		
		if(selectedSeat.contains("C1")) {
			C1Label.setEnabled(false);
		}
		else {
			C1Label.setEnabled(true);
		}
		C1Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(C1Label.isEnabled()) {
					if(C1Label.getBackground() == Color.RED) {
						C1Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("C1");
						number++;
					}
					else {
						if(number > 0) {
							C1Label.setBackground(Color.RED);
							seatList.add("C1");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'C2Label' and add it to the panel
		C2Label = new JLabel("   C2   ");
		C2Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		C2Label.setOpaque(true);
		C2Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_C2Label = new GridBagConstraints();
		gbc_C2Label.insets = new Insets(0, 0, 5, 5);
		gbc_C2Label.gridx = 2;
		gbc_C2Label.gridy = 6;
		contentPane.add(C2Label, gbc_C2Label);
		
		if(selectedSeat.contains("C2")) {
			C2Label.setEnabled(false);
		}
		else {
			C2Label.setEnabled(true);
		}
		C2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(C2Label.isEnabled()) {
					if(C2Label.getBackground() == Color.RED) {
						C2Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("C2");
						number++;
					}
					else {
						if(number > 0) {
							C2Label.setBackground(Color.RED);
							seatList.add("C2");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'C3Label' and add it to the panel
		C3Label = new JLabel("   C3   ");
		C3Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		C3Label.setOpaque(true);
		C3Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_C3Label = new GridBagConstraints();
		gbc_C3Label.insets = new Insets(0, 0, 5, 5);
		gbc_C3Label.gridx = 3;
		gbc_C3Label.gridy = 6;
		contentPane.add(C3Label, gbc_C3Label);
		
		if(selectedSeat.contains("C3")) {
			C3Label.setEnabled(false);
		}
		else {
			C3Label.setEnabled(true);
		}
		C3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(C3Label.isEnabled()) {
					if(C3Label.getBackground() == Color.RED) {
						C3Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("C3");
						number++;
					}
					else {
						if(number > 0) {
							C3Label.setBackground(Color.RED);
							seatList.add("C3");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'C4Label' and add it to the panel
		C4Label = new JLabel("   C4   ");
		C4Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		C4Label.setOpaque(true);
		C4Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_C4Label = new GridBagConstraints();
		gbc_C4Label.insets = new Insets(0, 0, 5, 5);
		gbc_C4Label.gridx = 4;
		gbc_C4Label.gridy = 6;
		contentPane.add(C4Label, gbc_C4Label);
		
		if(selectedSeat.contains("C4")) {
			C4Label.setEnabled(false);
		}
		else {
			C4Label.setEnabled(true);
		}
		C4Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(C4Label.isEnabled()) {
					if(C4Label.getBackground() == Color.RED) {
						C4Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("C4");
						number++;
					}
					else {
						if(number > 0) {
							C4Label.setBackground(Color.RED);
							seatList.add("C4");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'C5Label' and add it to the panel
		C5Label = new JLabel("   C5   ");
		C5Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		C5Label.setOpaque(true);
		C5Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_C5Label = new GridBagConstraints();
		gbc_C5Label.insets = new Insets(0, 0, 5, 5);
		gbc_C5Label.gridx = 5;
		gbc_C5Label.gridy = 6;
		contentPane.add(C5Label, gbc_C5Label);
		
		if(selectedSeat.contains("C5")) {
			C5Label.setEnabled(false);
		}
		else {
			C5Label.setEnabled(true);
		}
		C5Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(C5Label.isEnabled()) {
					if(C5Label.getBackground() == Color.RED) {
						C5Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("C5");
						number++;
					}
					else {
						if(number > 0) {
							C5Label.setBackground(Color.RED);
							seatList.add("C5");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'D1Label' and add it to the panel
		D1Label = new JLabel("   D1   ");
		D1Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		D1Label.setOpaque(true);
		D1Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_D1Label = new GridBagConstraints();
		gbc_D1Label.insets = new Insets(0, 0, 5, 5);
		gbc_D1Label.gridx = 1;
		gbc_D1Label.gridy = 7;
		contentPane.add(D1Label, gbc_D1Label);
		
		if(selectedSeat.contains("D1")) {
			D1Label.setEnabled(false);
		}
		else {
			D1Label.setEnabled(true);
		}
		D1Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(D1Label.isEnabled()) {
					if(D1Label.getBackground() == Color.RED) {
						D1Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("D1");
						number++;
					}
					else {
						if(number > 0) {
							D1Label.setBackground(Color.RED);
							seatList.add("D1");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'D2Label' and add it to the panel
		D2Label = new JLabel("   D2   ");
		D2Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		D2Label.setOpaque(true);
		D2Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_D2Label = new GridBagConstraints();
		gbc_D2Label.insets = new Insets(0, 0, 5, 5);
		gbc_D2Label.gridx = 2;
		gbc_D2Label.gridy = 7;
		contentPane.add(D2Label, gbc_D2Label);
		
		if(selectedSeat.contains("D2")) {
			D2Label.setEnabled(false);
		}
		else {
			D2Label.setEnabled(true);
		}
		D2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(D2Label.isEnabled()) {
					if(D2Label.getBackground() == Color.RED) {
						D2Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("D2");
						number++;
					}
					else {
						if(number > 0) {
							D2Label.setBackground(Color.RED);
							seatList.add("D2");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'D3Label' and add it to the panel
		D3Label = new JLabel("   D3   ");
		D3Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		D3Label.setOpaque(true);
		D3Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_D3Label = new GridBagConstraints();
		gbc_D3Label.insets = new Insets(0, 0, 5, 5);
		gbc_D3Label.gridx = 3;
		gbc_D3Label.gridy = 7;
		contentPane.add(D3Label, gbc_D3Label);
		
		if(selectedSeat.contains("D3")) {
			D3Label.setEnabled(false);
		}
		else {
			D3Label.setEnabled(true);
		}
		D3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(D3Label.isEnabled()) {
					if(D3Label.getBackground() == Color.RED) {
						D3Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("D3");
						number++;
					}
					else {
						if(number > 0) {
							D3Label.setBackground(Color.RED);
							seatList.add("D3");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'D4Label' and add it to the panel
		D4Label = new JLabel("   D4   ");
		D4Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		D4Label.setOpaque(true);
		D4Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_D4Label = new GridBagConstraints();
		gbc_D4Label.insets = new Insets(0, 0, 5, 5);
		gbc_D4Label.gridx = 4;
		gbc_D4Label.gridy = 7;
		contentPane.add(D4Label, gbc_D4Label);
		
		if(selectedSeat.contains("D4")) {
			D4Label.setEnabled(false);
		}
		else {
			D4Label.setEnabled(true);
		}
		D4Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(D4Label.isEnabled()) {
					if(D4Label.getBackground() == Color.RED) {
						D4Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("D4");
						number++;
					}
					else {
						if(number > 0) {
							D4Label.setBackground(Color.RED);
							seatList.add("D4");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'D5Label' and add it to the panel
		D5Label = new JLabel("   D5   ");
		D5Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		D5Label.setOpaque(true);
		D5Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_D5Label = new GridBagConstraints();
		gbc_D5Label.insets = new Insets(0, 0, 5, 5);
		gbc_D5Label.gridx = 5;
		gbc_D5Label.gridy = 7;
		contentPane.add(D5Label, gbc_D5Label);
		
		if(selectedSeat.contains("D5")) {
			D5Label.setEnabled(false);
		}
		else {
			D5Label.setEnabled(true);
		}
		D5Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(D5Label.isEnabled()) {
					if(D5Label.getBackground() == Color.RED) {
						D5Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("D5");
						number++;
					}
					else {
						if(number > 0) {
							D5Label.setBackground(Color.RED);
							seatList.add("D5");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'E1Label' and add it to the panel
		E1Label = new JLabel("   E1   ");
		E1Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		E1Label.setOpaque(true);
		E1Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_E1Label = new GridBagConstraints();
		gbc_E1Label.insets = new Insets(0, 0, 5, 5);
		gbc_E1Label.gridx = 1;
		gbc_E1Label.gridy = 8;
		contentPane.add(E1Label, gbc_E1Label);
		
		if(selectedSeat.contains("E1")) {
			E1Label.setEnabled(false);
		}
		else {
			E1Label.setEnabled(true);
		}
		E1Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(E1Label.isEnabled()) {
					if(E1Label.getBackground() == Color.RED) {
						E1Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("E1");
						number++;
					}
					else {
						if(number > 0) {
							E1Label.setBackground(Color.RED);
							seatList.add("E1");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'E2Label' and add it to the panel
		E2Label = new JLabel("   E2   ");
		E2Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		E2Label.setOpaque(true);
		E2Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_E2Label = new GridBagConstraints();
		gbc_E2Label.insets = new Insets(0, 0, 5, 5);
		gbc_E2Label.gridx = 2;
		gbc_E2Label.gridy = 8;
		contentPane.add(E2Label, gbc_E2Label);
		
		if(selectedSeat.contains("E2")) {
			E2Label.setEnabled(false);
		}
		else {
			E2Label.setEnabled(true);
		}
		E2Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(E2Label.isEnabled()) {
					if(E2Label.getBackground() == Color.RED) {
						E2Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("E2");
						number++;
					}
					else {
						if(number > 0) {
							E2Label.setBackground(Color.RED);
							seatList.add("E2");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'E3Label' and add it to the panel
		E3Label = new JLabel("   E3   ");
		E3Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		E3Label.setOpaque(true);
		E3Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_E3Label = new GridBagConstraints();
		gbc_E3Label.insets = new Insets(0, 0, 5, 5);
		gbc_E3Label.gridx = 3;
		gbc_E3Label.gridy = 8;
		contentPane.add(E3Label, gbc_E3Label);
		
		if(selectedSeat.contains("E3")) {
			E3Label.setEnabled(false);
		}
		else {
			E3Label.setEnabled(true);
		}
		E3Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(E3Label.isEnabled()) {
					if(E3Label.getBackground() == Color.RED) {
						E3Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("E3");
						number++;
					}
					else {
						if(number > 0) {
							E3Label.setBackground(Color.RED);
							seatList.add("E3");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'E4Label' and add it to the panel
		E4Label = new JLabel("   E4   ");
		E4Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		E4Label.setOpaque(true);
		E4Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_E4Label = new GridBagConstraints();
		gbc_E4Label.insets = new Insets(0, 0, 5, 5);
		gbc_E4Label.gridx = 4;
		gbc_E4Label.gridy = 8;
		contentPane.add(E4Label, gbc_E4Label);
		
		if(selectedSeat.contains("E4")) {
			E4Label.setEnabled(false);
		}
		else {
			E4Label.setEnabled(true);
		}
		E4Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(E4Label.isEnabled()) {
					if(E4Label.getBackground() == Color.RED) {
						E4Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("E4");
						number++;
					}
					else {
						if(number > 0) {
							E4Label.setBackground(Color.RED);
							seatList.add("E4");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text, font and background color on 'E5Label' and add it to the panel
		E5Label = new JLabel("   E5   ");
		E5Label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		E5Label.setOpaque(true);
		E5Label.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_E5Label = new GridBagConstraints();
		gbc_E5Label.insets = new Insets(0, 0, 5, 5);
		gbc_E5Label.gridx = 5;
		gbc_E5Label.gridy = 8;
		contentPane.add(E5Label, gbc_E5Label);
		
		if(selectedSeat.contains("E5")) {
			E5Label.setEnabled(false);
		}
		else {
			E5Label.setEnabled(true);
		}
		E5Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(E5Label.isEnabled()) {
					if(E5Label.getBackground() == Color.RED) {
						E5Label.setBackground(Color.LIGHT_GRAY);
						seatList.remove("E5");
						number++;
					}
					else {
						if(number > 0) {
							E5Label.setBackground(Color.RED);
							seatList.add("E5");
							number--;
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select seats that exceed the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This seat has been preempted.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
				start(seatList, user.getMovieInfo());
			}
		});
		
		// Set text and font on 'informLabel' and add it to the panel
		informLabel = new JLabel("Please choose the seat you want!");
		informLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_informLabel = new GridBagConstraints();
		gbc_informLabel.gridwidth = 5;
		gbc_informLabel.insets = new Insets(30, 0, 5, 5);
		gbc_informLabel.gridx = 1;
		gbc_informLabel.gridy = 10;
		contentPane.add(informLabel, gbc_informLabel);
		
		// Set text and font on 'seatInfoLabel' and add it to the panel
		seatInfoLabel = new JLabel("Select: [] (" + (user.getMovieInfo().getNumber() - number) + " / " + user.getMovieInfo().getNumber() + ")");
		seatInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_seatInfoLabel = new GridBagConstraints();
		gbc_seatInfoLabel.gridwidth = 5;
		gbc_seatInfoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_seatInfoLabel.gridx = 1;
		gbc_seatInfoLabel.gridy = 11;
		contentPane.add(seatInfoLabel, gbc_seatInfoLabel);
		
		// Set text and font on 'nextButton' and add it to the panel
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.gridwidth = 5;
		gbc_nextButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_nextButton.insets = new Insets(40, 10, 5, 10);
		gbc_nextButton.gridx = 1;
		gbc_nextButton.gridy = 12;
		contentPane.add(nextButton, gbc_nextButton);
		
		// 'nextButton' events handling by ActionListener
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If the user has selected as many seats as the number of people, go to the next page
				if (number == 0) {
					Collections.sort(seatList);  // Sort the selected seats
					new PaymentPage(user, seatList);  // Program switches from the seat selection page to payment page
					setVisible(false);  // Close the seat selection page
				}
				// If the user does not select as many seats as the number of people, a warning message is displayed to notify the user that additional seat selection is required.
				else {
					JOptionPane.showMessageDialog(null, "Please select your seats according to the number of people.", "Application Status", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Set text and font on 'backButton' and add it to the panel
		backButton = new JButton("Back");
		backButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridwidth = 5;
		gbc_backButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_backButton.insets = new Insets(0, 10, 0, 10);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 13;
		contentPane.add(backButton, gbc_backButton);
		
		// 'backButton' events handling by ActionListener
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainSelectionPage(user);  // After user presses the 'backButton', program switches from the seat selection page to main selection page
                setVisible(false);  // Close the seat selection page
			}
		});
	}
	
	
	private void start(List<String> seatList, MovieInformation movieInfo) {
		
		// First argument is the thread result, returned when processing finished.
		// Second argument is the value to update the GUI with via publish() and process()
		SwingWorker worker = new SwingWorker<Void, Integer>() {

			@Override
			protected Void doInBackground() throws Exception {
				int selectNumber = number;  // variable for storing the current number of seats user need to select
				int totalNumber = movieInfo.getNumber();  // Variable for storing the total number of seats user need to select
				
				// Send values to process() and use them to update the GUI
				publish(selectNumber);
				publish(totalNumber);
				
				return null;
			}

			// This will be called if you call publish() from doInBackground()
			protected void process(List<Integer> chunks) {
				// Save the values received from public() in doInBackground() to each variable for using it to update GUI
				int select = chunks.get(chunks.size()-2);
				int total = chunks.get(chunks.size()-1);
				
				Collections.sort(seatList);  // Sort the seatList
				
				// informing the seat information selected by the user using the provided variables
				seatInfoLabel.setText("Select: " + seatList.toString() + " (" + (total - select) + " / " + total + ")");			
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