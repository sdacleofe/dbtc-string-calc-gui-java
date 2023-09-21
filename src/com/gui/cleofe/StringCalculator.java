package com.gui.cleofe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StringCalculator extends JFrame implements ActionListener, KeyListener {
	private JPanel mainPanel, outputPanel, inputPanel;
	private JButton btnP, btnS, btnM, btnD, btnC, btnE;
	private JTextField currentInTxt, prevInTxt;
	private Color black00 = new Color(0, 0, 0);
	private Color grey73 = new Color(115, 115, 115);
	private Color whiteff = new Color(255, 255, 255);
	private Color orangeff = new Color(255, 145, 77);
	private Color greyd9 = new Color(217, 217, 217);
	private String[] strARR = new String[9];

	public StringCalculator(String title) {
		super(title);

		mainPanel = new JPanel();
		outputPanel = new JPanel();
		inputPanel = new JPanel();
		btnP = new JButton("+");
		btnS = new JButton("-");
		btnM = new JButton("*");
		btnD = new JButton("/");
		btnC = new JButton("C");
		btnE = new JButton("=");
		currentInTxt = new JTextField();
		prevInTxt = new JTextField();

		// background color
		mainPanel.setBackground(black00);
		outputPanel.setBackground(greyd9);
		inputPanel.setBackground(whiteff);
		btnP.setBackground(orangeff);
		btnS.setBackground(orangeff);
		btnM.setBackground(orangeff);
		btnD.setBackground(orangeff);
		btnC.setBackground(orangeff);
		btnE.setBackground(orangeff);
		currentInTxt.setBackground(greyd9);
		prevInTxt.setBackground(greyd9);

		// foreground color
		btnP.setForeground(whiteff);
		btnS.setForeground(whiteff);
		btnM.setForeground(whiteff);
		btnD.setForeground(whiteff);
		btnC.setForeground(whiteff);
		btnE.setForeground(whiteff);
		currentInTxt.setForeground(black00);
		prevInTxt.setForeground(grey73);

		// font style
		btnP.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		btnS.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		btnM.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		btnD.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		btnC.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		btnE.setFont(new Font("Open Sans Extrabold", Font.BOLD, 42));
		currentInTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 32));
		currentInTxt.setHorizontalAlignment(JTextField.RIGHT);
		currentInTxt.setBorder(null);
		prevInTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 22));
		prevInTxt.setHorizontalAlignment(JTextField.RIGHT);
		prevInTxt.setBorder(null);

		// pointer
		btnP.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnS.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnM.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnC.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnE.setCursor(new Cursor(Cursor.HAND_CURSOR));
		prevInTxt.setFocusable(false);

		mainPanel.setPreferredSize(new Dimension(390, 530));
		this.add(mainPanel, BorderLayout.CENTER);

		mainPanel.setLayout(null);
		outputPanel.setBounds(20, 20, 350, 120);
		inputPanel.setBounds(20, 160, 350, 350);

		inputPanel.setLayout(null);
		btnP.setBounds(20, 20, 90, 90);
		btnS.setBounds(130, 20, 90, 90);
		btnM.setBounds(20, 130, 90, 90);
		btnD.setBounds(130, 130, 90, 90);
		btnC.setBounds(240, 20, 90, 200);
		btnE.setBounds(20, 240, 310, 90);

		outputPanel.setLayout(null);
		currentInTxt.setBounds(20, 60, 310, 50);
		prevInTxt.setBounds(20, 10, 310, 60);

		mainPanel.add(outputPanel);
		mainPanel.add(inputPanel);
		inputPanel.add(btnP);
		inputPanel.add(btnS);
		inputPanel.add(btnM);
		inputPanel.add(btnD);
		inputPanel.add(btnC);
		inputPanel.add(btnE);
		outputPanel.add(currentInTxt);
		outputPanel.add(prevInTxt);

		btnP.addActionListener(this);
		btnS.addActionListener(this);
		btnM.addActionListener(this);
		btnD.addActionListener(this);
		btnE.addActionListener(this);
		btnC.addActionListener(this);
		currentInTxt.addKeyListener(this);
	}

	public static void main(String[] args) {
		StringCalculator frame = new StringCalculator("String Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton sourceBtnP = (JButton) e.getSource();
		JButton sourceBtnS = (JButton) e.getSource();
		JButton sourceBtnE = (JButton) e.getSource();
		JButton sourceBtnC = (JButton) e.getSource();

		if (sourceBtnP.getText().equals("+")) {
			strARR[0] = currentInTxt.getText().trim();
			strARR[2] = "+";
			dispPrevInput();
		}

		if (sourceBtnS.getText().equals("-")) {
			strARR[0] = currentInTxt.getText().trim();
			strARR[2] = "-";
			dispPrevInput();
		}

		if (sourceBtnS.getText().equals("*")) {
			strARR[0] = currentInTxt.getText().trim();
			strARR[2] = "*";
			dispPrevInput();
		}
		
		if (sourceBtnS.getText().equals("/")) {
			strARR[0] = currentInTxt.getText().trim();
			strARR[2] = "/";
			dispPrevInput();
		}

		if (sourceBtnE.getText().equals("=")) {
			if (prevInTxt.getText().contains("+")) {
				strARR[4] = currentInTxt.getText().trim();
				strARR[6] = "=";
				currentInTxt.setText(concatenate(strARR[0], strARR[4]));
			}

			if (prevInTxt.getText().contains("-")) {
				strARR[4] = currentInTxt.getText().trim();
				strARR[6] = "=";
				currentInTxt.setText(subtract(strARR[0], strARR[4]));
			}

			if (prevInTxt.getText().contains("*")) {
				strARR[4] = currentInTxt.getText().trim();
				strARR[6] = "=";
				currentInTxt.setText(multiply(strARR[0], strARR[4]));
			}
			
			if (prevInTxt.getText().contains("/")) {
				strARR[4] = currentInTxt.getText().trim();
				strARR[6] = "=";
				currentInTxt.setText(divide(strARR[0], strARR[4]));
			}
		}

		if (sourceBtnC.getText().equals("C")) {
			for (int i = 0; i < strARR.length; i++) {
				strARR[i] = "";
				prevInTxt.setText(strARR[i]);
				currentInTxt.setText("");
			}
		}
	}

	private String divide(String string, String string2) {
		String result = "";
		double firstParam = strARR[0].length();
		double secondParam = strARR[4].length();
		double total = Math.round(firstParam / secondParam);
		result = strARR[0].substring(0, (int) total);

		dispHistory();
		return result;
	}

	private String multiply(String inputStr1, String inputStr2) {
		String result = "";
		int secondParam = strARR[4].length();

		for (int i = 0; i < secondParam; i++) {
			result += strARR[0];
		}

		dispHistory();
		return result;
	}

	private String subtract(String inputStr1, String inputStr2) {
		String result = "";
		int len;
		if (strARR[0].length() > strARR[4].length()) {
			len = strARR[0].length() - strARR[4].length();
			result = strARR[0].substring(0, len);
		}

		if (strARR[0].length() == strARR[4].length()) {
			result = "";
		}

		if (strARR[0].length() < strARR[4].length()) {
			result = strARR[4].substring(0, strARR[0].length());
		}

		dispHistory();
		return result;
	}
	
	private String concatenate(String inputStr1, String inputStr2) {
		String result = inputStr1 + inputStr2;
		
		dispHistory();
		return result;
	}
	
	public void dispPrevInput() {
		int n = 2;
		for (int i = 1; i <= 7; i += n) {
			strARR[i] = " ";
		}
		for (int i = 0; i < 3; i++) {
			prevInTxt.setText(strARR[i]);
		}
		dispHistory();
	}
	
	private void dispHistory() {
		String joined = String.join("", strARR).replace("null", "");
		prevInTxt.setText(joined);
		currentInTxt.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField srcInTxt = (JTextField) e.getSource();
		int pos = srcInTxt.getCaretPosition();
		srcInTxt.setText(srcInTxt.getText().toUpperCase());
		srcInTxt.setCaretPosition(pos);
	}
}

