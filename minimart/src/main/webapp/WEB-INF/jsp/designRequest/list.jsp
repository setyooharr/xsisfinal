<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<c:forEach items="${designModelList}" var="designModel" varStatus="number">
	<tr>
		<td>${number.count}</td>
		<td>${designModel.code}</td>
		<td>${designModel.requestByUser.username}</td>	
		<td><fmt:formatDate value="${designModel.requestdate}" pattern="dd/MM/yyyy"/></td>
		<!-- <td> </td> -->
		<td><c:choose>
				<c:when test="${designModel.status == 1}">
					Submitted
				</c:when>
				<c:when test="${designModel.status == 2}">
					In Progress
				</c:when>
				<c:when test="${designModel.status == 3}">
					Received By Requester
				</c:when>
				<c:when test="${designModel.status == 4}">
					Settlement
				</c:when>
				<c:when test="${designModel.status == 5}">
					Approved Settlement
				</c:when>
				<c:when test="${designModel.status == 6}">
					Close Request
				</c:when>
				<c:when test="${designModel.status == 0}">
					Rejected
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose></td>
		<td><fmt:formatDate value="${designModel.createdDate}" pattern="dd/MM/yyyy"/></td>
		<td>${designModel.createdByUser.username}</td>
		<td>
			<button style="border: none;padding: 0;background: none;" type="button" id="button-detail" value="${designModel.id}">
				<i class="fa fa-search"></i>
			</button>
			<button style="border: none;padding: 0;background: none;" type="button" id="button-edit" value="${designModel.id}">
				<i class="fa fa-pencil"></i>
			</button>
		</td>
	</tr>
</c:forEach>