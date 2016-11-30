<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Staff"%>

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
		<h1>Quản lý đọc giả</h1>
	</div>
	<c:if test="${success != null }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<div class="content">
		<div class="row">
			<div class="col-lg-10"></div>
			<div class="col-lg-2">
				<a href="/LibraryManagement/add-student"><input class="btn btn-primary btn-large btn-block"
					type="submit" value="Tạo đọc giả"></a>

			</div>
		</div>
		<div>
			</br>
		</div>
		<table id="example" class="display">
			<thead>
				<th>STT</th>
				<th>ĐGID</th>
				<th>Tên</th>
				<th>Ngày sinh</th>
				<th>Giới tính</th>
				<th>Email</th>
				<th>Địa chỉ</th>
				<th>Số điện thoại</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<%
					int i = 1;
				%>
				<c:forEach var="listValue" items="${sList}">
					<tr>
						<td><%=i%></td>
						<td>${listValue.getId()}</td>
						<td>${listValue.getName()}</td>
						<td>${listValue.getDateOfBirth() }</td>
						<td><c:choose>
								<c:when test="${listValue.isGender() }">
									<c:out value="Nam"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Nữ"></c:out>
								</c:otherwise>
							</c:choose></td>
						<td>${listValue.getEmail() }</td>
						<td>${listValue.getAddress() }</td>
						<td>${listValue.getPhone() }</td>
						<td><a href="/LibraryManagement/edit-student/${listValue.getId()}" class ="btn btn-primary">Sửa </a></td>
						<td><a href="/LibraryManagement/deactivated-student-management/${listValue.getId()}"class ="btn btn-warning">Ngưng hoạt động</a></td>
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