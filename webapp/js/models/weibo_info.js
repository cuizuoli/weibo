define('models/weibo_info', ['DS'], function (DS) {
	var attr = DS.attr;
	return DS.Model.extend({
		//id: attr(),
		appId: attr(),
		appKey: attr(),
		appSecret: attr(),
		redirectUri: attr(),
		appUri: attr(),
		appName: attr(),
		appSummary: attr(),
		appIntro: attr(),
		appType: attr(),
		status: attr(),
		creator: attr(),
		modifier: attr(),
		createTime: attr(),
		modifyTime: attr(),
		createTimeFormat: attr(),
		modifyTimeFormat: attr()
	});
});
