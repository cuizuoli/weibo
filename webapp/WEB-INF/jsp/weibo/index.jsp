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
			<a class="navbar-brand" href="/weibo#/">微博应用接入系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li {{bind-attr class="menuRequestClass"}}>{{#link-to 'weibo.request'}}申请应用{{/link-to}}</li>
				<li {{bind-attr class="menuRequestListClass"}}>{{#link-to 'weibo.requestlist'}}申请中应用{{/link-to}}</li>
				<li {{bind-attr class="menuRequestedListClass"}}>{{#link-to 'weibo.requestedlist'}}待开发应用{{/link-to}}</li>
				<li {{bind-attr class="menuCompletedListClass"}}>{{#link-to 'weibo.completedlist'}}开发完了应用{{/link-to}}</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">退出系统</a></li>
			</ul>
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="weibo/list">
<table class="table table-hover table-bordered table-condensed">
	<colgroup>
		<col style="width:5%;">
		<col style="width:10%;">
		<col style="width:25%;">
		<col style="width:15%;">
		<col style="width:10%;">
		<col style="width:10%;">
		<col style="width:15%;">
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
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="weibo/request">
<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appId">应用ID</label>
		<div class="col-sm-3">
			{{input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用ID..." value=appId}}
			<span class="help-block">不超过30个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="appType">应用类型</label>
		<div class="col-sm-10">
			<div id="appTypeDiv" class="btn-group btn-group-sm" data-toggle="buttons">
				<label class="btn btn-primary">
					<input type="radio" id="appTypeApp" name="appType" value="app"> 站内应用
				</label>
				<label class="btn btn-primary active">
					<input type="radio" id="appTypeWeb" name="appType" value="web"> 网页应用
				</label>
				<label class="btn btn-primary">
					<input type="radio" id="appTypePage" name="appType" value="page"> PAGE应用企业版
				</label>
			</div>
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
			<button type="button" class="btn btn-primary btn-sm" {{action 'addRequest'}}>提交申请</button>
		</div>
	</div>
</form>
</script>
<script type="text/x-handlebars" data-template-name="weibo/requestedlist">
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
		<td><button type="button" class="btn btn-primary btn-xs" {{action 'getRequested' id}}>修改</button></td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="weibo/requested">
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
		<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..." value=appUri}}
			<span class="help-block">不超过200个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用访问地址</label>
		<div class="col-sm-6">
			<p class="form-control-static"><a {{bind-attr href="appAccessUri"}} target="_blank"><img src="/images/weibo/login_24x24.png"></a></p>
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
		<label class="col-sm-2 control-label" for="officialId">官方运营帐号ID</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="officialId" rows="3" placeholder="请输入官方运营帐号ID..." value=officialId}}
			<span class="help-block">不超过20个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="officialPassword">官方运营帐号密码</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="officialPassword" rows="3" placeholder="请输入官方运营帐号密码..." value=officialPassword}}
			<span class="help-block">不超过50个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="icon16">应用图标16*16地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="icon16" rows="3" placeholder="请输入应用图标16*16地址..." value=icon16}}
			<span class="help-block">16*16，2M以内，支持PNG、JPG</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="icon80">应用图标80*80地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="icon80" rows="3" placeholder="请输入应用图标80*80地址..." value=icon80}}
			<span class="help-block">16*16，2M以内，支持PNG、JPG</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="icon120">应用图标120*120地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="icon120" rows="3" placeholder="请输入应用图标120*120地址..." value=icon120}}
			<span class="help-block">16*16，2M以内，支持PNG、JPG</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="preview01">应用介绍图片地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="preview01" rows="3" placeholder="请输入应用介绍图片01地址..." value=preview01}}
		</div>
		<div class="col-sm-offset-2 col-sm-6">
			{{input class="form-control input-sm" id="preview02" rows="3" placeholder="请输入应用介绍图片02地址..." value=preview02}}
		</div>
		<div class="col-sm-offset-2 col-sm-6">
			{{input class="form-control input-sm" id="preview03" rows="3" placeholder="请输入应用介绍图片03地址..." value=preview03}}
		</div>
		<div class="col-sm-offset-2 col-sm-6">
			{{input class="form-control input-sm" id="preview04" rows="3" placeholder="请输入应用介绍图片04地址..." value=preview04}}
			<span class="help-block">2M以内，支持PNG、JPG 高：300px 宽：450px；</span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-primary btn-sm" {{action 'saveRequested'}}>保存信息</button>
			<button type="button" class="btn btn-primary btn-sm" {{action 'saveCompleted'}}>开发完成</button>
		</div>
	</div>
</form>
<div class="page-header">
	<h3>应用开发测试帐号列表</h3>
</div>
<form class="form-inline" role="form">
	<div class="form-group">
		<label class="sr-only" for="nickname">微博昵称</label>
		<input class="form-control input-sm" id="nickname" type="text" plackholder="请输入测试的微博昵称...">
	</div>
	<button class="btn btn-sm btn-primary" type="submit" {{action 'addWeiboTest'}}>添加测试帐号</button>
</form>
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
	{{#each weiboTest in weiboTests}}
	<tr>
		<td>{{weiboTest.id}}</td>
		<td>{{weiboTest.nickname}}</td>
		<td>{{weiboTest.status.name}}</td>
		<td>{{weiboTest.modifyTimeFormat}}</td>
		<td>
			{{#if weiboTest.isShowDelete}}
			<button type="button" class="btn btn-primary btn-xs" {{action 'deleteWeiboTest' weiboTest}}>删除</button>
			{{/if}}
		</td>
	</tr>
	{{/each}}
	</tbody>
</table>
</script>
<script type="text/x-handlebars" data-template-name="weibo/completed">
<h3>weibo/completed</h3>
</script>
<script data-main="/js/weibo_app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
