<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #285374!important">
  <!-- <a class="navbar-brand" href="#">Navbar</a> -->
  <img style="height:60px" src="img/logo-img.jpg" />
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link text-white" href="/homePage">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="/employee">Employee</a>
      </li>
    </ul>
  </div>
   <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
             <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		           Hi, Admin
		        </a>
		        <div class="dropdown-menu">
		          <a class="dropdown-item" href="/logout">Logout</a>
		        </div>
		      </li>
        </ul>
    </div>
</nav>
            
            