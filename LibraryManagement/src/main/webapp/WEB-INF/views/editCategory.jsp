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
		<h1>CHỈNH SỬA THỂ LOẠI SÁCH</h1>
	</div>
	<c:if test="${success != null }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<div class="content">
		<div>
			<hr>
		</div>
		<form action="../postEdit" method="post">
			<div class="form-group form-inline">
				<input type="text" name="id" id="id" hidden="true"
					value="${category.getId()}"> Thể loại: <input type="text"
					id="name" name="name" required class="form-control"
					value="${category.getName() }">
				<button type="submit" class="btn btn-primary">Chỉnh sửa</button>
			</div>

		</form>
		<div>
			<a href="/LibraryManagement/Category/" class="btn btn-default">Quay
				lại</a>
		</div>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>