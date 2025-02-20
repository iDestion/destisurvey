<%--
  Created by IntelliJ IDEA.
  User: Destion
  Date: 16/10/2019
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
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
    Bedankt voor de interesse! Dit onderzoek is een onderdeel van mijn bachelorscriptie "Informatiekunde" aan de Universiteit Utrecht en is mede mogelijk gemaakt door Muziekweb. Ik probeer te bepalen welk fragment uit een nummer het beste een idee van het gehele nummer geeft. Ik wil u vragen het volgende te doen: u krijgt van een aantal nummers drie fragmenten die u kunt beluisteren. Van elk nummer zijn de artiest en titel gegeven. De fragmenten rangschikt u op hoe goed ze een idee van het nummer geven naar uw mening. U hoeft het nummer niet te kennen. Meer uitleg volgt bij het voorbeeld. Voor verdere vragen kunt u mailen naar Mick Sneekes (m.sneekes@students.uu.nl). Voor klachten aangaande het onderzoek kunt u contact opnemen met Dr. Sander Bakkes (s.c.j.bakkes@uu.nl).
</p>

<a href="${pageContext.request.contextPath}/consentformnl.jsp">
    <button style="width: 120px;" id="confirm">Start de enquête→</button>
</a>

</body>
</html>