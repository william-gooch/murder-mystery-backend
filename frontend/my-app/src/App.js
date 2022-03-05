import './App.css';
import { Container, Row, Col} from 'react-bootstrap';
import Deck from './components/Deck';
import GameChat from './components/GameChat';
import { useEffect, useState } from 'react';
import CreateName from './components/CreateName';
import TutorialPopup from './components/TutorialPopup';

const socket = new WebSocket("wss://javascript.info/article/websocket/chat/ws");

function App() {

  useEffect(() => {
    socket.onopen = function(e) {
      console.log("[open] Connection established");
    };
  }, []);

  const [name, setName] = useState("");
  const [role, setRole] = useState("");

  const [nameOpen, setNameOpen] = useState(true)
  const [tutOpen, setTutOpen] = useState(false)

  const close = () => {
    setNameOpen(false);
  }

  return (
    <div className="App">

      {(tutOpen || nameOpen) &&
        <div className="startPrompt"></div>
      }
      {nameOpen &&
          <CreateName
            socket={socket}
            name={name}
            setName={setName}
            close={close}
          />
        
      }

      <Container fluid>
        <Row className="row1">
          <Col xs={8} className="col1">
            <h2>Game</h2>
            <GameChat socket={socket}  />
          </Col>
          <Col xs={4}>
            <h2>Players</h2>
            <TutorialPopup setTutOpen={setTutOpen} />
          </Col>
        </Row>
        <Row className="row2">
          <Col>
            <Deck name={name} socket={socket}/>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
