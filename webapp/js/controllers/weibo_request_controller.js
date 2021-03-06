define('controllers/weibo_request_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		menuRequestClass: 'active',
		actions: {
			addRequest: function() {
				var _this = this;
				var appId = _this.get('appId');
				_this.store.findQuery('weiboInfo', {'appId': appId}).then(function(weiboInfos) {
					if (weiboInfos.content.length > 0) {
						alert('ID为' + appId + '的应用已经存在，请使用其它的名字！');
					} else {
						_this.set('appType', {code: $('#appTypeDiv label.active input').val()});
						var weiboInfo = _this.store.createRecord('weiboInfo', _this.get('model'));
						weiboInfo.save().then(function() {
							alert('申请成功！');
							_this.store.unloadAll('weiboInfo');
							_this.transitionToRoute('weibo.requestlist');
						});
					}
				});
			}
		}
	});
});
