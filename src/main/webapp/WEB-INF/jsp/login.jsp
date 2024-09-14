<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link href="css/login.css" rel="stylesheet" />
</head>
<body>

<div class="content">
 <div class="text">Login</div>
  <form name="login" id="login" method="POST">
    <div class="field">
      <span class="fa fa-user"></span>
      <input type="email" name="name" placeholder="Email Id" required/>
    </div>
    <div class="field">
      <span class="fa fa-lock"></span>
      <input  type="password" name="password" placeholder="Password" required/>
    </div>
    
    <div class="auth-error">${error}</div> 
	
    <button type="submit">Log in</button>
    
  </form>
</div>

</body>
</html>
