<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>:: 에이앤티 테스트게시판 ::</title>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/etc.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').trigger('focus')
	});
	
	 
</script>

<!--ui object -->
<div id="wrap">
  <!--header -->
  <div id="header">
    <div class="topnav" id="myTopnav">
      <ul>
        <li> <a href="/">홈으로</a></li>
        <li> <a href="/board/list">FORM게시판</a></li>
        <li> <a href="/board/listAjax">AJAX게시판</a></li>
        <li> <a href="#">공지게시판</a></li>
        <li> <a href="#">자유게시판</a></li>
        <li> <a href="#">게시판관리</a></li>
        <li> <a href="#">회원괸리</a></li>
        <li> <a href="#">시스템관리</a></li>
      </ul>
    </div>
  </div>
  <!--//header --> 
  