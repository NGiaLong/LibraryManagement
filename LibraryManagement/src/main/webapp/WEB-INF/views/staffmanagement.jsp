<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.model.Staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="layouts/top.jsp"></jsp:include>
<div id="page-wrapper" style="height: 100%">
	<div class="container-fluid">
		<h1>QUẢN LÝ NHÂN SỰ</h1>

		<div class="row">
			<div class="col-lg-10"></div>
			<div class="col-lg-2">
				<a href="#"><input class="btn btn-primary btn-large btn-block"
					type="submit" value="Thêm nhân viên"></a>

			</div>
		</div>
		<div>
			</br>
		</div>
		<table id="example" class="display">
			<thead>
				<th>STT</th>
				<th>Mã nhân viên</th>
				<th>Tên nhân viên</th>
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
						<td>${listValue.getId() }</td>
						<td>${listValue.getName()}</td>
						<td>${listValue.getDateOfBirth()}</td>
						<td>${listValue.isGender()}</td>
						<td>${listValue.getEmail()}</td>
						<td>${listValue.getAddress()}</td>
						<td>${listValue.getPhone()}</td>
						<td></td>
						<td></td>
					</tr>
					<%
								i++;
							%>
				</c:forEach>
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="layouts/bot.jsp"></jsp:include>