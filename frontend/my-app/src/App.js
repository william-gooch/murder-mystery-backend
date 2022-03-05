import './App.css';
import { Container, Row, Col, Modal} from 'react-bootstrap';
import Deck from './components/Deck';
import GameChat from './components/GameChat';
import { useEffect, useState } from 'react';
import CreateName from './components/CreateName';
import TutorialPopup from './components/TutorialPopup';
import useWebsocket from './useWebsocket';
import PlayerList from './components/PlayerList';
import SelectPlayerPopup from './components/SelectPlayerPopup';


function App() {

  const [state, dispatch] = useWebsocket();

  const [name, setName] = useState("");
  const [role, setRole] = useState("");

  const [nameOpen, setNameOpen] = useState(true)
  const [tutOpen, setTutOpen] = useState(false)

  const close = () => {
    setNameOpen(false);
    setTutOpen(false);
  }

  return (
    <div className="App">
      {(tutOpen || nameOpen) && <div className="startPrompt"></div>}
      {nameOpen && (
        <CreateName
          state={state}
          dispatch={dispatch}
          name={name}
          setName={setName}
          close={close}
        />
      )}
      {tutOpen && (
        <div className="nameModal">
          <Modal.Dialog>
            <Modal.Header closeButton onClick={close}>
              <Modal.Title>Tutorial</Modal.Title>
            </Modal.Header>

            <Modal.Body>Bla bla</Modal.Body>
          </Modal.Dialog>
        </div>
      )}

      <Container fluid>
        <SelectPlayerPopup state={state} dispatch={dispatch} />
        <Row className="row1">
          <Col xs={8} className="col1">
            <h2>Game</h2>
            <GameChat state={state} dispatch={dispatch} />
          </Col>
          <Col xs={4}>
            <h2>Players</h2>
            <PlayerList state={state} />
            <TutorialPopup setTutOpen={setTutOpen} />
          </Col>
        </Row>
        <Row className="row2">
          <Col>
            <Deck name={name} state={state} dispatch={dispatch} />
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
