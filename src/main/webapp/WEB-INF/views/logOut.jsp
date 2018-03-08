<%--
  Created by IntelliJ IDEA.
  User: cooki
  Date: 2018-03-05
  Time: 오후 7:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Logout Page</title>
</head>
<body>
  Logout Page
  <h1>로그 아웃 하시려구요?</h1>
  <form action="/logOut" method="post">

      <input type="hidden"                        6
             name="${_csrf.parameterName}"
             value="${_csrf.token}"/>
      <button type="submit" class="btn">Log Out</button>

  </form>

</body>
</html>
