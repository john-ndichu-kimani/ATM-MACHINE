package atmScreen;

import javax.swing.*;

public class CashDispenser extends JFrame{
    private JPanel mainPanel;
    private JPanel headingPanel;
    private JLabel heading;
    private JPanel bodyPanel;
    private JLabel bodyLbl;
    public CashDispenser(){
        JFrame frame=new JFrame();
        frame.getContentPane();
        frame.add(mainPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
