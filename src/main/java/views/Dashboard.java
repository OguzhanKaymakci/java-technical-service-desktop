/*
 * Created by JFormDesigner on Thu May 05 11:43:36 TRT 2022
 */

package views;

import models.CustomerServiceImpl;
import models.UserImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class DashBoard extends Base {
    CustomerServiceImpl customerServiceImplFirst= new CustomerServiceImpl(2);
    CustomerServiceImpl customerServiceImplReady=new CustomerServiceImpl(3);
    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }
    public DashBoard() {
        initComponents();
        lblName.setText("Welcome " + UserImpl.name);
        tblNotComplieted.setModel(customerServiceImplFirst.serviceCustomerTable(null));
        tblComplieted.setModel(customerServiceImplReady.serviceCustomerTable(null));

    }

    private void btnCustomer(ActionEvent e) {
        CustomerAdd customerAdd = new CustomerAdd();
        customerAdd.setVisible(true);
        dispose();
    }

    private void btnServiceClick(ActionEvent e) {
        Serrvices serrvices = new Serrvices();
        serrvices.setVisible(true);
        dispose();
    }

    private void btnArchiveClick(ActionEvent e) {
        Archive archive = new Archive();
        archive.setVisible(true);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        btnCustomer = new JButton();
        btnService = new JButton();
        btnArchive = new JButton();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        tblNotComplieted = new JTable();
        scrollPane2 = new JScrollPane();
        tblComplieted = new JTable();
        lblName = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Technical Service ");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label1.setForeground(Color.blue);

        //---- btnCustomer ----
        btnCustomer.setIcon(new ImageIcon(getClass().getResource("/addIcon2.png")));
        btnCustomer.addActionListener(e -> btnCustomer(e));

        //---- btnService ----
        btnService.setIcon(new ImageIcon(getClass().getResource("/tecnicIcon.png")));
        btnService.addActionListener(e -> btnServiceClick(e));

        //---- btnArchive ----
        btnArchive.setIcon(new ImageIcon(getClass().getResource("/archiveIcon.png")));
        btnArchive.addActionListener(e -> btnArchiveClick(e));

        //---- label3 ----
        label3.setText("Work in Progress");
        label3.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        label3.setForeground(new Color(153, 204, 255));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblNotComplieted);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(tblComplieted);
        }

        //---- lblName ----
        lblName.setText(" ");
        lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setForeground(new Color(33, 17, 17));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnService, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnArchive, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(scrollPane2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnService, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnArchive, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(label3)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton btnCustomer;
    private JButton btnService;
    private JButton btnArchive;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable tblNotComplieted;
    private JScrollPane scrollPane2;
    private JTable tblComplieted;
    private JLabel lblName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
