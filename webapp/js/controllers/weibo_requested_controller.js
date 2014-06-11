define('controllers/weibo_requested_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		menuRequestedListClass: 'active',
		requestBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'request') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
		requestedBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'requested') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
		completedBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'completed') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
		verifyBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'verify') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
		squareBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'square') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
		releaseBtnClass: function() {
			var btnClass = 'btn btn-default';
			if (this.get('status.code') == 'release') {
				btnClass = 'btn btn-success';
			}
			return btnClass;
		}.property('status.code'),
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
			}
		}
	});
});