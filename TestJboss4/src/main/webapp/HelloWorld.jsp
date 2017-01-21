<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
<title>Hello world</title>
</head>
<body>
<h2><bean:write name="myHelloWorldForm" property="message" /></h2>
</body>
</html>