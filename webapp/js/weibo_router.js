define('weibo_router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		// Weibo App
		WeiboApp.Router.map(function () {
			this.resource('weibo', {path: '/'}, function() {
				this.route('list');
				this.route('request');
				this.route('info');
				this.route('request.list');
				this.route('requested.list');
				this.route('requested');
				this.route('completed.list');
				this.route('completed');
				this.route('verify.list');
				this.route('verify');
				this.route('square.list');
				this.route('square');
				this.route('release.list');
				this.route('release');
			});
		});

		WeiboApp.LoadingView = Ember.View.extend({
			templateName : 'loading',
			elementId : 'loading'
		});

		WeiboApp.ApplicationRoute = Ember.Route.extend({
			actions : {
				loading : function() {
					var view = this.container.lookup('view:loading').append();
					this.router.one('didTransition', view, 'destroy');
				}
			}
		});

		WeiboApp.WeiboIndexRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
			}
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
			model: function() {
				return {};
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

		WeiboApp.WeiboInfoRoute = Ember.Route.extend({
			queryParams: {
				id: {refreshModel: true}
			},
			model: function(params) {
				return this.store.find('weiboInfo', params.queryParams.id);
			},
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/info', {
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

		WeiboApp.WeiboRequestListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/request/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboRequestedListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/requested/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboRequestedRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/requested', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboCompletedListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/completed/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboCompletedRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/completed', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboVerifyListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/verify/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboVerifyRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/verify', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboSquareListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/square/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboSquareRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/square', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboReleaseListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/release/list', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

		WeiboApp.WeiboReleaseRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/release', {
					into: 'weibo',
					outlet: 'content'
				});
			},
		});

	};
});
