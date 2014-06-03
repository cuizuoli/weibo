define('controllers/weibo_request_controller', ['Ember'], function (Ember) {
	return Ember.ObjectController.extend({
		actions: {
			addRequest: function() {
				var _this = this;
				var store = _this.store;
				var appId = _this.get('appId');
				store.find('request', appId).then(function(request) {
					alert('appId为' + appId + '的数据已存在，请使用其它的名字！');
				}, function(error) {
					if (error.status == '200' && error.statusText == 'OK') {
						var model = _this.get('model');
						store.createRecord('request', model).save().then(function(request) {
							console.log(request);
						}, function(error) {
							if (error.status == '200' && error.statusText == 'OK') {
								alert('申请成功！');
							} else {
								console.log('status - ' + error.status + ", statusText - " + error.statusText + ', responseText - ' + error.responseText);
							}
						});
					} else {
						console.log('status - ' + error.status + ", statusText - " + error.statusText + ', responseText - ' + error.responseText);
					}
				});
			}
		}
	});
});
