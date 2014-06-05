define('controllers/weibo_list_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		weiboListActive: 'active',
		actions: {
			getRequest: function(appId) {
				var _this = this;
				var _store = _this.store;
				var weiboInfo = _store.find('weiboInfo', appId).then();
				_this.set('model', weiboInfo);
				_this.set('controllerName', 'weiboRequest');
				this.render('weibo/menu', {
					into: 'weibo',
					outlet: 'menu'
				});
				this.render('weibo/request', {
					into: 'weibo',
					outlet: 'content'
				});
			}
		}
	});
});
