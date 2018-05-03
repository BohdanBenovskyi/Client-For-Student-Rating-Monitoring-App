/********************************************************************************
 ** Form generated from reading ui file 'MainForm.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.benovskyi.bohdan;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainForm implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QGridLayout gridLayout;
    public QTableWidget tableWidget;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuEdit;
    public QMenu menuAbout;
    public QMenu menuHelp;
    public QStatusBar statusbar;

    public Ui_MainForm() { super(); }

    public void setupUi(QMainWindow MainForm)
    {
        MainForm.setObjectName("MainForm");
        MainForm.resize(new QSize(388, 363).expandedTo(MainForm.minimumSizeHint()));
        MainForm.setWindowIcon(new QIcon(new QPixmap("../../../../resources/220px-Polytechnic_Lwow_20091.bmp")));
        centralwidget = new QWidget(MainForm);
        centralwidget.setObjectName("centralwidget");
        gridLayout = new QGridLayout(centralwidget);
        gridLayout.setObjectName("gridLayout");
        tableWidget = new QTableWidget(centralwidget);
        tableWidget.setObjectName("tableWidget");

        gridLayout.addWidget(tableWidget, 0, 0, 1, 1);

        MainForm.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainForm);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 388, 21));
        menuFile = new QMenu(menubar);
        menuFile.setObjectName("menuFile");
        menuEdit = new QMenu(menubar);
        menuEdit.setObjectName("menuEdit");
        menuAbout = new QMenu(menubar);
        menuAbout.setObjectName("menuAbout");
        menuHelp = new QMenu(menubar);
        menuHelp.setObjectName("menuHelp");
        MainForm.setMenuBar(menubar);
        statusbar = new QStatusBar(MainForm);
        statusbar.setObjectName("statusbar");
        MainForm.setStatusBar(statusbar);

        menubar.addAction(menuFile.menuAction());
        menubar.addAction(menuEdit.menuAction());
        menubar.addAction(menuAbout.menuAction());
        menubar.addAction(menuHelp.menuAction());
        retranslateUi(MainForm);

        MainForm.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainForm)
    {
        MainForm.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainForm", "\u0421\u0438\u0441\u0442\u0435\u043c\u0430 \u043c\u043e\u043d\u0456\u0442\u043e\u0440\u0438\u043d\u0433\u0443 \u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0443 \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u0456\u0432", null));
        tableWidget.clear();
        tableWidget.setColumnCount(0);
        tableWidget.setRowCount(0);
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainForm", "File", null));
        menuEdit.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainForm", "Edit", null));
        menuAbout.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainForm", "About", null));
        menuHelp.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainForm", "Help", null));
    } // retranslateUi

}

