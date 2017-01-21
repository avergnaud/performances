<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
  <head>
    <title>Formulaire</title>
    <html:base/>
  </head>
  <body bgcolor="white">
    <html:form action="formulaire" focus="champ1">
      <table border="0" align="center">
        <tr>
          <td align="right">
            Champ 1
          </td>
          <td align="left">
            <html:text property="champ1" size="20" maxlength="20"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            Champ 2
          </td>
          <td align="left">
            <html:text property="champ2" size="20" maxlength="20"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <html:submit property="submit" value="Submit"/>
          </td>
          <td align="left">
            <html:reset/>
          </td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>