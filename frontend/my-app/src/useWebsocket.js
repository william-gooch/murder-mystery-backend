import React, { useEffect, useState } from 'react';

function useWebsocket() {
    const [socket, setSocket] = useState();
    const [state, setState] = useState();

    useEffect(() => {
        const socket = new WebSocket("ws://localhost:3456/ws");

        socket.onopen = function(e) {
            console.log("[open] Connection established");
        };

        socket.onmessage = ({ data }) => {
            const { event, state } = JSON.parse(data);
            switch(event) {
                case "UPDATE": setState(state);
                    return;
                default: return;
            }
        };
        
        setSocket(socket);
    }, []);

    const sendEvent = React.useCallback(function (event_name, args) {
        socket.send(JSON.stringify({ event: event_name, ...args }))
    }, [socket]);

    return [state, sendEvent];
}

export default useWebsocket;