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
<script type="text/x-handlebars" data-template-name="weibo">
{{outlet menu}}
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			{{outlet content}}
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="weibo/menu">
<div class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="javascript:void(0);">微博应用接入系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li {{bind-attr class="weiboListActive"}}>{{#link-to 'weibo.list'}}应用列表{{/link-to}}</li>
				<li {{bind-attr class="weiboRequestActive"}}>{{#link-to 'weibo.request'}}申请应用{{/link-to}}</li>
			</ul>
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="weibo/list">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>应用ID</th>
		<th>访问地址</th>
		<th>名称</th>
		<th>类型</th>
		<th>状态</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each model}}
	<tr>
		<td>{{appId}}</td>
		<td>{{appUri}}</td>
		<td>{{appName}}</td>
		<td>{{appType.name}}</td>
		<td>{{status.name}}</td>
		<td>{{modifyTimeFormat}}</td>
		<td><button id="addBtn" type="button" class="btn btn-primary btn-xs" {{action 'getRequest' appId}}>详细</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="weibo/request">
<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appId">应用唯一标识符</label>
		<div class="col-sm-3">
			{{input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用唯一标识符..." value=appId}}
			<span class="help-block">不超过30个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..." value=appUri}}
			<span class="help-block">不超过200个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appName">应用名称</label>
		<div class="col-sm-3">
			{{input class="form-control input-sm" id="appName" type="text" placeholder="请输入应用名称..." value=appName}}
			<span class="help-block">不超过10个汉字或20个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appSummary" type="text" placeholder="请输入应用简介..." value=appSummary}}
			<span class="help-block">不超过15个汉字或30个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
		<div class="col-sm-6">
			{{textarea class="form-control input-sm" id="appIntro" rows="3" placeholder="请输入应用介绍..." value=appIntro}}
			<span class="help-block">不超过1000个汉字或2000个字母</span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-2">
			<button id="addBtn" type="button" class="btn btn-primary btn-sm" {{action 'addRequest'}}>提交申请</button>
		</div>
	</div>
</form>
</script>
<script data-main="/js/app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
