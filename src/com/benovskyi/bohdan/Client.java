package com.benovskyi.bohdan;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;

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

public class Client extends QWidget{

	public Ui_MainLogin uiLogin = new Ui_MainLogin();
	public InetAddress addr;
	public Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client() {
		uiLogin.setupUi(this);
		uiLogin.btnLogin.clicked.connect(this, "login()");
		try {
			addr = InetAddress.getByName(null);	 //127.0.0.1
			socket = new Socket(addr, 9191);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	      }
	      catch (IOException e) {
	         try {
	            socket.close();
	         }
	         catch (IOException e2) {
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
		String password = uiLogin.edtPassword.text();
		
		if(login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Some field are empty!\nPlease enter login or password!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else {
			System.out.println("login: " + login);
			System.out.println("password: " + password);
			//out.println(login + " " + password);
			out.println("login");
			out.println(login);
			out.println(password);
			out.println("END" );
		}
	}

}
