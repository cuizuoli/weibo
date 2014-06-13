define('controllers/admin_requested_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		menuRequestedListClass: 'active',
		actions: {
			saveRequest: function() {
				var _this = this;
				_this.set('status', {code: 'requested'});
				var weiboInfo = _this.store.push('weiboInfo', _this.get('model'));
				weiboInfo.save().then(function(model) {
					alert('保存成功！');
					_this.store.unloadAll('weiboInfo');
					_this.transitionToRoute('admin.requestedlist');
				});
			},
		}
	});
});
