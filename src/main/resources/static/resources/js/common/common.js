var _isLmbVisible = false;

function doForLeftMenuBar(menuTitle) {
	if (_isLmbVisible) {
		$("body").append("<style id='tempStyleLeftmenubar' type='text/css'>@media screen and (min-width: 500px) { #wrapper { padding-left : 225px; } #page-wrapper { padding : 10px; } }</style>");
		$("#toggleMenubar").html('<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-mainmenu-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>');
		$("#leftMenuBar").html($('#tmplleftMenuContent').html());
		$("#lmi_" + menuTitle).addClass("active");
		_isLmbVisible = false;
	} else {
		$("#tempStyleLeftmenubar").remove();
		$("#toggleMenubar").empty();
		$("#leftMenuBar").empty();
		_isLmbVisible = true;
	}
}

var DropDownItem = function (name, value) {
    this.name = name;
    this.value = value;
};

$(document).ready(function () {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 50) {
			$('#back-to-top').fadeIn();
		} else {
			$('#back-to-top').fadeOut();
		}
	});
	// scroll body to 0px on click
	$('#back-to-top').click(function() {
		$('#back-to-top').tooltip('hide');
		$('body,html').animate({ scrollTop : 0 }, 800);
		return false;
	});
	$('#back-to-top').show();
});