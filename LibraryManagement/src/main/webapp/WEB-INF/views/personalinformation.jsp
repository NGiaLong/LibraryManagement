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
			<c:if test="${success != null }">
				<div class="alert alert-success">${success }</div>
			</c:if>
			<c:if test="${error != null }">
				<div class="alert alert-danger">${error }</div>
			</c:if>
			<h1>Thông tin cá nhân</h1>
			<hr>
			<%
				if ((int) ((session.getAttribute("roleSession"))) == 1) {
			%>
			<form:form id="form" modelAttribute="perInfor">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">NVID:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="id" type="text" class="form-control"
								id="inputPhone" name="inputPhone"
								value="${staffSession.getId() }" disabled="true" />
						</div>
					</div>
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Tên nhân viên:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="name" type="text" class="form-control"
								id="inputPhone" name="inputPhone"
								value="${staffSession.getName() }" />
						</div>
					</div>
				</div>
				<div class="row">

					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Ngày sinh:</label>
						<div class="input-group date col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span>
							<form:input path="dateOfBirth" type="date" class="form-control"
								id="inputDate" name="inputDate"
								value="${staffSession.getDateOfBirth() }" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Giới tính:</label>
						<div class="radio-inline col-sm-8">
							<c:choose>
								<c:when test="${staffSession.isGender() }">
									<label class="col-sm-4"><form:radiobutton path="gender"
											value="false" class="radio" />Nữ</label>
									<label class="col-sm-4"><form:radiobutton path="gender"
											value="true" class="radio" checked="true" />Nam</label>
								</c:when>
								<c:otherwise>
									<label class="col-sm-4"><form:radiobutton path="gender"
											value="false" class="radio" checked="true" />Nữ</label>
									<label class="col-sm-4"><form:radiobutton path="gender"
											value="true" class="radio" />Nam</label>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Email:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="email" type="email" class="form-control"
								id="inputPhoneNumber" name="inputPhoneNumber"
								value="${staffSession.getEmail() }" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Số điện thoại:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone"></i></span>
							<form:input path="phone" type="number" class="form-control"
								id="inputPhoneNumber" name="inputPhoneNumber"
								value="${staffSession.getPhone() }" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Địa chỉ:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<form:input path="address" type="text" class="form-control"
								id="inputAdress" name="inputAdress"
								value="${staffSession.getAddress() }" />
						</div>
					</div>
				</div>
				<div align="right">
					<form:button type="submit" class="btn btn-primary">Sửa</form:button>
					<button type="button" class="btn btn-info" id="myBtn">Thay
						đổi mật khẩu</button>
				</div>
			</form:form>
			<%
				}
			%>
		</div>
		<!-- /.container-fluid -->
		<div>
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3 align="center">
								<span class="glyphicon glyphicon-lock"></span> Thay đổi mật khẩu
							</h3>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<label for="usrname"><span
										class="glyphicon glyphicon-user"></span> Mật khẩu cũ</label> <input
										type="password" class="form-control" id="usrname"
										required="required" placeholder="Mật khẩu cũ">
								</div>
								<div class="form-group">
									<label for="psw"><span
										class="glyphicon glyphicon-eye-open"></span>Mật khẩu mới</label> <input
										type="password" class="form-control" id="psw"
										required="required" placeholder="Mật khẩu mới">
								</div>
								<div class="form-group">
									<label for="psw1"><span
										class="glyphicon glyphicon-eye-open"></span>Nhập lại mật khẩu</label>
									<input type="password" class="form-control" id="psw1"
										required="required" placeholder="Nhập lại mật khẩu mới">
								</div>
								<button type="submit" class="btn btn-success btn-block">
									<span class="glyphicon glyphicon-off"></span>Đổi mật khẩu
								</button>
							</form>
						</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(document).ready(function() {
				$("#myBtn").click(function() {
					$("#myModal").modal();
				});
			});
		</script>
	</div>
	<!-- /#page-wrapper -->
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>