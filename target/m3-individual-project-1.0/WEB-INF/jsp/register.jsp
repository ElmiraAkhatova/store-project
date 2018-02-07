<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
		
		$.validator.addMethod('hasUppercase', function(value) {
			return value.match(/[A-Z]/); 		// does this string have any single character from this set?
		}),
		
		$.validator.addMethod('hasLowercase', function(value) {
			return value.match(/[a-z]/); 		// does this string have any single character from this set?
		}),

		$.validator.addMethod('hasDigit', function(value) {
			return value.match(/[0-9]/); 		// does this string have any single character from this set?
		}),

		$.validator.addMethod('hasSpecial', function(value) {
			return value.match(/![A-Za-z0-9]/); 		// does this string have any single character from this set?
		}),
	
		$("form").validate({
			
			rules : {
				firstName : {
					required : true,
				},
				lastName : {
					required : true,
				},
				userName : {
					required : true,
				},
				password : {
					minlength : 10,
					required : true,
					hasUppercase: true,
					hasLowercase: true,
					hasDigit: true,
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password",  
				},
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match",
				},
				password : {
					hasUppercase : "You need at least one uppercase character",
					minlength : "Your password is too short. It must be at least 10 characters",
				},
			},
			errorClass : "error"
		});
	});
</script>

<c:url var="formAction" value="/register" />
<form method="POST" action="${formAction}">
	<div>
		<div>
			<label for="firstName">First Name: </label> <input type="text"
				id="firstName" name="firstName" placeHolder="First Name" />
		</div>
		<div>
			<label for="lastName">Last Name: </label> <input type="text"
				id="lastName" name="lastName" placeHolder="Last Name" />
		</div>
		<div>
			<label for="userName">User Name: </label> <input type="text"
				id="userName" name="userName" placeHolder="User Name" />
		</div>
		<div>
			<label for="password">Password: </label> <input type="password"
				id="password" name="password" placeHolder="Password" />
		</div>
		<div>
			<label for="confirmPassword">Confirm Password: </label> 
			<input type="password" id="confirmPassword" name="confirmPassword"
			placeHolder="Re-Type Password" />
		</div>
		<button type="submit" class="resPickerButton">Sign Me Up!</button>
	</div>
</form>
