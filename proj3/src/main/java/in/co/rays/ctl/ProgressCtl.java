package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.ProgressDto;
import in.co.rays.model.ProgressModel;

@WebServlet("/ProgressCtl")
public class ProgressCtl extends HttpServlet {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id =	req.getParameter("id");
		ProgressDto dto = new ProgressDto();
		ProgressModel model = new ProgressModel();
		if (id !=null) {
			dto=model.findByPK(Integer.parseInt(id));
			req.setAttribute("dto", dto);
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("ProgressView.jsp");
		rd.forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		ProgressDto dto = new ProgressDto();
		String id = req.getParameter("id");
		String op = req.getParameter("operation");
		ProgressModel model = new ProgressModel();
		
		
		dto.setName(req.getParameter("name"));
		dto.setWork(req.getParameter("work"));
		try {
			dto.setReportingDate(sdf.parse(req.getParameter("date")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dto.setTarget(req.getParameter("target"));
		dto.setLastWeek(req.getParameter("lastWeek"));
		dto.setCurrentWeek(req.getParameter("currentWeek"));
		
		


		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("dto", dto);
			req.setAttribute("msg", "Progress updated successfully");
		}
		if (op.equalsIgnoreCase("save")) {
			req.setAttribute("dto", dto);
			model.add(dto);
			req.setAttribute("msg", "Progress added successfully");
		}
		RequestDispatcher rd = req.getRequestDispatcher("ProgressView.jsp");
		rd.forward(req, resp);

	
		

	}
	
	

}