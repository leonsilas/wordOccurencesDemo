
package WordOccurences;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=130,21
	 */
	private final JLabel lblWordOccurences = new JLabel("Word Occurences");
	private JTextField textField;
	private JTextField textNumOccurences;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Creates wordMap
		WordOccurences testWord = new WordOccurences();
		Map<String,Integer> wordMap = testWord.createWordMap();

		// Prints out the number of times the word "more" appears in the text file
		System.out.println(testWord.numberWords(wordMap, "more"));

		// Runs the GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Word?:");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("# of Occurences:");
		contentPane.add(lblNewLabel_1);
		
		textNumOccurences = new JTextField();
		contentPane.add(textNumOccurences);
		textNumOccurences.setColumns(10);
		textNumOccurences.setText("0");
		
		JButton btnNewButton = new JButton("Compute");
		btnNewButton.setActionCommand("Compute");
		btnNewButton.addActionListener(new ComputeActionListener());
		contentPane.add(btnNewButton);
	}

	private class ComputeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Compute")) {
				String word = textField.getText();
				WordOccurences testWord = new WordOccurences();
				Map<String,Integer> wordMap = testWord.createWordMap();		
				int num = testWord.numberWords(wordMap, word);
				textNumOccurences.setText(Integer.toString(num));
			}
		}
	}	

}