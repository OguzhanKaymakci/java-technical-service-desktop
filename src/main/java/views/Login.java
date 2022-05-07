package views;

import Utils.Util;
import models.UserImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu May 05 09:57:01 TRT 2022
 */



/**
 * @author unknown
 */
public class Login extends JFrame {
    UserImpl userImpl= new UserImpl();


    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    public Login() {
        initComponents();
        txtEmail.setText("ok@gmail.com");
        txtPassword.setText("12345");
    }
    public void userLogin(){
        String email=txtEmail.getText().trim().toLowerCase();
        String password= String.valueOf(txtPassword.getPassword()).trim();
        if (email.equals("")){
            lblLoginError.setText("E-Mail is Empty !");
            txtEmail.requestFocus();
        }else if(!Util.isValidEmailAddress(email)){
            lblLoginError.setText("E-Mail format error !");
            txtEmail.requestFocus();

        }else if (password.length()==0){
            lblLoginError.setText("password is empty !");
        }else {
            lblLoginError.setText(" ");
            boolean status= userImpl.userLogin(email,password);

            if (true){
                DashBoard dashBoard= new DashBoard();
                dashBoard.setVisible(true);
                dispose();
            }else {
                lblLoginError.setText("E-Mail or Password Fail! ");
            }
        }
    }

    private void btnLoginClick(ActionEvent e) {
        userLogin();
    }

    private void txtEmailMouseReleased(MouseEvent e) {

    }

    private void txtPasswordMouseReleased(MouseEvent e) {

    }

    private void txtEmailKeyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            userLogin();
        }
    }

    private void txtPasswordKeyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            userLogin();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label4 = new JLabel();
        label5 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        txtEmail = new JTextField();
        label3 = new JLabel();
        txtPassword = new JPasswordField();
        btnLogin = new JButton();
        lblLoginError = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label4 ----
        label4.setText("USER");
        label4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        label4.setForeground(new Color(0, 153, 153));

        //---- label5 ----
        label5.setText("LOGIN");
        label5.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        label5.setForeground(new Color(79, 77, 77));

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/userLog.png")));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label1.setBackground(Color.lightGray);

        //---- label2 ----
        label2.setText("E-Mail");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        label2.setForeground(new Color(79, 77, 77));

        //---- txtEmail ----
        txtEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                txtEmailMouseReleased(e);
            }
        });
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtEmailKeyReleased(e);
            }
        });

        //---- label3 ----
        label3.setText("Password");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 17));
        label3.setForeground(new Color(79, 77, 77));

        //---- txtPassword ----
        txtPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                txtPasswordMouseReleased(e);
            }
        });
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtPasswordKeyReleased(e);
            }
        });

        //---- btnLogin ----
        btnLogin.setIcon(new ImageIcon(getClass().getResource("/5172973_arrow_entrance_in_internet_log_icon.png")));
        btnLogin.addActionListener(e -> btnLoginClick(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(94, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(174, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                            .addGap(152, 152, 152))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(lblLoginError, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(label4))
                    .addGap(34, 34, 34)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label2)
                    .addGap(18, 18, 18)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblLoginError, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label4;
    private JLabel label5;
    private JLabel label1;
    private JLabel label2;
    private JTextField txtEmail;
    private JLabel label3;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblLoginError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
