import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private Connection conn;
    private String USER = "qeihmzjrmhisbe";
    private String PASS = "f3c71911846bcc6f8c71a3b0f407b97e69e1ec6bc7ddd9211b1cb04bdf2bfa2c";
    private String DB_URL = System.getenv("JDBC_DATABASE_URL");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String role = request.getParameter("userRole");

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Checking");
            String query = "SELECT * FROM users WHERE username=? AND pwd=? AND userrole=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2,pass);
            stmt.setString(3,role);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                System.out.println("Reached rs");
                session.setAttribute("username", user +
                        ", you have successfully logged in!");
            }

            conn.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
