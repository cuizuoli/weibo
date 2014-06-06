define('controllers/weibo_list_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		weiboListActive: 'active',
		queryParams: ['id'],
		id: null,
		actions: {
			getRequest: function(id) {
				var _this = this;
				_this.transitionToRoute('weibo.info', {
					queryParams: {'id': id}
				});
			}
		}
	});
});
