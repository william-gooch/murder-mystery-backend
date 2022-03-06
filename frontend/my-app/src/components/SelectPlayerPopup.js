import React, {useState, useEffect} from 'react';
import {Form, Button, Modal, Card} from 'react-bootstrap'; 
import '../App.css';

function SelectPlayerPopup(props) {

  const makeSelection = (key) => {
    props.dispatch("SELECT_PLAYER", { playerId: key })
  }

  return (
    <div>
        <div className="SelectPlayerModal">
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Select Player</Modal.Title>
            </Modal.Header>

            <Modal.Body>
              {props.state &&
                props.state.players &&
                Object.keys(props.state.players)
                .filter(p => props.state.me.id !== p).map((key, index) => (
                  <Card className="player" onClick={() => makeSelection(key)}>
                    <div>{props.state.players[key].name}</div>
                  </Card>
                ))
              }
            </Modal.Body>
          </Modal.Dialog>
        </div>
    </div>
  );
}

export default SelectPlayerPopup;