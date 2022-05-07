/*
 * Created by JFormDesigner on Fri May 06 12:45:19 TRT 2022
 */

package views;

import models.ServiceImpl;
import models.UserImpl;
import prop.ComboItem;
import prop.Service;
import prop.User;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Serrvices extends Base {
    int row=-1;
    int row2=-1;
    int selectedId=0;
    ServiceImpl serviceImpl= new ServiceImpl();
    DashBoard dashBoard= new DashBoard();
    public Serrvices() {
        initComponents();
        lblName.setText("Welcome "+ UserImpl.name);
        tblCustomerService.setModel(serviceImpl.serviceCustomerTable(null));
        fncCmbDaysAdd();
        fncCmbStatusAdd();
        tblUpdateDelete.setModel(serviceImpl.serviceUpdateDeleteTable(null));

    }
    private void fncCmbDaysAdd(){
        for (int i = 0; i < 20; i++) {
            cmbDays.addItem(i);
        }
    }
    private void fncCmbStatusAdd(){
        cmbStatus.addItem(new ComboItem("status 0","0"));
        cmbStatus.addItem(new ComboItem("status 1","1"));
        cmbStatus.addItem(new ComboItem("status 2","2"));
        cmbStatus.addItem(new ComboItem("status 3","3"));
        cmbStatus.addItem(new ComboItem("status 4","4"));

    }
    public Service fncDataValid(){
        try {
            if ( txtTitle.getText().equals("") || txtTitle.getText().equals(null)) {
                txtTitle.requestFocus();
                lblError.setText("Title Empty");
            } else if (txtInfo.getText().equals("") || txtInfo.getText().equals(null)) {
                txtInfo.requestFocus();
                lblError.setText("Info Empty");
            } else if (cmbDays.getSelectedItem().equals("")) {
                cmbDays.requestFocus();
                lblError.setText("days Empty");
            } else if (cmbStatus.getSelectedItem().equals("")) {
                cmbStatus.requestFocus();
                lblError.setText("status Empty");
            } else if (txtPrice.getText().equals("")) {
                txtPrice.requestFocus();
                lblError.setText("price Empty");
            } else {
                String title = txtTitle.getText().toLowerCase(Locale.ROOT).trim();
                String info = txtInfo.getText().toLowerCase(Locale.ROOT).trim();
                int days = Integer.parseInt(String.valueOf(cmbDays.getSelectedItem()));
                //date
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
                LocalDate localDate = LocalDate.now();
                String date = dtf.format(localDate);
                //status
                int status = Integer.parseInt(((ComboItem)cmbStatus.getSelectedItem()).getValue());
                //date
                int price = Integer.parseInt(txtPrice.getText().toLowerCase(Locale.ROOT).trim());
                lblError.setText("");
                Service service = new Service(0, selectedId, title, info, days, date, status, price);
                return service;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void textClear(){
        txtTitle.setText("");
        txtInfo.setText("");
        txtPrice.setText("");
    }
    public void rowValue(){
        int column=0;
        row=tblCustomerService.getSelectedRow();
        selectedId= (int) tblCustomerService.getValueAt(row,column);

        int cid= Integer.parseInt(String.valueOf(tblCustomerService.getValueAt(row,0)));
        String name= String.valueOf(tblCustomerService.getValueAt(row,1));
        String surname= String.valueOf(tblCustomerService.getValueAt(row,2));
        String email= String.valueOf(tblCustomerService.getValueAt(row,3));
        String phone= String.valueOf(tblCustomerService.getValueAt(row,4));
        String address= String.valueOf(tblCustomerService.getValueAt(row,5));
        System.out.println("Selected Sindex: "+selectedId);



    }
    public void rowSelect() {
        int column = 0;
        row = tblUpdateDelete.getSelectedRow();
        selectedId = (int) tblUpdateDelete.getValueAt(row,column);

        int sid = Integer.parseInt(String.valueOf(tblUpdateDelete.getValueAt(row,0)));
        int cid = Integer.parseInt(String.valueOf(tblUpdateDelete.getValueAt(row,1)));
        String name = String.valueOf(tblUpdateDelete.getValueAt(row,2));
        String surname = String.valueOf(tblUpdateDelete.getValueAt(row,3));
        String title = String.valueOf(tblUpdateDelete.getValueAt(row,4));
        String info = String.valueOf(tblUpdateDelete.getValueAt(row,5));
        int days = Integer.parseInt(String.valueOf(tblUpdateDelete.getValueAt(row,6)));
        String date = String.valueOf(tblUpdateDelete.getValueAt(row,7));
        String status = String.valueOf(tblUpdateDelete.getValueAt(row,8));
        int price = Integer.parseInt(String.valueOf(tblUpdateDelete.getValueAt(row,9)));
        System.out.println("selectedId "+ selectedId);

        txtTitle.setText(title);
        txtInfo.setText(info);
        cmbDays.getSelectedItem();
        txtPrice.setText(String.valueOf(price));
        cmbStatus.getSelectedItem();
        txtDate.setText(date);

    }


    private void btnAddClick(ActionEvent e) {
        Service s = fncDataValid();
        if (s != null ) {
            int status = serviceImpl.serviceInsert(s);
            if (status >0) {
                System.out.println("Ekleme Başarlı");
                tblUpdateDelete.setModel(serviceImpl.serviceUpdateDeleteTable(null));
                textClear();
            }else {
                lblError.setText("Insert Error");
            }
        }
    }

    private void btnUpdateClick(ActionEvent e) {

        String title = txtTitle.getText();
        String info = txtInfo.getText();
        int days = Integer.parseInt((String) cmbDays.getSelectedItem());
        int price = Integer.parseInt(txtPrice.getText());

        Service service = new Service(selectedId,title,info,days,price);
        if (row!=-1){
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to update the customer?","Update Window",JOptionPane.YES_OPTION);
            if (answer==0){
                serviceImpl.serviceUpdate(service);
                tblCustomerService.setModel(serviceImpl.serviceCustomerTable(null));
                textClear();
                row=-1;

            }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose.");

        }
    }

    private void btnDeleteClick(ActionEvent e) {

        if (row != -1) {
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete the customer?","Delete Window",JOptionPane.YES_OPTION);

            if (answer==0) {
                serviceImpl.serviceDelete(selectedId);
                tblCustomerService.setModel(serviceImpl.serviceCustomerTable(null));
                textClear();
                row = -1;
            }
        }else {
            JOptionPane.showMessageDialog(this,"Please choose.");
        }
    }

    private void txtSearchKeyReleased(KeyEvent e) {
        String txtSearch = txtCustomerSearch.getText().trim();
        tblCustomerService.setModel(serviceImpl.serviceCustomerTable(txtSearch));

    }

    private void tblCustomerServiceKeyReleased(KeyEvent e) {
        rowValue();
    }

    private void tblCustomerServiceMouseClicked(MouseEvent e) {
        rowValue();
    }

    private void tblUpdateDeleteKeyReleased(KeyEvent e) {
        rowValue();
    }

    private void tblUpdateDeleteMouseClicked(MouseEvent e) {
        rowValue();
    }

    private void thisWindowClosing(WindowEvent e) {
        new DashBoard().setVisible(true);
    }

    private void btnServiceClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tblCustomerService = new JTable();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label8 = new JLabel();
        label7 = new JLabel();
        label6 = new JLabel();
        txtTitle = new JTextField();
        txtDate = new JTextField();
        txtPrice = new JTextField();
        txtInfo = new JTextField();
        cmbDays = new JComboBox();
        cmbStatus = new JComboBox();
        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        scrollPane2 = new JScrollPane();
        tblUpdateDelete = new JTable();
        lblName = new JLabel();
        lblError = new JLabel();
        txtCustomerSearch = new JTextField();
        btnService = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Service");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label1.setForeground(Color.blue);

        //---- label2 ----
        label2.setText("Customer Search");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 16));

        //======== scrollPane1 ========
        {

            //---- tblCustomerService ----
            tblCustomerService.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tblCustomerServiceKeyReleased(e);
                }
            });
            tblCustomerService.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblCustomerServiceMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tblCustomerService);
        }

        //---- label3 ----
        label3.setText("Title");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 2f));

        //---- label4 ----
        label4.setText("Date");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 2f));

        //---- label5 ----
        label5.setText("Price");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 2f));

        //---- label8 ----
        label8.setText("Status");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 2f));

        //---- label7 ----
        label7.setText("Days");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 2f));

        //---- label6 ----
        label6.setText("Info");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 2f));

        //---- btnAdd ----
        btnAdd.setText("ADD");
        btnAdd.setFont(btnAdd.getFont().deriveFont(btnAdd.getFont().getStyle() | Font.BOLD, btnAdd.getFont().getSize() + 3f));
        btnAdd.addActionListener(e -> btnAddClick(e));

        //---- btnUpdate ----
        btnUpdate.setText("UPDATE");
        btnUpdate.setFont(btnUpdate.getFont().deriveFont(btnUpdate.getFont().getStyle() | Font.BOLD, btnUpdate.getFont().getSize() + 3f));
        btnUpdate.addActionListener(e -> btnUpdateClick(e));

        //---- btnDelete ----
        btnDelete.setText("DELETE");
        btnDelete.setFont(btnDelete.getFont().deriveFont(btnDelete.getFont().getStyle() | Font.BOLD, btnDelete.getFont().getSize() + 3f));
        btnDelete.addActionListener(e -> btnDeleteClick(e));

        //======== scrollPane2 ========
        {

            //---- tblUpdateDelete ----
            tblUpdateDelete.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tblUpdateDeleteKeyReleased(e);
                }
            });
            tblUpdateDelete.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblUpdateDeleteMouseClicked(e);
                }
            });
            scrollPane2.setViewportView(tblUpdateDelete);
        }

        //---- txtCustomerSearch ----
        txtCustomerSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtSearchKeyReleased(e);
            }
        });

        //---- btnService ----
        btnService.setIcon(new ImageIcon(getClass().getResource("/tecnicIcon.png")));
        btnService.addActionListener(e -> btnServiceClick(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnService, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                                    .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))))
                        .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtInfo)
                                .addComponent(cmbDays)
                                .addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                            .addGap(96, 96, 96)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnAdd)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate)))
                        .addComponent(scrollPane1)
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnService, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(txtInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd)))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(cmbDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate)))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)))
                    .addGap(18, 18, 18)
                    .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable tblCustomerService;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label8;
    private JLabel label7;
    private JLabel label6;
    private JTextField txtTitle;
    private JTextField txtDate;
    private JTextField txtPrice;
    private JTextField txtInfo;
    private JComboBox cmbDays;
    private JComboBox cmbStatus;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JScrollPane scrollPane2;
    private JTable tblUpdateDelete;
    private JLabel lblName;
    private JLabel lblError;
    private JTextField txtCustomerSearch;
    private JButton btnService;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
