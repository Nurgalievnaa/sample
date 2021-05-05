
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    private static Connection connection;
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if(connect()){
            try{
                ServerSocket server = new ServerSocket(1978);
                Socket socket = server.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                PackageData pd = null;

                while (inputStream.readObject()!=null){
                    System.out.println(pd.toString());

                }

            }catch (Exception e){
                e.printStackTrace();

            }



        }
    }

    public static boolean connect(){
        boolean check = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sql_1","root","");
            System.out.println("Connected");
            check = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return check;
    }

    public static  void addStudent(Student u){
        try{
            PreparedStatement st = connection.prepareStatement("insert into students(name,surname,age) values(?,?,?)");
            st.setString(1,u.getName());
            st.setString(1,u.getSurname());
            st.setInt(2,u.getAge());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("select * from students");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                students.add(new Student(id,name,surname,age));
            }
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }


}
