<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/8/21
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Your Profile</title>
</head>
<body>
<%-- Verify that the user is logged in --%>
<c:if test="${validUser == null}">
    <jsp:forward page="login.jsp">
        <jsp:param name="origURL" value="${pageContext.request.requestURL}" />
        <jsp:param name="errorMsg" value="Please log in first." />
    </jsp:forward>
</c:if>

<%-- Verify that it's a POST method --%>
<c:if test="${pageContext.request.method != 'POST'}">
    <c:redirect url="profile.jsp" />
</c:if>

<%-- Update the project list in the bean --%>
<c:set target="${validUser}" property="projects" value="${paramValues.projects}" /> <sql:transaction>
    <%-- Delete the old project (if any) and insert the new ones --%>
    <sql:update> DELETE FROM EmployeeProjects WHERE UserName = ?
        <sql:param value="${validUser.userName}" /> </sql:update>
    <c:forEach items="${validUser.projects}" var="project">
        <sql:update> INSERT INTO users (UserName, ProjectName) ...



</body>
</html>
