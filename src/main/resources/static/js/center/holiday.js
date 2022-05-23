/*$('#holidayCalendar').on('click', function() {
	        var calendarEl = document.getElementById('calendar');
	        var calendar = new FullCalendar.Calendar(calendarEl, {
	          initialView: 'dayGridMonth',
	          locale: 'ko',
			  themeSystem: 'bootstrap5'
	        });
	        calendar.render();
	      });*/


 
document.addEventListener('DOMContentLoaded', function () {
            $(function () {
                var request = $.ajax({
                    url: "/center/trainer/hday/calendar", // 변경하기
                    method: "GET",
                    dataType: "json"
                });
 
                request.done(function (data) {
                    console.log(data); // log 로 데이터 찍어주기.
 
                    var calendarEl = document.getElementById('calendar');
 
                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        initialView: 'dayGridMonth',
	          			locale: 'ko',
		  				themeSystem: 'bootstrap5',
                        headerToolbar: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                        },
                        editable: true,
                        droppable: true, // this allows things to be dropped onto the calendar
                        drop: function (arg) {
                            // is the "remove after drop" checkbox checked?
                            if (document.getElementById('drop-remove').checked) {
                                // if so, remove the element from the "Draggable Events" list
                                arg.draggedEl.parentNode.removeChild(arg.draggedEl);
                            }
                        },
                        /**
                         * data 로 값이 넘어온다. log 값 전달.
                         */
                        events: data
                    });
 
                    calendar.render();
                });
 
                request.fail(function( jqXHR, textStatus ) {
                    alert( "Request failed: " + textStatus );
                });
            });
 
        });

           
 
        



     

    

/* 승인 버튼 클릭 시*/	
$('.approval').on('click', function() {
	
	Swal.fire({
		icon: 'question',
	 	html :"휴가 신청을 승인하시겠습니까?",
		showDenyButton: true,
		confirmButtonText: '확인',
		denyButtonText: '취소',
	}).then((result) => {
		if(result.isConfirmed) {
			var checkBtn = $(this);
			
			// checkBtn.parent() : checkBtn의 부모는 <td>이다.
			// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			
			var trId = td.eq(3).text();
	    	  console.log(tr);
		   	  console.log(trId);    				
		
				 $.ajax({						
					url: "/center/trainer/hday/approval",
					type: "post",
					data: { trId : trId},
					success: function(trId) {
						
						Swal.fire({
							icon: 'success',
							text: '휴가 신청이 승인되었습니다.',
							confirmButtonText: '확인',
						}).then((result) => {
							location.href="/center/trainer/hday";
						})
					
					},
					error: function(trId) {
						console.log("에러 발생");
						
					}
				}); 
		}

})
})
	
/* 반려 버튼 클릭 시*/	
$('.reject').on('click', function() {
	
	Swal.fire({
		icon: 'question',
	 	html :"휴가 신청을 반려하시겠습니까?",
		showDenyButton: true,
		confirmButtonText: '확인',
		denyButtonText: '취소',
	}).then((result) => {
		if(result.isConfirmed) {
			var checkBtn = $(this);
			
			// checkBtn.parent() : checkBtn의 부모는 <td>이다.
			// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			
			var trId = td.eq(3).text();
	    	 
		   	  console.log(trId);    				
		
				$.ajax({						
					url: "/center/trainer/hday/reject",
					type: "post",
					data: { trId : trId },
					success: function(trId) {
						console.log(trId);
						 Swal.fire({
							icon: 'success',
							text: '휴가 신청이 반려되었습니다.',
							confirmButtonText: '확인',
						}).then((result) => {
							location.href="/center/trainer/hday";
						})
					
					},
					error: function(trId) {
						console.log("에러 발생");
						
					}
				}); 
		}

})
})