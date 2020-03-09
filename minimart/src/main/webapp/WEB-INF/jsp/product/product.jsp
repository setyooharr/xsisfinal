<br/><br/><br/>
<div class="box box-primary box-solid">
	<div class="box-header with-border">
		<h3 class="box-title">List Product</h3>
	</div>
	<!-- box header -->
	<div class="panel panel-default" style="border-color: white; margin-bottom: 0px;">
		<div class="panel-body" style="padding: 10px;">
			<ol class="breadcrumb" style="background-color: #f5f5f5;">
		        <li><a href="/marcom174/"> Home</a></li>
		        <li><a href="#">Master</a></li>
		        <li class="active">List Product</li>
      		</ol>
		</div>
		
		<div class="row">
		  <div class="col-md-11"></div>
		  <div class="col-md-1">
				<button type="button" id="button-add" class="btn btn-info">Add</button>
			</div>
		</div>
	</div>
	<!-- panel -->
	
	<div class="box-body">
	
		
		 
		 <!-- FORM SEARCH -->
		
		 <table class="table table-hover" id="table-product-search">
			<thead>
				<tr>
					<th>
							<input class="form-control" type="text" id=data1 name="data1" placeholder="Product Code"/> 
						
					</th>					
					<th>
							<input class="form-control" type="text" id="data2" name="data2" placeholder="Product Name"/> 
						
					</th>
					<th>
							<input class="form-control" type="text" id="data3" name="data3" placeholder="Description"/> 
						
					</th>
					<th>
						<div class="input-group date">
							<input type="text" class="form-control pull-right" id="data4" name="data4" placeholder="Created"/> 
							
							<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</div>
						</div>
					</th>
					<th>
							<input class="form-control" type="text" id="data5" name="data5" placeholder="Created By"/> 
						
					</th>
					<th>
						<button type="button" id="button-search" style="size: 5" class="btn btn-warning btn-block">
						<span class="glyphicon glyphicon-search"></span>Search</button>
					</th>
				</tr>
			</thead>
		 </table>
		
		 
		 
		<table class="table table-hover" id="table-product">
			<thead>	
				
				<tr>
					<th>No.</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Action</th>
					
				</tr>
			</thead>
			
			<tbody id="list-data-product">
			
			</tbody>
		</table>
	</div>
</div>

<!-- Pop-Up -->
<div id="modal-input" class="modal fade">
	<div class="modal-dialog">
		
	</div>
</div>
<!-- Pop-Up -->

<script>

	
	listDataProduct();

	function listDataProduct() {
		$.ajax({
			url: "product/list.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});		
	}

	$(document).ready(function(){
		
		 //////////////////DATA TABLE-----------------------
		// Setup - add a text input to each footer cell
	 
	 	
	 	// DataTable
	 	
	 	$('#data4').datepicker({
		    autoclose: true,
		    format: 'dd/mm/yyyy'
		 });
		

	    var table = $('#table-product').DataTable( {
	        'sDom':'tip',
	        
	    	scrollY:        "300px",
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         true,
	        ordering:       false,
	        fixedColumns:   true,
	        lengthChange:   false,
	        autoWidth:      true
	    } );
	 
	    // Filter event handler
	    
	    $("#table-product-search").on("click", "#button-search", function() {
	    	for (var i = 1; i < 6; i++) {
	    		table.column(i).search($("#data"+ i).val()).draw();
			}
	    	
	    });
	    
	    
	    /* $( "#table-product-search").on("click", "#", function () {
	        table
	            .column( $(this).data('index') )
	            .search( this.value )
	            .draw();
	    } ); */
	    //////////////////DATA TABLE-----------------------
		////////////////////////////////////////////////////
	    
	    
	    
		$("#button-add").on("click", function(){
			$.ajax({
				url: "product/add.html",
				type: "get",
				dataType: "html",
				success: function(result){
					$("#modal-input").find(".modal-dialog").html(result);
					$("#modal-input").modal("show");					
				}				
			});
		});	
		
		
		
		$("#modal-input").on("submit","#form-product-add", function(){
			
			var nameProduct = document.getElementById("name");
			var alertNameProduct = document.getElementById("alertNameProduct");
			
			if (nameProduct.value=="") {
				nameProduct.style.borderColor="red";
				alertNameProduct.style.display="block";
				return false;
			} else {
				nameProduct.style.borderColor="inherit";
				alertNameProduct.style.display="none";
			}
			$.ajax({
				url: "product/add/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Saved! New Product has been add with code" + result.productModel.code);
					listDataProduct();
				}				
			});
			return false;
		});	
		
		$("#modal-input").on("submit","#form-product-edit", function(){
			var nameProduct = document.getElementById("name");
			var alertNameProduct = document.getElementById("alertNameProduct");
			
			if (nameProduct.value=="") {
				nameProduct.style.borderColor="red";
				alertNameProduct.style.display="block";
				return false;
			} else {
				nameProduct.style.borderColor="inherit";
				alertNameProduct.style.display="none";
			}
			$.ajax({
				url: "product/edit/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Updated! New Product has been updated with code" + result.productModel.code);
					listDataProduct();
				}				
			});
			return false;
		});
		
		$("#modal-input").on("submit","#form-product-delete", function(){
			$.ajax({
				url: "product/delete/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-input").modal("hide");					
					alert("Data Deleted! Data Product has been add with code " +  result.productModel.code + " has been deleted!");
					listDataProduct();
				}				
			});
			return false;
		});

	
	$("#list-data-product").on("click", "#button-detail", function(){
		var idDetail = $(this).val();
		$.ajax({
			url: "product/detail.html",
			type: "get",
			dataType: "html",
			data: {id:idDetail},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
	
	$("#list-data-product").on("click", "#button-edit", function(){
		var idDetail = $(this).val();
		$.ajax({
			url: "product/edit.html",
			type: "get",
			dataType: "html",
			data: {id:idDetail},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});
	
	$("#list-data-product").on("click", "#button-delete", function(){
		var idDelete = $(this).val();
		$.ajax({
			url: "product/delete.html",
			type: "get",
			dataType: "html",
			data: {id:idDelete},
			success: function(result){
				$("#modal-input").find(".modal-dialog").html(result);
				$("#modal-input").modal("show");					
			}				
		});	
	});	
	
	
	//JS SEARCH---di pakai klo tdk pake datatable
	/* $("#form-product-search").on("submit", function(){
		var codeSearch = document.getElementById("codeSearch").value;
		
		$.ajax({
			url: "product/search/code.html",
			type: "get",
			dataType: "html",
			data : {codeSearch:codeSearch},
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});
		return false;
		
	});	
	
	$("#form-product-search").on("submit", function(){
		var nameSearch = document.getElementById("nameSearch").value;
		$.ajax({
			url: "product/search/name.html",
			type: "get",
			dataType: "html",
			data : {nameSearch:nameSearch},
			success: function(result){
				$("#list-data-product").html(result);					
			}				
		});
		return false;
		
	});	 */
	
	
	
});
</script>