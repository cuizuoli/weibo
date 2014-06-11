define('controllers/admin_squarelist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuSquareListClass: 'active',
		actions: {
			saveRelease: function(model) {
				var _this = this;
				model.set('status', {code: 'release'});
				var weiboInfo = _this.store.push('weiboInfo', model);
				weiboInfo.save().then(function(model) {
					alert('申请上线成功！');
					_this.store.unloadRecord(model);
				});
			}
		}
	});
});
