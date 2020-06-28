<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2><b>SYSTEM ERROR PAGE</b></h2>
<br/>
<span style="font-family:arial;font-weight:bold;color:red;">HTTP:500</span>
<br/>
<span style="font-family:arial;font-size:12px;color:blue;"><c:out value="${ERROR_DETAIL}"/></span>