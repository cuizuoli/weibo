<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title></title>
<c:import url="/WEB-INF/includes/style.jsp"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<script type="text/x-handlebars" data-template-name="weibo/request">
			<ol class="breadcrumb">
				<li class="active"><strong>{{#link-to 'weibo.request'}}申请{{/link-to}}</strong></li>
				<li>{{#link-to 'weibo.requested'}}已申请{{/link-to}}</li>
				<li>{{#link-to 'weibo.completed'}}开发完成{{/link-to}}</li>
				<li>审核</li>
				<li>广场</li>
				<li>上线</li>
			</ol>
			<div id="requestAddDiv">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appId">应用唯一标识符</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用唯一标识符..." value=appId}}
						<span class="help-block">不超过30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..." value=appUri}}
						<span class="help-block">不超过200个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appName">应用名称</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appName" type="text" placeholder="请输入应用名称..." value=appName}}
						<span class="help-block">不超过10个汉字或20个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appSummary" type="text" placeholder="请输入应用简介..." value=appSummary}}
						<span class="help-block">不超过15个汉字或30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
					<div class="col-sm-10">
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
			</div>
			</script>
			<script type="text/x-handlebars" data-template-name="weibo/requested">
			<ol class="breadcrumb">
				<li>{{#link-to 'weibo.request'}}申请{{/link-to}}</li>
				<li class="active"><strong>{{#link-to 'weibo.requested'}}已申请{{/link-to}}</strong></li>
				<li>{{#link-to 'weibo.completed'}}开发完成{{/link-to}}</li>
				<li>审核</li>
				<li>广场</li>
				<li>上线</li>
			</ol>
			<div id="requestAddDiv">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appId">应用唯一标识符</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appId" type="text" placeholder="请输入应用唯一标识符..." value=appId}}
						<span class="help-block">不超过30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appUri">应用实际地址</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appUri" type="text" placeholder="请输入应用实际地址..." value=appUri}}
						<span class="help-block">不超过200个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appName">应用名称</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appName" type="text" placeholder="请输入应用名称..." value=appName}}
						<span class="help-block">不超过10个汉字或20个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appSummary">应用简介</label>
					<div class="col-sm-10">
						{{input class="form-control input-sm" id="appSummary" type="text" placeholder="请输入应用简介..." value=appSummary}}
						<span class="help-block">不超过15个汉字或30个字母</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="appIntro">应用介绍</label>
					<div class="col-sm-10">
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
			</div>
			</script>
		</div>
	</div>
</div>
<script data-main="/js/app" src="/js/lib/require.js"></script>
</body>
</html>
