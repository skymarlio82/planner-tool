
var LoginViewModel = function () {
	var self = this;
	self.userName = ko.observable("test").extend({ required : true });
	self.userPassword = ko.observable("password").extend({ required : true });
	self.rememberMe = ko.observable(false);
	self.errors = ko.validation.group(this);
	self.submit = function () {
		if (self.errors().length == 0) {
			$.ajax({
				url :  _contextRoot + '/user/default/loginform',
				type : 'POST',
				data : ko.toJSON(self),
				contentType : 'application/json;charset=utf-8',
				success : function (data) {
					$('#userLogin-frm')[0].reset();
					if (data.status == "Success") {
						window.location.replace(_contextRoot + "/dashboard/user/home");
					} else {
						var message = "";
						for (var i = 0; i < data.errors.length; i++) {
							message = message + data.errors[i] + ', ';
						}
						alert("Error : " + message);
					}
				},
				error : function (e) {
					alert("error - " + error.status);
				}
			});
		} else {
			self.errors.showAllMessages();
		}
		return false;
	};
};

var SignupViewModel = function () {
	var self = this;
	self.uname = ko.observable().extend({ required : true, minLength : 4, maxLength : 12 });
	self.password = ko.observable().extend({ required : true });
	self.confirmedPassword = ko.observable().extend({
		required : true,
		validation : {
			validator : function (val, other) {
				return val == other();
			},
			message : 'Passwords do not match.',
			params : self.password
		}
	});
	self.userHpNum = ko.observable().extend({ required : true, pattern : '^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$' });
	self.userEmail = ko.observable().extend({ required : true, email : true });
	self.errors = ko.validation.group(this);
	self.submit = function () {
		if (self.errors().length == 0) {
			alert("Success!");
		} else {
			self.errors.showAllMessages();
		}
		return false;
	};
};

function verifyUserLoginForm(loginFormData) {
	$.ajax({
		url : _contextRoot + '/s/user/default/loginform',
		contentType : "application/json",
		dataType : "json",
		type : "POST",
		data : JSON.stringify(loginFormData),
		success : function (data) {
			$('#userLogin-frm')[0].reset();
			if (data.status == "Success") {
				window.location.replace(_contextRoot + "/s/dashboard/user/home");
			} else {
				var message = "";
				for (var i = 0; i < data.errors.length; i++) {
					message = message + data.errors[i] + '<br/>';
				}
				$("#msgServer").html(message);
			}
		},
		error : function (error) {
			alert("error - " + error.status);
		},
		complete : function () {
			
		}
	});
}

$(document).ready(function () {
	$.backstretch([ _contextRoot + "/resources/image/login_bs_1.jpg", _contextRoot + "/resources/image/login_bs_2.jpg" ], { fade : 1000, duration : 3000 });
//	$("#userLogin-frm").validate({
//		rules : {
//			userName : "required",
//			userPassword : "required"
//		},
//		messages : {
//			userName : "username required",
//			userPassword : "password required"
//		},
//		errorElement : "em",
//		errorPlacement : function (error, element) {
//			error.addClass("help-block");
//			error.insertAfter(element);
//		},
//		highlight : function (element, errorClass, validClass) {
//			$(element).parents(".form-group").addClass("has-error").removeClass("has-success");
//		},
//		unhighlight : function (element, errorClass, validClass) {
//			$(element).parents(".form-group").addClass("has-success").removeClass("has-error");
//		}
//		,submitHandler : function (form) {
//			verifyUserLoginForm({userName : $('#userName').val(), userPassword : $('#userPassword').val(), rememberMe : $('#rememberMe').attr('checked')});
//		}
//	});
	ko.validation.rules.pattern.message = 'Invalid Input.';
	ko.validation.configure({
		registerExtenders : true,
		messagesOnModified : true,
		insertMessages : true,
		parseInputAttributes : true,
		messageTemplate : null
	});
	var vmLogin = new LoginViewModel();
	ko.applyBindings(vmLogin, $('#login').get(0));
	var vmSignup = new SignupViewModel();
	ko.applyBindings(vmSignup, $('#signup').get(0));
});
