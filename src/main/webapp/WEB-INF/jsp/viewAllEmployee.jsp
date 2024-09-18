<!DOCTYPE html>
<html lang="en">
<head>
<title>View All Employee</title>
 <jsp:include page="./includes/commonStyleIncludes.jsp" />
<jsp:include page="./includes/commonheaderJsIncludes.jsp" />

</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
    .employee-grid {
        padding:10px;
    }
    .employee-item {
        border: 1px solid #ccc;
        padding: 10px;
        border-radius: 5px;
        background-color: #f9f9f9;
        margin-bottom: 8px;
    }
    .employee-name {
        font-weight: bold;
    }
</style>

</head>

<body>
<jsp:include page="./includes/header.jsp" />
	<div id="wrapper ">
		<div id="page-wrapper">
			<div class="container-fluid">
				<h4 class="page-header" style="margin-left: 20px ; margin-top: 20px;">View All Employee</h4>

				<div class="col-lg-12 PadTop5">
                    <div class="employee-grid">
                        <c:forEach var="employee" items="${allEmployees}">
                            <div class="employee-item">
                                <div class="employee-name">Name: ${employee.name}</div>
                                <div class="employee-sex">Sex: ${employee.sex}</div>
                                <div class="employee-age">Age: ${employee.age}</div>
                            </div>
                        </c:forEach>
                    </div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>