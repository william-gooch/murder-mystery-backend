import '../App.css';
import SendMessage from './SendMessage';

function GameChat(props) {


  return (
    <div >
      
      {props.state && props.state.chat && props.state.chat.messages &&
        props.state.chat.messages.map((item) => (
        <>
          {item.message}
        </>
      ))}
      <SendMessage state={props.state} dispatch={props.dispatch}/>
    </div>
  );
}

export default GameChat;