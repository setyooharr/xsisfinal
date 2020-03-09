<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel-group">
	<div class="panel panel-primary panel-lg" style="width:120%">
           <div class="panel-heading" style="background-color: #1c93f6; color: white;" align="left">
              <h1 class="panel-title">Add Design Request</h1>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <form method="get" id="form-dr-add">
            <div class="panel-body" align="right">
          
      <!-- ----------Design Request---------- -->      	
      <table class="table">
		<tr>
			<td align="right" valign="middle">*Transaction Code</td>
			<td>&nbsp;</td>
			<td><input class="form-control" placeholder="Auto Generated"
				type="text" id="trCode" name="trCode" value="${codeAuto}" disabled="disabled"/><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Request By</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control"	type="text" id="requestBy" name="requestBy" disabled="disabled"/><br/>
			</td>
			
		</tr>

		<tr>
			<td align="right">*Event Code</td>
			<td>&nbsp;</td>
			<td>
				<select class="form-control" id="eventCode" name="eventCode" required="required">
					<option value="" disabled selected>-Select Event-</option>
					<%-- <c:forEach items="${t_eventModelList}" var="t_eventModel">
						<option value="${t_eventModel.id}">${t_event.employeeName}</option>
					</c:forEach> --%>
				</select><br>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Request Date</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control"	type="text" id="requestDate" name="requestDate" disabled="disabled"/><br/>
			</td>
		</tr>
		
		<tr>
			<td align="right" valign="middle">*Design Title</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control" placeholder="Type Title"
				type="text" id="designTitle" name="designTitle" required="required"/><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">Note</td>
			<td>&nbsp;</td>
			<td>
				<textarea class="form-control" rows="3"	placeholder="Type Note" id="note" name="note">
				</textarea><br/>
			</td>
		</tr>		
	</table>
	</div>
	

	<!-- ----------End of Design Request---------- -->
	
	<!-- ----------Add Item---------- -->
	
	<div class="panel-body">
			<input type="hidden" id="nomorBaris" name="nomorBaris"  value="0" />
			<div>
				<button type="button" class="btn btn-primary btn-md add-more" onclick="tambahItem();"><i class="glyphicon glyphicon-plus"></i>&nbsp; Add Item</button>
			</div>
			<div>
			<table class="table" id="table-add-item">
			<tr style="border-bottom-width: 1;">

				<th>Product Name</th>
				<th>Product Description</th>
				<th>Title</th>
				<th>Request PIC</th>
				<th>Due Date</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Note</th>
				<th></th>	
			</tr>
				<tbody id="list-data-item-design-request">
					
				</tbody>
			</table>
			
		</div>
		</div>
			<div class="panel-footer" align="right"> 
	              <button type="submit" class="btn btn-primary">Save</button>
	              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
    		 </div> 
    	</form>
		
    <!-- ----------End fAdd Item---------- -->
	</div>
</div>
	
<script type="text/javascript">
function tambahItem() {
	var table = document.getElementById("table-add-item");
	var row = table.insertRow(1);
	
	var nomorBaris = document.getElementById("nomorBaris").value;
	var tableBaris = table.rows.length - 3;
	var nomor = 0;
	
	if (tableBaris == 0) {
		document.getElementById("nomorBaris").value = tableBaris;
		nomor = tableBaris;
	} else {
		document.getElementById("nomorBaris").value = parseInt(nomorBaris) + 1;
		nomor = parseInt(nomorBaris) + 1;
	}
	
	var productName = row.insertCell(0);
	var productDesc = row.insertCell(1);
	var title = row.insertCell(2);
	var requestPic = row.insertCell(3);
	var dueDate = row.insertCell(4);
	var startDate = row.insertCell(5);
	var endDate = row.insertCell(6);
	var note = row.insertCell(7);
	var action = row.insertCell(8);
	var action2 = row.insertCell(9);
	
	productName.innerHTML = 
		'<select class="form-control" id="productName_'+nomor+'" name="productName_'+nomor+'" required>'
		+'<option value="" disabled selected>-Select Product-</option>'
		+'<c:forEach var="productModel" items="${productModelList}">'							
			+'<option value="${productModel.id}-${productModel.name}">'
				+'${produrctModel.name}'
			+'</option>'
		+'</c:forEach>'
	+'</select>';
	productDesc.innerHTML = '<input type="text" id="productDesc_'+nomor+'" name="productDesc_'+nomor+'" placeholder="Product Description" size="10" class="form-control" disabled/>';
	title.innerHTML = '<input type="text" id="title_'+nomor+'" name="title_'+nomor+'" size="15" placeholder="Type Title" class="form-control" required/>';
	requestPic.innerHTML = '<input type="text" id="requestPic_'+nomor+'" name="requestPic_'+nomor+'" placeholder="PIC" size="5" class="form-control" required/>';
	dueDate.innerHTML = '<input type="text" class="form-control pull-right" name="data3" id="data3" placeholder="Request Date" size="10" required/>';
	startDate.innerHTML = '<input type="text" id="startDate_'+nomor+'" name="startDate_'+nomor+'" placeholder="Start Date" size="10" class="form-control" disabled/>';
	endDate.innerHTML = '<input type="text" id="endDate_'+nomor+'" name="endDate_'+nomor+'" size="10" placeholder="End Date" class="form-control" disabled/>';
	note.innerHTML = '<input type="text" id="note_'+nomor+'" name="note_'+nomor+'" placeholder="Note" size="10" class="form-control" />';
	action.innerHTML = '<button type="button" id="btn-delete" style="background: none; border: 0;"><i class="fa fa-fw fa-pencil"></i></i></button>';
	action2.innerHTML = '<button type="button" id="btn-delete" style="background: none; border: 0;" onclick="hapusItem(this)"><i class="glyphicon glyphicon-trash"></i></button>';

}

function hapusItem(baris) {
     var parentRowIndex = baris.parentNode.parentNode.rowIndex;
     
     document.getElementById("table-add-item").deleteRow(parentRowIndex);
     
}

$(document).ready(function(){
	
	//DUEDATE
    $('#data3').datepicker({
		    autoclose: true,
		    format: 'dd-mm-yyyy'
		 });
	
  
	
	/* $(".add-more").on("click", function(){
		var html = $(".copy-fields").html();
		$(".after-add-more").after(html);	
	});
	
	$("body").on("click",".remove", function(){
		var html = $(".copy-fields").html();
		$(this).parents(".control-group").remove();	
	}); */
	
});

</script>
	 