import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function SelectPlayerPopup(props) {

  return (
    <div>
        <div className="SelectPlayerModal">
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Select Player</Modal.Title>
            </Modal.Header>

            <Modal.Body>Bla bla</Modal.Body>
          </Modal.Dialog>
        </div>
    </div>
  );
}

export default SelectPlayerPopup;