import './App.css';
import { Container, Row, Col, Modal, Button } from 'react-bootstrap';
import Deck from './components/Deck';
import GameChat from './components/GameChat';
import React, { useEffect, useState } from 'react';
import CreateName from './components/CreateName';
import TutorialPopup from './components/TutorialPopup';
import useWebsocket from './useWebsocket';
import PlayerList from './components/PlayerList';
import SelectPlayerPopup from './components/SelectPlayerPopup';
import SelectCardPopup from './components/SelectCardPopup';
import Accuse from './components/Accuse';


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

  const dark = React.useMemo(() => state ? !state.day : false, [state]);
  React.useEffect(() => {
    if(dark) {
      document.body.style.backgroundColor = "#111";
    } else {
      document.body.style.backgroundColor = "#fff";
    }
  }, [dark]);

  return (
    <div className={`App ${dark ? 'dark' : ''}`}>
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

            <Modal.Body>
              Welcome to Mysterious Murder the card game!
              <ul>
                <li>Start the game when enough players join</li>
                <li>Use your cards and chat to interact with players</li>
                <li>Intereactions differ in the day and night</li>
                <li>Start the game when enough players join</li>

              </ul>
            </Modal.Body>
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
      {state?.selection?.player?.id === state?.me?.id && state?.selection?.type === "EvidenceSelection" && 
        <div className="nameModal">
          <Accuse state={state} dispatch={dispatch} />
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
