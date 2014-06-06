define('router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		WeiboApp.Router.map(function () {
			this.resource('weibo', {path: '/'}, function() {
				this.route('list');
				this.route('request');
				this.route('info');
			});
		});

		WeiboApp.WeiboIndexRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
			},
		});

		WeiboApp.WeiboListRoute = Ember.Route.extend({
			beforeModel: function(transition) {
				$('#loading').show();
			},
			afterModel: function(model, transition) {
				$('#loading').hide();
			},
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

		WeiboApp.WeiboInfoRoute = Ember.Route.extend({
			queryParams: {
				id: {refreshModel: true}
			},
			beforeModel: function(transition) {
				$('#loading').show();
			},
			afterModel: function(model, transition) {
				$('#loading').hide();
			},
			model: function(params) {
				return this.store.find('weiboInfo', params.queryParams.id);
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
