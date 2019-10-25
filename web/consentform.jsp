<%--
  Created by IntelliJ IDEA.
  User: Destion
  Date: 25/10/2019
  Time: 11:44
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
    <link rel="stylesheet" href="Style/CSS/consent.css">
</head>
<body>
<img src="Style/Images/logo.png" alt="Logo Universiteit Utrecht">
<p class="content" id="header">
    Als u deel wilt nemen aan het onderzoek, vraag ik u om de toestemmingsverklaring hieronder goed te lezen en te bevestigen dat u toestemming geeft.
</p>
<br>
<br>
<p class="content" id="consentcontent">
    Toestemmingsverklaring: Ik ben naar tevredenheid over het onderzoek geïnformeerd. Ik heb de mogelijkheid gekregen om vragen over het onderzoek te stellen en eventuele vragen zijn naar tevredenheid beantwoord. Ik heb over deelname aan het onderzoek kunnen nadenken. Ik begrijp dat het mij vrij staat om op elk gewenst moment het experiment af te breken. Ik begrijp dat er voor mij geen risico's of ongemakken te verwachten zijn op basis van mijn deelname aan dit experiment. Ik begrijp dat de anonieme data die met dit experiment verzameld wordt, elektronisch opgeslagen zal worden. Ik begrijp dat de verzamelde data zal worden gebruikt voor wetenschappelijke doeleinden en eventueel zal worden gepubliceerd. Ik geef hierbij uit vrije wil toestemming om deel te nemen aan het onderzoek. Ten slotte bevestig ik dat ik 18 jaar of ouder ben.
</p>
<br>
<form id="radioform" action="${pageContext.request.contextPath}/consent" method="post">
    <label id="consentlabel" class="content" for="consent"><input type="radio" id="consent" name="consent" value="consent" required> Ik geef toestemming</label>
    <label id="noconsentlabel" class="content" for="noconsent"><input type="radio" id="noconsent" name="consent" value="noconsent"> Ik geef geen toestemming</label>
    <input id="confirm" type="submit" value="Continue→">
</form>

</body>
</html>
