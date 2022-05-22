	
updateElements();
makeDeletable();

$('document').ready(function() {
	var isSuccess = false
	var list

	$.ajax({
		url: "/trainer/schedule/ajax/allschedule",
		type: "get",
		dataType: "json",
		// async: true,
		contentType: "application/json",
		success: function(db) {
			console.log(db);
			list = db.scheduleList
			console.log("list ", list)
			
			$.each(list, function(i, e) {
				console.log("i : ", i, " e:", e)
				
				 createNew(e.title, e.fromTimeHour, e.fromTimeHalf, e.toTimeHour, e.toTimeHalf, e.weekDay, e.color);	
				
			});

			

		},
		error: function(fail) {
			console.log(fail);
			alert('실패');
		}
	});

	




});	
			

			
			/*
			이벤트
			*/
		$(function(){
			//팝업창 띄우기
			$(".addNew").on("click", function(){
					  
			$(".popUp").fadeToggle();
			console.log("pop");
			});
		})					

			

			
			

	
		/* 일정추가 팝업열기 */
		$(".addNew").on("click", function(){
		  
		  $(".popUp").fadeToggle();
		  
		});

	
		
		

		
		

/* 데이터 전송시 사용하는 일정추가 */
$(function() {
	//clicking to add class
	$(".addButton").on("click", function() {

		var title = $(".nameInput").val();
		
		//요일 = checkboxValue = weekDay
		var checkboxValue = '';

		//요일 = checkboxValue = weekDay
		$.each($("input:checked"), function() {
			checkboxValue += $(this).val();
		});

		var fromTimeHour = $("#fromTimeHour").val();
		var fromTimeHalf = $("#fromTimeHalf").val();

		var toTimeHour = $("#toTimeHour").val();
		var toTimeHalf = $("#toTimeHalf").val();

		
		var color = $(this).css('backgroundColor');

		var param = { title: title, fromTimeHour: fromTimeHour, fromTimeHalf: fromTimeHalf, toTimeHour: toTimeHour, toTimeHalf: toTimeHalf, weekDay: checkboxValue, color: color }
			console.log(param);
	
						$.ajax({
							url: "/trainer/schedule/addschedule",
							type: "post",
							async: false,
							data: JSON.stringify(param),
							contentType: 'application/json; charset=utf-8',
							success: function(data) {
								 alert(data);
							//	 location.href = "/trainer/schedule/allschedule";
							//	 createNew(title, fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf, checkboxValue, color);
							},
							error: function(fail) {
								console.log(fail);
							}
							
							
							
							
			});
			
				
				/* HTML에 삽입할 함수 호출 */
		      createNew(title, fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf, checkboxValue, color);
		     
			
	});

})
		
		
		
		
		
	$(function(){	
		
		 //색상 선택 
		$(".color").on("click", function() {
		  
		  let myColor = $(this).css('backgroundColor');
		  
		  $(".addButton").css('backgroundColor', myColor);
		  
		});
		
		
		})
		
		
		function shake () {
		  $(".nameInput").toggleClass("shake");
		}
		
		
		
		
		
		
		function createNew(title, fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf, weekDay, color) {
		  var unit = 20;
		  
		  //제목 + 요일 숫자 합쳐서 title
		  var newElement = '<div id=' + title + weekDay 
		  + ' class="test myClass ui-draggable ui-draggable-handle ui-resizable"'
		  + ' style="top: ' + getStartHour(fromTimeHour, fromTimeHalf) + 'px'
		  + '; height : ' +  getToHour(fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf) + 'px'
		  + '; background-color : ' + color
		  + '; left : ' + weekDay + 'px'
		  + '; " ><p class="title">' 
		  + title + '<i class="fa fa-trash-o" aria-hidden="true"></i></p>'
		  + '<div class="ui-resizable-handle ui-resizable-s" style="z-index:90;"></div></div>';
		  
		  //타임테이블에 집어넣어줌 
		  $(newElement).insertBefore(".tableTimes");
		   
		  
		  // html로 삽인되는 구문 좌, 위, 높이, 너비, 색상
		  // left 안읽힘...
		  
		  // $("#" + title + weekDay).css({
		  //  "left": weekDay,
		  //  "top": getStartHour(fromTimeHour, fromTimeHalf),
		  //  "height": getToHour(fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf),
		  //  "width": "160px;",
		  //  "background-color": "black"
		    
		 // });
		  
		  
		  
		  
		  
		  
		  //updateElements();
		}
		

		
		
		
		
		
		
		
		
		
		function makeResizable() {
			
		  /*$( ".myClass" ).resizable({
		  handles: 's',
		  grid: [ 160, 15 ]
		});*/
		
		console.log("makeResizable");
		}
		
		
		

		
		function makeDraggable() {
			
		  /*$(".myClass").draggable({
		  containment: 'parent',
		    grid: [160,15]
		});*/
		
		  console.log("dragable");
		}
		

		
		
		
		function updateElements() {
		 
		  makeDraggable();

		  
		  makeResizable();
		  
		}
		
		
		
		function makeDeletable() {
		  
		  
		  /*$(".fa-trash-o").on("click", function() {
		    
		  $(this).parent().parent().remove();
		   
		  
		});*/
		
		}
		
		
		
		
		
		
		
		
		/*
		NOTE: need to make sure inputs are valid on functions bellow and test more
		- FROM needs to be smaller than TO
		- create function validate input
		*/
		
		function correctHour(toHour) {
		  
		        var result;
		
		        if(toHour < 7) {
		          result = 12 + Number(toHour);
		        } else {
		          result = toHour;
		        }
		        // alert(result);
		        return result;
		      }
		
		function getToHour(fromHour, fromHalf, toHour, toHalf) {
		  //needs to handle 9am to 1pm types of entry
		  var compensation;
		  
		  if(fromHalf == 30 && toHalf == 30) {
		    
		    compensation = 0;
		    
		  } else if (fromHalf == 30 ){
		    
		    compensation = -15;
		    
		  } else if(toHalf == 30){
		    
		    compensation = 15;
		    
		  } else {
		    
		    compensation = 0;
		  }
		  
		    var correctedToHour = correctHour(toHour);
		    var correctedFromHour = correctHour(fromHour);
		    // alert(correctedHour);
		    return ((correctedToHour - correctedFromHour) * 41) + compensation;
		  
		}
		
		
		
		
		
		
		
		function getStartHour(fromHour, fromHalf) {
		  
		  let base = 115; //that gives 7am
		  var unitHalf;
		  
		  //this rounds down or up
		  if (fromHalf >= 30) {
		    
		    unitHalf = 15; //half an hour
		  
		  } else {
		    
		    unitHalf = 0;
		  }
		  
		  
		  if(fromHour >= 7) {
		    
		    return base + ((fromHour - 7) * 40) + unitHalf;
		    
		  } else {
		    //260 is the base for anything after 12
		    return  260 + (fromHour * 30) + unitHalf;
		    
		  }
		  
		};
		
		function validateInput (number1, number2) {
		  //tittle cant be an empty string
		  //fromHour > toHour
		  //array of weekdays is not empty
		  //color with r,g or b lower than 130 makes color of text white
		  
		  
		}
		
		
		