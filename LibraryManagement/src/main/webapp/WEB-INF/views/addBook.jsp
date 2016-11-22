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
		<h1>THÊM MỚI SÁCH</h1>
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
			<form:form id="form" modelAttribute="createBookBean">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Tên sách:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-book"></i></span>
							<form:input path="title" type="text" class="form-control"
								id="title" name="title" placeholder="Tên sách" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Mô tả sách:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-file"></i></span>
							<form:textarea path="description" type="text"
								class="form-control" rows="6" id="description" name="description"
								placeholder="Mô tả" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Tác giả:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="author" type="text" class="form-control"
								id="author" name="author" placeholder="Tác giả" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Phiên bản:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:input path="edition" type="number" class="form-control"
								id="edition" name="edition" placeholder="Phiên bản" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Nhà sản xuất:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone"></i></span>
							<form:input path="publisher" type="text" class="form-control"
								id="publisher" name="publisher" placeholder="Nhà sản xuất" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Thể loại:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:select path="categoryId" class="form-control">
								<c:forEach var="item" items="${listCategory}">
									<form:option class="form-control" value="${item.getId()}">${item.getName() }</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8"></div>
					<a href="/LibraryManagement/Book"
						class="btn btn-default">Quay lại</a>
					<form:button type="submit" class="btn btn-primary">Thêm</form:button>
				</div>
			</form:form>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>