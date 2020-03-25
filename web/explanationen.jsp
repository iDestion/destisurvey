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
    Thank you for your interest! This research is part of my bachelor thesis for the Information Science degree at Utrecht University and is done in co-operation with Muziekweb. We are trying to determine which fragment of a song best represents the entirety of the track. I would like to ask you to do the following: you will be presented with three fragments of a song at a time. Each question shows the title and artist of the song. Please rank these fragments in the order of representativeness for the complete track, with the most representative one as the first. You do not need to know the song in advance. More guidance follows in the example questions. For further question you can contact Mick Sneekes (m.sneekes@students.uu.nl). For complaints about this survey you can contact Dr. Sander Bakkes (s.c.j.bakkes@uu.nl).
</p>

<a href="${pageContext.request.contextPath}/consentformen.jsp">
    <button style="width: 120px;" id="confirm">Start the survey→</button>
</a>

</body>
</html>