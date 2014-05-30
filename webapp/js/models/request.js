define('models/request', ['DS'], function (DS) {
	var attr = DS.attr;
	return DS.Model.extend({
		appId: attr(),
		appUri: attr(),
		appName: attr(),
		appSummary: attr(),
		appIntro: attr()
	});
});
