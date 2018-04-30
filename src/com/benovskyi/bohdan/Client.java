package com.benovskyi.bohdan;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;

public class Client extends QWidget{

	public Client() {
		show();
	}
	
	public static void main(String[] args) {
		QApplication.initialize(args);
		
		Client client = new Client();
		
		
		QApplication.execStatic();
	}

}
