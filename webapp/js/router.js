define('router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		WeiboApp.Router.map(function () {
			this.resource('weibo', {path: '/'}, function() {
				this.route('request');
				this.route('requested');
				this.route('completed');
				this.route('verify');
				this.route('square');
				this.route('release');
			});
		});

		WeiboApp.WeiboRequestRoute = Ember.Route.extend({
			model: function() {
				return {};
			}
		});
	};
});
