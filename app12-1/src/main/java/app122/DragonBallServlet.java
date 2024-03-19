package app122;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dragon")
public class DragonBallServlet extends HttpServlet{
	private int parsingParam(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DragonBallService service = new DragonBallService();
		
		String pageStr = req.getParameter("page");
		String pagePerStr = req.getParameter("pagePer");
		
		int page = parsingParam(pageStr, 1);
		int pagePer = parsingParam(pagePerStr, 20);
		
		DragonBallDTO dto = service.getDragonBallPage(page, pagePer);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/dragonball.jsp")
		.forward(req, resp);
	
	}
	
	
}
