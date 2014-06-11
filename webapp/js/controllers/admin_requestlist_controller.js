define('controllers/admin_requestlist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuRequestListClass: 'active',
		queryParams: ['id'],
		id: null,
		actions: {
			getRequest: function(id) {
				var _this = this;
				_this.transitionToRoute('admin.request', {
					queryParams: {'id': id}
				});
			}
		}
	});
});
