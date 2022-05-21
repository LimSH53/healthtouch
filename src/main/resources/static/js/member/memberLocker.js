//라커 등록
function registLocker() {
        	
	    	const locNum = $("#selectBox option:selected").val();
        	const memberId = $("[name=id]").val();
        	const startDate = $("[name=start]").val();
        	const endDate = $("[name=end]").val();
        	
        	const obj =  { locNum : locNum, memberId : memberId, startDate : startDate, endDate : endDate};
        	console.log(obj);
        	
        	$.ajax({	
        		
				url: "/member/product/regist",	
				type: "post",
				data: { locNum : locNum, id : memberId, startDate : startDate, endDate : endDate},
				success: function() {
					Swal.fire({
						icon: 'success',
						text: '락커 이용 등록이 완료되었습니다.',
						confirmButtonText: '확인',
					}).then((result) => {
						location.href="/member/product/lockerAll";
					})
				},
				error: function(e) {
					console.log(e);
				}
			});
		}
		

    
	    
	    
	    
	    
	    
	    