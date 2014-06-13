define('models/weibo_info', ['DS'], function (DS) {
	var attr = DS.attr;
	return DS.Model.extend({
		appId: attr(),
		appKey: attr(),
		appSecret: attr(),
		redirectUri: attr(),
		appAccessUri: attr(),
		appUri: attr(),
		appName: attr(),
		appSummary: attr(),
		appIntro: attr(),
		appType: attr(),
		officialId: attr(),
		officialPassword: attr(),
		icon16: attr(),
		icon80: attr(),
		icon120: attr(),
		preview01: attr(),
		preview02: attr(),
		preview03: attr(),
		preview04: attr(),
		status: attr(),
		creator: attr(),
		modifier: attr(),
		createTime: attr(),
		modifyTime: attr(),
		modifyTimeFormat: attr()
	});
});
