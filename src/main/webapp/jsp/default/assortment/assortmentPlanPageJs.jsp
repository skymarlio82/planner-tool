<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery-1.12.4.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>
<!-- jQuery plug-ins for DataTables and Editor about UI -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.ui-1.11.4/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables-1.10.13/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables-1.10.13/js/dataTables.jqueryui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.buttons-1.2.4/js/dataTables.buttons.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.select-1.2.1/js/dataTables.select.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.buttons-1.2.4/js/buttons.jqueryui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.editor-1.6.1/js/dataTables.editor.cracked.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.editor-1.6.1/js/editor.jqueryui.min.js"/>"></script>

<!-- jQuery dataTables plug-ins for rowReorder -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.rowreorder-1.2.0/js/dataTables.rowReorder.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/assortment/assortment.js"/>"></script>
<script type="text/javascript">
	var _contextRoot = '<%=request.getContextPath() %>';
	doForLeftMenuBar("assortment");
	$(document).ready(function () {
		$("#leftMenuBarSwitcher").click(function (event) {
			event.preventDefault();
			doForLeftMenuBar("assortment");
		});
	});
</script>