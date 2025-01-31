package in.sp.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");
        String mygender = req.getParameter("gender1");
        String mycity = req.getParameter("city1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Ajay@5292");

            PreparedStatement ps = con.prepareStatement("INSERT INTO register(name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mygender);
            ps.setString(5, mycity);

            int count = ps.executeUpdate();
            if (count > 0) {
                resp.sendRedirect("login.jsp"); // Redirect to login page after successful registration
            } else {
                resp.sendRedirect("register.jsp?error=Registration Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("register.jsp?error=Exception Occurred");
        }
    }
}
