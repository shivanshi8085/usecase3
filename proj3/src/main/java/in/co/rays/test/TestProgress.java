package in.co.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.ProgressDto;
import in.co.rays.model.ProgressModel;

public class TestProgress {
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		//testfindBypk();
		testSearch();
	}

	private static void testSearch() throws Exception {
   
		ProgressModel model = new ProgressModel();
		ProgressDto dto = new ProgressDto();
        dto.setName("Nikhil");		
		List list = model.search(dto,0,10);
	   Iterator	it = list.iterator();
		
		while(it.hasNext()) {
			 dto =(ProgressDto) it.next();
			 
			 System.out.println(dto.getId());
			 System.out.println(dto.getName());
			 System.out.println(dto.getWork());
			 System.out.println(dto.getReportingDate());
			 System.out.println(dto.getTarget());
			 System.out.println(dto.getLastWeek());
			 System.out.println(dto.getCurrentWeek());
		}
		
	}

	private static void testfindBypk() {
		
		ProgressModel model = new ProgressModel();
		ProgressDto dto = model.findByPK(2);
		
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getWork());
		System.out.println(dto.getReportingDate());
		System.out.println(dto.getTarget());
		System.out.println(dto.getLastWeek());
		System.out.println(dto.getCurrentWeek());
	}

	private static void testDelete() {

    ProgressDto	dto = new ProgressDto();
    ProgressModel model = new ProgressModel();
    
    dto.setId(4);
    model.delete(dto);
    System.out.println("Data delete");

	}

	private static void testUpdate() throws Exception {
		
      SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy");
		
		ProgressDto dto = new ProgressDto();
		dto.setId(2);
		ProgressModel model = new ProgressModel();
		
		dto.setName("lansi");
		dto.setWork("eating");
		dto.setReportingDate(sf.parse("23-03-2002"));
		dto.setTarget("eat");
		dto.setLastWeek("good");
		dto.setCurrentWeek("verygood");
		
         model.update(dto);
  System.out.println("Data update");		
	}

	private static void testAdd() throws ParseException {
		
		SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy");
		
		ProgressDto dto = new ProgressDto();
		ProgressModel model = new ProgressModel();
		
		dto.setId(3);
		dto.setName("pranshu");
		dto.setWork("eating");
		dto.setReportingDate(sf.parse("23-03-2002"));
		dto.setTarget("eat");
		dto.setLastWeek("good");
		dto.setCurrentWeek("verygood");
		
		model.add(dto);
    System.out.println("Data added");		
		
	}

}
