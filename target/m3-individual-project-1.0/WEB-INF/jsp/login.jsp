<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



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
<h1>Welcome to Restaurant Picker</h1>
<p>Sometimes the toughest decision is "Where are we going to eat?" Behold the amazing benefits of using Restaurant Picker and why you should sign up immediately!</p>
</div>
<div>
	<c:url var="formAction" value="/" />
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
