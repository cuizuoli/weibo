<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>微博应用接入管理系统</title>
<c:import url="/WEB-INF/includes/style.jsp"/>
</head>
<body>
<script type="text/x-handlebars" data-template-name="admin">
{{outlet menu}}
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			{{outlet content}}
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="admin/menu">
<div class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/a#/">微博应用接入管理系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li {{bind-attr class="menuRequestListClass"}}>{{#link-to 'admin.requestlist'}}待申请应用{{/link-to}}</li>
				<li {{bind-attr class="menuRequestedListClass"}}>{{#link-to 'admin.requestedlist'}}已申请应用{{/link-to}}</li>
				<li {{bind-attr class="menuTestListClass"}}>{{#link-to 'admin.testlist'}}待申请测试帐号{{/link-to}}</li>
				<li {{bind-attr class="menuCompletedListClass"}}>{{#link-to 'admin.completedlist'}}待审核应用{{/link-to}}</li>
				<li {{bind-attr class="menuVerifyListClass"}}>{{#link-to 'admin.verifylist'}}待广场应用{{/link-to}}</li>
				<li {{bind-attr class="menuSquareListClass"}}>{{#link-to 'admin.squarelist'}}待上线应用{{/link-to}}</li>
				<li {{bind-attr class="menuReleaseListClass"}}>{{#link-to 'admin.releaselist'}}上线应用{{/link-to}}</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">退出系统</a></li>
			</ul>
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="admin/requestlist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>应用ID</th>
		<th>访问地址</th>
		<th>类型</th>
		<th>状态</th>
		<th>申请者</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each model}}
	<tr>
		<td>{{id}}</td>
		<td>{{appId}}</td>
		<td>{{appUri}}</td>
		<td>{{appType.name}}</td>
		<td>{{status.name}}</td>
		<td>{{creator}}</td>
		<td>{{modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'getRequest' id}}>修改</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/request">
<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appId">应用ID</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appId}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appType">应用类型</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{appType.name}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">App Key</label>
		<div class="col-sm-2">
			{{input class="form-control input-sm" id="appKey" type="text" placeholder="请输入App Key..." value=appKey}}
			<span class="help-block">不超过20个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">App Secret</label>
		<div class="col-sm-3">
			{{input class="form-control input-sm" id="appSecret" type="text" placeholder="请输入App Secret..." value=appSecret}}
			<span class="help-block">不超过50个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">Redirect URI</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="redirectUri" type="text" placeholder="请输入Redirect URI..." value=redirectUri}}
			<span class="help-block">不超过100个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appAccessUri">应用访问地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appAccessUri" type="text" placeholder="请输入应用访问地址..." value=appAccessUri}}
			<span class="help-block">不超过200个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appUri}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appName">应用名称</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appName}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appSummary}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
		<div class="col-sm-6">
			<pre>{{appIntro}}</pre>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-2">
			<button type="button" class="btn btn-primary btn-sm" {{action 'saveRequest'}}>完成申请</button>
		</div>
	</div>
</form>
</script>
<script type="text/x-handlebars" data-template-name="admin/requestedlist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
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
		<td>{{id}}</td>
		<td>{{appId}}</td>
		<td>{{appUri}}</td>
		<td>{{appName}}</td>
		<td>{{appType.name}}</td>
		<td>{{status.name}}</td>
		<td>{{modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'getRequest' id}}>修改</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/requested">
<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appId">应用ID</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appId}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appType">应用类型</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{appType.name}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">App Key</label>
		<div class="col-sm-2">
			{{input class="form-control input-sm" id="appKey" type="text" placeholder="请输入App Key..." value=appKey}}
			<span class="help-block">不超过20个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">App Secret</label>
		<div class="col-sm-3">
			{{input class="form-control input-sm" id="appSecret" type="text" placeholder="请输入App Secret..." value=appSecret}}
			<span class="help-block">不超过50个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">Redirect URI</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="redirectUri" type="text" placeholder="请输入Redirect URI..." value=redirectUri}}
			<span class="help-block">不超过100个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appAccessUri">应用访问地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appAccessUri" type="text" placeholder="请输入应用访问地址..." value=appAccessUri}}
			<span class="help-block">不超过200个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appUri}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appName">应用名称</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appName}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appSummary}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
		<div class="col-sm-6">
			<pre>{{appIntro}}</pre>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-2">
			<button type="button" class="btn btn-primary btn-sm" {{action 'saveRequest'}}>保存</button>
		</div>
	</div>
</form>
</script>
<script type="text/x-handlebars" data-template-name="admin/completedlist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>应用ID</th>
		<th>访问地址</th>
		<th>类型</th>
		<th>状态</th>
		<th>申请者</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each weiboInfo in model}}
	<tr>
		<td>{{weiboInfo.id}}</td>
		<td>{{weiboInfo.appId}}</td>
		<td>{{weiboInfo.appUri}}</td>
		<td>{{weiboInfo.appType.name}}</td>
		<td>{{weiboInfo.status.name}}</td>
		<td>{{weiboInfo.creator}}</td>
		<td>{{weiboInfo.modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'saveVerify' weiboInfo}}>提交审核</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/completed">
<h3>admin/completed</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/verifylist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>应用ID</th>
		<th>访问地址</th>
		<th>类型</th>
		<th>状态</th>
		<th>申请者</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each weiboInfo in model}}
	<tr>
		<td>{{weiboInfo.id}}</td>
		<td>{{weiboInfo.appId}}</td>
		<td>{{weiboInfo.appUri}}</td>
		<td>{{weiboInfo.appType.name}}</td>
		<td>{{weiboInfo.status.name}}</td>
		<td>{{weiboInfo.creator}}</td>
		<td>{{weiboInfo.modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'saveSquare' weiboInfo}}>申请广场</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/verify">
<h3>admin/verify</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/squarelist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>应用ID</th>
		<th>访问地址</th>
		<th>类型</th>
		<th>状态</th>
		<th>申请者</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each weiboInfo in model}}
	<tr>
		<td>{{weiboInfo.id}}</td>
		<td>{{weiboInfo.appId}}</td>
		<td>{{weiboInfo.appUri}}</td>
		<td>{{weiboInfo.appType.name}}</td>
		<td>{{weiboInfo.status.name}}</td>
		<td>{{weiboInfo.creator}}</td>
		<td>{{weiboInfo.modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'saveRelease' weiboInfo}}>申请上线</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/square">
<h3>admin/square</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/releaselist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:20%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>应用ID</th>
		<th>访问地址</th>
		<th>类型</th>
		<th>状态</th>
		<th>申请者</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each model}}
	<tr>
		<td>{{id}}</td>
		<td>{{appId}}</td>
		<td>{{appUri}}</td>
		<td>{{appType.name}}</td>
		<td>{{status.name}}</td>
		<td>{{creator}}</td>
		<td>{{modifyTimeFormat}}</td>
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'getRelease' id}}>查看</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="admin/release">
<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label">应用ID</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appId}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用类型</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{appType.name}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">App Key</label>
		<div class="col-sm-2">
			<p class="form-control-static">{{appKey}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">App Secret</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appSecret}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Redirect URI</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{redirectUri}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用访问地址</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appAccessUri}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用实际地址</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appUri}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用名称</label>
		<div class="col-sm-3">
			<p class="form-control-static">{{appName}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用简介</label>
		<div class="col-sm-6">
			<p class="form-control-static">{{appSummary}}</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用介绍</label>
		<div class="col-sm-6">
			<pre>{{appIntro}}</pre>
		</div>
	</div>
</form>
</script>
<script type="text/x-handlebars" data-template-name="admin/testlist">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:40%;">
		<col style="width:20%;">
		<col style="width:15%;">
		<col style="width:10%;">
	</colgroup>
	<thead>
	<tr class="active">
		<th>ID</th>
		<th>昵称</th>
		<th>状态</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	{{#each weiboTest in model}}
	<tr>
		<td>{{weiboTest.id}}</td>
		<td>{{weiboTest.nickname}}</td>
		<td>{{weiboTest.status.name}}</td>
		<td>{{weiboTest.modifyTimeFormat}}</td>
		<td>
			{{#if weiboTest.isShowAdded}}
			<button type="button" class="btn btn-primary btn-xs" {{action 'addedWeiboTest' weiboTest}}>添加</button>
			{{/if}}
			{{#if weiboTest.isShowDeleted}}
			<button type="button" class="btn btn-primary btn-xs" {{action 'deletedWeiboTest' weiboTest}}>删除</button>
			{{/if}}
		</td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script data-main="/js/admin_app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
