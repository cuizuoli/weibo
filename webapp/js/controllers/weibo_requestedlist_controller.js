define('controllers/weibo_requestedlist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuRequestedListClass: 'active',
		queryParams: ['id'],
		id: null,
		actions: {
			getRequest: function(id) {
				var _this = this;
				_this.transitionToRoute('weibo.requested', {
					queryParams: {'id': id}
				});
			}
		}
	});
});
