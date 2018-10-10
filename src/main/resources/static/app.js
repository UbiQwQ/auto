var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var userId=1;
    var userId2=2;
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        // stompClient.subscribe('/topic/greetings', function (greeting) {
        //     showGreeting(JSON.parse(greeting.body).content);
        // });
        // my subscribe
        stompClient.subscribe('/user/' + userId +'/prepare', function (prepare) {
            showPrepare(JSON.parse(prepare.body).content);
        });
        stompClient.subscribe('/user/' + userId2 +'/prepare', function (prepare) {
            showPrepare2(JSON.parse(prepare.body).content);
        });
        stompClient.subscribe('/topic/prepare', function (prepare) {
            showPrepare(JSON.parse(prepare.body).content);
        });
        stompClient.send("/hello", {}, JSON.stringify({'name': 'innovation'}));
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

//my show
function showPrepare(message) {
    // $("#prepare").append("<p>" + message + "</p>");
    // $("#prepare").val(message);
    $("#prepare").html(message);
}
function showPrepare2(message) {
    // $("#prepare").append("<p>" + message + "</p>");
    // $("#prepare").val(message);
    $("#prepare2").html(message);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});