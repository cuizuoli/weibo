define('controllers/weibo_requested_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		menuRequestedListClass: 'active',
		weiboTests: function() {
			return this.store.findQuery('weiboTest', {appId: this.get('appId')});
		}.property('appId'),
		actions: {
			saveRequested: function() {
				var _this = this;
				var weiboInfo = _this.store.push('weiboInfo', _this.get('model'));
				weiboInfo.save().then(function(model) {
					alert('保存成功！');
					_this.store.unloadAll('weiboInfo');
					_this.transitionToRoute('weibo.requestedlist');
				});
			},
			saveCompleted: function() {
				var _this = this;
				_this.set('status', {code: 'completed'});
				var weiboInfo = _this.store.push('weiboInfo', _this.get('model'));
				weiboInfo.save().then(function() {
					alert('开发完了成功！');
					_this.store.unloadAll('weiboInfo');
					_this.transitionToRoute('weibo.completedlist');
				});
			},
			addWeiboTest: function() {
				var _this = this;
				_this.store.createRecord('weiboTest', {
					appId: _this.get('appId'),
					nickname: $('#nickname').val()
				}).save().then(function(weiboTest) {
					alert('测试帐号请求已发出，请等待后台人员处理！');
					_this.store.findQuery('weiboTest', {appId: _this.get('appId')}).then(function(weiboTestList) {
						_this.set('weiboTestList', weiboTestList);
					});
				});
			},
			deleteWeiboTest: function(weiboTest) {
				var _this = this;
				if (weiboTest.get('status.code') == 'del') {
					alert('请等待后台人员处理！');
				} else {
					_this.store.push('weiboTest', {
						id: weiboTest.id,
						status: {code: 'del'}
					}).save().then(function(result) {
						if (result.get('data').appId) {
							alert('删除测试帐号请求已发出，请等待后台人员处理！');
						} else {
							alert('删除测试帐号成功！');
						}
						_this.store.findQuery('weiboTest', {appId: _this.get('appId')}).then(function(weiboTestList) {
							_this.set('weiboTests', weiboTestList);
						});
					});
				}
			}
		}
	});
});
