package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.ProgressDto;
import in.co.rays.model.ProgressModel;

@WebServlet("/ProgressListCtl")
public class ProgressListCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProgressDto dto = new ProgressDto();
		ProgressModel model = new ProgressModel();
		
		List list = model.search(dto, 0, 5);
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("ProgressListView.jsp");
		rd.forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		ProgressDto dto = new ProgressDto();
		ProgressModel model = new ProgressModel();
		if (op.equalsIgnoreCase("delete")) {
			
			
			if(ids!=null && ids.length > 0) {
				for(String id:ids) {
					ProgressDto deletedto = new ProgressDto();
					deletedto.setId(Integer.parseInt(id));
					model.delete(deletedto);
					req.setAttribute("msg","Record delete sucessfully");
				}
			}else {
				req.setAttribute("msg","Select Atleast one record");
			}
		}
		if(op.equalsIgnoreCase("new")){
			resp.sendRedirect("ProgressCtl");
			return;
		}
		if(op.equals("search")){
	
			dto.setName(req.getParameter("name"));
		}
		if(op.equals("Search")){
			
			dto.setId(Integer.parseInt(req.getParameter("id")));
		}
		List list=model.search(dto, 0, 5);
		req.setAttribute("list",list);
		RequestDispatcher rd = req.getRequestDispatcher("ProgressListView.jsp");
		rd.forward(req, resp);

	}

}
