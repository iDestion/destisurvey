<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Destion
  Date: 04/10/2019
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Music-Thumbnails</title>

    <!-- CSS sheets -->
      <link rel="stylesheet" href="Style/CSS/reset.css">
      <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="Style/CSS/global.css">
  </head>
  <body>

<%--  TODO make preview questions (static) and welcome page--%>
<%--  TODO handle random song/fragment combination  --%>

  <!-- Load in the necessary JS scripts for the sortable list -->
  <script src="JS/jquery.js"></script>
  <script src="JS/jquery-ui.js"></script>
  <script src="JS/jquery-ui-touch.js"></script>

  <img src="Style/Images/logo.png" alt="Logo Universiteit Utrecht">
  
  <p class="content">
      This is an example question, purely used as a proof of context. The top fragment is the most representative, the bottom one the least. Music snippets do not belong to me.
      <br>The song used is <span style="font-weight: bold">Lola Montez</span> by <span style="font-weight: bold">Volbeat</span>.
  </p>

  <ul id="image-list1" class="sortable-list">
    <li id="fragment1"  class="ranker">
      <p>Fragment 1</p>
      <audio controls>
        <source src=<%=%> type="audio/flac">
      </audio>
    </li>
    <li id="fragment2"  class="ranker">
      <p>Fragment 2</p>
      <audio controls>
        <source src="Music/LolaMontezRif.flac" type="audio/flac">
      </audio>
    </li>
    <li id="fragment3"  class="ranker">
      <p>Fragment 3</p>
      <audio controls>
        <source src="Music/LolaMontezChorus.flac" type="audio/flac">
      </audio></li>
  </ul>

  <form action="${pageContext.request.contextPath}/store" method="post">
    <input type="hidden" name="result" id="result" value="">
    <input id="confirm" type="submit" value="Continue→">
  </form>
  <script src="JS/sortable.js"></script>
  </body>
</html>
