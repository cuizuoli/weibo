<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title></title>
<c:import url="/WEB-INF/includes/style.jsp"/>
<c:import url="/WEB-INF/includes/script.jsp"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li class="active"><strong>申请</strong></li>
				<li><a href="javascript:void(0);">已申请</a></li>
				<li><a href="javascript:void(0);">开发完成</a></li>
				<li><a href="javascript:void(0);">审核</a></li>
				<li><a href="javascript:void(0);">广场</a></li>
				<li><a href="javascript:void(0);">上线</a></li>
			</ol>
			<div class="page-header">
				<h3>申请</h3>
			</div>
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appId">应用唯一标识符</label>
					<div class="col-sm-10">
						<input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用唯一标识符..."/>
						<span class="help-block">不超过30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
					<div class="col-sm-10">
						<input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..."/>
						<span class="help-block">不超过200个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appName">应用名称</label>
					<div class="col-sm-10">
						<input class="form-control input-sm" id="appName" type="text" placeholder="请输入应用名称..."/>
						<span class="help-block">不超过10个汉字或20个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
					<div class="col-sm-10">
						<input class="form-control input-sm" id="appSummary" type="text" placeholder="请输入应用简介..."/>
						<span class="help-block">不超过15个汉字或30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
					<div class="col-sm-10">
						<textarea class="form-control input-sm" id="appIntro" rows="3" placeholder="请输入应用介绍..."></textarea>
						<span class="help-block">不超过1000个汉字或2000个字母</span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-2">
						<button id="addBtn" type="button" class="btn btn-primary btn-sm">添加</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
