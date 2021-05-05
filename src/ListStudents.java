
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudents extends JPanel {
    private JTextArea area;
    private JButton backBtn;
    private MainFrame parent;
    public ListStudents(MainFrame parent) {
        this.parent = parent;
        setSize(500,500);
        setLayout(null);
        area = new JTextArea();
        area.setBounds(100,100,300,150);
        add(area);

        backBtn = new JButton("BACK");
        backBtn.setBounds(100,250,300,30);
        add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainScreen();
            }
        });
    }

    public void fillData(){
        area.setText("");
        for(int i =0;i<Main.students.size();i++){
            area.append(Main.students.get(i).toString()+"\n");
        }
    }
}
