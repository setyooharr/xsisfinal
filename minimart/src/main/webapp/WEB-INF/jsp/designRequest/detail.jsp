<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel-group">
	<div class="panel panel-primary panel-lg" style="width:120%">
           <div class="panel-heading" style="background-color: #1c93f6; color: white;" align="left">
              <h1 class="panel-title">Design Detail Request</h1>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <form method="get" id="form-dr-detail">
            <div class="panel-body" align="right">
          
      <!-- ----------Design Request---------- -->      	
      <table class="table">
		<tr>
			<td align="right" valign="middle">*Transaction Code</td>
			<td>&nbsp;</td>
			<td><input type="hidden" name="id" id="id" value="${designItemModel.id}"/>
				<input class="form-control" placeholder="Auto Generated"
				type="text" id="trCode" name="trCode" value="${codeAuto}" readonly="readonly"/><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Request By</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control"	type="text" id="requestByUser" name="requestByUser" value="${requestByUser.username}" readonly="readonly"/><br/>
 				<input class="form-control"	type="hidden" id="requestBy" name="requestBy" value="${requestBy}" readonly="readonly"/><br/>
			</td>
			
		</tr>

		<tr>
			<td align="right">*Event Code</td>
			<td>&nbsp;</td>
			<td>
				<select class="form-control" id="eventCode" name="eventCode" disabled>
					<c:forEach items="${eventModelList}" var="eventModel">
						<option value="${eventModel.id}"${eventModel.id == designModel.tEventId ? 'selected="true"':''}>
							${eventModel.code}</option>
					</c:forEach>
				</select><br>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">*Request Date</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control"	type="text" id="requestDate" name="requestDate" value="${requestDate}" readonly="readonly"/><br/>
			</td>
		</tr>
		
		<tr>
			<td align="right" valign="middle">*Design Title</td>
			<td>&nbsp;</td>
			<td>
				<input class="form-control" type="text" id="designTitle" name="designTitle" value="${designModel.code}" readonly/><br/>
			</td>
			<td>&nbsp;</td>
			<td align="right" valign="middle">Note</td>
			<td>&nbsp;</td>
			<td>
				<textarea class="form-control" rows="4" id="note" name="note" readonly>
				${designModel.note}
				</textarea><br/>
			</td>
		</tr>
		<tr>
			<td align="right" valign="middle">Status</td>
			<td>&nbsp;</td>
			<td>
				<input type="text" id="status" name="status" class="form-control" value="${designModel.status}" readonly>
			</td>
		</tr>		
	</table>
	</div>

	<!-- ----------End of Design Request---------- -->
	
	<!-- ----------Add Item---------- -->
	
	<div class="panel-body">
			<input type="hidden" id="nomorBaris" name="nomorBaris"  value="0" />
			<div>
			<table class="table" id="table-add-item">
			<tr style="border-bottom-width: 1;">

				<th>Product Name</th>
				<th>Title</th>
				<th>Request PIC</th>
				<th>Due Date</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Note</th>	
			</tr>
				<c:forEach items="${designModel.designDetailModelList}" var="designDetailModel">
					<tr>
						<td>
							<input class="form-control" type="text" value="${designDetailModel.productModel.name}" disabled="disabled">
						</td>
						<td>
							<input class="form-control" type="text" value="${designDetailModel.titleItem}" size="5" disabled="disabled">
						</td>
						<td>
							<input class="form-control" type="text" value="${designDetailModel.requestPic}" disabled="disabled">
						</td>
						<td>
							<input class="form-control" type="text" value="<fmt:formatDate value="${designDetailModel.requestDueDate}" pattern="dd/MM/yyyy"/>" disabled="disabled"/>
						</td>
						<td>
							<input class="form-control" type="text" value="DD/MM/YYYY" disabled="disabled">
						</td>
						<td>
							<input class="form-control" type="text" value="DD/MM/YYYY" disabled="disabled">
						</td>
						<td>
							<input class="form-control" type="text" value="${designDetailModel.note}" disabled="disabled">
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		</div>
			<div class="panel-footer" align="right"> 
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
	var tableBaris = table.rows.length - 2;
	var nomor = 0;
	
	if (tableBaris == 0) {
		document.getElementById("nomorBaris").value = tableBaris;
		nomor = tableBaris;
	} else {
		document.getElementById("nomorBaris").value = parseInt(nomorBaris) + 1;
		nomor = parseInt(nomorBaris) + 1;
	}
	
	var productName = row.insertCell(0);
	/* var productDesc = row.insertCell(1); */
	var title = row.insertCell(1);
	var requestPic = row.insertCell(2);
	var dueDate = row.insertCell(3);
	var startDate = row.insertCell(4);
	var endDate = row.insertCell(5);
	var note = row.insertCell(6);
	var action = row.insertCell(7);
	var action2 = row.insertCell(8);
	
	productName.innerHTML = 
		'<select class="form-control" id="productName_'+nomor+'" name="productName_'+nomor+'" required>'
		+'<option value="" disabled selected>-Select Product-</option>'
		+'<c:forEach var="productModel" items="${productModelList}">'							
			+'<option value="${productModel.id}-${productModel.name}">'
				+'${productModel.name}'
			+'</option>'
		+'</c:forEach>'
	+'</select>';
	/* productDesc.innerHTML = '<input type="text" id="productDesc_'+nomor+'" name="productDesc_'+nomor+'" size="5" style="font-size: x-small;" class="form-control" value="${designDetailModel.productModel.description}"/>'; */
	title.innerHTML = '<input type="text" id="title_'+nomor+'" name="title_'+nomor+'" size="15" style="font-size: x-small;" class="form-control" />';
	requestPic.innerHTML = '<input type="text" id="requestPic_'+nomor+'" name="requestPic_'+nomor+'" size="5" style="font-size: x-small;" class="form-control" />';
	dueDate.innerHTML = '<input type="date" date="dd-MM-yyyy" id="dueDate_'+nomor+'" name="dueDate_'+nomor+'" size="15" style="font-size: x-small;" class="form-control" />';
	startDate.innerHTML = '<input type="text" id="startDate_'+nomor+'" name="startDate_'+nomor+'" size="15" style="font-size: x-small;" class="form-control" readonly="readonly"/>';
	endDate.innerHTML = '<input type="text" id="endDate_'+nomor+'" name="endDate_'+nomor+'" size="15" style="font-size: x-small;" class="form-control" readonly="readonly" />';
	note.innerHTML = '<input type="text" id="note_'+nomor+'" name="note_'+nomor+'" size="15" style="font-size: x-small;" class="form-control" />';
	action.innerHTML = '<button type="button" id="btn-delete" style="background: none; border: 0;"><i class="fa fa-fw fa-pencil"></i></i></button>';
	action2.innerHTML = '<button type="button" id="btn-delete" style="background: none; border: 0;" onclick="hapusItem(this)"><i class="glyphicon glyphicon-trash"></i></button>';

}

function hapusItem(baris) {
     var parentRowIndex = baris.parentNode.parentNode.rowIndex;
     document.getElementById("table-add-item").deleteRow(parentRowIndex);
     
}

$(document).ready(function(){
	
	//DUEDATE
  /*   $('#dueDate_').datepicker({
		    autoclose: true,
		    format: 'dd-mm-yyyy'
		 });
	 */

});
</script>
	 