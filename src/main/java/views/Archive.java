/*
 * Created by JFormDesigner on Thu May 05 15:29:01 TRT 2022
 */

package views;

import java.awt.event.*;
import models.CustomerImpl;
import models.CustomerServiceImpl;
import models.UserImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Archive extends Base {
    CustomerServiceImpl customerServiceImpl1= new CustomerServiceImpl();


    public Archive() {
        initComponents();
        lblName.setText("Dear. " + UserImpl.name);
        tblArchive.setModel(customerServiceImpl1.serviceCustomerTable(null));

    }

    private void thisWindowClosing(WindowEvent e) {
        String txtSearch = txtCustomerSearch.getText().trim();
        tblArchive.setModel(customerServiceImpl1.serviceCustomerTable(txtSearch));
        new DashBoard().setVisible(true);

    }

    private void btnArchiveClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        txtCustomerSearch = new JTextField();
        scrollPane1 = new JScrollPane();
        tblArchive = new JTable();
        lblName = new JLabel();
        btnArchive = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Archive");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label1.setForeground(Color.blue);

        //---- label2 ----
        label2.setText("Customer Search");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 16));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblArchive);
        }

        //---- btnArchive ----
        btnArchive.setIcon(new ImageIcon(getClass().getResource("/archiveIcon.png")));
        btnArchive.addActionListener(e -> btnArchiveClick(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnArchive, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                            .addGap(342, 342, 342)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(15, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 596, Short.MAX_VALUE))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnArchive, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addGap(154, 154, 154)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField txtCustomerSearch;
    private JScrollPane scrollPane1;
    private JTable tblArchive;
    private JLabel lblName;
    private JButton btnArchive;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
