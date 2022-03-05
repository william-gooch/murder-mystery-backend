import { Card, Container } from 'react-bootstrap';
import '../App.css';
import SendMessage from './SendMessage';

function GameChat(props) {
  return (
    <div className="test">
      <table className="chat">
        <tr style={{height: "100%"}}>
          <div className="chatBox">
            <td valign="top">
              {props.state &&
                props.state.chat &&
                props.state.chat.messages &&
                props.state.chat.messages.filter(item => props.isAlive ? item.sender.isAlive : true).map((item) => (
                  <Card className="message">
                    <span style={{fontSize: '0.8em'}}>{item.sender.name}:</span>
                    <div>{item.message}</div>
                  </Card>
                ))}
            </td>
          </div>
        </tr>
        <tr>
          <td valign="bottom">
            <SendMessage state={props.state} dispatch={props.dispatch} />
          </td>
        </tr>
      </table>
    </div>
  );
}

export default GameChat;