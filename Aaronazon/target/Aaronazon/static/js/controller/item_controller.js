'use strict';

angular.module('myApp').controller('ItemController', ['$scope', 'ItemService', function($scope, ItemService){
	var self = this;
	self.item = 
	{
		id:null, 
		itemName:'', 
		description:'', 
		itemType: {
			itemTypeName:''
		}
	};
	self.items =[];
	
	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	
	fetchAllItems();
	
	//gets all the items
	function fetchAllItems(){
		ItemService.fetchAllItems()
			.then(
			function(d){
				self.items = d;
				console.log('items', d);
			},
			function(errResponse){
				console.error('Error while fetching Items');
			}
		);
	}
	
	//creates a new item
	function createItem(item){
		console.log('Creating item', item)
		ItemService.createItem(item)
			.then(
			fetchAllItems,
			function(errResponse){
				console.error('Error while Creating Item');
			}
		);
	}
	
	//updates an item
	function updateItem(item, id){
		ItemService.updateItem(item, id)
			.then(
			fetchAllItems,
			function(errResponse){
				console.error('Error while updating Items');
			}
		);
	}
	
	//deletes an item
	function deleteItem(item, id){
		console.log('Deleting item', item, ' with id', id);
		ItemService.deleteItem(item, id)
			.then(
			fetchAllItems,
			function(errResponse){
				console.error('Error while deleting Item');
			}
		);
	}
	
	//allows you to add or update an item
	function submit(){
		if(self.item.id==null){
			createItem(self.item);
		}else {
			updateItem(self.item, self.item.id);
		}
		reset();
	}
	
	//allows you to edit an item
	function edit(id){
		for(var i = 0; i < self.items.length; i++){
			if(self.items[i].id == id){
				self.item = angular.copy(self.items[i]);
				break;
			}
		}
	}
	
	//removes from list
	function remove(id){
		if(self.item.id == id){
			reset();
		}
		deleteItem(id);
	}

	function reset(){
		self.item={id:null, itemName:'', description:'', itemType:''};
		$scope.myForm.$setPristine(); //makes form blank
	}

}]);