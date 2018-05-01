package com.benovskyi.bohdan;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;

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
		System.out.println("login: " + login);
		
		String password = uiLogin.edtPassword.text();
		System.out.println("password: " + password);
	}

}
