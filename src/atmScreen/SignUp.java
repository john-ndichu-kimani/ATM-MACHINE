package atmScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
public class SignUp extends JFrame{
    private JPanel mainPanel;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtLName;
    private JTextField txtMobile;
    private JTextField txtEmail;
    private JButton submitBtn;
    private JButton cancelBtn;
    private JLabel FNameLbl;
    private JLabel LNamelbl;
    private JLabel emailLbl;
    private JLabel mobileLbl;
    private JLabel countryLbl;
    private JComboBox countryCB;
    private JLabel heading;
    private JLabel lbl;
    private JPasswordField txtPassword;
    private JLabel loginLbl;
    private JLabel alreadyLbl;
    private JTextField txtAccount;


    public SignUp() {


    JFrame frame=new JFrame();
    frame.getContentPane();
    frame.setSize(500,500);
    frame.setVisible(true);
    frame.add(mainPanel);
    submitBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(txtName.getText().isEmpty()||txtLName.getText().isEmpty()||txtAddress.getText().isEmpty()||txtEmail.getText().isEmpty()||txtMobile.getText().isEmpty()||countryCB.getSelectedItem().toString().isEmpty()){
                JOptionPane.showMessageDialog(null,"Missing fields");
            }
            else{
try {
    AtmBankDatabase c1=new AtmBankDatabase();

    String sql="INSERT INTO account_tb VALUES(?,?,?,?,?,?,?,?,?)";

    PreparedStatement pst=c1.con.prepareStatement(sql);

    pst.setString(1,txtAccount.getText());
    pst.setString(2,txtName.getText());
    pst.setString(3,txtLName.getText());
    pst.setString(4,txtEmail.getText());
    pst.setString(5,txtAddress.getText());
    pst.setString(6,txtMobile.getText());
    pst.setString(7, String.valueOf(countryCB.getSelectedItem()));
    pst.setDouble(8,5000);
    pst.setString(9,txtPassword.getText());

    pst.executeUpdate();

JOptionPane.showMessageDialog(null,"Hurray!!, Account saved Successfully");

new Login();
frame.dispose();


c1.con.close();
clear();


}catch (Exception ex){
    JOptionPane.showMessageDialog(null,ex);
}
            super.mouseClicked(e);
        }}
    });
        cancelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?");
                super.mouseClicked(e);

                System.exit(0);
            }
        });
        loginLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new Login();
                frame.dispose();

                super.mouseClicked(e);
            }
        });
    }

    private void clear() {
        txtName.setText("");
        txtLName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
        countryCB.setSelectedIndex(-1);
        txtPassword.setText("");
    }

}
