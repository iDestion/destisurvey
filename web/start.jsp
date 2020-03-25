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
    De echte vragen starten nu. De enquête gaat door tot alle vragen beantwoord zijn. U kunt op elk moment stoppen, resultaten worden tijdens het maken van de vragen opgeslagen.
</p>

<a href="${pageContext.request.contextPath}/init">
    <button style="width: 120px;" id="confirm">Naar de vragen→</button>
</a>
</body>
</html>
