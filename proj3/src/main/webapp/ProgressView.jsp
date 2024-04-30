<%@page import="in.co.rays.dto.ProgressDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ProgressCtl" method="post">
	
	
	
	
	<%
		ProgressDto dto = (ProgressDto) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update Progress</h1>
	<%
		} else {
	%>
	<h1 align="center">Add Progress</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
			<tr>
				<th>Name :</th>
				<td><input type="text" name="name"
					value="<%=(dto != null) ? dto.getName() : ""%>"></td>
			</tr>
			&nbsp;
			
			<tr>
				<th>Work :</th>
				<td><input type="text" name="work"
					value="<%=(dto != null) ? dto.getWork() : ""%>"></td>
			</tr>
			&nbsp;
			
			<tr>
			
				<th>ReportingDate :</th>
				<td><input type="<%=dto != null ? "text" : "date"%>" name="date"
					value="<%=(dto != null) ? dto.getReportingDate() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>Target :</th>
				<td><input type="text" name="target"
					value="<%=(dto != null) ? dto.getTarget() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>LastWeek :</th>
				<td><input type="text" name="lastWeek"
					value="<%=(dto != null) ? dto.getLastWeek(): ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>CurrentWeek :</th>
				<td><input type="text" name="currentWeek"
					value="<%=(dto != null) ? dto.getCurrentWeek() : ""%>"></td>
			</tr>

			&nbsp;
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>
</body>
</html>

</body>
</html>