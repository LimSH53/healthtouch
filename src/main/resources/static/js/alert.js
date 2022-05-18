var sock = null;

$(document).ready(function(){
	connectWs();
});

function connectWs() {
	sock = new SockJS(getContextPath() + '/alert');
	
	sock.onopen = function() {
		console.log('open');
	};
	
	sock.onmessage = function(e) {
		console.log('message', e.data);
		sock.close();
	};
	
	sock.onclose = function() {
		console.log('close');
	};
};

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};

/*
function onMessage(evt) {
	var data = evt.data;
	
	let toast = "<div class='toast' role='alert' aria-live='assertive' aria-atomic='true'>";
    toast += "<div class='toast-header'><i class='fas fa-bell mr-2'></i><strong class='mr-auto'>알림</strong>";
    toast += "<small class='text-muted'>just now</small><button type='button' class='ml-2 mb-1 close' data-dismiss='toast' aria-label='Close'>";
    toast += "<span aria-hidden='true'>&times;</span></button>";
    toast += "</div> <div class='toast-body'>" + data + "</div></div>";
    $("#msgStack").append(toast);   // msgStack div에 생성한 toast 추가
    $(".toast").toast({"animation": true, "autohide": false});
    $('.toast').toast('show');
}
*/