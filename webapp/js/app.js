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
		Ember: 'lib/ember-1.5.1',
		DS: 'lib/ember-data.min',
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
		'models/request',
		'controllers/weibo_request_controller'
	], function (Router, WeiboInfoModel, RequestModel, WeiboRequestController) {
		// Configure router.
		Router();
	
		// Configure models.
		WeiboApp.WeiboInfo = WeiboInfoModel;
		WeiboApp.Request = RequestModel;

		// Configure controllers.
		WeiboApp.WeiboRequestController = WeiboRequestController;

		// Configure view.
		//Weibo.EditTodoView = EditTodoView;

		WeiboApp.advanceReadiness();
	});
});
