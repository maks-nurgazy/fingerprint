'use strict';


var connectingElement = document.querySelector('#connecting');

var stompClient = null;

function connect() {

    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
}

// Connect to WebSocket Server.
connect();

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/publicChatRoom', onMessageReceived);
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var src = "data:image/jpeg;base64,";
    src += message.image;

    var newImage = document.createElement('img');
    newImage.src = src;
    newImage.width = newImage.height = 80;
    document.querySelector('#imageContainer').innerHTML = newImage.outerHTML;//where to insert your image

}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}
