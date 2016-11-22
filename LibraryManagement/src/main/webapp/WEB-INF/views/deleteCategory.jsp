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
		<h1>XÓA THỂ LOẠI SÁCH</h1>
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
		<div>
			<h3>Bạn có muốn xóa thể loại này?</h3>
		</div>
		<form action="../postDelete" method="post">
			<div class="form-group form-inline">
			<input type="text" hidden="true" name="id" id="id" value="${category.getId()}">
				<h4>Thể loại: ${category.getName()}</h4>				
			</div>
			<button type="submit" class="btn btn-danger">Xóa</button>
			<a href="/LibraryManagement/Category/" class="btn btn-default">Quay lại</a>
		</form>		
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>