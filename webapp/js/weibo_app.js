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
		'controllers/weibo_list_controller',
		'controllers/weibo_request_controller',
		'controllers/weibo_info_controller'
	], function (Router,
			WeiboInfoModel,
			WeiboListController,
			WeiboRequestController,
			WeiboInfoController) {
		Router();
		WeiboApp.WeiboInfo = WeiboInfoModel;
		WeiboApp.WeiboListController = WeiboListController;
		WeiboApp.WeiboRequestController = WeiboRequestController;
		WeiboApp.WeiboInfoController = WeiboInfoController;
		WeiboApp.advanceReadiness();
	});
});
