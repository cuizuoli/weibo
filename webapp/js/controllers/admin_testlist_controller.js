define('controllers/admin_testlist_controller', ['Ember'], function (Ember) {
	return Ember.ArrayController.extend({
		menuTestListClass: 'active',
		actions: {
			addedWeiboTest: function(weiboTest) {
				var _this = this;
				_this.store.push('weiboTest', {
					id: weiboTest.id,
					status: {code: 'added'}
				}).save().then(function() {
					alert('添加测试帐号成功！');
					_this.store.findQuery('weiboTest', {'statusCodes': 'add,del'}).then(function(weiboTests) {
						_this.set('model', weiboTests);
					});
				});
			},
			deletedWeiboTest: function(weiboTest) {
				var _this = this;
				_this.store.push('weiboTest', {
					id: weiboTest.id,
					status: {code: 'del'}
				}).save().then(function() {
					alert('删除测试帐号成功！');
					_this.store.findQuery('weiboTest', {'statusCodes': 'add,del'}).then(function(weiboTests) {
						_this.set('model', weiboTests);
					});
				});
			}
		}
	});
});
