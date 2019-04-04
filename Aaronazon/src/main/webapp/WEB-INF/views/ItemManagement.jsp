<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/item_service.js' />"></script>
<script src="<c:url value='/static/js/controller/item_controller.js' />"></script>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet" type="text/css"></link>
<head>
<meta charset="ISO-8859-1">
<title>Item</title>
<style>
	table{
		margin-top: 10px;
		border: solid black 1px;
	}
	table tr td{
		padding-bottom: 30px;
	}
</style>
</head>
<body ng-app="myApp" class="ng-cloak">
	<t:headerfooter>
	<div class="container" ng-controller="ItemController as ctrl">
		<h1><span>Item Administration Form</span></h1>
		<form name="myForm">
		<table class="new-item table">
		<tr>
		<td>
			<input type="hidden" ng-model="ctrl.item.id" />
			<label for="itemName">Item Name</label>
		</td>
		<td>
			<input type="text" ng-model="ctrl.item.itemName" id="itemName" name="itemName" placeholder="Enter Item Name" required ng-minlength="3"/>
			<div class="{ 'has-error' : 'myForm.itemName.$dirty && myForm.itemName.$invalid && !myForm.itemName.$pristine'}">
				<span ng-show="myForm.itemName.$error.required">This is required Field </span>
				<span ng-show="myForm.itemName.$error.minlength">Item name has to be at least 3 characters</span>
			</div>
		</td>
		</tr>
		<tr><td>
			<label class="itemname-label" for="itemDesc">Item Description</label>
		</td>
		<td>
			<input type="text" ng-model="ctrl.item.description" id="itemDesc" placeholder="Enter your Item Description" />
		</td></tr>
		<tr><td>
			<label class="itemtype-label" for="itemTypeName">Item Type</label>
		</td>
		<td>
			<select ng-model="ctrl.item.itemType.itemTypeName" id="itemTypeName">
				<option value="Shirt">Shirt</option>
				<option value="Socks">Socks</option>
				<option value="Pants">Pants</option>
			</select>
		</td></tr>
		<tr>
		<td>
			<input type="submit" ng-click="ctrl.submit()" value="{{!ctrl.item.id ? 'Add' : 'Update'}}" class="btn-submit" ng-disabled="myForm.$invalid">
		</td>
		<td>
			<button type="button" ng-click="ctrl.reset()" class="btn-warning" ng-disabled="myForm.$pristine">Reset Form</button>
		</td>
			</tr>
		</table>
		</form>


		<div class="tablecontainer"><span>List of Items</span>
			<table class="item table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Item Type</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="itm in ctrl.items">
						<td><span ng-bind="itm.id"></span></td>
						<td><span ng-bind="itm.itemName"></span></td>
						<td><span ng-bind="itm.description"></span></td>
						<td><span ng-bind="itm.itemType.itemTypeName"></span></td>
						<td>
							<button type="button" ng-click="ctrl.edit(itm.id)" class="btn success">Edit</button>
							<button type="button" ng-click="ctrl.remove(itm.id)" class="btn remove">Remove</button>
						</td>
				</tbody>
			</table>
		</div>
	</div>
	</t:headerfooter>
</body>
</html>