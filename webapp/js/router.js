define('router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		WeiboApp.Router.map(function () {
			this.resource('request', function() {
				this.route('add');
				this.route('list');
			});
		});

		WeiboApp.RequestAddRoute = Ember.Route.extend({
			model: function() {
				return {};
			}
		});

		WeiboApp.RequestListRoute = Ember.Route.extend({
		});
	};
});
