package com.benovskyi.bohdan;

import com.trolltech.qt.core.QObject;
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
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Client extends QMainWindow {

	public Ui_MainLogin uiLogin = new Ui_MainLogin();
	public Ui_MainForm uiForm = new Ui_MainForm();
	public InetAddress addr;
	public Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public static QAction[] gr;

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
		String group = "";

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

					String[] inst = institutes.split("\\s+");

					String[] groups = new String[inst.length];

					ArrayList allGroups = new ArrayList();

					if (in.readLine().equals("grp")) {
						for (int i = 0; i < groups.length; i++) {
							groups[i] = in.readLine();
						}
					}

					for (int i = 0; i < inst.length; i++) {
						allGroups.add(i);
						String[] tmp = groups[i].split("\\s+");
						for (int j = 0; j < tmp.length; j++)
							allGroups.add(tmp[j]);
					}

					QMenu instit = new QMenu("Інститути");
					QAction quit = new QAction("Вихід", this);

					QMenu[] insti = new QMenu[inst.length];

					for (int i = 0; i < inst.length; i++) {
						insti[i] = new QMenu(inst[i], this);
					}
					
					/*WORK!!!!!*/
					gr = new QAction[allGroups.size() - inst.length];
					boolean flag = false;
					boolean flg = false;
					int tmp = 0;
					for(int i = 0; i < inst.length; i++) {
						for(int j = 0; j < allGroups.size(); j++) {
							if(allGroups.get(j) instanceof Integer && flag == false) {
									allGroups.remove(j);
									flag = true;
									flg = true;
									tmp = j;
							}
							if(allGroups.get(j) instanceof Integer) {
								allGroups.remove(j);
								tmp = j;
								flg = true;
								break;
							}
							else {
								if(flg) {
									j = tmp;
									flg = false;
								}
								gr[j] = new QAction(allGroups.get(j).toString(), this);
								insti[i].addAction(gr[j]);
							}
						}
					}

					for (int l = 0; l < inst.length; l++) {
						instit.addMenu(insti[l]);
					}
					
					
					for(int i = 0; i < gr.length; i++) {
						gr[i].triggered.connect(this, "get_rating()");
					}
					

					uiForm.menuFile.addMenu(instit);
					uiForm.menuFile.addAction(quit);
					
					QAction au = new QAction("About author", this);
					QAction aqj = new QAction("About QtJambi", this);
					QAction aq = new QAction("About Qt", this);
					
					uiForm.menuAbout.addAction(au);
					uiForm.menuAbout.addAction(aqj);
					uiForm.menuAbout.addAction(aq);
					
					quit.triggered.connect(QApplication.instance(), "quit()");
					au.triggered.connect(this, "about_author()");
					aqj.triggered.connect(this, "about_programJambi()");
					aq.triggered.connect(this, "about_programQt()");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// out.println("END");
		}

	}
	
	public void about_author() {
		System.out.println("About Author implementation");
	}
	
	public void about_programJambi() {
		QApplication.aboutQtJambi();
	}
	
	public void about_programQt() {
		QApplication.aboutQt();
	}
	
	public void get_rating() {
		for(int i = 0; i < gr.length; i++) {
			if(gr[i] == QObject.signalSender()) {
				System.out.println("Slot group " + gr[i].text());
			}
		}
	}
}
