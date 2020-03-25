<%--
  Created by IntelliJ IDEA.
  User: Destion
  Date: 18/12/2019
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music-Thumbnails</title>

    <%@include file="favicon.jsp"%>

    <link rel="stylesheet" href="Style/CSS/reset.css">
    <link rel="stylesheet" href="Style/CSS/global.css">
</head>
<body>
<img src="Style/Images/logo.png" alt="Logo Universiteit Utrecht">
<p class="content">
    From now on, real questions will be shown. The survey will keep going until all questions are answered. You can stop at any time, results are recorded while the questions are answered.
</p>

<a href="${pageContext.request.contextPath}/initen">
    <button style="width: 120px;" id="confirm">To the questions→</button>
</a>
</body>
</html>
