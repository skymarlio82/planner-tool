<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery-1.12.4.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>
<!-- Bootstrap Multiselect JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-multiselect-0.9.13/js/bootstrap-multiselect.js"/>"></script>
<!-- jQuery plug-ins for DataTables and Editor about UI -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.ui-1.11.4/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables-1.10.13/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables-1.10.13/js/dataTables.jqueryui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.buttons-1.2.4/js/dataTables.buttons.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.select-1.2.1/js/dataTables.select.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.buttons-1.2.4/js/buttons.jqueryui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.editor-1.6.1/js/dataTables.editor.cracked.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.editor-1.6.1/js/editor.jqueryui.min.js"/>"></script>
<!-- jQuery dataTables plug-ins for fixedColumns -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.fixedcolumns-3.2.2/js/dataTables.fixedColumns.min.js"/>"></script>
<!-- jQuery plug-ins for Prompt -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.impromptu-6.2.2/js/jquery-impromptu.min.js"/>"></script>
<!-- CanvasJS Charts -->
<script type="text/javascript" src="<c:url value="/resources/plugin/canvasjs-1.9.10/js/canvasjs.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/canvasjs-1.9.10/js/jquery.canvasjs.min.js"/>"></script>
<!-- jQuery dataTables plug-ins for KeyTable -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.keytable-2.2.1/js/dataTables.keyTable.min.js"/>"></script>
<!-- jQuery dataTables plug-ins for autofill -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.autofill-2.2.0/js/dataTables.autoFill.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.datatables.autofill-2.2.0/js/autoFill.jqueryui.min.js"/>"></script>
<!-- MVVM Knockout -->
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout-3.4.2/js/knockout.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout.mapping-2.4.1/js/knockout.mapping.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout.validation-1.0.1/js/knockout.validation.min.js"/>"></script>
<!-- APP Script -->
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/buyplan/buyplan_t2d_01.js"/>"></script>
<script type="text/javascript">
	var _contextRoot = '<%=request.getContextPath() %>';
	doForLeftMenuBar("buyplan");
	$(document).ready(function () {
		$("#leftMenuBarSwitcher").click(function (event) {
			event.preventDefault();
			doForLeftMenuBar("buyplan");
		});
	});
</script>