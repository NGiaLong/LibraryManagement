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
		<h1>DANH SÁCH TÀI LIỆU</h1>
		<hr>
	</div>
	<c:if test="${success != null }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<div class="content">
		<div class="row">
			<div class="col-md-6 form-inline">
				<a href="Book/uploadExcel"><input class="btn btn-success" type="submit"
					value="Tạo bằng file"></a>
			</div>
			<div class="col-md-6">
				<a href="Book/add" class="pull-right"><input class="btn btn-primary" type="submit"
					value="Tạo mới sách"></a>
			</div>
		</div>
		</br>
		<table id="example" class="display">
			<thead>
				<th>STT</th>
				<th>Mã sách</th>
				<th>Tên sách</th>
				<th>Tác giả</th>
				<th>Phiên bản</th>
				<th>Nhà sản xuất</th>
				<th>Thể loại</th>
				<th>Tình trạng</th>
				<th></th>
			</thead>
			<tbody>
				<%
					int i = 1;
				%>
				<c:forEach var="listValue" items="${listBook}">
					<tr>
						<td><%=i%></td>
						<td>${listValue.getId()}</td>
						<td>${listValue.getTitle()}</td>
						<td>${listValue.getAuthor()}</td>
						<td>${listValue.getEdition()}</td>
						<td>${listValue.getPublisher()}</td>
						<td>${listValue.getCategoryName()}</td>
						<td><c:choose>
								<c:when test="${listValue.isStatus()}">
									<c:out value="Còn"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Đã mượn"></c:out>
								</c:otherwise>
							</c:choose></td>
						<td><a href="Book/edit/${listValue.getId()}"
							class="btn btn-primary">Sửa </a> <a
							href="Book/delete/${listValue.getId()}" class="btn btn-danger">
								Xóa</a></td>
					</tr>
					<%
						i++;
					%>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>