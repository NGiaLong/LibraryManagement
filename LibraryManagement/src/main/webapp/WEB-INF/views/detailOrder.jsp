<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="layouts/top.jsp"></jsp:include>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home">
						<use xlink:href="#stroked-home"></use></svg></a></li>
		</ol>
	</div>
	<!--/.row-->
	<div class="header">
		<h1>CHI TIẾT ĐƠN MƯỢN SÁCH</h1>
	</div>
	<hr>
	<c:if test="${success != null }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<div id="page-wrapper" style="height: 100%">
		<div class="container-fluid">
			<div class="row">
				<div class="form-group col-sm-6 ">
					<label class="control-label col-sm-4">Mã đơn mượn sách:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-book"></i></span> <input type="text"
							class="form-control" id="id" name="id" placeholder="Mã sách"
							readonly="true" value="${order.getId() }" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6 ">
					<label class="control-label col-sm-4">Tên bạn đọc:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							class="form-control" readonly="true"
							value="${order.getStudentName() }" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Tên nhân viên:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-file"></i></span> <input type="text"
							class="form-control" id="description" name="description"
							readonly="true" value="${order.getStaffName()}" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Ngày mượn:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							class="form-control" id="author" name="author" readonly="true"
							value="${order.getDatePurchase()}" />
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Ngày hết hạn:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input type="text"
							class="form-control" id="edition" name="edition" readonly="true"
							value="${order.getDateExpire()}" />
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<table id="example" class="display">
					<thead>
						<th>STT</th>
						<th>Mã sách</th>
						<th>Tên sách</th>
						<th>Tác giả</th>
						<th>Tình trạng</th>
						<th>Ngày trả</th>
						<th></th>
					</thead>
					<tbody>
						<%
							int i = 1;
						%>
						<c:forEach var="listValue" items="${detailList}">
							<tr>
								<td><%=i%></td>
								<td>${listValue.getBookId()}</td>
								<td>${listValue.getBookTitle()}</td>
								<td>${listValue.getBookAuthor()}</td>
								<td><c:choose>
										<c:when test="${listValue.isStatus()}">
											<c:out value="Đã trả"></c:out>
										</c:when>
										<c:otherwise>
											<c:out value="Chưa trả"></c:out>
										</c:otherwise>
									</c:choose></td>
								<td>${listValue.getDatePaid()}</td>
								<td><c:choose>
										<c:when test="${listValue.isStatus()}">
											<a href="" class="btn btn-warning">Hủy</a>
										</c:when>
										<c:otherwise>
											<a href="" class="btn btn-success">Trả</a>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<%
								i++;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
			<div class="pull-left">
				<a href="/LibraryManagement/Book" class="btn btn-info">Quaylại</a>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>