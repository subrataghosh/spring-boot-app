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

                     <div class="mb-2 mt-2">
                          <h4>Dependents</h4>
                          <div id="dependents">
                              <div class="dependent" id="dependent-0">
                                  <label for="dependents[0].name">Dependent Name:</label>
                                  <input class="" type="text" name="dependents[0].name" required/>

                                  <label for="dependents[0].relation">Relation:</label>
                                  <input class="" type="text" name="dependents[0].relation" required/>
                                  <button type="button" class="remove-dependent" style="display:none;">Remove</button>
                              </div>
                          </div>

                          <button class="btn btn-secondary" type="button" id="add-dependent-btn">Add Dependent</button>
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

     var dependentIndex = 1;

     function addDependent() {
         var newDependentDiv = `
             <div class="dependent" id="dependent-${dependentIndex}">
                 <label for="dependents[${dependentIndex}].name">Dependent Name:</label>
                 <input type="text" name="dependents[` + dependentIndex + `].name" required/>

                 <label for="dependents[` + dependentIndex + `].relation">Relation:</label>
                 <input type="text" name="dependents[` + dependentIndex + `].relation" required/>

                 <button type="button" class="remove-dependent">Remove</button>
             </div>
         `;

         $('#dependents').append(newDependentDiv);

         dependentIndex++;
     }

     function removeDependent(button) {
         $(button).closest('.dependent').remove();
     }

     $('#add-dependent-btn').on('click', function() {
         addDependent();
     });

     $(document).on('click', '.remove-dependent', function() {
         removeDependent(this);
     });

</script>
</html>