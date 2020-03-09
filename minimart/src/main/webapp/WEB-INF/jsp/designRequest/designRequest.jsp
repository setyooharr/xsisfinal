<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div>
<br/><br/><br/>
	<div class="panel panel-primary" >
	<div class="panel-heading" style="padding: 1;">
		<h2 class="panel-title">List Design Request</h2>
	</div>
	<div class="panel panel-default" style="border-color:white; margin-bottom:0;">
		<div class="panel-body" style="padding:10;">
		<ol class="breadcrumb" style="background-color:#f5f5f5;">
			<li><a href="/marcom174/">Home</a></li>
			<li><a href="#">Transaksi</a></li>
			<li class="active">Design Request</li>
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
						<input type="text" placeholder="Transaction Code" class="form-control" id="data1" name="data1"/>
					</th>
					<th>
						<input type="text" placeholder="Request By" class="form-control" id="data2" name="data2"/>
					</th>
					<th>
						<div class="input-group date">
							<input type="text" class="form-control pull-right"  name="data3" id="data3" placeholder="Request Date"/>
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</div>
						</div>
					</th>
					<th>
						<input type="text" placeholder="-Assign To-" class="form-control" id="data4" name="data4"/>
					</th>
					<th>
						<input type="text" class="form-control pull-right" id="data5" name="data5" placeholder="Status"/> 
					</th>
					<th>
						<div class="input-group date">
							<input type="text" class="form-control pull-right" id="data6" name="data6" placeholder="Created"/>
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</div>
						</div>
					</th>
					<th>
						<input type="text" class="form-control pull-right" id="data7" name="data7" placeholder="Created By"/> 
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
					<th>Transaction Code</th>
					<th>Request By</th>
					<th>Request Date</th>
					<!-- <th>Assign To</th> -->
					<th>Status</th>
					<th>Created Date</th>
					<th>Created By</th>
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

	<div class="modal-dialog modal-lg">
	
	</div>

</div>
<!-- Popup -->

<script>

listDataDesign();

	function listDataDesign() {
		$.ajax({
			url:"designRequest/list.html",
			type:"get",
			dataType:"html",
			success: function(result){
				$("#list-data-user").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		
		/* ----- DATA TABLE ----- */
		
 		$('#data3,#data6').datepicker({
			autoclose: true,
			format: 'dd/mm/yyyy'
		})
		
		/* var table = $('#table-user').DataTable({
			'sDom':'tip',
			scrollY:        "300px",
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         true,
	        ordering:       false,
	        fixedColumns:   true,
	        lengthChange:   false,
	        autoWidth:      false
		}); */
		
		//Filter event handler
		 
		$("#table-cari").on("click","#button-cari", function(){
			for(var i=1; i<7; i++){
				table.column(i).search($("#data"+i).val()).draw();
				
			}
		});
		/* $('#data1').select2();
		$('#data2').select2();
		$('#data3').select2(); */
		
			
		
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"designRequest/add.html",
				type:"get",
				dataType:"html",
				success: function(result){
					$("#modal-input").find(".modal-dialog").html(result);
					$("#modal-input").modal("show");
				}
			});
			
		});
		
			$("#modal-input").on("submit","#form-dr-add", function(){
				$.ajax({
					url:"designRequest/add/save.json",
					type:"get",
					dataType:"json",
					data:$(this).serialize(),
					success: function(result){
						$("#modal-input").modal("hide");
						alert("Data Saved! New Design has been add with code "+result.designModel.code);
						listDataDesign();
					}
				});
				return false;
			});
			
			 $("#list-data-user").on("click", "#button-detail", function(){
			      var idDetail = $(this).val();
			      $.ajax({
			        url:"designRequest/detail.html",
			        type:"get",
			        dataType:"html",
			        data: {id:idDetail},
			        success: function(result){
			          $("#modal-input").find(".modal-dialog").html(result);
			          $("#modal-input").modal("show");
			        }
			        
			      });
			      
			  });
							
	});
</script>