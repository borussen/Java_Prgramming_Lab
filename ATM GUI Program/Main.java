import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class name is Main. This is source code for the project.
 * It implements 'ATM' program using GUI.
 * 
 * @version JavaSE-16 25 October 2021
 * @author KIM HOJIN (2016314786)
 */
public class Main {
	
	private static int state = 0;  // Class variable for control the program state
	private static int type = 0;  // Class variable used to distinguish the same program state
	private static int language = 0;  // Class variable for control the program language; 0 means English, and 1 means Korean
	private static int user = 0;  // Class variable for storing user index in ArrayList 'bankAccounts'
	private static int receiver = 0;  // Class variable for storing receiver index in ArrayList 'bankAccounts'
	private static double withdrawal = 0;  // Class variable for storing withdrawal amount
	private static double deposit = 0;  // Class variable for storing deposit amount 
	private static double transfer = 0;  // Class variable for storing transfer amount

	public static void main(String[] args) {
		ArrayList<BankAccount> bankAccounts = new ArrayList<>();  // ArrayList for listing objects of bank accounts
		
		// Instantiate User object
		User user1 = new User("Firuz"); 
		User user2 = new User("John");
		User user3 = new User("Eldor");
		
		// Instantiate BankAccount object and initialize ArrayList bankAccounts
		bankAccounts.add(new BankAccount("200100237898", 1234, 500000.0, user1));
		bankAccounts.add(new BankAccount("110000022033", 4321, 700000.0, user2));
		bankAccounts.add(new BankAccount("111111111111", 2222, 900000.0, user3));
		
		// Create and set frame
		JFrame frame = new JFrame();
		frame.setSize(550, 550);
		frame.setTitle("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		// Set frame layout
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        frame.setLayout(grid);
        
		// Create button, label, scroll pane and text area components 
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();
		JButton button7 = new JButton();
		JButton button8 = new JButton();
		JButton button9 = new JButton();
		JButton button0 = new JButton();
		JButton option1 = new JButton();
		JButton option2 = new JButton();
		JButton option3 = new JButton();
		JButton option4 = new JButton();
		JButton english = new JButton();
		JButton korean = new JButton();
		JButton cancel = new JButton();
		JButton clear = new JButton();
		JButton enter = new JButton();
		JLabel woori = new JLabel();
        JLabel atm = new JLabel();
		JScrollPane scrollPane = new JScrollPane();
        JTextArea textbox = new JTextArea();
       
        // Set image on 'button1' and add it to frame
        button1.setIcon(new ImageIcon(Main.class.getResource("1.png")));
		gbc.gridx = 1;
        gbc.gridy = 6;
        grid.setConstraints(button1, gbc);
        frame.add(button1);
        
        // Set image on 'button2' and add it to frame
        button2.setIcon(new ImageIcon(Main.class.getResource("2.png"))); 
        gbc.gridx = 2;
        gbc.gridy = 6;
        grid.setConstraints(button2, gbc);
        frame.add(button2);
        
        // Set image on 'button3' and add it to frame
        button3.setIcon(new ImageIcon(Main.class.getResource("3.png"))); 
        gbc.gridx = 3;
        gbc.gridy = 6;
        grid.setConstraints(button3, gbc);
        frame.add(button3);
        
        // Set image on 'button4' and add it to frame
        button4.setIcon(new ImageIcon(Main.class.getResource("4.png"))); 
        gbc.gridx = 1;
        gbc.gridy = 7;
        grid.setConstraints(button4, gbc);
        frame.add(button4);
        
        // Set image on 'button5' and add it to frame
        button5.setIcon(new ImageIcon(Main.class.getResource("5.png"))); 
        gbc.gridx = 2;
        gbc.gridy = 7;
        grid.setConstraints(button5, gbc);
        frame.add(button5);
        
        // Set image on 'button6' and add it to frame
        button6.setIcon(new ImageIcon(Main.class.getResource("6.png"))); 
        gbc.gridx = 3;
        gbc.gridy = 7;
        grid.setConstraints(button6, gbc);
        frame.add(button6);
        
        // Set image on 'button7' and add it to frame
        button7.setIcon(new ImageIcon(Main.class.getResource("7.png"))); 
        gbc.gridx = 1;
        gbc.gridy = 8;
        grid.setConstraints(button7, gbc);
        frame.add(button7);
        
        // Set image on 'button8' and add it to frame
        button8.setIcon(new ImageIcon(Main.class.getResource("8.png"))); 
        gbc.gridx = 2;
        gbc.gridy = 8;
        grid.setConstraints(button8, gbc);
        frame.add(button8);
        
        // Set image on 'button9' and add it to frame
        button9.setIcon(new ImageIcon(Main.class.getResource("9.png"))); 
        gbc.gridx = 3;
        gbc.gridy = 8;
        grid.setConstraints(button9, gbc);
        frame.add(button9);
        
        // Set image on 'button0' and add it to frame
        button0.setIcon(new ImageIcon(Main.class.getResource("0.png"))); 
        gbc.gridx = 2;
        gbc.gridy = 9;
        grid.setConstraints(button0, gbc);
        frame.add(button0);
        	
        // Set image and text on 'option1' and add it to frame
        option1.setIcon(new ImageIcon(Main.class.getResource("arr.png")));
        option1.setText("OPTION 1");
        gbc.gridx = 0;
        gbc.gridy = 2;
        grid.setConstraints(option1, gbc);
        frame.add(option1);
        
        // Set image and text on 'option2' and add it to frame
        option2.setIcon(new ImageIcon(Main.class.getResource("arr.png")));
        option2.setText("OPTION 2");
        gbc.gridx = 0;
        gbc.gridy = 3;
        grid.setConstraints(option2, gbc);
        frame.add(option2);
        
        // Set image and text on 'option3' and add it to frame
        option3.setIcon(new ImageIcon(Main.class.getResource("arr.png")));
        option3.setText("OPTION 3");
        gbc.gridx = 0;
        gbc.gridy = 4;
        grid.setConstraints(option3, gbc);
        frame.add(option3);
        
        // Set image and text on 'option4' and add it to frame
        option4.setIcon(new ImageIcon(Main.class.getResource("arr.png")));
        option4.setText("OPTION 4");
        gbc.gridx = 0;
        gbc.gridy = 5;
        grid.setConstraints(option4, gbc);
        frame.add(option4);
        
        // Set image and text on 'english' and add it to frame
        english.setIcon(new ImageIcon(Main.class.getResource("eng.png")));
        english.setText("ENGLISH");
        gbc.gridx = 4;
        gbc.gridy = 2;
        grid.setConstraints(english, gbc);
        frame.add(english); 
        
        // Set image and text on 'korean' and add it to frame
        korean.setIcon(new ImageIcon(Main.class.getResource("kor.png")));
        korean.setText("KOREAN");
        gbc.gridx = 4;
        gbc.gridy = 3;
        grid.setConstraints(korean, gbc);
        frame.add(korean);

        // Set image and text on 'cancel' and add it to frame
        cancel.setIcon(new ImageIcon(Main.class.getResource("cancel.png")));
        cancel.setText("CANCEL");
        gbc.gridx = 4;
        gbc.gridy = 6;
        grid.setConstraints(cancel, gbc);
        frame.add(cancel);
        
        // Set image and text on 'clear' and add it to frame
        clear.setIcon(new ImageIcon(Main.class.getResource("clear.png")));
        clear.setText("CLEAR");
        gbc.gridx = 4;
        gbc.gridy = 7;
        grid.setConstraints(clear, gbc);
        frame.add(clear);
        
        // Set image and text on 'enter' and add it to frame
        enter.setIcon(new ImageIcon(Main.class.getResource("enter.png")));
        enter.setText("ENTER");
        gbc.gridx = 4;
        gbc.gridy = 8;
        grid.setConstraints(enter, gbc);
        frame.add(enter);
        
        // Set image on 'woori' and add it to frame
        woori.setIcon(new ImageIcon(Main.class.getResource("woori.png")));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        grid.setConstraints(woori, gbc);
        frame.getContentPane().add(woori);
        
        // Set text on 'atm' and add it to frame
        atm.setText("SKKU ATM");
        gbc.gridx = 2;
        gbc.gridy = 1;
        grid.setConstraints(atm, gbc);
        frame.getContentPane().add(atm);
        
        // Set 'textbox' and 'scrollPane' and add it to frame 
        textbox.setColumns(20);
        textbox.setRows(5);
        textbox.setEditable(false);
        scrollPane.setViewportView(textbox);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        grid.setConstraints(scrollPane, gbc);
        frame.add(scrollPane);
       
        // When 'button1' is clicked, input '1' in the text box
        button1.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
        		// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "1";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button2' is clicked, input '2' in the text box
        button2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "2";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button3' is clicked, input '3' in the text box
        button3.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "3";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button4' is clicked, input '4' in the text box
        button4.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "4";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button5' is clicked, input '5' in the text box
        button5.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "5";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button6' is clicked, input '6' in the text box
        button6.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "6";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button7' is clicked, input '7' in the text box
        button7.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "7";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button8' is clicked, input '8' in the text box
        button8.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "8";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button9' is clicked, input '9' in the text box
        button9.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Only allow number to be entered when the program is in the following states
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "9";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'button0' is clicked, input '0' in the text box
        button0.addActionListener(new ActionListener () {
        	// Only allow number to be entered when the program is in the following states
			public void actionPerformed(ActionEvent e) {
				if ((state == 2) || (state == 5) || (state == 6) || (state == 7) || (state == 8)) {
					String temp = textbox.getText();
					String text = "0";
					String newtext = temp + text;
					textbox.setText(newtext);
				}
			}
		});
        
        // When 'option1' is clicked on the option selection stage, the program displays the name and balance of the user
        option1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state == 3) {
					// Output the execution result in English
					if (language == 0) {
						textbox.setText("User: " +  bankAccounts.get(user).getBankUser().getName() + "\n" 
	    						+ "Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n" 
	    						+ "Press ENTER...");
					}
					// Output the execution result in Korean
					else {
						textbox.setText("사용자: " +  bankAccounts.get(user).getBankUser().getName() + "\n" 
	    						+ "잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n" 
	    						+ "엔터를 눌러주세요...");
					}
					state = 4;  // Set 'state' to move on to the next stage 
					type = 0;  // Set 'type' to distinguish the same 'state'
				}
			}
		});
        
        // When 'option2' is clicked on the option selection stage, the program asks the amount of money that user want to withdraw
        option2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state == 3) {
					if (language == 0) {
						textbox.setText("Enter Withdrawal amount: ");
					}
					else {
						textbox.setText("출금 금액을 입력하세요: ");
					}
					state = 5;  // Set 'state' to move on to the next stage 
				}
			}
		});
        
        // When 'option3' is clicked on the option selection stage, the program asks the amount of money that user want to deposit
        option3.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state == 3) {
					if (language == 0) {
						textbox.setText("Enter Deposit amount: ");
					}
					else {
						textbox.setText("입금 금액을 입력하세요: ");
					}
					state = 6;  // Set 'state' to move on to the next stage 
				}
			}
		});
        
        // When 'option4' is clicked on the option selection stage, the program asks to enter the reciever's account number
        option4.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state == 3) {
					if (language == 0) {
						textbox.setText("Enter Account Number (Receiver): ");
					}
					else {
						textbox.setText("계좌 번호를 입력하세요 (수신자): ");
					}
					state = 7;  // Set 'state' to move on to the next stage 
				}
			}
		});
        
        // When 'english' is clicked while program language is set in Korean, the text box content immediately changes to English in consideration of 'state' and 'type' and the program language is set to English
        english.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (language == 1) {
					language = 0;  // Change the program language to English
					
					// Change the content displayed in the text box into English in consideration of the 'state' and 'type' and print it out
					if (state == 1) {
						if (type == 1) {
							textbox.setText("Process is canceled by user! Please press Enter...");
						}
						else if (type == 2) {
							textbox.setText("Thank you for banking with us!\n" + "press ENTER...");
						}
						else {
							textbox.setText("Please, insert your card and press ENTER...");
						}
					}
					else if (state == 2) {
						if (type == 1) {
							textbox.setText("Wrong pin! Try Again.\n" + "PIN: ");
						}
						else {
							textbox.setText("PIN: ");
						}
					}
					else if (state == 3) {
						textbox.setText("Welcome " + bankAccounts.get(user).getBankUser().getName() + "\n" 
    							+ "Please choose options:\n" 
    							+ "OPTION 1: Balance Checking\n"
    							+ "OPTION 2: Withdrawing money\n"
    							+ "OPTION 3: Deposit\n"
    							+ "OPTION 4: Transfer");
					}
					else if (state == 4) {
						if (type == 1) {
							textbox.setText("Not enough money!\n" + "press ENTER...");
						}
						else if (type == 2) {
							textbox.setText("Success:)\n" 
	        						+ "User: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
	        						+ "Withdrawal Amount: " + String.format("%.2f", withdrawal) + "\n"
	        						+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
	        						+ "Press Enter...");
						}
						else if (type == 3) {
							textbox.setText("Success:)\n" 
	        						+ "User: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
	        						+ "Deposit Amount: " + String.format("%.2f", deposit) + "\n"
	        						+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
	        						+ "Press Enter...");
						}
						else if (type == 4) {
							textbox.setText("You entered the wrong account number!\n" + "Press Enter...");
						}
						else if (type == 5) {
							textbox.setText("Not enough money!\n" + "press ENTER...");
						}
						else if (type == 6) {
							textbox.setText("Transfer Amount: " + String.format("%.2f", transfer) + "\n"
            						+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
            						+ "Press ENTER..");
						}
						else {
							textbox.setText("User: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
		    						+ "Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n" 
		    						+ "Press ENTER...");
						}
					}
					else if (state == 5) {
						textbox.setText("Enter Withdrawal amount: ");
					}
					else if (state == 6) {
						textbox.setText("Enter Deposit amount: ");
					}
					else if (state == 7) {
						textbox.setText("Enter Account Number (Receiver): ");
					}
					else if (state == 8) {
						textbox.setText("Transfer Account: " + bankAccounts.get(receiver).getBankUser().getName() +"\n"
	    						+ "Enter Transfer Amount: ");
					}
				}
			}
		});
        
        // When 'korean' is clicked while program language is set in English, the text box content immediately changes to Korean in consideration of 'state' and 'type' and the program language is set to Korean
        korean.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (language == 0) {
					language = 1;  // Change the program language to Korean
					
					// Change the content displayed in the text box into Korean in consideration of the 'state' and 'type' and print it out
					if (state == 1) {
						if (type == 1) {
							textbox.setText("사용자에 의해 진행이 취소되었습니다! 엔터를 눌러주세요...");
						}
						else if (type == 2) {
							textbox.setText("저희 은행을 이용해주셔서 감사합니다!\n" + "엔터를 눌러주세요...");
						}
						else {
							textbox.setText("카드를 넣은 뒤 엔터를 눌러주세요...");
						}
					}	
					else if (state == 2) {
						if (type == 1) {
							textbox.setText("잘못된 핀 번호입니다! 다시 시도해주세요.\n" + "핀 번호: ");
						}
						else {
							textbox.setText("핀 번호: ");
						}
					}
					else if (state == 3) {
						textbox.setText("어서오세요, " + bankAccounts.get(user).getBankUser().getName() + "\n" 
    							+ "옵션을 선택해주세요.\n" 
    							+ "OPTION 1: 잔액 확인\n"
    							+ "OPTION 2: 예금 인출\n"
    							+ "OPTION 3: 입금\n"
    							+ "OPTION 4: 송금");
					}
					else if (state == 4) {
						if (type == 1) {
							textbox.setText("금액이 부족합니다!\n" + "엔터를 눌러주세요...");
						}
						else if (type == 2) {
							textbox.setText("성공했습니다:)\n" 
        							+ "사용자: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
        							+ "출금액: " + String.format("%.2f", withdrawal) + "\n"
        							+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
        							+ "엔터를 눌러주세요...");
						}
						else if (type == 3) {
							textbox.setText("성공했습니다:)\n" 
	        						+ "사용자: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
	        						+ "입금액: " + String.format("%.2f", deposit) + "\n"
	        						+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
	        						+ "엔터를 눌러주세요...");
						}
						else if (type == 4) {
							textbox.setText("잘못된 계좌 번호를 입력하였습니다!\n" + "엔터를 눌러주세요...");
						}
						else if (type == 5) {
							textbox.setText("금액이 부족합니다!\n" + "엔터를 눌러주세요...");
						}
						else if (type == 6) {
							textbox.setText(("이체 금액: " + String.format("%.2f", transfer) + "\n"
            						+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n"
            						+ "엔터를 눌러주세요..."));
						}
						else {
							textbox.setText("사용자: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
		    						+ "잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance()) + "\n" 
		    						+ "엔터를 눌러주세요...");
						}
					}
					else if (state == 5) {
						textbox.setText("출금 금액을 입력하세요: ");
					}
					else if (state == 6) {
						textbox.setText("입금 금액을 입력하세요: ");
					}
					else if (state == 7) {
						textbox.setText("계좌 번호를 입력하세요 (수신자): ");
					}
					else if (state == 8) {
						textbox.setText("이체하시려는 계좌주: " + bankAccounts.get(receiver).getBankUser().getName() +"\n"
	    						+ "송금하실 금액을 입력하세요: ");
					}
				}
			}
		});
         
        // When 'cancel' is clicked, the program cancel the operation at any time
        cancel.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state != 1) {
					if (language == 0) {
						textbox.setText("Process is canceled by user! Please press Enter...");
					}
					else {
						textbox.setText("사용자에 의해 진행이 취소되었습니다! 엔터를 눌러주세요...");
					}
					state = 1;  // Set 'state' to return to the stage where the PIN number is input
					type = 1;  // Set 'type' to distinguish the same 'state'
				}
			}
		});
        
        // When 'clear' is clicked, the program erases the numbers entered by the user
        clear.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (state == 2) {
					if (type == 1) {
						if (language == 0) {
    						textbox.setText("Wrong pin! Try Again.\n" + "PIN: ");
    					}
    					else {
    						textbox.setText("잘못된 핀 번호입니다! 다시 시도해주세요.\n" + "핀 번호: ");
    					}
					}
					else {
						if (language == 0) {
							textbox.setText("PIN: ");
						}
						else {
							textbox.setText("핀 번호: ");
						}
					}
				}
				else if (state == 5) {
					if (language == 0) {
						textbox.setText("Enter Withdrawal amount: ");
					}
					else {
						textbox.setText("출금 금액을 입력하세요: ");
					}
				}
				else if (state == 6) {
					if (language == 0) {
						textbox.setText("Enter Deposit amount: ");
					}
					else {
						textbox.setText("입금 금액을 입력하세요: ");
					}
				}
				else if (state == 7) {
					if (language == 0) {
						textbox.setText("Enter Account Number (Reciever): ");
					}
					else {
						textbox.setText("계좌 번호를 입력하세요 (수신자): ");
					}
				}
				else if (state == 8) {
					if (language == 0) {
						textbox.setText("Transfer Account: " + bankAccounts.get(receiver).getBankUser().getName() +"\n"
	    						+ "Enter Transfer Amount: ");
					}
					else {
						textbox.setText("이체하시려는 계좌주: " + bankAccounts.get(receiver).getBankUser().getName() +"\n"
	    						+ "송금하실 금액을 입력하세요: ");
					}
				}
			}
		});
        
        // When 'enter' is clicked, the program displays the appropriate content in the text box considering the 'state'
        enter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (state == 1) {
        			// The program asks the user to enter the PIN number
        			if (language == 0) {
						textbox.setText("PIN: ");
					}
					else {
						textbox.setText("핀 번호: ");
					}
        			state = 2;  // Set 'state' to move on to the next stage  
        			type = 0;  // Set 'type' to distinguish the same 'state'
        		}
        		
        		// The stage after the user enter the PIN number
        		else if (state == 2) {
        			String text = textbox.getText();
        			int pin = Integer.parseInt(text.replaceAll("[^0-9]", ""));    			
        			
        			for(int i = 0; i < 3; i++) {
        				// When the user enters the correct PIN number, the program displays the user's name and the following menu
        				if (pin == bankAccounts.get(i).getPinCode()) {
        					if (language == 0) {
        						textbox.setText("Welcome " + bankAccounts.get(i).getBankUser().getName() + "\n" 
            							+ "Please choose options:\n" 
            							+ "OPTION 1: Balance Checking\n"
            							+ "OPTION 2: Withdrawing money\n"
            							+ "OPTION 3: Deposit\n"
            							+ "OPTION 4: Transfer");
        					}
        					else {
        						textbox.setText("어서오세요, " + bankAccounts.get(i).getBankUser().getName() + "\n" 
            							+ "옵션을 선택해주세요.\n" 
            							+ "OPTION 1: 잔액 확인\n"
            							+ "OPTION 2: 예금 인출\n"
            							+ "OPTION 3: 입금\n"
            							+ "OPTION 4: 송금");
        					}
        					state = 3;  // Set 'state' to move on to the next stage  
        					user = i;  // Storing user index in ArrayList 'bankAccounts'
        					break;
        				}
        				
        				// When the user enters the wrong PIN number, the program prints following message and asks the user to enter the PIN number again
        				if (i == 2) {
        					if (language == 0) {
        						textbox.setText("Wrong pin! Try Again.\n" + "PIN: ");
        					}
        					else {
        						textbox.setText("잘못된 핀 번호입니다! 다시 시도해주세요.\n" + "핀 번호: ");
        					}
        					type = 1;  // Set 'type' to distinguish the same 'state'
        				}
        			}
        		}
        		
        		// The stage after executing the option
        		else if (state == 4) {
        			// The program prints the following message
        			if (language == 0) {
        				textbox.setText("Thank you for banking with us!\n" + "press ENTER...");
					}
					else {
						textbox.setText("저희 은행을 이용해주셔서 감사합니다!\n" + "엔터를 눌러주세요...");
					}
        			state = 1;  // Set 'state' to return to the stage where the PIN number is input
        			type = 2;  // Set 'type' to distinguish the same 'state'
        		}
        		
        		// The stage after the user enter the withdrawing money
        		else if (state == 5) {
        			String text = textbox.getText();
        			withdrawal = Double.parseDouble(text.replaceAll("[^0-9]", ""));
        			
        			// When the amount of withdrawal exceeds user balance, the program prints following message
        			if (withdrawal > bankAccounts.get(user).getBalance()) {
        				if (language == 0) {
        					textbox.setText("Not enough money!\n" + "press ENTER...");
        				}
        				else {
        					textbox.setText("금액이 부족합니다!\n" + "엔터를 눌러주세요...");
        				}
        				state = 4;  // Set 'state' to move on to the option execution completion stage
        				type = 1;  // Set 'type' to distinguish the same 'state'
        			}
        			// When the amount of withdrawal does not exceed user balance, the program processes user request successfully and shows the following message
        			else {
        				if (language == 0) {
        					textbox.setText("Success:)\n" 
        							+ "User: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
        							+ "Withdrawal Amount: " + String.format("%.2f",withdrawal) + "\n"
        							+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance() - withdrawal) + "\n"
        							+ "Press Enter...");
        				}
        				else {
        					textbox.setText("성공했습니다:)\n" 
        							+ "사용자: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
        							+ "출금액: " + String.format("%.2f",withdrawal) + "\n"
        							+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance() - withdrawal) + "\n"
        							+ "엔터를 눌러주세요...");
        				}
        				bankAccounts.get(user).setBalance(bankAccounts.get(user).getBalance() - withdrawal);  // Set user's updated balance
        				state = 4;  // Set 'state' to move on to the option execution completion stage
        				type = 2;  // Set 'type' to distinguish the same 'state'
        			}
        		}
        		
        		// The stage after the user enter the deposit amount
        		else if (state == 6) {
        			String text = textbox.getText();
        			deposit = Double.parseDouble(text.replaceAll("[^0-9]", ""));
        			
        			if (language == 0) {
        				textbox.setText("Success:)\n" 
        						+ "User: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
        						+ "Deposit Amount: " + String.format("%.2f", deposit) + "\n"
        						+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance() + deposit) + "\n"
        						+ "Press Enter...");
        			}
        			else {
        				textbox.setText("성공했습니다:)\n" 
        						+ "사용자: " + bankAccounts.get(user).getBankUser().getName() + "\n" 
        						+ "입금액: " + String.format("%.2f", deposit) + "\n"
        						+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance() + deposit) + "\n"
        						+ "엔터를 눌러주세요...");
        			}
        			bankAccounts.get(user).setBalance(bankAccounts.get(user).getBalance() + deposit);  // Set user's updated balance
        			state = 4;  // Set 'state' to move on to the option execution completion stage
        			type = 3;  // Set 'type' to distinguish the same 'state'
        		}
        		
        		// The stage after the user enter the receiver's account number
        		else if (state == 7) {
        			String text = textbox.getText();
        			String account = text.substring(text.length()-12, text.length());
        			
        			for(int i = 0; i < 3; i++) {
        				// When the user enters the correct account number, the program shows the receiver's name and asks to enter the transferring amount of money
        				if (account.equals(bankAccounts.get(i).getBankNumber())) {
        					if (language == 0) {
        						textbox.setText("Transfer Account: " + bankAccounts.get(i).getBankUser().getName() +"\n"
                						+ "Enter Transfer Amount: ");
        					}
        					else {
        						textbox.setText("이체하시려는 계좌주: " + bankAccounts.get(i).getBankUser().getName() +"\n"
                						+ "송금하실 금액을 입력하세요: ");
        					}
            				receiver = i;  // Storing receiver index in ArrayList 'bankAccounts'
            				state = 8;  // Set 'state' to move on to the next stage
            				break;
        				}
        				// When the user enters the wrong account number, the program prints following message
        				if (i == 2) {
        					if (language == 0) {
        						textbox.setText("You entered the wrong account number!\n" + "Press Enter...");
        					}
        					else {
        						textbox.setText("잘못된 계좌 번호를 입력하였습니다!\n" + "엔터를 눌러주세요...");
        					}
        					state = 4;  // Set 'state' to move on to the option execution completion stage
        					type = 4;  // Set 'type' to distinguish the same 'state'
        				}
        			}	
        		}
        		
        		// The stage after the user enter the transferring amount of money
        		else if (state == 8) {
        			String text = textbox.getText();
        			transfer = Double.parseDouble(text.replaceAll("[^0-9]", ""));
        			
        			// If the user enters the amount that exceeds the user's balance, the program prints following message
        			if (transfer > bankAccounts.get(user).getBalance()) {
        				if (language == 0) {
        					textbox.setText("Not enough money!\n" + "press ENTER...");
        				}
        				else {
        					textbox.setText("금액이 부족합니다!\n" + "엔터를 눌러주세요...");
        				}
        				state = 4;  // Set 'state' to move on to the option execution completion stage
        				type = 5;  // Set 'type' to distinguish the same 'state'
        			}
        			// If the user enters the amount that does not exceed the user's balance, the transferring is done successfully and prints the following message
        			else {
        				if (language == 0) {
        					textbox.setText("Transfer Amount: " + String.format("%.2f", transfer) + "\n"
            						+ "Current Balance: " + String.format("%.2f", bankAccounts.get(user).getBalance() - transfer) + "\n"
            						+ "Press ENTER..");
        				}
        				else {
        					textbox.setText("이체 금액: " + String.format("%.2f", transfer) + "\n"
            						+ "현재 잔액: " + String.format("%.2f", bankAccounts.get(user).getBalance() - transfer) + "\n"
            						+ "엔터를 눌러주세요..");
        				}
        				bankAccounts.get(user).setBalance(bankAccounts.get(user).getBalance() - transfer);  // Set user's updated balance
        				bankAccounts.get(receiver).setBalance(bankAccounts.get(receiver).getBalance() + transfer);  // Set receiver's updated balance
        				state = 4;  // Set 'state' to move on to the option execution completion stage
            			type = 6;  // Set 'type' to distinguish the same 'state'
        			}
        		}
        	}
        });
        
        // Output the first screen of the program in the text box
        if (state == 0) {
        	if (language == 0) {
        		textbox.setText("Please, insert your card and press ENTER...");
        	}
        	else {
        		textbox.setText("카드를 넣은 뒤 엔터를 눌러주세요...");
        	}
        	state = 1;  // Set 'state' to move on to the next stage
        	type = 0;  // Set 'type' to distinguish the same 'state'
        }
        
        frame.setVisible(true);  // Display frame
	}	
}
