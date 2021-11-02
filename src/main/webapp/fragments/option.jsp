<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="medical.m2i.bo.Ville"%>
<%
ArrayList<Ville> listeville = new ArrayList<Ville>();
%>

<%
listeville = (ArrayList) request.getAttribute("listeville");
if (listeville != null) {
%><option value="">--choisisser une ville--</option>
<%
for (Ville v : listeville) {
%><option value="<%=v.getNom()%>"><%=v.getNom()%></option>
<%
}
}
%>