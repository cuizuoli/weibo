define('controllers/weibo_request_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		appId: '',
		actions: {
			addRequest: function() {
				var store = this.store;
				var appId = this.get('appId');
				store.find('request', appId).then(function(request) {
					console.log(request.get('data'));
				}, function(error) {
					console.log(error.readyState, error.responseText, error.status, error.statusText);
				});
			},
			checkRequest: function() {
				var store = this.store;
				var appId = this.get('appId');
				store.find('request', appId).then(function(request) {
					console.log(request.get('data'));
				}, function(error) {
					console.log(error.readyState, error.responseText, error.status, error.statusText);
				});
			}
		}
	});
});
