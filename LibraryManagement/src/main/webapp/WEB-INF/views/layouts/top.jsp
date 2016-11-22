<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Library Management</title>

<!-- CSS -->
<link href="<c:url value="/resources/css/jquery-ui.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/datepicker3.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">

<%-- <link href="<c:url value="/resources/js/jquery-1.11.1.min.css" />"
	rel="stylesheet"> --%>



<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css" />


<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/chart.min.js" />"></script>
<%-- <script src="<c:url value="/resources/js/chart-data.js" />"></script> --%>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script src="<c:url value="/resources/js/easypiechart.js" />"></script>
<script src="<c:url value="/resources/js/easypiechart-data.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<!--Icons-->
<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>


<script type="text/javascript"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js">
	
</script>
<script src="<c:url value="/resources/js/script.js" />"></script>
</head>


<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Library</span>Management</a>
				<ul class="user-menu">
					<li class="dropdown pull-right"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><svg
								class="glyph stroked male-user"> <use
								xlink:href="#stroked-male-user"></use></svg> <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked male-user">
									<use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="/FFVStore/logout"><svg
										class="glyph stroked cancel"> <use
										xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
		<!-- /.container-fluid --> </nav>

		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
			<form role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
			</form>
			<ul class="nav menu">
				<li><a href="#"><svg class="glyph stroked dashboard-dial">
						<use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
				<li class="parent "><a
					href="/LibraryManagement/staff-management"> <span
						data-toggle="collapse" href="#sub-item-1"><svg
								class="glyph stroked chevron-down"> <use
								xlink:href="#stroked-chevron-down"></use></svg></span> Quản lý nhân viên
				</a>
					<ul class="children collapse" id="sub-item-1">
						<li><a class="" href="#"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Tạo tài khoản
						</a></li>
						<li><a class="" href="/LibraryManagement/deactivated-staff-management"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Ngừng hoạt động
						</a></li>
					</ul></li>
				<li class="parent "><a href="/LibraryManagement/student-management"> <span
						data-toggle="collapse" href="#sub-item-2"><svg
								class="glyph stroked chevron-down"> <use
								xlink:href="#stroked-chevron-down"></use></svg></span> Quản lý độc giả
				</a>
					<ul class="children collapse" id="sub-item-2">
						<li><a class="" href="/FFVStore/cua-hang/tao"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Tạo độc giả
						</a></li>
						<li><a class="" href="/LibraryManagement/deactivated-student-management"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Ngừng hoạt động
						</a></li>
					</ul></li>
				<li class="parent "><a href="#"> <span
						data-toggle="collapse" href="#sub-item-3"><svg
								class="glyph stroked chevron-down"> <use
								xlink:href="#stroked-chevron-down"></use></svg></span> Quản lý sách
				</a>
					<ul class="children collapse" id="sub-item-3">
						<li><a class="" href="/FFVStore/taomonan"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Thêm sách
						</a></li>
						<li><a class="" href="/FFVStore/taomonan"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Import sách mới
						</a></li>
						<li><a class="" href="#"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Sách còn trong kho
						</a></li>
					</ul></li>
				<li class="parent "><a href="/LibraryManagement/Category"> <span
						data-toggle="collapse" href="#sub-item-5"><svg
								class="glyph stroked chevron-down"> <use
								xlink:href="#stroked-chevron-down"></use></svg></span> Quản lý thể loại sách
				</a>
					<ul class="children collapse" id="sub-item-5">
						<li><a class="" href="/LibraryManagement/Category/add"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Thêm thể loại
						</a></li>						
						<li><a class="" href="/LibraryManagement/Category"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Danh sách thể loại
						</a></li>
					</ul></li>
				<li class="parent "><a href="#"> <span
						data-toggle="collapse" href="#sub-item-4"><svg
								class="glyph stroked chevron-down"> <use
								xlink:href="#stroked-chevron-down"></use></svg></span> Quản lý mượn
				</a>
					<ul class="children collapse" id="sub-item-4">
						<li><a class="" href="/FFVStore/thongkethu"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Tạo mới mượn sách
						</a></li>
						<li><a class="" href="/FFVStore/thongkeluong"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Danh sách mượn sách
						</a></li>
						<li><a class="" href="#"> <svg
									class="glyph stroked chevron-right"> <use
									xlink:href="#stroked-chevron-right"></use></svg> Danh sách quá hạn
						</a></li>
					</ul></li>
				<li role="presentation" class="divider"></li>
			</ul>

		</div>
		<!--/.sidebar-->