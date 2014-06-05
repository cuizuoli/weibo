define('router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		WeiboApp.Router.map(function () {
			this.resource('weibo', {path: '/'}, function() {
				this.route('list');
				this.route('request');
			});
		});

		WeiboApp.WeiboListRoute = Ember.Route.extend({
			model: function() {
				return this.store.findAll('weiboInfo');
			},
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
			actions: {
				error: function(reason) {
					console.log(reason);
				}
			}
		});

		WeiboApp.WeiboRequestRoute = Ember.Route.extend({
			model: function(params) {
				var appId = params.queryParams.appId;
				if (!appId) {
					appId = '-1';
				}
				return this.store.find('weiboInfo', appId);
			},
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/request', {
					into: 'weibo',
					outlet: 'content'
				});
			},
			actions: {
				error: function(reason) {
					console.log(reason);
				}
			}
		});
	};
});
