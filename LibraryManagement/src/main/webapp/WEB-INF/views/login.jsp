<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="message">${message }</div>
	<div id="login" class="container">
		<div class="row-fluid">
			<div class="span12">
				<div class="login well well-small">
					<div class="center">
						<img src="http://placehold.it/250x100&text=Logo" alt="logo">
					</div>
					<div>${mess}</div>
					<form:form id="form" style="" class="login-form" method="post"
						modelAttribute="loginBean">
						<div class="control-group">
							<div class="input-prepend">
								<fieldset>
									<span class="add-on"><i class="icon-user"></i></span>
									<form:input path="id" required="required"
										placeholder="Tên đăng nhập" maxlength="255" type="text"
										id="UserMaNhanVien" />
								</fieldset>

							</div>
						</div>
						<div class="control-group">
							<div class="input-prepend">
								<fieldset>
									<span class="add-on"><i class="icon-lock"></i></span>
									<form:input path="password" required="required"
										placeholder="Mật khẩu" type="password" id="UserMatKhau" />
								</fieldset>

							</div>
						</div>
						<div class="control-group">
							<label id="remember-me"> <input type="checkbox" value="1"
								id="UserRememberMe"> Remember Me?
							</label>
						</div>
						<div class="control-group">
							<input class="btn btn-primary btn-large btn-block" type="submit"
								value="Sign in">
						</div>
					</form:form>
				</div>
				<!--/.login-->
			</div>
			<!--/.span12-->
		</div>
		<!--/.row-fluid-->
	</div>
	<!--/.container-->
	</div>
</body>
</html>