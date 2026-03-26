import java.sql.*;
import java.util.*;
class sub{
public static void main(String[] args){    
String url = "jdbc:mysql://localhost:3306/stu_db";
        String user = "root";      
        String password = "rexy123";  

        Scanner sc = new Scanner(System.in);
        
        try {
            // 1. Driver Load panna
           // Class.forName("com.mysql.cj.jdbc.Driver");
            
          
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("--- Connected to Database ---");

System.out.println("1.add student");
System.out.println("2.view student");
System.out.println("3.update student");
System.out.println("4.delete student");
System.out.println("5.exit from student table");
System.out.print("Enter your choice:");
int choice=sc.nextInt();
if(choice==1){
System.out.print("Enter your ID:");
int id=sc.nextInt();
sc.nextLine();
System.out.println("Enter your Name:");
String name=sc.nextLine();
System.out.print("Enter your Age:");
int age=sc.nextInt();
sc.nextLine();
System.out.print("Enter your departement");
String dept=sc.nextLine();
String sql="insert into students values (?,?,?,?)";
PreparedStatement pmt=con.prepareStatement(sql);
pmt.setInt(1,id);
pmt.setString(2,name);
pmt.setInt(3,age);
pmt.setString(4,dept);
int rows=pmt.executeUpdate();
}
else if(choice==2){
System.out.println("Welcome to viewing");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from students");
while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("dept"));
}
}
else if(choice==3){
System.out.println("welcome to update");
String up="update students set age =13 where id=1";
PreparedStatement pmt =con.prepareStatement(up);
int rows=pmt.executeUpdate(); 
System.out.println(rows+" updated successfully");
}
else if(choice==4){
System.out.println("welcome to delete");
String del="delete from  students where id=1";
PreparedStatement pmt=con.prepareStatement(del);
int rows=pmt.executeUpdate();
System.out.println("deleted successfully" +rows);

}
else{
System.out.println("exit");
}
}
catch(Exception e){
System.out.print(e);
}
}
}



            
          
            
        
