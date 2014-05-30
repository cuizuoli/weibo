define('controllers/request_add_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		actions: {
			addRequest: function() {
				var store = this.store;
				var model = this.get('model');
				console.log(model);
				store.recordIsLoaded(WeiboApp.Request, model.appId);
				var request = store.find('request', model.appId).then(function() {
					store.recordIsLoaded(WeiboApp.Request, model.appId);
				});
				console.log(request);
			}
		}
	});
});
