package atmScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Login extends JFrame{
    private JPanel mainPanel;
    private JPanel headPanel;
    private JLabel heading;
    private JLabel lbl;
    private JPanel bodyPanel;
    private JTextField txtName;
    private JLabel lblName;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JLabel lblAccount;
    private JTextField txtAccount;

    public Login() {

    JFrame frameL=new JFrame();
    frameL.getContentPane();
    frameL.add(mainPanel);
    frameL.setVisible(true);
    frameL.setSize(500,500);
    submitButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {


            if(txtName.getText().isEmpty()||txtEmail.getText().isEmpty()||txtAccount.getText().isEmpty()||txtPassword.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"You submitted empty fields.");
            }
            else {

                try {
                   AtmBankDatabase c2=new AtmBankDatabase();
                   Statement st=c2.con.createStatement();
                    String sql = "SELECT * FROM account_tb WHERE email='" + txtEmail.getText() + "' and password='" + txtPassword.getText() + "'";
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        new MainMenu();

                        frameL.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong account username or password");
                    }

                    c2.con.close();
                    clear();


                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }


            }


            super.mouseClicked(e);
        }
    });
    cancelButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel!!");
            System.exit(0);

            super.mouseClicked(e);
        }
    });
        lblAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new SignUp().setVisible(true);

                super.mouseClicked(e);
            }
        });
    }
private void clear(){
    txtName.setText("");
    txtEmail.setText("");
    txtAccount.setText("");
    txtPassword.setText("");
}
}
