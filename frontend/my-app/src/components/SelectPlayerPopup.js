import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function SelectPlayerPopup(props) {
  const open = props.state?.selection?.player?.id === props.state?.me?.id
    && props.state?.selection?.type === "PlayerSelection";

  return (
    <div>
      {open &&
        <div className="SelectPlayerModal">
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Select Player</Modal.Title>
            </Modal.Header>

            <Modal.Body>Bla bla</Modal.Body>
          </Modal.Dialog>
        </div>
      }
    </div>
  );
}

export default SelectPlayerPopup;