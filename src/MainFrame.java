
import javax.swing.*;

public class MainFrame extends JFrame {
    private MainScreen mainScreen;
    private AddStudent addStudent;
    private ListStudents listStudents;
    public MainFrame(){
        setSize(500,500);
        setTitle("Bitlab application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        mainScreen = new MainScreen(this);
        mainScreen.setVisible(true);
        add(mainScreen);

        addStudent = new AddStudent(this);
        addStudent.setVisible(false);
        add(addStudent);

        listStudents = new ListStudents(this);
        listStudents.setVisible(false);
        add(listStudents);
    }

    void showAddStudentScreen(){
        mainScreen.setVisible(false);
        listStudents.setVisible(false);
        addStudent.setVisible(true);
    }


    void showListStudentScreen(){
        mainScreen.setVisible(false);
        addStudent.setVisible(false);
        listStudents.setVisible(true);
    }

    void showMainScreen(){
        addStudent.setVisible(false);
        listStudents.setVisible(false);
        mainScreen.setVisible(true);
    }

    void fillListData(){
        listStudents.fillData();
    }
}
