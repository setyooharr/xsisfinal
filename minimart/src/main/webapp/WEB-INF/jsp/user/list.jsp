<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<c:forEach items="${userModelList}" var="userModel" varStatus="number">"src/main/webapp/WEB-INF/jsp/product/list.jsp"
	<tr>
		<td>${number.count}</td>
		<td>${userModel.employeeModel.employeeName}</td>
		<td>${userModel.roleModel.nama}</td>
		<td>${userModel.employeeModel.companyModel.companyName}</td>
		<td>${userModel.username}</td>
		<td>
			<fmt:formatDate value="${userModel.createdDate}" pattern="dd/MM/YYYY"/>
		</td>
		
		<td>${userModel.createdBy}</td>
		<td>
			<button type="button" style="background: none; border: 0;" id="button-detail" value="${userModel.id}"><i class="fa fa-fw fa-search"></i></button>
			<button type="button" style="background: none; border: 0;" id="button-edit" value="${userModel.id}"><i class="fa fa-fw fa-pencil"></i></button>
			<button type="button" style="background: none; border: 0;" id="button-delete" value="${userModel.id}"><i class="glyphicon glyphicon-trash"></i></button>
		</td>
	</tr>
</c:forEach>