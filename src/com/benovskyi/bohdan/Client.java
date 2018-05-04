package com.benovskyi.bohdan;

import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QMenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client extends QMainWindow {

	public Ui_MainLogin uiLogin = new Ui_MainLogin();
	public Ui_MainForm uiForm = new Ui_MainForm();
	public InetAddress addr;
	public Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public Client() {
		uiLogin.setupUi(this);
		uiLogin.btnLogin.clicked.connect(this, "login()");
		try {
			addr = InetAddress.getByName(null); // 127.0.0.1
			socket = new Socket(addr, 9191);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e2) {
				System.err.println("Socket not closed");
			}
		}

		show();
	}

	public static void main(String[] args) {
		QApplication.initialize(args);

		Client client = new Client();

		QApplication.execStatic();
	}

	public void login() {
		String login = uiLogin.edtLogin.text();
		String password = uiLogin.edtPasswod.text();
		String institutes = "";

		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Some field are empty!\nPlease enter login or password!", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else {
			System.out.println("login: " + login);
			System.out.println("password: " + password);
			// out.println(login + " " + password);
			out.println("login");
			out.println(login);
			out.println(password);

			try {
				if (in.readLine().equals("OK")) {
					System.out.println("All is fine");
					hide();
					uiForm.setupUi(this);
					show();

					out.println("inst");
					if (in.readLine().equals("inst")) {
						institutes = in.readLine();
						System.out.println("Institutes: " + institutes);
					}

					//int hmi = countWordsUsingSplit(institutes);
					//System.out.println("HMI: " + hmi);
					String[] inst = institutes.split("\\s+");

					QMenu instit = new QMenu("Інститути");
					QAction quit = new QAction("Вихід", this);
					
					for(int i = 0; i < inst.length; i++) {
						instit.addMenu(new QMenu(inst[i], this));
						
					}

					uiForm.menuFile.addMenu(instit);
					uiForm.menuFile.addAction(quit);
					quit.triggered.connect(QApplication.instance(), "quit()");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// out.println("END");
		}
	}

	public static int countWordsUsingSplit(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] words = input.split("\\s+");
		return words.length;
	}

}
