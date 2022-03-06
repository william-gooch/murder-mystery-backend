import { Card, Container } from 'react-bootstrap';
import '../App.css';

function PlayerList(props) {

  return (
    <div className="test">
      <table className="chat">
        <tr style={{height: "100%"}}>
          <div className="playerBox">
              {props.state &&
                props.state.players &&
                Object.keys(props.state.players).map((key, index) => (
                  <td valign="top">

                  <Card className="player">
                    <div>{props.state.players[key].name}</div>
                  </Card>
                  </td>

                ))}
          </div>
        </tr>
        <tr>
          <td valign="bottom">
          </td>
        </tr>
      </table>
    </div>
  );
}

export default PlayerList;