define('models/weibo_test', ['DS'], function (DS) {
	var attr = DS.attr;
	return DS.Model.extend({
		appId: attr(),
		nickname: attr(),
		status: attr(),
		creator: attr(),
		modifier: attr(),
		createTime: attr(),
		modifyTime: attr(),
		modifyTimeFormat: attr(),
		isShowAdded: function() {
			if (this.get('status.code') == 'add') {
				return true;
			}
			return false;
		}.property('status'),
		isShowDelete: function() {
			if (this.get('status.code') == 'add' || this.get('status.code') == 'added') {
				return true;
			}
			return false;
		}.property('status'),
		isShowDeleted: function() {
			if (this.get('status.code') == 'del') {
				return true;
			}
			return false;
		}.property('status')
	});
});
