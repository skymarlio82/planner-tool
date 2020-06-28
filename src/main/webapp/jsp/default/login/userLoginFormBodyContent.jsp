<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="container">
	<div class="text-center"><h2><b>NIKE JUST SMARTER</b></h2></div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4 tab-content">
			<script id="customMsgTmpl" type="text/html"><em class="errMsg" data-bind='validationMessage: field'></em></script>
			<div id="login" class="tab-pane active">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in at here:</h3>
					</div>
					<div class="panel-body">
						<form id="userLogin-frm" name="userLogin-frm" class="form-signin" role="form">
							<fieldset>
								<div data-bind='validationOptions: { messageTemplate: "customMsgTmpl" }'>
									<div class="form-group">
										<input id="userName" name="userName" data-bind="value : userName" type="text" placeholder="Username" class="form-control" autocomplete="off" tabindex="1" autofocus />
									</div>
									<div class="form-group">
										<input id="userPassword" name="userPassword" data-bind="value : userPassword" type="password" placeholder="Password" class="form-control" autocomplete="off" tabindex="2" value="" />
									</div>
									<div class="checkbox">
										<label><input id="rememberMe" name="rememberMe" data-bind="checked : rememberMe" type="checkbox" tabindex="3" />Remember me</label>
									</div>
									<div class="form-group">
										<input id="userLogin-submit-btn" data-bind="click : submit" class="btn btn-lg btn-success btn-block" type="submit" value="Login" tabindex="4" />
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<div id="signup" class="tab-pane">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please fill the form to register:</h3>
					</div>
					<div class="panel-body">
						<form id="userReg-frm" name="userReg-frm" class="form-register" role="form">
							<fieldset>
								<div data-bind='validationOptions: { messageTemplate: "customMsgTmpl" }'>
									<div class="form-group">
										<input id="uname" name="uname" data-bind="value : uname" type="text" placeholder="Username" class="form-control" autocomplete="off" tabindex="1" autofocus />
									</div>
									<div class="form-group">
										<input id="password" name="password" data-bind="value : password" type="password" placeholder="Password" class="form-control" autocomplete="off" tabindex="2" value="" />
									</div>
									<div class="form-group">
										<input id="confirmedPassword" name="confirmedPassword" data-bind="value : confirmedPassword" type="password" placeholder="Password confirmation" class="form-control" autocomplete="off" tabindex="3" value="" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-4">
												<input id="captcha" name="captcha" type="text" placeholder="Captcha" class="form-control" autocomplete="off" tabindex="4" value="" />
											</div>
											<div class="col-sm-8">
												<img src="<c:url value="/user/default/image/captcha"/>" style="cursor:hand;margin-top:12px" width="195px" height="33px" onClick="this.src='<c:url value="/user/default/image/captcha"/>?nocache='+Math.random()" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<input id="userHpNum" name="userHpNum" data-bind="value : userHpNum" type="text" placeholder="HP No." class="form-control" autocomplete="off" tabindex="6" value="" />
									</div>
									<div class="form-group">
										<input id="userEmail" name="userEmail" data-bind="value : userEmail" type="email" placeholder="E-mail" class="form-control" autocomplete="off" tabindex="7" value="" />
									</div>
									<input id="userReg-submit-btn" data-bind="click : submit" class="btn btn-lg btn-success btn-block" type="submit" tabindex="8" value="Apply" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4 tab-content">
			<div class="text-center">
				<ul class="list-inline">
					<li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li>
					<li><a class="text-muted" href="#signup" data-toggle="tab">Register</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>