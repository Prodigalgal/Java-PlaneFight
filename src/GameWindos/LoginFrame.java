package GameWindos;

import listener.LoginFrameListener;
import thread.MusicThread;
import config.Images;

import javax.swing.*;

public class LoginFrame extends WorkFrame{

    private JPanel firstPanel;
    public JButton loginButton;
    public JButton registerButton;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private static JTextField nameTextField;
    private static JPasswordField passwordField;
    private JLabel label;

    private static LoginFrame instance;

    static {
        new MusicThread().BK.start();
    }

    private LoginFrame(){

        this.setBounds(700,300,500,500);
        this.setTitle("SC2 Login");
        this.setResizable(false);
        firstPanel = new JPanel();
        label = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton("注册");
        nameLabel = new JLabel("用户名：");
        passwordField = new JPasswordField("");
        passwordLabel = new JLabel("密    码：");
        nameTextField = new JTextField("");
        inIt();
        addActionListener();

    }
    public void inIt(){
        firstPanel.setLayout(null);
        nameLabel.setBounds(150,50,100,50);
        passwordLabel.setBounds(150,70,100,50);
        nameTextField.setBounds(200,65,100,20);
        passwordField.setBounds(200,85,100,20);
        loginButton.setBounds(140,130,80,30);
        loginButton.setIcon(new ImageIcon(Images.loginButton));
        loginButton.setBorder(null);
        loginButton.setContentAreaFilled(false);
        label.setIcon(new ImageIcon(Images.FirstPanel));
        label.setBounds(0,0,500,500);
        passwordField.setToolTipText("长度10个字符以内");
        nameTextField.setToolTipText("长度10个字符以内");
        registerButton.setBounds(240,130,80,30);
        registerButton.setIcon(new ImageIcon(Images.reButton));
        registerButton.setBorder(null);
        registerButton.setContentAreaFilled(false);
        registerButton.setToolTipText("没账号？先注册一个吧");
        firstPanel.add(loginButton);
        firstPanel.add(registerButton);
        firstPanel.add(nameLabel);
        firstPanel.add(passwordLabel);
        firstPanel.add(nameTextField);
        firstPanel.add(passwordField);
        firstPanel.add(label);
        this.add(firstPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }
    public String getPasswordField() {
        return String.valueOf(passwordField.getPassword());
    }

    public static LoginFrame getInstance() {
        if(instance == null) {
            instance = new LoginFrame();
        }
        return instance;
    }

    public void addActionListener() {
        LoginFrameListener loginFrameListener = new LoginFrameListener();
        loginButton.addActionListener(loginFrameListener);
        registerButton.addActionListener(loginFrameListener);
    }

    public void reInitial() {
        passwordField.setText("");
        nameTextField.setText("");
    }
}
