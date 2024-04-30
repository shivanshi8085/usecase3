package in.co.rays.test;

import java.text.SimpleDateFormat;

import in.co.rays.dto.EmployeDto;
import in.co.rays.model.EmployeModel;

public class EmployeTest {
	public static void main(String[] args) throws Exception {
		
		
		testAdd();
	}

	private static void testAdd()throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		EmployeDto dto = new EmployeDto();
		EmployeModel model = new EmployeModel();
		
		dto.setName("shivanshi");
		dto.setDob(sdf.parse("12-04-2001"));
		dto.setCompany("NCS");
		dto.setDepartment("Electronic");
		dto.setSalary("15000");
		
		model.add(dto);
		System.out.println("Data Added");
		
		
	}

}
