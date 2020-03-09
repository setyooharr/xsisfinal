<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<div class="box box-primary" >
            <div class="box-header" style=" padding:1; background-color: #1c93f6; color: white;" align="left">
              <h3 class="box-title">Add User</h3>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" align="right">
            <form method="get" id="form-user-add">
            	
      <table>
		<tr>
			<td align="right" valign="middle">*Role Name</td>
			<td>&nbsp;</td>
			<td>
				<select class="form-control" id="idRole" name="idRole" required="required">
				<option value="" disabled selected>-Select Role Name-</option>
				<c:forEach items="${roleModelList}" var="roleModel">
					<option value="${roleModel.id}">${roleModel.nama}</option>
				</c:forEach>
				</select><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Username</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control" placeholder="Type Username"
				type="text" id="username" name="username" pattern="(?=.*\d)(?=.*[a-z]).{8,}" required="required"/><br/>
			</td>
		</tr>

		<tr>
			<td align="right">*Employee Name</td>
			<td>&nbsp;</td>
			<td>
				<select class="form-control" id="idEmployee" name="idEmployee" required="required">
					<option value="" disabled selected>-Select Employee-</option>
					<c:forEach items="${employeeModelList}" var="employeeModel">
						<option value="${employeeModel.id}">${employeeModel.employeeName}</option>
					</c:forEach>
				</select><br>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Password</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control" placeholder="Type Password" 
				type="password" id="rpassword" name="rpassword" pattern="(?=.*[a-z])(?=.*[A-Z]).{8,}" onChange="isPasswordMatch()" required/><br/>
			</td>
		</tr>
		
		<tr>
			<td colspan="4"></td>
			<td align="right" valign="middle">*Re-type Password</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control" placeholder="Re-type Password"
				type="password" id="password" name="password" required/><br/>
				<div id="checkPassword"></div>
			</td>
		</tr>		
	</table>	
	
              <button type="submit" class="btn btn-primary">Save</button>
              <button type="button" data-dismiss="modal" class="btn btn-warning">Cancel</button>
             </form>
            </div>
            <!-- /.box-body -->
	</div>
	<script>
    var password = document.getElementById("password");
    var rpassword = document.getElementById("rpassword");
	function isPasswordMatch() {
		if(password.value != rpassword.value) {
			password.setCustomValidity("Passwords Don't Match");
		  } else {
			  password.setCustomValidity('');
		  }
		}
	rpassword.onchange = isPasswordMatch;
	password.onkeyup = isPasswordMatch;	
	</script>
	