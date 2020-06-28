<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery-1.12.4.min.js"/>"></script>
<!-- jQuery templates -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.loadTemplate-1.5.10/js/jquery.loadTemplate.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>
<!-- Morris Charts JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.morris-0.5.0/js/raphael.min-2.1.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.morris-0.5.0/js/morris.min.js"/>"></script>
<!-- jQuery flot -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.flot-0.8.3/js/jquery.flot.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.flot-0.8.3/js/jquery.flot.resize.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.flot-0.8.3/js/jquery.flot.time.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.flot-0.8.3/js/jquery.flot.stack.min.js"/>"></script>
<!-- CanvasJS Charts -->
<script type="text/javascript" src="<c:url value="/resources/plugin/canvasjs-1.9.10/js/canvasjs.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/canvasjs-1.9.10/js/jquery.canvasjs.min.js"/>"></script>
<!-- WebSocket -->
<script type="text/javascript" src="<c:url value="/resources/plugin/sockjs-client-1.1.4/js/sockjs.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/stomp-2.3.3/js/stomp.min.js"/>"></script>

<!-- The main application script -->
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard/dashboard.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard/canvasjs-demo-init.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard/flot-demo-init.js"/>"></script>

<script type="text/javascript">
	var _contextRoot = '<%=request.getContextPath() %>';
	var _username= '${sessionScope.USER_CONFIG.userName}';
	$(document).ready(function() {
		doForLeftMenuBar("dashboard");
		$("#leftMenuBarSwitcher").click(function (event) {
			event.preventDefault();
			doForLeftMenuBar("dashboard");
		});
	});
</script>
