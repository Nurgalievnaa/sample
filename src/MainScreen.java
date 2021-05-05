
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JPanel {
    private MainFrame parent;
    private JButton btn1;
    private JButton btn2;
    public MainScreen(MainFrame parent) {
        this.parent = parent;
        setSize(500,500);
        setLayout(null);
        btn1 = new JButton("ADD STUDENT");
        btn1.setBounds(100,100,300,30);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showAddStudentScreen();
            }
        });
        btn2 = new JButton("LIST STUDENT");
        btn2.setBounds(100,200,300,30);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.fillListData();
                parent.showListStudentScreen();
            }
        });
    }
}
