define('controllers/admin_verifylist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuVerifyListClass: 'active',
		actions: {
			saveSquare: function(model) {
				var _this = this;
				model.set('status', {code: 'square'});
				var weiboInfo = _this.store.push('weiboInfo', model);
				weiboInfo.save().then(function(model) {
					alert('申请广场成功！');
					_this.store.unloadRecord(model);
				});
			}
		}
	});
});
