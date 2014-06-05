define('controllers/weibo_request_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		weiboRequestActive: 'active',
		queryParams: ['appId'],
		appId: null,
		actions: {
			getRequest: function() {
				var _this = this;
				console.log('test');
			}
		}
	});
});
