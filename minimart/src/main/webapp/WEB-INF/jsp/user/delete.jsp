<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="box box-default box-solid" style="width: fit-content; position: absolute;top: 50%;left: 50%;">
	<div class="box-header" align="left">
              <h3 class="box-title">Delete Data ?</h3>

              <div class="box-tools pull-right">
                <button type="button" style="background-color: red" class="btn btn-box-tool" data-dismiss="modal"><i class="fa fa-times"></i></button>
              </div>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" align="center">
            <form method="get" id="form-user-delete">
            	<input type="hidden" id="id" name="id" value="${userModel.id}" />
              <button type="submit" class="btn btn-primary">Delete</button>
              <button type="button" data-dismiss="modal" class="btn btn-warning">Cancel</button>
             </form>
            </div>
            <!-- /.box-body -->
	</div>	