<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://js.t.sinajs.cn/t4/enterprise/js/public/appframe/appClient.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<script type="text/javascript">
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}',display:'apponweibo'});
});
</script>
<style type="text/css">
#authDiv {z-index:10}
</style>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">


<!--====headerArea====-->
<div id="headerArea">
</div>
<!--====headerArea end====-->
</div>
<!--=========wrapper end=========-->
</body>
</html>
