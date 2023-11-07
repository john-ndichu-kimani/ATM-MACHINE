package atmScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Balance extends JFrame {
    private JPanel mainPanel;
    private JLabel heading;
    private JLabel accountLbl;
    private JTextField txtAccount;
    private JButton balanceBtn;
    private JButton backBtn;

    public Balance() {

      JFrame f= new JFrame();
      f.getContentPane();
      f.add(mainPanel);
      f.setSize(500,500);
      f.setVisible(true);


        balanceBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtAccount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter your account number");
                }
                else{

                   AtmBankDatabase cb=new AtmBankDatabase();
                   try {
                       Statement st=cb.con.createStatement();

                       String sql="SELECT * FROM account_tb WHERE accountnum='"+Integer.valueOf(txtAccount.getText())+"'";

                       ResultSet rs=st.executeQuery(sql);

                       while (rs.next()){
                           int balance=rs.getInt("balance");

                          JOptionPane.showMessageDialog(null,"Your account balance is: "+balance);

                       }

                   }catch (SQLException ex){
                       JOptionPane.showMessageDialog(null,ex);
                   }
                }
                super.mouseClicked(e);
            }
        });
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                new MainMenu();
                super.mouseClicked(e);
            }
        });
    }
}
