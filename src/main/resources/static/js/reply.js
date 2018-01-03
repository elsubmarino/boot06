var replyManager=(function(){
	var getAll=function(obj,callback){
		console.log("get All...");
		
		$.getJSON("/replies/"+obj,callback);
	};
	
	var add=function(obj,callback){
		console.log("add...");
		//$.post("/replies/"+obj.bno,obj,callback,'json');
		$.ajax({
			url:"/replies/"+obj.bno,
			data:JSON.stringify(obj),
			contentType:"application/json",
			type:"POST",
			success:callback
		});
	};
	
	var update=function(obj,callback){
		console.log("update.....");
		$.ajax({
			url:"/replies/"+obj.bno,
			dataType:"json",
			type:"PUT",
			data:JSON.stringify(obj),
			contentType:"application/json",
			success:callback
		});
	};
	
	var remove=function(obj,callback){
		console.log("remove....");
		$.ajax({
			url:"/replies/"+obj.bno+"/"+obj.rno,
			type:"DELETE",
			contentType:"application/json",
			dataType:"json",
			success:callback
		});
	};
	
	return{
		getAll:getAll,
		add:add,
		update:update,
		remove:remove
	}
})();