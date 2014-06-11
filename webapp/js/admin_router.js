define('admin_router', ['Ember', 'AdminApp'], function (Ember, AdminApp) {
	return function () {
		// Admin App
		AdminApp.Router.map(function () {
			this.resource('admin', {path: '/'}, function() {
				this.route('requestlist');
				this.route('request');
				this.route('completedlist');
				this.route('completed');
				this.route('verifylist');
				this.route('verify');
				this.route('squarelist');
				this.route('square');
				this.route('releaselist');
				this.route('release');
			});
		});

		AdminApp.LoadingView = Ember.View.extend({
			templateName : 'loading',
			elementId : 'loading'
		});

		AdminApp.ApplicationRoute = Ember.Route.extend({
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

		AdminApp.AdminIndexRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
			}
		});

		AdminApp.AdminRequestlistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'request'});
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/requestlist', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminRequestRoute = Ember.Route.extend({
			queryParams: {
				id: {refreshModel: true}
			},
			model: function(params) {
				return this.store.find('weiboInfo', params.queryParams.id);
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/request', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminCompletedlistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'completed'});
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/completedlist', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminCompletedRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/completed', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminVerifylistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'verify'});
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/verifylist', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminVerifyRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/verify', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminSquarelistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'square'});
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/squarelist', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminSquareRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/square', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminReleaselistRoute = Ember.Route.extend({
			model: function() {
				return this.store.findQuery('weiboInfo', {'statusCode': 'release'});
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/releaselist', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

		AdminApp.AdminReleaseRoute = Ember.Route.extend({
			queryParams: {
				id: {refreshModel: true}
			},
			model: function(params) {
				return this.store.find('weiboInfo', params.queryParams.id);
			},
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/release', {
					into: 'admin',
					outlet: 'content'
				});
			}
		});

	};
});
