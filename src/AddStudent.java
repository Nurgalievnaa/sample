
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JPanel {
    private MainFrame parent;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JTextField idField;
    private JLabel lbl;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JButton btn;
    private JButton backBtn;
    public AddStudent(MainFrame parent) {
        this.parent = parent;
        setLayout(null);
        setSize(500,500);

        lbl = new JLabel("Name:");
        lbl.setSize(300,30);
        lbl.setLocation(30,100);
        add(lbl);

        lbl2 = new JLabel("Surname:");
        lbl2.setSize(300,30);
        lbl2.setLocation(30,140);
        add(lbl2);

        lbl3 = new JLabel("Age:");
        lbl3.setSize(300,30);
        lbl3.setLocation(30,180);
        add(lbl3);

        lbl4 = new JLabel("id:");
        lbl4.setSize(300,30);
        lbl4.setLocation(30,50);
        add(lbl4);

        idField = new JTextField();
        idField.setBounds(100,50,300,30);
        add(idField);

        nameField = new JTextField();
        nameField.setBounds(100,100,300,30);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setBounds(100,140,300,30);
        add(surnameField);


        ageField = new JTextField();
        ageField.setBounds(100,180,300,30);
        add(ageField);

        btn = new JButton("SUBMIT");
        btn.setBounds(100,200,300,30);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String surname = surnameField.getText();
                int age = Integer.parseInt(ageField.getText());
                Student st = new Student(id,name,surname,age);
                Main.addStudent(st);
                idField.setText("");
                nameField.setText("");
                surnameField.setText("");
                ageField.setText("0");
            }
        });


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
}
