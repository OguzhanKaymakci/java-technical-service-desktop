/*
 * Created by JFormDesigner on Thu May 05 12:06:32 TRT 2022
 */

package views;

import Utils.Util;
import models.CustomerImpl;
import models.UserImpl;
import prop.Customer;
import prop.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CustomerAdd extends Base {
    CustomerImpl customerImpl = new CustomerImpl();
    int row=-1;
    int selectId = 0;
    public CustomerAdd() {
        initComponents();
        lblName.setText("Welcome " + UserImpl.name);
        tblCustomer.setModel(customerImpl.customerTablemodel());
    }

    private void btnCustomerAddClick(ActionEvent e) {

        Customer c = fncDataValid();
        if (c != null ) {
            int status = customerImpl.customerInsert(c);
            if (status >0) {
                tblCustomer.setModel(customerImpl.customerTablemodel());
                lblError.setText("Added customer success !");
                txtName.setText("");
                txtSurname.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                txtAddress.setText("");

            }else  {
                if (status == -1) {
                    lblError.setText("E-Mail or Phone have already used");
                }else {
                    lblError.setText("Insert Error");
                }
            }
        }

    }

    private void thisWindowClosing(WindowEvent e) {
        new DashBoard().setVisible(true);
    }
    public void rowValue(){
        int column = 0;
        row = tblCustomer.getSelectedRow();
        selectId = (int) tblCustomer.getValueAt(row, column);
        String cid= String.valueOf(tblCustomer.getValueAt(row,0));
        String name= String.valueOf(tblCustomer.getValueAt(row,1));
        String surname= String.valueOf(tblCustomer.getValueAt(row,2));
        String email= String.valueOf(tblCustomer.getValueAt(row,3));
        String phone= String.valueOf(tblCustomer.getValueAt(row,4));
        String address= String.valueOf(tblCustomer.getValueAt(row,5));

        txtName.setText(name);
        txtSurname.setText(surname);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        txtAddress.setText(address);
    }
    private Customer fncDataValid() {

        String name=txtName.getText().trim();
        String surname=txtSurname.getText().trim();
        String email=txtEmail.getText().trim().toLowerCase();  //boşluk varsa al trimle sil
        String phone=txtPhone.getText().trim();
        String address=txtAddress.getText().trim();

        if (name.equals("")){
            lblError.setText("Name is Empty!!!");
            txtName.requestFocus();
        }else if (surname.equals("")){
            lblError.setText("Surname is Empty!!!");
            txtSurname.requestFocus();
        }else if (email.equals("")){
            lblError.setText("Email is Empty!!!");
            txtEmail.requestFocus();
        }else if(!Util.isValidEmailAddress(email)){ //fprmatı başkaysa
            lblError.setText("Email Validation Error!!!");
            txtEmail.requestFocus();
        }else if (phone.equals("")){ //boşşa sıfırsa
            lblError.setText("Phone is Empty!!!");
            txtPhone.requestFocus();//imleç otomatik olarak passwworde gelicek
        }
        else if (address.equals("")){ //boşşa sıfırsa
            lblError.setText("Adress is Empty!!!");
            txtAddress.requestFocus();//imleç otomatik olarak passwworde gelicek
        }else {
            lblError.setText("");
            Customer c = new Customer(0,name,surname,email,phone,address);
            return c;
        }
        return null;
    }

    private void btnDeleteClick(ActionEvent e) {
        if (row !=-1){
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete the customer?","Delete Window",JOptionPane.YES_OPTION);//parent component nerede görüneceği this button

            if (answer==0){
                customerImpl.CustomerDelete(selectId);
                tblCustomer.setModel(customerImpl.customerTablemodel()); //tabloyu refresh et
                txtName.setText("");
                txtSurname.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                txtAddress.setText("");
                row=-1;
            }
        }

        else{
            JOptionPane.showMessageDialog(this,"Please choose.");
        }
    }

    private void btnUpdateClick(ActionEvent e) {

        String name= txtName.getText();
        String surname= txtSurname.getText();
        String email= txtEmail.getText();
        String phone= txtPhone.getText();
        String address= txtAddress.getText();

        Customer customer= new Customer(selectId,name,surname,email,phone,address);
        //carsModel.add(c);
        if (row!=-1){
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to update the customer?","Update Window",JOptionPane.YES_OPTION);//parent component nerede görüneceği this button

            if (answer==0){
                customerImpl.customerUpdate(customer);
                tblCustomer.setModel(customerImpl.customerTablemodel()); //tabloyu refresh et
//                System.out.println(row+" update");
                txtName.setText("");
                txtSurname.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                txtAddress.setText("");
                row=-1;

            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please choose.");
        }
    }

    private void tblCustomerKeyReleased(KeyEvent e) {
        rowValue();
    }

    private void tblCustomerMouseClicked(MouseEvent e) {
        rowValue();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtSurname = new JTextField();
        txtPhone = new JTextField();
        txtAddress = new JTextField();
        btnCustomerAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        lblError = new JLabel();
        lblName = new JLabel();
        scrollPane1 = new JScrollPane();
        tblCustomer = new JTable();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- button1 ----
            button1.setIcon(new ImageIcon(getClass().getResource("/addIcon2.png")));

            //---- label1 ----
            label1.setText("Customer Managment");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
            label1.setForeground(Color.blue);

            //---- label2 ----
            label2.setText("Name");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

            //---- label4 ----
            label4.setText("E-mail");
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

            //---- label6 ----
            label6.setText("Addres");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));

            //---- label5 ----
            label5.setText("Phone");
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

            //---- label3 ----
            label3.setText("Surname");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

            //---- btnCustomerAdd ----
            btnCustomerAdd.setIcon(new ImageIcon(getClass().getResource("/\u0131conAddCusIcon.png")));
            btnCustomerAdd.setText("ADD");
            btnCustomerAdd.setFont(btnCustomerAdd.getFont().deriveFont(btnCustomerAdd.getFont().getStyle() | Font.BOLD, btnCustomerAdd.getFont().getSize() + 6f));
            btnCustomerAdd.addActionListener(e -> btnCustomerAddClick(e));

            //---- btnUpdate ----
            btnUpdate.setIcon(new ImageIcon(getClass().getResource("/updateCusIcon.png")));
            btnUpdate.setText("UPDATE");
            btnUpdate.setFont(btnUpdate.getFont().deriveFont(btnUpdate.getFont().getStyle() | Font.BOLD, btnUpdate.getFont().getSize() + 6f));
            btnUpdate.addActionListener(e -> btnUpdateClick(e));

            //---- btnDelete ----
            btnDelete.setIcon(new ImageIcon(getClass().getResource("/deleteIcon.png")));
            btnDelete.setText("DELETE");
            btnDelete.setFont(btnDelete.getFont().deriveFont(btnDelete.getFont().getStyle() | Font.BOLD, btnDelete.getFont().getSize() + 6f));
            btnDelete.addActionListener(e -> btnDeleteClick(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(149, 149, 149)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAddress)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnCustomerAdd, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 66, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCustomerAdd, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
            );
        }

        //======== scrollPane1 ========
        {

            //---- tblCustomer ----
            tblCustomer.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tblCustomerKeyReleased(e);
                }
            });
            tblCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblCustomerMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tblCustomer);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label4;
    private JLabel label6;
    private JLabel label5;
    private JLabel label3;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtSurname;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JButton btnCustomerAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JLabel lblError;
    private JLabel lblName;
    private JScrollPane scrollPane1;
    private JTable tblCustomer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
