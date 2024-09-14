<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Employee</title>
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
			<div class="card" style="margin-top: 20px;">
			<div class="card-body">
			 <h4>Add Employee Details</h4>
				<div class="card"  style="margin-top: 20px;">
				  <div class="card-body">
				    <form name="addEmployee" id="addEmployee" modelAttribute="Employee" class="form-group" method="POST">
					  <div class="form-row">
					    <div class="form-group col-md-4">
					      <label for="inputName">Employee Name</label>
					      <input type="text" class="form-control" id="inputName" placeholder="Employee Name" name="name">
					    </div>
					    <div class="form-group col-md-4">
                          <label for="inputAge">Employee Age</label>
                          <input type="text" class="form-control" id="inputAge" placeholder="Employee Age" name="age">
                        </div>
                        <div class="form-group col-md-4">
                          <label for="inputSex">Employee Sex</label>
                          <input type="text" class="form-control" id="inputSex" placeholder="Employee Sex" name="sex">
                        </div>
					  </div>
					  <button type="submit"  id="addDevice" class="btn btn-primary">Submit</button>
					  <button type="reset" class="btn btn-default"
									onclick="window.location.reload(true);">Reset</button>
	               </form>
				  </div>
				</div>

				 </div>
				</div>
			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
</script>
</html>