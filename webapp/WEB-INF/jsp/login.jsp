<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>微博应用接入系统</title>
<c:import url="/WEB-INF/includes/style.jsp"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-12" style="padding:30px 300px;">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">微博应用接入系统</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="/j_spring_security_check" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label" for="username">用户名: </label>
							<div class="col-sm-8">
								<input class="form-control input-sm" id="username" name="username" type="text" value="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码: </label>
							<div class="col-sm-8">
								<input class="form-control input-sm" id="password" name="password" type="password" value="">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button type="submit" class="btn btn-sm btn-primary">登录系统</button>
								<button type="register" class="btn btn-sm btn-default" disabled>接入注册</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
