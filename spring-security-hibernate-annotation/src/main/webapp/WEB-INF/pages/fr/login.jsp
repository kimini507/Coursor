<!-- LOGIN -->
<div class="row">
	<div class="col-md-4">
	</div>
	<div class="col-md-4">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name='LOGIN_FORM' action="<c:url value='/login' />" method='POST'>
			<div class="form-group">
				 
				<label for="USERNAME">
					Username
				</label>
				<input type="text" class="form-control" id="USERNAME" value="<c:if test="${not empty username}">${username}</c:if>" name="username" placeholder="Username">
			</div>
			<div class="form-group">
				 
				<label for="PASSWORD">
					Password
				</label>
				<input type="password" class="form-control" id="PASSWORD" name="password" placeholder="Password">
			</div>
			<div class="checkbox">
				 
				<label>
					<input type="checkbox" id="REMEMBER_ME" name="rememberMe"> Remember me
				</label>
			</div> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit" class="btn btn-default">
				Log In
			</button>
		</form>
	</div>
	<div class="col-md-4">
	</div>
</div>
