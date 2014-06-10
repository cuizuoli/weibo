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
				<li {{bind-attr class="weiboListActive"}}>{{#link-to 'weibo.list'}}应用列表{{/link-to}}</li>
				<li {{bind-attr class="weiboRequestActive"}}>{{#link-to 'weibo.request'}}申请应用{{/link-to}}</li>
				<li {{bind-attr class="weiboRequestListActive"}}>{{#link-to 'weibo.request.list'}}申请中应用{{/link-to}}</li>
				<li {{bind-attr class="weiboRequestedListActive"}}>{{#link-to 'weibo.requested.list'}}待开发应用{{/link-to}}</li>
				<li {{bind-attr class="weiboCompletedListActive"}}>{{#link-to 'weibo.completed.list'}}开发完了应用{{/link-to}}</li>
				<li {{bind-attr class="weiboVerifyListActive"}}>{{#link-to 'weibo.verify.list'}}审核应用{{/link-to}}</li>
				<li {{bind-attr class="weiboSquareListActive"}}>{{#link-to 'weibo.square.list'}}广场应用{{/link-to}}</li>
				<li {{bind-attr class="weiboSquareListActive"}}>{{#link-to 'weibo.release.list'}}上线应用{{/link-to}}</li>
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
<script type="text/x-handlebars" data-template-name="weibo/info">
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
		<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
		<div class="col-sm-6">
			{{input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..." value=appUri}}
			<span class="help-block">不超过200个字母</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">应用状态</label>
		<div class="col-sm-10">
			<div class="btn-group btn-group-sm">
				<button type="button" {{bind-attr class="requestBtnClass"}}>申请</button>
				<button type="button" {{bind-attr class="requestedBtnClass"}}>已申请</button>
				<button type="button" {{bind-attr class="completedBtnClass"}}>开发完成</button>
				<button type="button" {{bind-attr class="verifyBtnClass"}}>审核</button>
				<button type="button" {{bind-attr class="squareBtnClass"}}>广场</button>
				<button type="button" {{bind-attr class="releaseBtnClass"}}>上线</button>
			</div>
		</div>
	</div>
	{{#with appKey}}
	<div class="form-group">
		<label class="col-sm-2 control-label">App Key</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{appKey}}</p>
		</div>
	</div>
	{{/with}}
	{{#with appSecret}}
	<div class="form-group">
		<label class="col-sm-2 control-label">App Secret</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{appSecret}}</p>
		</div>
	</div>
	{{/with}}
	{{#with redirectUri}}
	<div class="form-group">
		<label class="col-sm-2 control-label">授权回调页</label>
		<div class="col-sm-10">
			<p class="form-control-static">{{redirectUri}}</p>
		</div>
	</div>
	{{/with}}
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
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-primary btn-sm" {{action 'saveRequest'}}>保存修改</button>
			<button type="button" class="btn btn-success btn-sm" {{action 'completedDev'}}>开发完成</button>
			<button type="button" class="btn btn-info btn-sm" {{action 'listRequest'}}>应用列表</button>
		</div>
	</div>
</form>
</script>
<script type="text/x-handlebars" data-template-name="weibo/request/list">
<h3>weibo/request/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/requested/list">
<h3>weibo/requested/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/requested">
<h3>weibo/requested</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/completed/list">
<h3>weibo/completed/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/completed">
<h3>weibo/completed</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/verify/list">
<h3>weibo/verify/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/verify">
<h3>weibo/verify</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/square/list">
<h3>weibo/square/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/square">
<h3>weibo/square</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/release/list">
<h3>weibo/release/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="weibo/release">
<h3>weibo/release</h3>
</script>
<script data-main="/js/weibo_app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
