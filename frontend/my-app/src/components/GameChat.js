import '../App.css';
import SendMessage from './SendMessage';

function GameChat(props) {


  return (
    <div >
      
      {props.state && props.state.messages &&
        props.state.messages.map((item) => (
        <>
          {item.text}
        </>
      ))}
      <SendMessage state={props.state} dispatch={props.dispatch}/>
    </div>
  );
}

export default GameChat;