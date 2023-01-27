<!DOCTYPE html>
<body xmlns:form="http://www.w3.org/1999/xhtml">
<h2>
    Please, book the hotel room
</h2>
<br>
<br>

<form:form action = "showDetails" modelAttribute="booking">
    Full name <form:input path="name"/>
    <br>
    Duration <form:input path="duration"/>
    <br>
    Cost <form:input path="cost"/>
    <br>
    Currency <form:input path="currency"/>
    <br>
    Date <form:input path="date"/>
    <br>
    NumberOfRoom <form:input path="numberOfRoom"/>
    <br>
    <br>
    <input type="submit" value="OK">

</form:form>
</body>
</html>