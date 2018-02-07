<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<div>
<h1>Welcome to the clothing store!</h1>
<p>Please login:</p>
</div>
<div>
	<c:url var="formAction" value="/login" />
	<form method="POST" action="${formAction}">
		<div>
			<label for="userName">User Name: </label> <input type="text"
				id="userName" name="userName" placeHolder="User Name"
				class="form-control" />
		</div>
		<div>
			<label for="password">Password: </label> <input type="password"
				id="password" name="password" placeHolder="Password"
				class="form-control" />
		</div>
		<button type="submit" class="resPickerButton">Login</button>
	</form>
	<div>
		<c:url var ="goSignUp" value="/register" />
		<p>Are you a new user? <a href="${goSignUp}">Click here</a> to sign up.</p>
	</div>
</div>
