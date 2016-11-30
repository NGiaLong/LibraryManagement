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
	<div id="page-wrapper" style="height: 100%">
		<div class="container-fluid">
			<h1>Thêm nhân viên</h1>
			<form:form id="form" modelAttribute="createStaffBean">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Tên nhân viên:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="name" type="text" class="form-control" 
								id="inputPhone" name="inputPhone" placeholder="Tên nhân viên" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Ngày sinh:</label>
						<div class="input-group date col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span>
							<form:input path="dateOfBirth" type="date" required class="form-control" 
								id="inputDate" name="inputDate" placeholder="Ngày sinh" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Giới tính:</label>
						<div class="radio-inline col-sm-8">
							<label class="col-sm-4"><form:radiobutton path="gender"
									value="false" class="radio"/>Nữ</label> <label class="col-sm-4"><form:radiobutton
									path="gender" value="true" class="radio" />Nam</label>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Email:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="email" type="email" required class="form-control"
								id="inputPhoneNumber" name="inputPhoneNumber"
								placeholder="Email" />
						</div>
					</div>
				</div>
				<div class="row">
				<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Số điện thoại:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone"></i></span>
							<form:input path="phone" type="number" required class="form-control"
								id="inputPhoneNumber" name="inputPhoneNumber"
								placeholder="Số điện thoại" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Địa chỉ:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:input path="address" type="text" required class="form-control"
								id="inputAdress" name="inputAdress" placeholder="Địa chỉ" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8"></div>
					<a href="/LibraryManagement/staff-management" class="btn btn-default" >Quay lại</a>
					<form:button type="submit" class="btn btn-primary">Thêm</form:button>
				</div>

			</form:form>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>
