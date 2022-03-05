import React, { useEffect, useState } from 'react';

function useWebsocket() {
    const [state, setState] = useState();
    const [chat, setChat] = useState();
    
    const socket = new WebSocket("wss://javascript.info/article/websocket/chat/ws");

    useEffect(() => {
        socket.onopen = function(e) {
            console.log("[open] Connection established");
        };

        socket.onmessage = ({ data }) => {
            switch(data.event) {
                case "UPDATE": setState(data.state);
                    return;
                case "CHAT": setChat(data.chat);
                    return;
            }
        };
    }, []);

    const sendEvent = function (event_name, args) {
        socket.send(JSON.stringify({ event: event_name, ...args }))
    };

    return [state, sendEvent];
}

export default useWebsocket;