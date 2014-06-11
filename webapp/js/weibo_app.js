// Define libraries
requirejs.config({
	baseUrl: '/js',

	shim: {
		Bootstrap: {
			deps: ['jQuery'],
			exports: 'Bootstrap'
		},
		Ember: {
			deps: ['jQuery', 'Handlebars'],
			exports: 'Ember'
		},
		DS: {
			deps: ['Ember'],
			exports: 'DS'
		}
	},

	paths: {
		// lib
		jQuery: 'lib/jquery-1.11.1.min',
		Handlebars: 'lib/handlebars-v1.3.0',
		Ember: 'lib/ember',
		DS: 'lib/ember-data',
		Bootstrap: 'lib/bootstrap.min',
		// App
		WeiboApp: 'weibo_app'
	}
});

define('WeiboApp', ['Ember', 'DS', 'Bootstrap'], function (Ember, DS, Bootstrap) {
	window.WeiboApp = Ember.Application.create({
		LOG_TRANSITIONS: true,
		LOG_TRANSITIONS_INTERNAL: true,
		LOG_VIEW_LOOKUPS: true,
		LOG_ACTIVE_GENERATION: true
	});
	window.WeiboApp.ApplicationAdapter = DS.RESTAdapter.extend({
		namespace: 'weibo/api'
	});
	Ember.RSVP.configure('onerror', function(error) {
		Ember.Logger.assert(false, error);
	});
	Ember.run.backburner.DEBUG = true;
	return window.WeiboApp;
});

requirejs(['WeiboApp'], function(WeiboApp) {
	WeiboApp.deferReadiness();
	requirejs([
		'weibo_router',
		'models/weibo_info',
		'controllers/weibo_requestlist_controller',
		'controllers/weibo_request_controller',
		'controllers/weibo_requestedlist_controller',
		'controllers/weibo_requested_controller',
		'controllers/weibo_completedlist_controller',
		'controllers/weibo_verifylist_controller',
		'controllers/weibo_squarelist_controller',
		'controllers/weibo_releaselist_controller'
	], function (Router,
			WeiboInfoModel,
			WeiboRequestlistController,
			WeiboRequestController,
			WeiboRequestedlistController,
			WeiboRequestedController,
			WeiboCompletedlistController,
			WeiboVerifylistController,
			WeiboSquarelistController,
			WeiboReleaselistController) {
		Router();
		WeiboApp.WeiboInfo = WeiboInfoModel;
		// request.
		WeiboApp.WeiboRequestlistController = WeiboRequestlistController;
		WeiboApp.WeiboRequestController = WeiboRequestController;
		// requested.
		WeiboApp.WeiboRequestedlistController = WeiboRequestedlistController;
		WeiboApp.WeiboRequestedController = WeiboRequestedController;
		WeiboApp.WeiboCompletedlistController = WeiboCompletedlistController;
		WeiboApp.WeiboVerifylistController = WeiboVerifylistController;
		WeiboApp.WeiboSquarelistController = WeiboSquarelistController;
		WeiboApp.WeiboReleaselistController = WeiboReleaselistController;
		WeiboApp.advanceReadiness();
	});
});
