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
    If you want to participate in this research, I would like to ask you to thoroughly read the text below and to confirm you consent to it.
</p>
<br>
<br>
<p class="content" id="consentcontent">
    Statement of consent: I have been informed about the research to my satisfaction. I have been given the possibility of asking question about the research and these, if any, have been answered to satisfaction. I have been able to think about joining the research. I understand I can end the experiment at any time. I understand no risks or discomfort are expected to result from my participation in this research. I understand the anonymous data, collected by this survey, will be stored electronically. I understand the anonymous data collected by this survey will be used for scientific purposes and may be published. I hereby voluntarily consent to participating in this research. Lastly, I confirm being at least 18 years of age.
</p>
<br>
<form id="radioform" action="${pageContext.request.contextPath}/consent" method="post">
    <label id="consentlabel" class="content" for="consent"><input type="radio" id="consent" name="consent" value="consenten" required> I consent</label>
    <label id="noconsentlabel" class="content" for="noconsent"><input type="radio" id="noconsent" name="consent" value="noconsenten"> I don't consent</label>
    <input id="confirm" type="submit" value="Continue→">
</form>

</body>
</html>
