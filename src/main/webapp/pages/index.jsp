<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report-App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">ReportApplication</h3>

		<form:form action="search" modelAttribute="searchkey" method="POST">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${name}"/>
						</form:select></td>

					<td>Plan status :</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}"/>
						</form:select></td>

					<td>Gender :</td>
					<td>
						<form:select path="gender"> <!-- Correct path attribute -->
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><form:input type ="date" path="startDate" /></td>

					<td>End Date :</td>
						<td><form:input type ="date" path="endDate" /></td>			
				</tr>
				<tr>
				 <td><a href="/" class="btn btn-primary">Reset</a></td>
					<td><input type="submit" value="search" class="btn btn-primary"/></td>
				</tr>
			</table>
	

	</form:form>
	<hr/>
	<table class="table table-striped" class="table table-striped-columns">
	<thead>
	<tr>
	<td>S.No</td>
    <td>Holder Name</td>
	<td>Plan Name</td>
	<td>Gender</td>
	<td>Plan Status</td>
	<td>Start Date</td>
	<td>End Date</td>
	<td>Benifit Amt</td>
	</tr>
	</thead>
	
	<c:forEach items ="${key}" var ="plan" varStatus="index">
	<tr>
	<td>${index.count}</td>
	<td>${plan.name}</td>
	<td>${plan.palnName}</td>
	<td>${plan.gender}</td>
	<td>${plan.planStatus}</td>
	<td>${plan.planStartDate}</td>
	<td>${plan.planEndDate}</td>
	<td>${plan.benifitamount}</td>
	</tr>
	
	</c:forEach>
	<tr>
    <c:if test="${empty key}">
        <td colspan="8" style="text-align: center">No Record found</td>
    </c:if>
</tr>

	</tbody>
	</table>
    <hr/>
    Export :<a href="excel" class="btn btn-primary" >Excel</a>     <a href="pdf" class="btn btn-primary">Pdf</a>
    </div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</body>
</html>