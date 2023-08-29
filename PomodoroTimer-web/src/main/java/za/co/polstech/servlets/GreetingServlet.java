package za.co.polstech.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mizu
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        resp.setBufferSize(8192);
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                + "<img src=\"duke.waving.gif\" "
                + "alt=\"Duke waving his hand\">"
                + "<form method=\"get\">"
                + "<h2>Hello, my name is Duke. What's yours?</h2>"
                + "<input title=\"My name is: \"type=\"text\" "
                + "name=\"username\" size=\"25\">"
                + "<p></p>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">"
                + "</form>");

            String username = req.getParameter("username");
            if (username != null && username.length() > 0) {
                RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/response");

                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
            out.println("</body></html>");
        }
        
        super.doGet(req, resp);
    }
}
