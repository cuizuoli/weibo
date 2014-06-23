<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>${weiboInfo.appName}</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script type="text/javascript" src="/js/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="http://tjs.sjs.sinajs.cn/t35/apps/opent/js/frames/client.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="media">
				<a class="pull-left" href="javascript:void(0);">
					<img class="media-object" alt="" src="${weiboInfo.icon80}">
				</a>
				<div class="media-body">
					<h4>${weiboInfo.appName}</h4>
					${weiboInfo.appIntro}
				</div>
			</div>
			<div class="col-xs-6" style="margin-top:20px;">
			<a href="javascript:void(0);" class="thumbnail">
				<img src="${weiboInfo.preview01}" alt="">
			</a>
			</div>
			<div class="col-xs-6" style="margin-top:20px;">
			<a href="javascript:void(0);" class="thumbnail">
				<img src="${weiboInfo.preview02}" alt="">
			</a>
			</div>
			<div class="col-xs-6">
			<a href="javascript:void(0);" class="thumbnail">
				<img src="${weiboInfo.preview03}" alt="">
			</a>
			</div>
			<div class="col-xs-6">
			<a href="javascript:void(0);" class="thumbnail">
				<img src="${weiboInfo.preview04}" alt="">
			</a>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}'});
});
</script>
</body>
</html>