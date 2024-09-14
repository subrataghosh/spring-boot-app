<!DOCTYPE html>
<html lang="en">
<head>
<title>Employee</title>
 <jsp:include page="./includes/commonStyleIncludes.jsp" />
<jsp:include page="./includes/commonheaderJsIncludes.jsp" />

</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

</head>

<body>
<jsp:include page="./includes/header.jsp" />
	<div id="wrapper ">
		<div id="page-wrapper">
			<div class="container-fluid">

				<h4 class="page-header" style="margin-left: 20px ; margin-top: 20px;">Employee Details</h4>

					<div class="col-lg-12 PadTop5">
						<div id="gridView" class="table-responsive SpaceTab">
							<table class="table table-bordered" width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<thead class="theadBg">
									<tr>
										<td>Id</td>
                                        <td>Name</td>
                                        <td>Age</td>
                                        <td>Sex</td>
                                        <td>Action</td>
									</tr>
								</thead>
								<c:forEach items="${allEmployees}" var="employee">
                                    <tr>
                                        <td>${employee.id}</td>
                                        <td>${employee.name}</td>
                                        <td>${employee.age}</td>
                                        <td>${employee.sex}</td>
                                        <td><a href="/viewEmployee" >View</a></td>

                                    </tr>
                                </c:forEach>
							</table>
						</div>
					</div>
					<a href="/addEmployee" class="btn btn-primary" style="margin-left: 17px">Add Employee</a>
			</div>
		</div>
	</div>
</body>
</html>