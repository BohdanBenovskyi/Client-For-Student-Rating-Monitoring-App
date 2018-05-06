/********************************************************************************
 ** Form generated from reading ui file 'MainLoginV2.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.benovskyi.bohdan;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainLogin implements com.trolltech.qt.QUiForm<QMainWindow> {
	public QWidget centralwidget;
	public QGridLayout gridLayout;
	public QVBoxLayout verticalLayout_3;
	public QHBoxLayout horizontalLayout;
	public QVBoxLayout verticalLayout;
	public QLabel lblLogin;
	public QLabel lblPasswod;
	public QVBoxLayout verticalLayout_2;
	public QLineEdit edtLogin;
	public QLineEdit edtPasswod;
	public QHBoxLayout horizontalLayout_2;
	public QPushButton btnLogin;
	public QPushButton btnClose;

	public Ui_MainLogin() {
		super();
	}

	public void setupUi(QMainWindow MainLogin) {
		MainLogin.setObjectName("MainLogin");
		MainLogin.resize(new QSize(260, 101).expandedTo(MainLogin.minimumSizeHint()));
		MainLogin.setWindowIcon(
				new QIcon(new QPixmap("D:\\Projects\\ClientAppSRM\\resources\\220px-Polytechnic_Lwow_20091.bmp")));
		centralwidget = new QWidget(MainLogin);
		centralwidget.setObjectName("centralwidget");
		gridLayout = new QGridLayout(centralwidget);
		gridLayout.setObjectName("gridLayout");
		verticalLayout_3 = new QVBoxLayout();
		verticalLayout_3.setObjectName("verticalLayout_3");
		horizontalLayout = new QHBoxLayout();
		horizontalLayout.setObjectName("horizontalLayout");
		verticalLayout = new QVBoxLayout();
		verticalLayout.setObjectName("verticalLayout");
		lblLogin = new QLabel(centralwidget);
		lblLogin.setObjectName("lblLogin");

		verticalLayout.addWidget(lblLogin);

		lblPasswod = new QLabel(centralwidget);
		lblPasswod.setObjectName("lblPasswod");

		verticalLayout.addWidget(lblPasswod);

		horizontalLayout.addLayout(verticalLayout);

		verticalLayout_2 = new QVBoxLayout();
		verticalLayout_2.setObjectName("verticalLayout_2");
		edtLogin = new QLineEdit(centralwidget);
		edtLogin.setObjectName("edtLogin");

		verticalLayout_2.addWidget(edtLogin);

		edtPasswod = new QLineEdit(centralwidget);
		edtPasswod.setObjectName("edtPasswod");
		edtPasswod.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Password);

		verticalLayout_2.addWidget(edtPasswod);

		horizontalLayout.addLayout(verticalLayout_2);

		verticalLayout_3.addLayout(horizontalLayout);

		horizontalLayout_2 = new QHBoxLayout();
		horizontalLayout_2.setObjectName("horizontalLayout_2");
		btnLogin = new QPushButton(centralwidget);
		btnLogin.setObjectName("btnLogin");

		horizontalLayout_2.addWidget(btnLogin);

		btnClose = new QPushButton(centralwidget);
		btnClose.setObjectName("btnClose");

		horizontalLayout_2.addWidget(btnClose);

		verticalLayout_3.addLayout(horizontalLayout_2);

		gridLayout.addLayout(verticalLayout_3, 0, 0, 1, 1);

		MainLogin.setCentralWidget(centralwidget);
		retranslateUi(MainLogin);
		btnClose.clicked.connect(MainLogin, "close()");

		MainLogin.connectSlotsByName();
	} // setupUi

	void retranslateUi(QMainWindow MainLogin) {
		MainLogin.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login&Password", null));
		lblLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login", null));
		lblPasswod.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Password", null));
		btnLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login", null));
		btnClose.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Close", null));
	} // retranslateUi

}
