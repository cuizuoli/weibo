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
				<li {{bind-attr class="adminRequestListActive"}}>{{#link-to 'admin.request.list'}}待申请应用{{/link-to}}</li>
				<li {{bind-attr class="adminRequestedListActive"}}>{{#link-to 'admin.requested.list'}}已申请应用{{/link-to}}</li>
				<li {{bind-attr class="adminCompletedListActive"}}>{{#link-to 'admin.completed.list'}}待审核应用{{/link-to}}</li>
				<li {{bind-attr class="adminVerifyListActive"}}>{{#link-to 'admin.verify.list'}}待广场应用{{/link-to}}</li>
				<li {{bind-attr class="adminSquareListActive"}}>{{#link-to 'admin.square.list'}}待上线应用{{/link-to}}</li>
				<li {{bind-attr class="adminReleaseListActive"}}>{{#link-to 'admin.release.list'}}上线应用{{/link-to}}</li>
			</ul>
		</div>
	</div>
</div>
</script>
<script type="text/x-handlebars" data-template-name="admin/request/list">
<h3>admin/request/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/request">
<h3>admin/request</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/requested/list">
<h3>admin/requested/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/requested">
<h3>admin/requested</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/completed/list">
<h3>admin/completed/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/completed">
<h3>admin/completed</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/verify/list">
<h3>admin/verify/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/verify">
<h3>admin/verify</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/square/list">
<h3>admin/square/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/square">
<h3>admin/square</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/release/list">
<h3>admin/release/list</h3>
</script>
<script type="text/x-handlebars" data-template-name="admin/release">
<h3>admin/release</h3>
</script>
<script data-main="/js/admin_app" src="/js/lib/require.js"></script>
<c:import url="/WEB-INF/includes/loading.jsp"/>
</body>
</html>
