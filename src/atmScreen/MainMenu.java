package atmScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenu extends JFrame{
    private JPanel mainPanel;
    private JPanel bodyPanel;
    private JPanel container;
    private JButton balanceBtn;
    private JLabel sbheadinglbl;
    private JPanel headPanel;
    private JButton cancelBtn;
    private JButton withdrawBtn;
    private JButton depositBtn;

    public MainMenu() {


   JFrame frame= new JFrame();
   frame.getContentPane();
   frame.add(mainPanel);
   frame.setSize(500,500);
   frame.setVisible(true);
    cancelBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            new Login();
            frame.dispose();



            super.mouseClicked(e);
        }
    });
        withdrawBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new AtmKeyPad();
                frame.dispose();
                super.mouseClicked(e);
            }
        });
        depositBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // deposit

                new DepositPage();
                frame.dispose();
                super.mouseClicked(e);
            }
        });
        balanceBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//checking balance
                new Balance();




                super.mouseClicked(e);
            }
        });
    }


}
