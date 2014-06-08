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
<div class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/weibo">微博应用接入系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/weibo/list">应用列表</a></li>
				<li class="active"><a href="/weibo/request">申请应用</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal" role="form" action="/weibo/request" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appId">应用ID</label>
					<div class="col-sm-3">
						<input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用ID..."/>
						<span class="help-block">不超过30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appType">应用类型</label>
					<div class="col-sm-10">
						<label class="checkbox-inline input-sm">
							<input type="radio" id="appTypeApp" name="appType" value="app">&nbsp;&nbsp;站内应用
						</label>
						<label class="checkbox-inline input-sm">
							<input type="radio" id="appTypeApp" name="appType" value="web" checked>&nbsp;&nbsp;网页应用
						</label>
						<label class="checkbox-inline input-sm">
							<input type="radio" id="appTypeApp" name="appType" value="page">&nbsp;&nbsp;PAGE应用企业版
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
					<div class="col-sm-6">
						<input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..."/>
						<span class="help-block">不超过200个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appName">应用名称</label>
					<div class="col-sm-3">
						<input class="form-control input-sm" id="appName" type="text" placeholder="请输入应用名称..."/>
						<span class="help-block">不超过10个汉字或20个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
					<div class="col-sm-6">
						<input class="form-control input-sm" id="appSummary" type="text" placeholder="请输入应用简介..."/>
						<span class="help-block">不超过15个汉字或30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
					<div class="col-sm-6">
						<textarea class="form-control input-sm" id="appIntro" rows="3" placeholder="请输入应用介绍..."></textarea>
						<span class="help-block">不超过1000个汉字或2000个字母</span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-2">
						<button id="addRequestBtn" type="submit" class="btn btn-primary btn-sm">提交申请</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script data-main="/js/app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
