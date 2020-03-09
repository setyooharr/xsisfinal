<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<div class="box box-default box-solid" style="width: fit-content;">
            <div class="box-header" style=" padding:1; background-color: #1c93f6; color: white;" align="left">
              <h3 class="box-title">Edit User - ${userModel.employeeModel.employeeName} (${userModel.username})</h3>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" align="right">
            <form method="get" id="form-user-detail">
           <input type="hidden" id="id" name="id" value="${userModel.id}">      	
      <table>
      		<tr>
			<td align="right" valign="middle">*Role Name</td>
			<td>&nbsp;</td>
			<td>
			<select class="form-control" id="idRole" name="idRole" disabled="disabled">
				<c:forEach items="${roleModelList}" var="roleModel">
					<option value="${roleModel.id}" ${roleModel.id == userModel.idRole ? 'selected="true"':'' }>
					${roleModel.nama}</option>
				</c:forEach>
				</select><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Username</td>
			<td>&nbsp;</td>
			<td>
				<input type="text" class="form-control" id="username" name="username" value="${userModel.username}" disabled="disabled" />
				<br/>
			</td>
		</tr>
		
		<tr>
			<td align="right">*Employee Name</td>
			<td>&nbsp;</td>
			<td>	
			<select class="form-control" id="idEmployee" name="idEmployee" disabled="disabled">
				<c:forEach items="${employeeModelList}" var="employeeModel">
					<option value="${employeeModel.id}" ${employeeModel.id == userModel.idEmployee ? 'selected="true"':''}>
						${employeeModel.employeeName}
					</option>
				</c:forEach>
			</select>
			<br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Password</td>
			<td>&nbsp;</td>
			<td>
				<input type="password" class="form-control" id="rpassword" name="rpassword" value="${userModel.password}" disabled="disabled" />
				<br/> 
			</td>
		</tr>
		
		<tr>
			<td colspan="4"></td>
			<td align="right" valign="middle">*Re-type Password</td>
			<td>&nbsp;</td>
			<td>
				<input type="password" class="form-control" id="password" name="password" value="${userModel.password}" disabled="disabled" />
				<br/>
			</td>
		</tr>		
	
      </table>
      		
		<button type="button" data-dismiss="modal" class="btn btn-warning">Cancel</button>
	
            </form>	
            </div>    
		
	</div>
