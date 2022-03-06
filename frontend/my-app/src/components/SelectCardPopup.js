import React, {useState, useEffect} from 'react';
import {Form, Button, Modal, Card, ListGroup, Image} from 'react-bootstrap'; 
import '../App.css';

function SelectCardPopup(props) {

  const makeSelection = (key) => {
    props.dispatch("SELECT_CARD", { cardId: key })
  }

  return (
    <div>
        <div className="SelectPlayerModal">
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Select Card</Modal.Title>
            </Modal.Header>

            <Modal.Body>
              <ListGroup>
                {props.state?.me?.deck?.map?.(card => (
                  <ListGroup.Item style={{ boxShadow: "0px 3px 8px -4px #000000", cursor: "pointer" }} onClick={() => makeSelection(card.ID)}>
                    <Image src="holder.js/100px180" />
                    <h3>{card.name}</h3>
                    <h6>
                      {card.desc}
                    </h6>
                  </ListGroup.Item>
                ))}
              </ListGroup>
            </Modal.Body>
          </Modal.Dialog>
        </div>
    </div>
  );
}

export default SelectCardPopup;