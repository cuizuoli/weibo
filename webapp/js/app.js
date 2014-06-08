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

requirejs(['WeiboApp'], function(WeiboApp) {
	WeiboApp.deferReadiness();
	requirejs([
		'router',
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
