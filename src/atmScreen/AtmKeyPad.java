
package atmScreen;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
//This class acts as the atm keypad where the user types in the amount to withdraw and his/her the account number
public class AtmKeyPad extends JFrame{
    private JPanel mainPanel;
    private JTextField txtAmount;
    private JLabel amountLbl;
    private JButton submitBtn;
    private JButton cancelBtn;
    private JLabel heading;
    private JLabel accountLbl;
    private JTextField txtAccount;

    public AtmKeyPad() {

    JFrame frame=new JFrame();
    frame.getContentPane();
    frame.add(mainPanel);
    frame.setSize(500,500);
    frame.setVisible(true);

    submitBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(txtAccount.getText().isEmpty()||txtAmount.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"You cannot submit empty fields");
            }
            else {
                try {
                    AtmBankDatabase c3 = new AtmBankDatabase();

                    Statement st = c3.con.createStatement();
                    String sql = "SELECT * FROM account_tb WHERE accountnum='" + Integer.valueOf(txtAccount.getText()) + "'";

                    ResultSet rs = st.executeQuery(sql);

                    if(rs.next()) {

                        int accountnum = rs.getInt(1);
                        int amount = Integer.valueOf(txtAmount.getText());

                        int balance = rs.getInt(8);
                        if (amount > balance) {
                            JOptionPane.showMessageDialog(null, "Please enter a lower amount you have insufficient balance");

                        }
                        try {
                            int newBalance=balance-amount;
                            String q1 = "UPDATE account_tb SET balance='" + newBalance + "' WHERE accountnum='" + Integer.valueOf(txtAccount.getText()) + "'";

                            st.executeUpdate(q1);
                            clear();
                            JOptionPane.showMessageDialog(null,"Withdraw of : "+amount+" was successful!!");

                            JFrame frame=new JFrame();

                            frame.dispose();
                            new CashDispenser();
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Failed to withdraw");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            super.mouseClicked(e);
        }
    });
    cancelBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            new MainMenu();
            frame.dispose();
            super.mouseClicked(e);
        }
    });

    }
    public void clear(){
        txtAccount.setText(" ");
        txtAmount.setText(" ");
    }
}
