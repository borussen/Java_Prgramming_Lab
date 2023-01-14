import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Class name is CheckReservationPage. This is about Movie Reservation Program of Final Project.
 * It implements the program's reservation check page.
 * The program provides the user with overall information on confirmed reservations.
 * This allows the user to check whether the reservation has been successful.
 * 
 * @version JavaSE-16 11 December 2021
 * @author KIM HOJIN (2016314786)
 */
public class CheckReservationPage extends JFrame {

	private JPanel contentPane;
	private JLabel imageLabel;  // JLabel for attaching image
	private JLabel movieLabel;  // JLabel for inform user where to find out reserved movie title
	private JLabel movieTitleLabel;  // JLabel for inform reserved movie title to user
	private JLabel dateLabel;  // JLabel for inform user where to find out reserved date information
	private JLabel dateInfoLabel;  // JLabel for inform reserved date information to user
	private JLabel timeLabel;  // JLabel for inform user where to find out reserved time information
	private JLabel timeInfoLabel;  // JLabel for inform reserved time information to user
	private JLabel numberLabel;  // JLabel for inform user where to find out reserved number of people
	private JLabel numberInfoLabel;  // JLabel for inform reserved number of people to user
	private JLabel seatLabel;  // JLabel for inform user where to find out reserved seat information
	private JLabel seatInfoLabel;  // JLabel for inform reserved seat information to user
	private JLabel paymentLabel;  // JLabel for inform user where to find out payment amount
	private JLabel paymentInfoLabel;  // JLabel for inform payment amount information to user
	private JLabel informLabel_1;  // JLabel for provide additional guidance to user
	private JLabel informLabel_2;  // JLabel for provide additional guidance to user
	private JLabel informLabel_3;  // JLabel for provide additional guidance to user
	private JButton completeButton;  // JButton to complete the program

	/**
	 * Create the frame.
	 */
	public CheckReservationPage(User user, List<String> seatList, int payment) {
		
		// Set the panel and panel layout
		setTitle("Reservation");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		// Set image on 'imageLabel' and add it to the panel
		imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(CheckReservationPage.class.getResource("reservation.png")));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageLabel.gridheight = 3;
		gbc_imageLabel.gridwidth = 2;
		gbc_imageLabel.insets = new Insets(10, 0, 5, 0);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		// Set text and font on 'movieLabel' and add it to the panel
		movieLabel = new JLabel("Movie");
		movieLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_movieLabel = new GridBagConstraints();
		gbc_movieLabel.insets = new Insets(20, 10, 5, 5);
		gbc_movieLabel.gridx = 0;
		gbc_movieLabel.gridy = 4;
		contentPane.add(movieLabel, gbc_movieLabel);
		
		// Set text and font on 'movieTitleLabel' and add it to the panel
		movieTitleLabel = new JLabel(user.getMovieInfo().getTitle());
		movieTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_movieTitleLabel = new GridBagConstraints();
		gbc_movieTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_movieTitleLabel.insets = new Insets(20, 0, 5, 10);
		gbc_movieTitleLabel.gridx = 1;
		gbc_movieTitleLabel.gridy = 4;
		contentPane.add(movieTitleLabel, gbc_movieTitleLabel);
		
		// Set text and font on 'dateLabel' and add it to the panel
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.insets = new Insets(5, 10, 5, 5);
		gbc_dateLabel.gridx = 0;
		gbc_dateLabel.gridy = 5;
		contentPane.add(dateLabel, gbc_dateLabel);
		
		// Set text and font on 'dateInfoLabel' and add it to the panel
		dateInfoLabel = new JLabel(user.getMovieInfo().getDate());
		dateInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_dateInfoLabel = new GridBagConstraints();
		gbc_dateInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_dateInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_dateInfoLabel.gridx = 1;
		gbc_dateInfoLabel.gridy = 5;
		contentPane.add(dateInfoLabel, gbc_dateInfoLabel);
		
		// Set text and font on 'timeLabel' and add it to the panel
		timeLabel = new JLabel("Time");
		timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_timeLabel = new GridBagConstraints();
		gbc_timeLabel.insets = new Insets(5, 10, 5, 5);
		gbc_timeLabel.gridx = 0;
		gbc_timeLabel.gridy = 6;
		contentPane.add(timeLabel, gbc_timeLabel);
		
		// Set text and font on 'timeInfoLabel' and add it to the panel
		timeInfoLabel = new JLabel(user.getMovieInfo().getTime());
		timeInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_timeInfoLabel = new GridBagConstraints();
		gbc_timeInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_timeInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_timeInfoLabel.gridx = 1;
		gbc_timeInfoLabel.gridy = 6;
		contentPane.add(timeInfoLabel, gbc_timeInfoLabel);
		
		// Set text and font on 'numberLabel' and add it to the panel
		numberLabel = new JLabel("Number");
		numberLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_numberLabel = new GridBagConstraints();
		gbc_numberLabel.insets = new Insets(5, 10, 5, 5);
		gbc_numberLabel.gridx = 0;
		gbc_numberLabel.gridy = 7;
		contentPane.add(numberLabel, gbc_numberLabel);
		
		// Set text and font on 'numberInfoLabel' and add it to the panel
		numberInfoLabel = new JLabel(user.getMovieInfo().getNumber() + " People");
		numberInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_numberInfoLabel = new GridBagConstraints();
		gbc_numberInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_numberInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_numberInfoLabel.gridx = 1;
		gbc_numberInfoLabel.gridy = 7;
		contentPane.add(numberInfoLabel, gbc_numberInfoLabel);
		
		// Set text and font on 'seatLabel' and add it to the panel
		seatLabel = new JLabel("Seat");
		seatLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_seatLabel = new GridBagConstraints();
		gbc_seatLabel.insets = new Insets(5, 10, 5, 5);
		gbc_seatLabel.gridx = 0;
		gbc_seatLabel.gridy = 8;
		contentPane.add(seatLabel, gbc_seatLabel);
		
		// Set text and font on 'seatInfoLabel' and add it to the panel
		seatInfoLabel = new JLabel(seatList.toString());
		seatInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_seatInfoLabel = new GridBagConstraints();
		gbc_seatInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_seatInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_seatInfoLabel.gridx = 1;
		gbc_seatInfoLabel.gridy = 8;
		contentPane.add(seatInfoLabel, gbc_seatInfoLabel);
		
		// Set text and font on 'paymentLabel' and add it to the panel
		paymentLabel = new JLabel("Payment");
		paymentLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_paymentLabel = new GridBagConstraints();
		gbc_paymentLabel.insets = new Insets(5, 10, 5, 5);
		gbc_paymentLabel.gridx = 0;
		gbc_paymentLabel.gridy = 9;
		contentPane.add(paymentLabel, gbc_paymentLabel);
		
		// Set text and font on 'paymentInfoLabel' and add it to the panel
		paymentInfoLabel = new JLabel(payment + " won");
		paymentInfoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_paymentInfoLabel = new GridBagConstraints();
		gbc_paymentInfoLabel.anchor = GridBagConstraints.EAST;
		gbc_paymentInfoLabel.insets = new Insets(5, 0, 5, 10);
		gbc_paymentInfoLabel.gridx = 1;
		gbc_paymentInfoLabel.gridy = 9;
		contentPane.add(paymentInfoLabel, gbc_paymentInfoLabel);
		
		// Set text and font on 'informLabel_1' and add it to the panel
		informLabel_1 = new JLabel("Thank you, " + user.getUserName() + "!");
		informLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_informLabel_1 = new GridBagConstraints();
		gbc_informLabel_1.gridwidth = 2;
		gbc_informLabel_1.insets = new Insets(20, 0, 5, 0);
		gbc_informLabel_1.gridx = 0;
		gbc_informLabel_1.gridy = 11;
		contentPane.add(informLabel_1, gbc_informLabel_1);
		
		// Set text and font on 'informLabel_2' and add it to the panel
		informLabel_2 = new JLabel("Mobile ticket has been sent to your cell phone.");
		informLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_informLabel_2 = new GridBagConstraints();
		gbc_informLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_informLabel_2.gridwidth = 2;
		gbc_informLabel_2.gridx = 0;
		gbc_informLabel_2.gridy = 12;
		contentPane.add(informLabel_2, gbc_informLabel_2);
		
		// Set text and font on 'informLabel_3' and add it to the panel
		informLabel_3 = new JLabel("Please show it when you enter the movie theater.");
		informLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_informLabel_3 = new GridBagConstraints();
		gbc_informLabel_3.gridwidth = 2;
		gbc_informLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_informLabel_3.gridx = 0;
		gbc_informLabel_3.gridy = 13;
		contentPane.add(informLabel_3, gbc_informLabel_3);
		
		// Set text and font on 'completeButton' and add it to the panel
		completeButton = new JButton("Complete");
		completeButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_completeButton = new GridBagConstraints();
		gbc_completeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_completeButton.gridwidth = 2;
		gbc_completeButton.insets = new Insets(5, 10, 0, 10);
		gbc_completeButton.gridx = 0;
		gbc_completeButton.gridy = 14;
		contentPane.add(completeButton, gbc_completeButton);
		
		// 'completeButton' events handling by ActionListener
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();  // After user presses the 'backButton', program switches from the reservation check page to login page
                setVisible(false);  // Close the reservation check page
			}
		});
	}
}