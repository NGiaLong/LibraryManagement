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
		<h1>DANH SÁCH ĐƠN MƯỢN SÁCH</h1>
	</div>
	</br>
	<c:if test="${success != null }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<hr>
	<div class="content">
		<c:choose>
			<c:when test="${oList.size() < 1 }">
				<div class="alert alert-danger" align="center">
					<h3>Không có đơn thuê sách nào</h3>
				</div>
			</c:when>
			<c:otherwise>
				<table id="example" class="display">
					<thead>
						<th>STT</th>
						<th>Mã thuê</th>
						<th>Tên đọc giả</th>
						<th>Tên nhân viên</th>
						<th>Ngày mượn</th>
						<th>Ngày trả</th>
						<th>Tình trạng</th>
						<th></th>
					</thead>
					<tbody>
						<%
							int i = 1;
						%>
						<c:forEach var="listValue" items="${orderList}">
							<tr>
								<td><%=i%></td>
								<td><a>${listValue.getId()}</a></td>
								<td>${listValue.getStudentName()}</td>
								<td>${listValue.getStaffName()}</td>
								<td>${listValue.getDatePurchase()}</td>
								<td>${listValue.getDateExpire()}</td>
								<td><c:choose>
										<c:when test="${listValue.isStatus()}">
											<c:out value="Đã trả"></c:out>
										</c:when>
										<c:otherwise>
											<c:out value="Chưa trả"></c:out>
										</c:otherwise>
									</c:choose></td>
								<td>
								<a href="Detail/${listValue.getId()}" class="btn btn-info">Chi tiết</a>
								</td>
							</tr>
							<%
								i++;
							%>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>

	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>