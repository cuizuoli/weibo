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
			<h3>微博管理主页</h3>
			<script type="text/x-handlebars" data-template-name="weibo/index">
			{{#link-to 'weibo.request'}}Request{{/link-to}}
			</script>
		</div>
	</div>
</div>
<script data-main="/js/app" src="/js/lib/require.js"></script>
</body>
</html>
