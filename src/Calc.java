

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Calc() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plan");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		double num1, num2;
		try {
			num1 = Double.parseDouble(request.getParameter("n1"));
			num2 = Double.parseDouble(request.getParameter("n2"));
		} catch (NumberFormatException e) {
			String message = "Хибний формат чисел!";
			out.println(message);
			out.close();
			out.flush();
			return;
		}
		String message = "";
		switch (request.getParameter("op")) {
		case "add": message = Double.toString(num1 + num2);
					break;
		case "sub": message = Double.toString(num1 - num2);
					break;
		case "mul": message = Double.toString(num1 * num2);
					break;
		case "div": if (num2 == 0) message = "Ділити на нуль не можна!";
					else message = Double.toString(num1 / num2);
					break;
		}
		out.println(message);
		out.close();
		out.flush();
		return;
	}
}