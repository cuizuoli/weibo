define('controllers/admin_releaselist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuReleaseListClass: 'active',
		queryParams: ['id'],
		id: null,
		actions: {
			getRelease: function(id) {
				var _this = this;
				_this.transitionToRoute('admin.release', {
					queryParams: {'id': id}
				});
			}		}
	});
});
