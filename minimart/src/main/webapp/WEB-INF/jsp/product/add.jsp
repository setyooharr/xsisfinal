<div class="panel panel-primary">
	<div class="panel-heading">Add Product</div>
	<form method="get" id="form-product-add">
		<div class="panel-body">
			<table class="table" >
				<tr>
					<td>
						Product Code	:
					</td>
					<td>
						 <input type="text" id="code" name="code" class="form-control" value="${codeAuto}"/>
					</td>
				</tr>
				<tr>
					<td>
						Product Name	:
					</td>
					<td>
						 <input type="text" id="name" name="name" class="form-control" placeholder="Type Product Name"/>
						<a style="font-size: small; color: red; display: none;" id="alertNameProduct">Name must be filled out!</a>
					</td>
				</tr>
				<tr>
					<td>
						Description 	:
					</td>
					<td>
						<input type="text" id="description" name="description" class="form-control" placeholder="Type Description"/>
					</td>
				
				</tr>
				
			</table>
		
		</div>
			<div class="panel-footer"> 
	              <button type="submit" class="btn btn-primary">Save</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
	     		 <!--  <button type="reset" class="btn btn-warning">Reset</button> -->
    		 </div> 
					
	</form>

</div>


