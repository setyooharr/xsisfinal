
<nav class="navbar" style="height: 100%; position: fixed;"
	role="navigation">
	<aside class="main-sidebar">

		<section class="sidebar">
			<ul class="sidebar-menu">
				<li class="header">Smart POS</li>
				
				<c:forEach items ="${menuModelList}" var="menuModel">
					<a href="${contextName}/${menuModel.controller}.html">
						${menuModel.nama}
					</a> 
					<br/>
				</c:forEach>	
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</nav>