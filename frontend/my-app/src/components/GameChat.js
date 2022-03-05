import React, {useState, useEffect} from 'react';
import '../App.css';
import SendMessage from './SendMessage';

function GameChat(props) {

  const [messages, setMessages] = useState(props.state.messages)

  return (
    <div >
      
      {messages.length > 0 &&
        messages.map((item) => (
        <>
          {item.text}
        </>
      ))}
      <SendMessage state={props.state} dispatch={props.dispatch}/>
    </div>
  );
}

export default GameChat;