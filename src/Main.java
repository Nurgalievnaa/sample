
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);


        try {
            Socket socket = new Socket("127.0.0.1", 1978);
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());
            PackageData pd = null;

            while (inputStream.readObject()!=null){
                System.out.println(pd.toString());


            }

        } catch (Exception e) {
            e.printStackTrace();
        }}


        public static void addStudent (Student student){
            students.add(student);
        }


}
