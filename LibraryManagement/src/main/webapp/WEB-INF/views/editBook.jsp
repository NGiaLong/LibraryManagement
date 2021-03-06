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
		<h1>CHỈNH SỬA SÁCH</h1>
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
			<form:form id="form" modelAttribute="editBookBean">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Mã sách:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-book"></i></span>
							<form:input path="id" type="text" class="form-control" id="id"
								name="id" placeholder="Mã sách" readonly="true"
								value="${book.getId() }" />
						</div>
					</div>
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Tên sách:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-book"></i></span>
							<form:input path="title" type="text" class="form-control"
								id="title" name="title" placeholder="Tên sách"
								value="${book.getTitle() }" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Mô tả sách:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-file"></i></span>
							<form:input path="description" type="text" class="form-control"
								id="description" name="description"
								placeholder="${book.getDescription()}"
								value="${book.getDescription()}" />
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
								id="author" name="author" placeholder="Tác giả"
								value="${book.getAuthor()}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Phiên bản:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:input path="edition" type="number" class="form-control"
								id="edition" name="edition" placeholder="Phiên bản"
								value="${book.getEdition()}" />
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
								id="publisher" name="publisher" placeholder="Nhà sản xuất"
								value="${book.getPublisher()}" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Thể loại:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:select path="categoryId" class="form-control">
								<c:forEach var="item" items="${listCategory}">

									<c:choose>
										<c:when test="${item.getId()==book.getCategoryId()}">
											<form:option class="form-control" selected="true"
												value="${item.getId()}">${item.getName() }</form:option>
										</c:when>
										<c:otherwise>
											<form:option class="form-control" value="${item.getId()}">${item.getName() }</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Tình trạng:</label>
						<div class="radio-inline col-sm-8">
							<c:choose>
								<c:when test="${book.isStatus() }">
									<label class="col-sm-4"><form:radiobutton path="status"
											value="false" class="radio" />Đã mượn</label>
									<label class="col-sm-4"><form:radiobutton path="status"
											value="true" class="radio" checked="true" />Còn</label>
								</c:when>
								<c:otherwise>
									<label class="col-sm-4"><form:radiobutton path="status"
											value="false" class="radio" checked="true" />Đã mượn</label>
									<label class="col-sm-4"><form:radiobutton path="status"
											value="true" class="radio" />Còn</label>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8"></div>
					<a href="/LibraryManagement/Book"
						class="btn btn-default">Quay lại</a>
					<form:button type="submit" class="btn btn-primary">Sửa</form:button>
				</div>
			</form:form>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>