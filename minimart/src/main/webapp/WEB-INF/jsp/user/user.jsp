<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div>
<br/><br/><br/>
	<div class="panel panel-primary" >
	<div class="panel-heading" style="padding: 1;">
		<h2 class="panel-title">Add User</h2>
	</div>
	<div class="panel panel-default" style="border-color:white; margin-bottom:0;">
		<div class="panel-body" style="padding:10;">
		<ol class="breadcrumb" style="background-color:#f5f5f5;">
			<li><a href="/marcom174/">Home</a></li>
			<li><a href="#">Master</a></li>
			<li class="active">List Product</li>
		</ol>
		<div class="col-md-11"></div>
		<div class="col-md-1">
			<span><button type="button" class="btn btn-primary btn-block" id="button-tambah">Add</button></span>
		</div>		
		
	</div>
	<div class="bos-body">
		<table class="table table-hover" id="table-cari">
			<tr>
					<th>
						<select class="form-control" id="data1" name="data1">
							<option value="">-Select Employee Name-</option>
							<c:forEach items="${employeeModelList}" var="employeeModel">
								<option value="${employeeModel.employeeName}">${employeeModel.employeeName}</option>
							</c:forEach>
						</select>
					</th>
					<th>
						<select class="form-control" id="data2" name="data2">
							<option value="">-Select Role Name-</option>
							<c:forEach items="${roleModelList}" var="roleModel">
								<option value="${roleModel.nama}">${roleModel.nama}</option>
							</c:forEach>
						</select>
					</th>
					<th>
						<select class="form-control" id="data3" name="data3">
							<option value="">-Select Company Name-</option>
							<c:forEach items="${companyModelList}" var="companyModel">
								<option value="${companyModel.companyName}">${companyModel.companyName}</option>
							</c:forEach>
						</select>
					</th>
					<th><input type="text" placeholder="Username" class="form-control" id="data4" name="data4"/></th>	
					
					<th>
						<div class="input-group date" id="data5">
							<input type="text" class="form-control pull-right" name="data5" placeholder="Created"/> 
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</div>
						</div>
					</th>
					<th>
						<input type="text" placeholder="Created By" class="form-control" id="data6" name="data6"/>
					</th>
					<th>
						<button type="button" class="btn btn-warning btn-block" id="button-cari">Search</button>
					</th>
				</tr>
		</table>
			
		<table class="table table-hover" id="table-user">
			<thead>
				<tr>
					<th>No.</th>
					<th>Employee</th>
					<th>Role</th>
					<th>Company</th>
					<th>Username</th>
					<th>Created Date</th>
					<th>Create By</th>
					<th>Action</th>
				</tr>
			
			</thead>
				<tbody id="list-data-user">
					<tr></tr>
				</tbody>
			</table>
			</div>
		</div>
	</div>
	
</div>

<!-- Popup -->
<div id="modal-input" class="modal fade">

	<div class="modal-dialog">
	
	</div>

</div>
<!-- Popup -->

<script>

	listDataUser();

	function listDataUser() {
		$.ajax({
			url:"user/list.html",
			type:"get",
			dataType:"html",
			success: function(result){
				$("#list-data-user").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		
		/* ----- DATA TABLE ----- */
		
		$('#data5').datepicker({
			autoclose: true,
			format: 'dd/mm/yyyy'
		})
		
		var table = $('#table-user').DataTable({
			'sDom':'tip',
			scrollY:        "300px",
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         true,
	        ordering:       false,
	        fixedColumns:   true,
	        lengthChange:   false,
	        autoWidth:      false
		});
		
		//Filter event handler
		
		$("#table-cari").on("click","#button-cari", function(){
			for(var i=1; i<6; i++){
				table.column(i).search($("#data"+i).val()).draw();
				
			}
		});
		$('#data1').select2();
		$('#data2').select2();
		$('#data3').select2();
		
			
		
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"user/add.html",
				type:"get",
				dataType:"html",
				success: function(result){
					$("#modal-input").find(".modal-dialog").html(result);
					$("#modal-input").modal("show");
				}
			});
			
		});
		
			$("#modal-input").on("submit","#form-user-add", function(){
				$.ajax({
					url:"user/add/save.json",
					type:"get",
					dataType:"json",
					data:$(this).serialize(),
					success: function(result){
						$("#modal-input").modal("hide");
						alert("New user has been add with username "+result.userModel.username);
						listDataUser();
					}
				});
				return false;
			});
			
			
			$("#list-data-user").on("click", "#button-detail", function(){
				var idDetail = $(this).val();
				$.ajax({
					url:"user/detail.html",
					type:"get",
					dataType:"html",
					data: {id:idDetail},
					success: function(result){
						$("#modal-input").find(".modal-dialog").html(result);
						$("#modal-input").modal("show");
					}
				});
				
			});
			
			$("#list-data-user").on("click", "#button-delete", function(){
				var idDelete = $(this).val();
				$.ajax({
					url:"user/delete.html",
					type:"get",
					dataType:"html",
					data: {id:idDelete},
					success: function(result){
						$("#modal-input").find(".modal-dialog").html(result);
						$("#modal-input").modal("show");
					}
				});
				
			});
			
			$("#modal-input").on("submit","#form-user-delete", function(){
				$.ajax({
					url:"user/delete/save.json",
					type:"get",
					dataType:"json",
					data:$(this).serialize(),
					success: function(result){
						$("#modal-input").modal("hide");
						alert("Data Deleted ! Data user has been deleted");
						listDataUser();
					}
				});
				return false;
			});
			
			$("#list-data-user").on("click", "#button-edit", function(){
				var idEdit = $(this).val();
				$.ajax({
					url:"user/edit.html",
					type:"get",
					dataType:"html",
					data: {id:idEdit},
					success: function(result){
						$("#modal-input").find(".modal-dialog").html(result);
						$("#modal-input").modal("show");
					}
				});
				
			});
			
			$("#modal-input").on("submit","#form-user-edit", function(){
				$.ajax({
					url:"user/edit/save.json",
					type:"get",
					dataType:"json",
					data:$(this).serialize(),
					success: function(result){
						$("#modal-input").modal("hide");
						alert("Data Updated ! Data user has been updated");
						listDataUser();
					}
				});
				return false;
			});
				
	});
</script>