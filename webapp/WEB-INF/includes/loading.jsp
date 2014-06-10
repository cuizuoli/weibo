<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.theme-popover-mask {z-index:9998;position:fixed;top:0;left:0;width:100%;height:100%;background:#fff;opacity:0.5;filter:alpha(opacity=50);}
.theme-popover {z-index:9999;position:fixed;top:50%;left:50%;width:100px;height:100px;margin:-50px 0 0 -50px;border-radius:5px;opacity:0.5;filter:alpha(opacity=50);}
</style>
<script type="text/x-handlebars" data-template-name="loading">
<div id="loading">
	<div class="theme-popover-mask"></div>
	<div class="theme-popover">
		<img alt="loading" src="/images/ajax-loading.gif">
	</div>
</div>
</script>