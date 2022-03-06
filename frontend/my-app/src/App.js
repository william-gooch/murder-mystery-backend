import './App.css';
import { Container, Row, Col, Modal, Button } from 'react-bootstrap';
import Deck from './components/Deck';
import GameChat from './components/GameChat';
import { useEffect, useState } from 'react';
import CreateName from './components/CreateName';
import TutorialPopup from './components/TutorialPopup';
import useWebsocket from './useWebsocket';
import PlayerList from './components/PlayerList';
import SelectPlayerPopup from './components/SelectPlayerPopup';
import SelectCardPopup from './components/SelectCardPopup';


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

  const startGame = () => {
    dispatch("START_GAME")
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
      {state?.selection?.player?.id === state?.me?.id && state?.selection?.type === "PlayerSelection" && 
        <div className="nameModal">
          <SelectPlayerPopup state={state} dispatch={dispatch} />
        </div>
      }
      {state?.selection?.player?.id === state?.me?.id && state?.selection?.type === "CardSelection" && 
        <div className="nameModal">
          <SelectCardPopup state={state} dispatch={dispatch} />
        </div>
      }

      <Container fluid>
        <Row className="row1">
          <Col xs={8} className="col1">
            <h2>Game</h2>
            <GameChat state={state} dispatch={dispatch} />
          </Col>
          <Col xs={4}>
            <h2>Players</h2>
            <PlayerList state={state} />
            <TutorialPopup setTutOpen={setTutOpen} />
            <Button variant="primary" onClick={startGame}>Start Game</Button>
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
