package docx.ifttt.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import docx.ifttt.webhooks.IFTTTWebhook;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField IFTTTKeyBox;
	private JTextField WebHookBox;
	private static JTextPane outputBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("IFTTT Webhooks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IFTTT-Webhooks");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 209, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblIftttMakerKey = new JLabel("IFTTT Key:");
		lblIftttMakerKey.setBounds(10, 61, 57, 14);
		contentPane.add(lblIftttMakerKey);
		
		IFTTTKeyBox = new JTextField();
		IFTTTKeyBox.setBounds(77, 58, 209, 20);
		contentPane.add(IFTTTKeyBox);
		IFTTTKeyBox.setColumns(10);
		
		JLabel lblWebhook = new JLabel("Webhook:");
		lblWebhook.setBounds(10, 86, 57, 14);
		contentPane.add(lblWebhook);
		
		WebHookBox = new JTextField();
		WebHookBox.setColumns(10);
		WebHookBox.setBounds(77, 83, 209, 20);
		contentPane.add(WebHookBox);
		
		JButton btnCall = new JButton("Call");
		btnCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IFTTTWebhook.callWebhook(WebHookBox.getText(), IFTTTKeyBox.getText());
				outputBox.setText(IFTTTWebhook.getWebhookOutput());
			}
		});
		btnCall.setBounds(197, 114, 89, 23);
		contentPane.add(btnCall);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 148, 282, 2);
		contentPane.add(separator);
		
		outputBox = new JTextPane();
		outputBox.setBounds(10, 187, 276, 318);
		contentPane.add(outputBox);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setBounds(10, 162, 46, 14);
		contentPane.add(lblOutput);
	}
}
