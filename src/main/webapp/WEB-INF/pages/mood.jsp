<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/20
  Time: 下午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>说说</title>
</head>
<body>
<div id="moods" align="center">
    <b>说说列表</b>
    <table align="center" border="1">
        <tr>
            <th>用户名</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>点赞数</th>
            <th>点赞</th>
        </tr>
        <c:if test="${moodList == null}">
            <tr>
                <td>目前没有说说</td>
            </tr>
        </c:if>
        <c:if test="${moodList != null}">
            <c:forEach items="${moodList}" var="mood">
                <tr>
                    <td>${mood.nickname}</td>
                    <td>${mood.content}</td>
                    <td><fmt:formatDate value="${mood.publishTime}" pattern="yy-MM-dd HH:mm:ss"/> </td>
                    <td>${mood.praiseNum}</td>
                    <td><a id="praise" href="/mood/${mood.id}/praiseForRedis?userId=${mood.userId}">赞</a> </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>
</body>
</html>
