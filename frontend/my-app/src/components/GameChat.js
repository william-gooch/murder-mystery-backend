import React, {useState, useEffect} from 'react';
import '../App.css';
import SendMessage from './SendMessage';

function GameChat(props) {

  const [messages, setMessages] = useState([])

  useEffect(() => {
    props.socket.onmessage = function(event) {
      const data = JSON.parse(event.data);
      try {
        //CHECK IF CHAT MESSAGE
        setMessages(arr => [...arr, data])
      } catch (err) {
        console.log(err);
      }
    }
  }, []);


  return (
    <div >
      
      {messages.length > 0 &&
        messages.map((item) => (
        <>
          {item.text}
        </>
      ))}
      <SendMessage socket={props.socket}/>
    </div>
  );
}

export default GameChat;