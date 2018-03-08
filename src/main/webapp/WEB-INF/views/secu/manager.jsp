<%--
  Created by IntelliJ IDEA.
  User: cooki
  Date: 2018-03-05
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Only Manager Can Access This Page!!!</h1>

  <h2><sec:authentication property="name"></sec:authentication></h2>
</body>
</html>
