import React, {useState, useEffect} from 'react';
import {Form, Button, Modal, Card, Dropdown} from 'react-bootstrap'; 
import '../App.css';

function Accuse(props) {

  const [weapon, setWeapon] = useState("")
  const [day, setDay] = useState("")
  const [time, setTime] = useState("")

  const makeSelection = (key) => {
    props.dispatch("ACCUSE_PLAYER", { playerId: key, weapon: weapon, day: day, time: time })
  }

  return (
    <div>
      <div className="SelectPlayerModal">
        <Modal.Dialog>
          <Modal.Header>
            <Modal.Title>Accuse a Player</Modal.Title>
          </Modal.Header>
          <div style={{display: "flex"}}>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Weapons
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {props?.state?.weapons?.map((item) => {
                  <Dropdown.Item onClick={() => setWeapon(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Day
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {props?.state?.days?.map((item) => {
                  <Dropdown.Item onClick={() => setDay(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Time
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {props?.state?.times?.map((item) => {
                  <Dropdown.Item onClick={() => setTime(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
          </div>
          
          <Modal.Body style={{display: "flex"}}>
            {props.state &&
              props.state.players &&
              Object.keys(props.state.players)
                .filter((p) => props.state.me.id !== p)
                .map((key, index) => (
                  <Card className="player" onClick={() => makeSelection(key)}>
                    <div>{props.state.players[key].name}</div>
                  </Card>
                ))}
          </Modal.Body>
        </Modal.Dialog>
      </div>
    </div>
  );
}

export default Accuse;