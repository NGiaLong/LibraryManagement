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
	<div class="container-fluid">
		<div class="row">
			<h1>Chỉnh sửa thông tin cá nhân</h1>
			<form class="form-horizontal">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Mã nhân viên:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="maNV"
								value="${nv.getMaNhanVien() }" disabled>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Tên nhân viên:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="tenNV"
								value="${nv.getTenNhanVien() }" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Giới tính:</label>
						<div class="col-sm-8">
							<c:choose>
								<c:when test="${nv.isGioiTinh() }">
									<c:out value="Nữ"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Nam"></c:out>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Ngày sinh:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="tenNV"
								value="${nv.getNgaySinh() }">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Số điện thoại:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="tenNV"
								value="${nv.getSoDienThoai() }">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Chức vụ:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="tenNV"
								value="${nv.getChucVu() }" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Lương:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="tenNV"
								value="${nv.getLuong() }" disabled>
						</div>
					</div>
				</div>



			</form>
			<div class="row">
				<div class="col-sm-9"></div>

				<div class="col-sm-2">
					<form method="post">
						<input class="btn btn-success btn-large btn-block" type="submit"
							value="Lưu">
					</form>
				</div>
			</div>
		</div>

		<div class="row">
			<h3>Thay đổi mật khẩu</h3>
			<form:form id="formMK" modelAttribute="thayDoiMatKhau" method="POST"
				action="/CellPhoneShop/thay-doi-mat-khau">
				<div class="row">
					<div class="form-group col-sm-6 ">
						<label class="control-label col-sm-4">Mật khẩu cũ:</label>
						<div class="col-sm-8">
							<form:input path="matKhauCu" type="password" class="form-control"
								id="matKhauCu" />
						</div>
					</div>

				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Mật khẩu mới:</label>
						<div class="col-sm-8">
							<form:input path="matKhauMoi" type="password"
								class="form-control" id="matKhauMoi" />
						</div>
					</div>

				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 ">Nhập lại mật khẩu:</label>
						<div class="col-sm-8">
							<form:input path="nhapLaiMatKhau" type="password"
								class="form-control" id="nhapLaiMatKhau" />
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-sm-9"></div>

					<div class="col-sm-2">
						<button type="submit" class="btn btn-primary">Lưu thay
							đổi</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>