define('admin_router', ['Ember', 'AdminApp'], function (Ember, AdminApp) {
	return function () {
		// Admin App
		AdminApp.Router.map(function () {
			this.resource('admin', {path: '/'}, function() {
				this.route('request.list');
				this.route('request');
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

		AdminApp.AdminIndexRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
			},
		});

		AdminApp.AdminRequestListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/request/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

		AdminApp.AdminRequestRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/request', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

		AdminApp.AdminRequestedListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/requested/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

		AdminApp.AdminRequestedRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/requested', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

		AdminApp.AdminCompletedListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/completed/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
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
			},
		});

		AdminApp.AdminVerifyListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/verify/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
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
			},
		});

		AdminApp.AdminSquareListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/square/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
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
			},
		});

		AdminApp.AdminReleaseListRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/release/list', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

		AdminApp.AdminReleaseRoute = Ember.Route.extend({
			renderTemplate: function() {
				this.render('admin/menu', {
					into: 'admin',
					outlet: 'menu'
				});
				this.render('admin/release', {
					into: 'admin',
					outlet: 'content'
				});
			},
		});

	};
});
