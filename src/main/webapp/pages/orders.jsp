<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Orders</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #008000;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #008000;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: bold;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #008000;
            color: #333;
            background-color: #98FB98;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        .pn {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<a href="../index.jsp" style="font-weight: bold">Back to main menu</a>
<br/>
<br/>

<h1>Order list</h1>
<c:if test="${!empty orders}">
    <table class="tg">
        <tr>
            <th width="50">Id</th>
            <th width="150">Client</th>
            <th width="50">Service</th>
            <th width="80">State</th>
            <th width="150">Team</th>
            <th width="150">Date order</th>
            <th width="150">Date execution</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.id}</td>
                <td>${order.id}</td>
                <td>${order.id}</td>
                <td>${order.id}</td>
                <td>${order.dateOrder}</td>
                <td>${order.dateExecution}</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
