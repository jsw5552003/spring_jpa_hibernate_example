<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1" session="false"%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>Home</title>
</head>

<body>
	<div id="page">
		<div id="header" style="display:inline-block; width:450px; margin-bottom:-10px; margin-top:-9px">
			<div style="margin-top:-10px; margin-left:-60px">
				<h6 style="text-align:center;">Professional Sports League Tool</h6>
			</div>
		</div>
	</div>
	<hr>
	<div id="selectionContent">
		<h3>Choose your team</h3>
		<hr style="float: left; width: 400px; clear: none;">
		<form id="selectionForm">
			<div style="min-width:120px; display:block; height:20px"><label for="leagues">League<span style="color:red;">*</span>:</label></div>
           	<div style="min-width:120px; display:block; height:20px">
           		<select id="comboBoxLeagues" name="leagues" style="padding:0px; width: 180px">
               		<option selected="selected"></option>
               	</select>
            </div> 
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			//call to populate the leagues
            $.getJSON("json/getAllLeagues.do", function(obj) {
            var jsonData = obj;
            populateDropDown(jsonData, "comboBoxLeagues");                     
            });
		});
	</script>
</body>