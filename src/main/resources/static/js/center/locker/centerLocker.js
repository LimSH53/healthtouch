//라커 등록
function registLocker() {
        	
	    	const locNum = $("#selectBox option:selected").val();
        	const memberId = $("[name=id]").val();
        	const startDate = $("[name=start]").val();
        	const endDate = $("[name=end]").val();
        	
        	const obj =  { locNum : locNum, memberId : memberId, startDate : startDate, endDate : endDate};
        	console.log(obj);
        	
        	$.ajax({	
        		
				url: "/center/locker/regist",	
				type: "post",
				data: { locNum : locNum, id : memberId, startDate : startDate, endDate : endDate},
				success: function() {
					Swal.fire({
						icon: 'success',
						text: '락커 이용 등록이 완료되었습니다.',
						confirmButtonText: '확인',
					}).then((result) => {
						location.href="/center/locker/list";
					})
				},
				error: function(e) {
					console.log(e);
				}
			});
		}
		

// 락커 이동
$('#beforLocNum').change(function() {
    var value = $(this).val();
    $(this).css('color', value);
    
    console.log(value);
});
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
/* $('#searchName').autocomplete({
	       	 source : function(request, response) { //source: 입력시 보일 목록
	       	     $.ajax({
	       	           url : "/center/locker/regist"   
	       	         , type : "POST"
	       	         , dataType: "JSON"
	       	         , data : {value: request.term}	// 검색 키워드
	       	         , success : function(data){ 	// 성공
	       	             response(
	       	                 $.map(data.resultList, function(name) {
	       	                     return {
	       	                    	     label : "이름 "  	// 목록에 표시되는 값
	       	                           , value : name.MEMBER_NAME		// 선택 시 input창에 표시되는 값
	       	                          
	       	                     };
	       	                 })
	       	             );    //response
	       	         }
	       	         ,error : function(){ //실패
	       	             alert("오류가 발생했습니다.");
	       	         }
	       	     });
	       	 }
	       		,focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌	
	       			return false;
	       		},
	       		minLength: 1,// 최소 글자수
	       		delay: 100	//autocomplete 딜레이 시간(ms),
	       		 , select : function(evt, ui) { 
	             	// 아이템 선택시 실행 ui.item 이 선택된 항목을 나타내는 객체, lavel/value/idx를 가짐
	       			console.log(ui.item.label);
	       			console.log(ui.item.idx); 
	       	 }
	       }); */