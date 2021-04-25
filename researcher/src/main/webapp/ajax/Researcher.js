function getRow() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("researcher_id").value = this.cells[1].textContent;
			document.getElementById("name").value = this.cells[2].textContent;
			document.getElementById("company").value = this.cells[3].textContent;
			document.getElementById("product_id").value = this.cells[4].textContent;
			document.getElementById("product_name").value = this.cells[5].textContent;
			document.getElementById("product_description").value = this.cells[6].textContent;
			document.getElementById("product_price").value = this.cells[7].textContent;
		};
	}
}

function getRowSearch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("researcher_id").value = this.cells[1].textContent;
			document.getElementById("name").value = this.cells[2].textContent;
			document.getElementById("company").value = this.cells[3].textContent;
			document.getElementById("product_id").value = this.cells[4].textContent;
			document.getElementById("product_name").value = this.cells[5].textContent;
			document.getElementById("product_description").value = this.cells[6].textContent;
			document.getElementById("product_price").value = this.cells[7].textContent;
		};
	}
}

function getID() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("researcher_id").value = this.cells[1].textContent;
		};
	}
}

function getIDserch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("researcher_id").value = this.cells[1].textContent;
		};
	}
}

function resetForm() {
	document.getElementById("researcher_id").value = "0";
	document.getElementById("name").value = "";
	document.getElementById("company").value = "";
	document.getElementById("product_id").value = "";
	document.getElementById("product_name").value = "";
	document.getElementById("product_description").value = "";
	document.getElementById("product_price").value = "";
}

function save() {
	var researcher_id = $('#researcher_id').val();
	researcher_id = parseInt(researcher_id);
	if (researcher_id === 0) {
		if(ValidInput()){
			$.ajax({
				url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researcher',
				method : 'POST',
				headers : {
					"Content-Type" : "application/json"
				},
				data : getJSON(),
				success : function(data) {
					$("#idTable").find("tr:gt(0)").remove();
					$("#table").find("tr:gt(0)").remove();
					load();
					resetForm();
					alert(data);
				},
				error : function(jqXHR, exception) {
					alert("error");
				}
			});
		}else{
			alert("Fill form");
		}
	}else{
		if(ValidInput()){
			$.ajax({
				url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researcher',
				method : 'PUT',
				headers : {
					"Content-Type" : "application/json"
				},
				data : getJSON(),
				success : function(data) {
					$("#idTable").find("tr:gt(0)").remove();
					$("#table").find("tr:gt(0)").remove();
					load();
					resetForm();
					alert(data);
				},
				error : function(jqXHR, exception) {
					alert("error");
				}
			});
		}else{
			alert("Fill form");
		}
	}
}

function delet(){
	getID();
	swal({
		title: "Are you sure?",
		text: "Do you realy want to Delete this?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researcher/' + $('#researcher_id').val(),
					method: 'DELETE',
					success: function (resultText) {
						$("#table").find("tr:gt(0)").remove();
						$("#idTable").find("tr:gt(0)").remove();
						load();
						swal("Deleted!", {
							icon: "success",
							});
						},
						error: function (jqXHR, exception) {
							swal("fail");
						}
					});
				} else {
					swal("Safe!");
				}
			});
}

function deletSearch(){
	getIDserch();
	swal({
		title: "Are you sure?",
		text: "Do you realy want to Delete this?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researcher/' + $('#researcher_id').val(),
					method: 'DELETE',
					success: function (resultText) {
						$("#table").find("tr:gt(0)").remove();
						$("#idTable").find("tr:gt(0)").remove();
						load();
						swal("Deleted!", {
							icon: "success",
							});
						},
						error: function (jqXHR, exception) {
							swal("fail");
						}
					});
				} else {
					swal("Safe!");
				}
			});
}

function load() {
	$.ajax({
		url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researchers',
		method : 'GET',
		headers : {
			Accept : "application/json",
			"Content-Type" : "application/json"
		},
		success : function(data, textStatus, errorThrown) {
			var items = [];
			$.each(data.researcher,function(key, val) {
				var index = key + 1;
				items.push("<tr>");
				items.push("<td>" + index + "</td>");
				items.push("<td>" + val.researcher_id + "</td>");
				items.push("<td>" + val.name + "</td>");
				items.push("<td>" + val.company + "</td>");
				items.push("<td>" + val.product_id + "</td>");
				items.push("<td>" + val.product_name + "</td>");
				items.push("<td>" + val.product_description + "</td>");
				items.push("<td>" + val.product_price + "</td>");
				items.push("<td><button onclick='getRow()' type='button' class='btn btn-info btn-fill'>Edit</button></td>");
				items.push("<td><button onclick='delet()' type='button' class='btn btn-danger btn-fill'>Delete</button></td>");
				items.push("</tr>");
			});
		$("<tbody/>", {
			html : items.join("")
		}).appendTo("#table");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Ajax request fail");
		},
		timeout : 120000,
	});
}

function getJSON() {
	return JSON.stringify({
		"researcher_id" : $('#researcher_id').val(),
		"name" : $('#name').val(),
		"company" : $('#company').val(),
		"product_id" : $('#product_id').val(),
		"product_name" : $('#product_name').val(),
		"product_description" : $('#product_description').val(),
		"product_price" : $('#product_price').val(),
	});
}

function ValidInput(){
	var researcher_id = $('#researcher_id').val();
	var name = $('#name').val();
	var company = $('#company').val();
	var product_id = $('#product_id').val();
	var product_name = $('#product_name').val();
	var product_description = $('#product_description').val();
	var product_price = $('#product_price').val();
	var researcher_id = $('#researcher_id').val();
	var name = $('#name').val();
	var company = $('#company').val();
	var product_id = $('#product_id').val();
	var product_name = $('#product_name').val();
	var product_description = $('#product_description').val();
	var product_price = $('#product_price').val();
	if(researcher_id === "" || name === "" || company === "" || product_id === "" || product_name === "" || product_description === "" || product_price === ""){
		return false;
	}else{
		return true;
	}
	return true;
}

function search(){
$("#idTable").find("tr:gt(0)").remove();
	var searchID = $('#searchID').val();
	if(searchID === ""){
		alert("Please Enter ID")
	}else{
	$.ajax({
		url : 'http://localhost:8080/researcher/webresources/ResearcherResources/Researcher/' + searchID,
		method : 'GET',
		headers : {
			Accept : "application/json",
			"Content-Type" : "application/json"
		},
		success : function(data, textStatus, errorThrown) {
			var items = [];
			$.each(data,function(key, val) {
				var index = key + 1;
				items.push("<tr>");
				items.push("<td>" + index + "</td>");
				items.push("<td>" + val.researcher_id + "</td>");
				items.push("<td>" + val.name + "</td>");
				items.push("<td>" + val.company + "</td>");
				items.push("<td>" + val.product_id + "</td>");
				items.push("<td>" + val.product_name + "</td>");
				items.push("<td>" + val.product_description + "</td>");
				items.push("<td>" + val.product_price + "</td>");
				items.push("<td><button onclick='getRow()' type='button' class='btn btn-info btn-fill'>Edit</button></td>");
				items.push("<td><button onclick='delet()' type='button' class='btn btn-danger btn-fill'>Delete</button></td>");
				items.push("</tr>");
			});
		$("<tbody/>", {
			html : items.join("")
		}).appendTo("#idTable");
	},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Ajax request fail");
		},
		timeout : 120000,
		});
	}
}