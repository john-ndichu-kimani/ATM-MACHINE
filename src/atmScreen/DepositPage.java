package atmScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepositPage extends JFrame{
    private JPanel mainPanel;
    private JPanel headPanel;
    private JLabel heading;
    private JLabel lblAccount;
    private JTextField txtAccount;
    private JTextField txtAmount;
    private JLabel amountLbl;
    private JButton submitBtn;
    private JButton exitBtn;
    public DepositPage(){
        JFrame f=new JFrame();
        f.getContentPane();
        f.setSize(500,500);
        f.add(mainPanel);
        f.setVisible(true);
        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtAccount.getText().isEmpty()||txtAmount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please provide the fields");
                }
                else{
                  AtmBankDatabase c4=new AtmBankDatabase();
                  try{
                  //logic for depositing cash
                      int amount=Integer.valueOf(txtAmount.getText());
                      int account=Integer.valueOf(txtAccount.getText());
                      Statement st=c4.con.createStatement();
                      String q2="SELECT * FROM account_tb WHERE accountnum='"+Integer.valueOf(txtAccount.getText())+"'";

                      ResultSet rs=st.executeQuery(q2);
                      if(rs.next()){
                          //getting the balance from the table
                          int balance=rs.getInt("balance");

                          // newBalance=amount+balance

                          int newBalance=amount+balance;

                          String q="UPDATE account_tb SET balance='"+newBalance+"' WHERE accountnum='"+Integer.valueOf(txtAccount.getText())+"' ";

                          st.executeUpdate(q);

JOptionPane.showMessageDialog(null,"Deposit of: '"+amount+"' was successful.");
f.dispose();
                      }
clear();

                  }catch (Exception ex){
                      JOptionPane.showMessageDialog(null,ex);

                  }
                }
                super.mouseClicked(e);
            }
        });
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(null,"Are you sure you want to exit!1");
                super.mouseClicked(e);
            }
        });
    }
public void clear(){
        txtAccount.setText(" ");
        txtAmount.setText(" ");
}

}
