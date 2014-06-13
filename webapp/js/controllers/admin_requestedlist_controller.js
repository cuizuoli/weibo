define('controllers/admin_requestedlist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuRequestedListClass: 'active',
		queryParams: ['id'],
		id: null,
		actions: {
			getRequest: function(id) {
				var _this = this;
				_this.transitionToRoute('admin.requested', {
					queryParams: {'id': id}
				});
			}
		}
	});
});
