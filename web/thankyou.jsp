<%--
  Created by IntelliJ IDEA.
  User: Destion
  Date: 25/10/2019
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music thumbnailing</title>

    <%@include file="favicon.jsp"%>

    <link rel="stylesheet" href="Style/CSS/reset.css">
    <link rel="stylesheet" href="Style/CSS/global.css">
    <link rel="stylesheet" href="Style/CSS/thankyou.css">
</head>
<body>
<img src="Style/Images/logo.png" alt="Logo Universiteit Utrecht">

<p id="header">Ik zou graag op de hoogte blijven van het onderzoek.</p>

<form id="radioform" action="${pageContext.request.contextPath}/getresult" method="post">
    <label id="resultyeslabel" class="content" for="resultyes"><input type="radio" id="resultyes" name="resultsradio" value="resultyes" required> Ja, e-mail: <input type="email" name="email" id="email"></label>
<%--    <label for="email" class="content">E-mail adres: <input type="email" name="email" id="email"></label>--%>
    <label id="resultnolabel" class="content" for="resultno"><input type="radio" id="resultno" name="resultsradio" value="resultno" required> Nee</label>
    <input id="confirm" type="submit" value="Continue→">
</form>
</body>
</html>
