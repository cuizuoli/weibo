define('controllers/admin_completedlist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuCompletedListClass: 'active',
		actions: {
			saveVerify: function(model) {
				var _this = this;
				model.set('status', {code: 'verify'});
				var weiboInfo = _this.store.push('weiboInfo', model);
				weiboInfo.save().then(function(model) {
					alert('提交审核成功！');
					_this.store.unloadRecord(model);
				});
			}
		}
	});
});
