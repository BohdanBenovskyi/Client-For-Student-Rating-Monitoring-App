import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainLogin implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QVBoxLayout verticalLayout_3;
    public QHBoxLayout horizontalLayout_2;
    public QVBoxLayout verticalLayout;
    public QLabel lblLogin;
    public QLabel lblPassword;
    public QVBoxLayout verticalLayout_2;
    public QLineEdit edtLogin;
    public QLineEdit edtPassword;
    public QHBoxLayout horizontalLayout;
    public QPushButton btnLogin;
    public QPushButton btnExit;

    public Ui_MainLogin() { super(); }

    public void setupUi(QWidget MainLogin)
    {
        MainLogin.setObjectName("MainLogin");
        MainLogin.resize(new QSize(275, 105).expandedTo(MainLogin.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainLogin.sizePolicy().hasHeightForWidth());
        MainLogin.setSizePolicy(sizePolicy);
        MainLogin.setWindowIcon(new QIcon(new QPixmap("../../../../resources/220px-Polytechnic_Lwow_20091.bmp")));
        gridLayout = new QGridLayout(MainLogin);
        gridLayout.setObjectName("gridLayout");
        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3.setObjectName("verticalLayout_3");
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        lblLogin = new QLabel(MainLogin);
        lblLogin.setObjectName("lblLogin");

        verticalLayout.addWidget(lblLogin);

        lblPassword = new QLabel(MainLogin);
        lblPassword.setObjectName("lblPassword");

        verticalLayout.addWidget(lblPassword);


        horizontalLayout_2.addLayout(verticalLayout);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        edtLogin = new QLineEdit(MainLogin);
        edtLogin.setObjectName("edtLogin");

        verticalLayout_2.addWidget(edtLogin);

        edtPassword = new QLineEdit(MainLogin);
        edtPassword.setObjectName("edtPassword");

        verticalLayout_2.addWidget(edtPassword);


        horizontalLayout_2.addLayout(verticalLayout_2);


        verticalLayout_3.addLayout(horizontalLayout_2);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        btnLogin = new QPushButton(MainLogin);
        btnLogin.setObjectName("btnLogin");

        horizontalLayout.addWidget(btnLogin);

        btnExit = new QPushButton(MainLogin);
        btnExit.setObjectName("btnExit");

        horizontalLayout.addWidget(btnExit);


        verticalLayout_3.addLayout(horizontalLayout);


        gridLayout.addLayout(verticalLayout_3, 0, 0, 1, 1);

        retranslateUi(MainLogin);
        btnExit.clicked.connect(MainLogin, "close()");

        MainLogin.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget MainLogin)
    {
        MainLogin.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login", null));
        lblLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login", null));
        lblPassword.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Password", null));
        btnLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Login", null));
        btnExit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainLogin", "Exit", null));
    } // retranslateUi

}

