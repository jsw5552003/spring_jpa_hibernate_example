<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1" session="false"%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>Home</title>

<script type="text/javascript"
       src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<script type="text/javascript"
       src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script type="text/javascript"
       src="<c:url value="/resources/js/home.js" />"></script>
<link href="<c:url value="/resources/css/jquery-ui.css" />"
       rel="stylesheet">
<link href="<c:url value="/resources/css/global.css" />"
       rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.css" />"
       rel="stylesheet">


</head>

<body>
	<div>
		<div id="header" style="display:inline-block; width:450px; margin-bottom:-10px; margin-top:-9px">
			<div style="margin-top:-10px; margin-left:-60px">
				<h6 style="text-align:center;">Professional Sports League Tool</h6>
			</div>
		</div>
	</div>
	<hr>
	<div id="selectionContent">
		<h3>Choose your Player</h3>
		<hr style="float: left; width: 400px; clear: none;">
		<br>
		<form id="selectionForm">
			<!-- Leagues combo box -->
			<div style="min-width:120px; display:block; height:20px"><label for="leagues">League<span style="color:red;">*</span>:</label></div>
           	<div style="min-width:120px; display:block; height:20px">
           		<select id="comboBoxLeagues" name="leagues" style="padding:0px; width: 180px">
               		<option selected="selected"></option>
               	</select>
            </div> 
            <br>
			<!-- Cities combo box -->
            <div style="min-width:120px; display:block; height:20px"><label for="cities">City<span style="color:red;">*</span>:</label></div>
           	<div style="min-width:120px; display:block; height:20px">
           		<select id="comboBoxCities" name="cities" style="padding:0px; width: 180px">
               		<option selected="selected"></option>
               	</select>
            </div>
            <br>
            <!-- Teams Combo box -->
             <div style="min-width:120px; display:block; height:20px"><label for="teams">Team<span style="color:red;">*</span>:</label></div>
           	<div style="min-width:120px; display:block; height:20px">
           		<select id="comboBoxTeams" name="teams" style="padding:0px; width: 180px">
               		<option selected="selected"></option>
               	</select>
            </div>
            <br>
            <!-- Players Combo box -->
             <div style="min-width:120px; display:block; height:20px"><label for="teams">Player<span style="color:red;">*</span>:</label></div>
           	<div style="min-width:120px; display:block; height:20px">
           		<select id="comboBoxPlayers" name="players" style="padding:0px; width: 180px">
               		<option selected="selected"></option>
               	</select>
            </div>
            <br>
		</form>
	</div>
	
<script>
	$(document).ready(function() {
		//clear cache
		$.ajaxSetup({ cache: false });
		//call to populate the leagues
		setDefaultList("Leagues");
		//call to populate the cities
		setDefaultList("Cities");
		//call to populate the teams
		setDefaultList("Teams");
		//call to populate the players
		setDefaultList("Players");
	});
</script>
</body>