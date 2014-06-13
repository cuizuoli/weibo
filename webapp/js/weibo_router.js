define('weibo_router', ['Ember', 'WeiboApp'], function (Ember, WeiboApp) {
	return function () {
		// Weibo App
		WeiboApp.Router.map(function () {
			this.resource('weibo', {path: '/'}, function() {
				this.route('requestlist');
				this.route('request');
				this.route('requestedlist');
				this.route('requested');
				this.route('completedlist');
				this.route('completed');
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
				},
				error: function(reason) {
					console.log(reason);
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

		WeiboApp.WeiboRequestlistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'request'});
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
			}
		});

		WeiboApp.WeiboRequestedlistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'requested'});
			},
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/requestedlist', {
					into: 'weibo',
					outlet: 'content'
				});
			}
		});

		WeiboApp.WeiboRequestedRoute = Ember.Route.extend({
			model: function(params) {
				var _this = this;
				return _this.store.find('weiboInfo', params.queryParams.id);
			},
			renderTemplate: function() {
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/requested', {
					into: 'weibo',
					outlet: 'content'
				});
			}
		});

		WeiboApp.WeiboCompletedlistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCodes': 'completed,verify,square,release'});
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
			}
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
			}
		});

	};
});
