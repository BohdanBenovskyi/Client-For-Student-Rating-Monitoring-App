package com.benovskyi.bohdan;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;
import javax.swing.JOptionPane;

public class Client extends QWidget{

	Ui_MainLogin uiLogin = new Ui_MainLogin();
	
	public Client() {
		uiLogin.setupUi(this);
		uiLogin.btnLogin.clicked.connect(this, "login()");
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
			System.out.println("Some field are empty! Please enter login or password!");
			JOptionPane.showMessageDialog(null, "Some field are empty!\nPlease enter login or password!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else {
			System.out.println("login: " + login);
			System.out.println("password: " + password);
		}
	}

}
