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
		AdminApp: 'admin_app'
	}
});

define('AdminApp', ['Ember', 'DS', 'Bootstrap'], function (Ember, DS, Bootstrap) {
	window.AdminApp = Ember.Application.create({
		LOG_TRANSITIONS: true,
		LOG_TRANSITIONS_INTERNAL: true,
		LOG_VIEW_LOOKUPS: true,
		LOG_ACTIVE_GENERATION: true
	});
	window.AdminApp.ApplicationAdapter = DS.RESTAdapter.extend({
		namespace: 'a/api'
	});
	Ember.RSVP.configure('onerror', function(error) {
		Ember.Logger.assert(false, error);
	});
	Ember.run.backburner.DEBUG = true;
	return window.AdminApp;
});

requirejs(['AdminApp'], function(AdminApp) {
	AdminApp.deferReadiness();
	requirejs([
		'admin_router'
	], function (Router) {
		Router();
		AdminApp.advanceReadiness();
	});
});
