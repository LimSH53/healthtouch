





updateElements();
makeDeletable();





/*
이벤트
*/

//팝업창 띄우기
$(".addNew").on("click", function(){
  
  $(".popUp").fadeToggle();
  
});


$(".addButton").on("click", function(){
  
  var title = $(".nameInput").val();
  
  var checkboxValue = []; 
  

 $.each($("input:checked"), function(){            
        checkboxValue.push($(this).val());
   });
  
  var fromTimeHour = $("#fromTimeHour").val();
  var fromTimeHalf = $("#fromTimeHalf").val();
  
  var toTimeHour = $("#toTimeHour").val();
  var toTimeHalf = $("#toTimeHalf").val();
  
  var color = $(this).css('backgroundColor');

  
  if(title != "") {

    for(var i = 0; i < checkboxValue.length; i++) {
      
      createNew(title, fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf, Number(checkboxValue[i]), color);
     
    } 
    
      makeDeletable();
      updateElements()
    $(".nameInput").val("");
    $(".popUp").fadeToggle();
    
    
  } else {

    //흔들어
    shake();
 
    setTimeout(shake,310);
  }
  
});

 //컬러선택
$(".color").on("click", function() {
  
  let myColor = $(this).css('backgroundColor');
  
  $(".addButton").css('backgroundColor', myColor);
  
});

function shake () {
  $(".nameInput").toggleClass("shake");
}

function createNew(title, fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf, weekDay, color) {
  
  
  var unit = 40;
  //제목+요일을 아이디로
  var newElement = '<div id=' + title + weekDay 
  + ' class="myClass ui-draggable ui-draggable-handle ui-resizable"><p class="title">' 
  + title 
  + '<i class="fa fa-trash-o" aria-hidden="true"></i></p><div class="ui-resizable-handle ui-resizable-s" style="z-index:90;"></div></div>';
  
  //삽입
  $(newElement).insertBefore(".tableTimes");
   
  

  $("#" + title + weekDay).css({
    "left": weekDay,
    "top": getStartHour(fromTimeHour, fromTimeHalf),
    "height": getToHour(fromTimeHour, fromTimeHalf, toTimeHour, toTimeHalf),
    "background-color": "" + color,
    
  });
  
  updateElements();
}

function makeResizable() {
  $( ".myClass" ).resizable({
  handles: 's',
  grid: [ 0, 20 ]
});
}

function makeDraggable() {
  $(".myClass").draggable({
  containment: 'parent',
    grid: [100,20]
});
  console.log("dragable");
}



function updateElements() {
  makeDraggable();
  makeResizable();
  
}

function makeDeletable() {
  
  $(".fa-trash-o").on("click", function() {
    
  $(this).parent().parent().remove();
   
  
});
}



/* 24시간 단위 */
function correctHour(toHour) {
  
    var result;

    if(toHour < 24) {
      result = 0 + Number(toHour);
    } else {
      result = toHour;
    }
    // alert(result);
    return result;
  }


      /* 시간표 추가의 height를 조정 */
function getToHour(fromHour, fromHalf, toHour, toHalf) {

  var compensation;
  
  if(fromHalf == 30 && toHalf == 30) {
    
    compensation = 0;
    
  } else if (fromHalf == 30 ){
    
    compensation = -20;
    
  } else if(toHalf == 30){
    
    compensation = 20;
    
  } else {
    
    compensation = 0;
  }
  
    var correctedToHour = correctHour(toHour);
    var correctedFromHour = correctHour(fromHour);

    return ((correctedToHour - correctedFromHour) * 40) + compensation;
  
}


/* 추가되는 시간표의 시작지점을 조정 */
function getStartHour(fromHour, fromHalf) {
  
  let base = 115; //7am
  var unitHalf;
  
  //this rounds down or up
  if (fromHalf >= 30) {
    /* 시작시간이 30분단위일때 시작지점에서 한칸(20) 내려가게 설정 */
    unitHalf = 20; 
  
  } else {
    /* 시작시간이 00분 단위일때 시작지점 조정할 필요없음 */
    unitHalf = 0;
  }
  
  
  if(fromHour >= 7) {
    
    return base + ((fromHour - 7) * 40) + unitHalf;
    
  } else {
    //12시 이후엔 높이 260 에서부터 시작
    return  400 + (fromHour * 30) + unitHalf;
    
  }
  
};

function validateInput (number1, number2) {

 
}


