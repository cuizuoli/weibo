<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>${appName}</title>
<script type="text/javascript" src="/js/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="http://js.t.sinajs.cn/t4/enterprise/js/public/appframe/appClient.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}',display:'apponweibo'});
});
</script>
</body>
</html>