$(document).ready(function() {
	$("#josephForm").validate({
		errorPlacement: function(error, element) {  
			/*if(element.attr("id")=="startindex"){  
				$( element ) .closest( "form" ) .find( "input[id='" +
						 element.attr( "id" ) + "']" ) .append( error ); //error.appendTo($("#interval")); 
			}*/
	/*		if(element.attr("id")=="startindex"){  
				//error.appendTo($("#startindex")); 
				$("#startindex").append(error);
				}
			if(element.attr("id")=="josephlist"){  
				$("#stringarray").append(error); 
				}
			if(element.attr("id")=="interval"){  
				//error.appendTo($("#startindex")); 
				$("#interval").append(error);
				}
			*/},
		/*
		 * errorPlacement: function(error, element) { // Append error within
		 * linked label $( element ) .closest( "form" ) .find( "label[for='" +
		 * element.attr( "id" ) + "']" ) .append( error ); }, errorElement:
		 * "span",
		 */
		/*rules : {
			josephInterval : {
				required : true
			},
			startIndex : {
				required : true
			},
			josephList : {
				required : true
			}
		},*/
		messages : {
			josephInterval : {
				required : "please input interval"
			},
			startIndex : {
				required : "please input start"
			},
			josephList : {
				required : "please input persons"
			}
		},

		submitHandler : function(form) {
			sub();
		},
	});

});

function show() {

	var a = $('#stringarraay').val();
	var li = $("<li></li>").text(a);
	li.text(a);
	$('#josephlist').append(li);
	// when mouse is hovering on the 'li' tag, show 'hiddendiv'.
	$('li').hover(function() {
		$('#hiddendiv').css("display", "block");
		// remove the style of other sibling elements
		$(this).siblings('li').removeClass('selected');
		$(this).addClass('selected');
		console.log("show menu");
	}, function() {

	});
	$("#stringarraay").val("");

	// when users click on the blank area,hide 'hiddendiv' and selected li tag.
	$(document).click(function(event) {
		var _con = $('.josephlistscrolling'); // Set the target area
		if (!_con.is(event.target) && _con.has(event.target).length === 0) { // Mark
			$('#hiddendiv').css("display", "none");
			$('.selected').css("background-color", "#ffffff");
			
			$("#startindex").removeClass("blur");
			$("#startindex").attr("placeholder","");
			
			$("#interval").removeClass("blur");
			$("#interval").attr("placeholder","");
			
			$("#josephlist").removeClass("blur");
			$("#stringarraay").attr("placeholder","");
		}
		//var _con = $('.josephlistscrolling');
	});
}
function checkPositiveInteger(number) {
	var num = Number(number);
	if (Number.isInteger(num) && num >= 0)
		return true;
	else
		return false;

}

function sub() {

	$("#result").val("");
	var persons = [];
	$("#josephlist li").each(function(i, dom) {
		persons[i] = $(this).text();
	});

	if (checkPositiveInteger($("#interval").val())
			&& checkPositiveInteger($("#startindex").val())) {
		var interval = $("#interval").val();
		var startIndex = $("#startindex").val();
	}

	var jsondata = {
		"circle" : {
			"start" : startIndex,
			"interval" : interval,
			"persons" : persons
		}
	};
	var encoded = JSON.stringify(jsondata);
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json;char-set=utf-8",
		url : "Josephcontroller",
		data : encoded,
		success : function(data, textStatus) {
			var josephResponse = eval(data);
			console.log(data);			
			if(data.person!=null)
				$("#result").val(data.person);
			else
			{	
				var dataErrors=data.errors;
				$.each(dataErrors, function(index, item) {
				console.log("josephResponse.errors:"+dataErrors[index].field);
				//var errorField=new Array();
				
			//	var result= $.inArray("circle.interval", dataErrors[index].field);
				/*if(result!=-1)
					{
					$("#interval").val("").focus();
					$("#interval").addClass("blur");
					$("#interval").attr("placeholder",circleErrorMessage); 
					
					}*/
				if(dataErrors[index].field=="circle.interval")
					{
					$("#interval").val("").focus();
					$("#interval").addClass("blur");
					$("#interval").attr("placeholder",dataErrors[index].message);
					}
				else if(dataErrors[index].field=="circle.start"){
					$("#startindex").val("").focus();
					$("#startindex").addClass("blur");
					$("#startindex").attr("placeholder",dataErrors[index].message);
				}
				else {
					$("#josephlist").addClass("blur");
					$("#stringarraay").attr("placeholder",dataErrors[index].message);
				}
			//	if(data.)
				/*
				// 循环获取数据
				if (index == "errors" && item != null) {
					
					var errors = item;
					
					$.each(errors, function(errorIndex, errorItem) {
						var circleError = errorItem;
						$.each(circleError, function(circleErrorIndex,
								circleErrorItem) {
							var circleErrorMessage;
							if (circleErrorIndex == "field") {
								var circleField = circleErrorItem;
								var message;
								if (circleField == "circle.interval") {
									$("#interval").addClass("blur");
									$("#interval").val("").focus();
									$("#interval").attr("placeholder",circleErrorMessage); 
									
								}
								else if(circleField == "circle.start"){
									$("#startindex").addClass("blur");
								//	$("#startindex").focus();
									$("#startindex").attr('placeholder',circleErrorMessage); 
								}
								else{
									$("#josephlist").addClass("blur");
									$("#josephlist").attr('placeholder',circleErrorMessage); 
								}

							} else if (circleErrorIndex == "message")
							//var	circleErrorMessage1 = circleErrorIndex;
								
								circleErrorIndex.message;
						});

					});
					console.log("errors are:" + errors);
				} else if (index == "person" && item != null) {
					var person = item;
					$("#result").val(person);
				}
				
			*/});
				}

		},
		error : function(XMLHttpRequest, textStatus, errorThrown, data) {
		//	window.location.href = 'wrongpage.html';
		}

	});

}
//
function clearall() {
	$('ol li').each(function() {
		$(this).remove();
	});
	$("#interval").val("").focus();
	$("#startindex").val("");
	$("#stringarraay").val("");
}

function showdiv(obj, id) {
	var objDiv = $("#" + id + "");
	$(objDiv).css("display", "block");

}
function hidediv(obj, id) {
	var objDiv = $("#" + id + "");
	$(objDiv).css("display", "none");
}
function deleteli() {
	$("li.selected").remove();
	$('#hiddendiv').css("display", "none");
	console.log("delete li");
}
function insertli() {

	$("li.selected").before("<li>" + $("#stringarraay").val() + "</li>");
	$('#hiddendiv').css("display", "none");
}
function moveupli() {
	if ($("li.selected").prev()) // check whether the previous element exists
		$("li.selected").prev().before($("li.selected")); // Insert this
	// element after the
	// previous element
	$('#hiddendiv').css("display", "none");
}
function movedownli() {
	if ($("li.selected").next()) // check whether the next element exists
		$("li.selected").next().after($("li.selected"));
	$('#hiddendiv').css("display", "none");

}
function renameli() {
	$("li.selected").text($("#stringarraay").val());
	$('#hiddendiv').css("display", "none");

}