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
		<h1>THÊM MỚI SÁCH BẰNG FILE</h1>
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
			<form action="savefile" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="form-inline col-sm-6 ">
						<label class="control-label col-sm-4">Chọn file upload:</label>
						<div class="form-inline col-sm-8">
							<input type="file" name="file" class="form-control" />
						</div>
					</div>
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Chọn thể loại:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-file"></i></span> <select
								class="form-control" name="categoryId">
								<c:forEach var="listValue" items="${categoryList}">
									<option value="${listValue.getId()}">${listValue.getName()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<a href="../Book" class="btn btn-default">Quay lại</a> 
				<input type="submit" value="Upload File" class="btn btn-info" />
			</form>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>