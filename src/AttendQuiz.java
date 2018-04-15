import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendQuiz extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
	
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
ArrayList<String> list = new ArrayList<String>(); 
String name=request.getParameter("name");  
 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
              

PreparedStatement ps=con.prepareStatement("select questions from quiz");

              
out.print("<center><h1>:Questions:</h1>");  
  
ResultSet rs=ps.executeQuery();  
              
  
   
while(rs.next())  
{  

  list.add(rs.getString(1));
                  
}  
  
out.print("<form method='post' action='answ'>"
		+ "1. <input type='text' name='q0' size='45' value='"+list.get(0)+"' /><br/>"
		+ "<input type='radio' name='ans0' value='true'/>True"
		+"<input type='radio' name='ans0' value='false'/>False<br/><br/>"
		+ "2. <input type='text' name='q1' size='45' value='"+list.get(1)+"'/><br/>"
		+ "<input type='radio' name='ans1' value='true'/>True"
		+"<input type='radio' name='ans1' value='false'/>False<br/><br/>"
		+ "3. <input type='text' name='q2' size='45' value='"+list.get(2)+"' /><br/>"
		+ "<input type='radio' name='ans2' value='true'/>True"
		+"<input type='radio' name='ans2' value='false'/>False<br/><br/>"
		+ "4. <input type='text' name='q3' size='45' value='"+list.get(3)+"' /><br/>"
		+ "<input type='radio' name='ans3' value='true'/>True"
		+"<input type='radio' name='ans3' value='false'/>False<br/><br/>"
		+ "5. <input type='text' name='q4' size='45' value='"+list.get(4)+"' /><br/>"
		+ "<input type='radio' name='ans4' value='true'/>True"
		+"<input type='radio' name='ans4' value='false'/>False<br/><br/>"
		+ "6. <input type='text' name='q5' size='45' value='"+list.get(5)+"' /><br/>"
		+ "<input type='radio' name='ans5' value='true'/>True"
		+"<input type='radio' name='ans5' value='false'/>False<br/><br/>"
		+ "7. <input type='text' name='q6' size='45' value='"+list.get(6)+"' /><br/>"
		+ "<input type='radio' name='ans6' value='true'/>True"
		+"<input type='radio' name='ans6' value='false'/>False<br/><br/>"
		+ "8. <input type='text' name='q7' size='45' value='"+list.get(7)+"' /><br/>"
		+ "<input type='radio' name='ans7' value='true'/>True"
		+"<input type='radio' name='ans7' value='false'/>False<br/><br/>"
		+ "9. <input type='text' name='q8' size='45' value='"+list.get(8)+"' /><br/>"
		+ "<input type='radio' name='ans8' value='true'/>True"
		+"<input type='radio' name='ans8' value='false'/>False<br/><br/>"
		+ "10. <input type='text' name='q9' size='45' value='"+list.get(9)+"' /><br/>"
		+ "<input type='radio' name='ans9' value='true'/>True"
		+"<input type='radio' name='ans9' value='false'/>False<br/><br/>"
		+ "<input type='submit' value='Result'/></form></center>");
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  


		}
}  
