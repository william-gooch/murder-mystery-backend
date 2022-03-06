import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function SelectCardPopup(props) {

  return (
    <div>
        <div className="SelectPlayerModal">
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Select Card</Modal.Title>
            </Modal.Header>

            <Modal.Body>Bla bla</Modal.Body>
          </Modal.Dialog>
        </div>
    </div>
  );
}

export default SelectCardPopup;