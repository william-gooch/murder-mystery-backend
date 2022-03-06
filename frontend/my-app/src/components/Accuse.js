import React, {useState, useEffect} from 'react';
import {Form, Button, Modal, Card, Dropdown} from 'react-bootstrap'; 
import '../App.css';

function Accuse(props) {

  const [weapon, setWeapon] = useState()
  const [day, setDay] = useState()
  const [time, setTime] = useState()
  const [location, setLocation] = useState();

  const [weapons, times, days, locations] = React.useMemo(() => {
    const sorted = props.state?.allEvidence.sort(a => a.ID);
    return [
      sorted.slice(0, 9),
      sorted.slice(10, 34),
      sorted.slice(24, 42),
      sorted.slice(43, 50)
    ]
  }, [props.state.allEvidence]);

  const makeSelection = (key) => {
    props.dispatch("SELECT_EVIDENCE", { playerId: key, weaponCardId: weapon.ID, dayCardId: day.ID, timeCardId: time.ID, locationCardId: location.ID })
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
                {weapons?.map((item) => {
                  <Dropdown.Item onClick={() => setWeapon(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Day
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {days?.map((item) => {
                  <Dropdown.Item onClick={() => setDay(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Time
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {times?.map((item) => {
                  <Dropdown.Item onClick={() => setTime(item)}>{item.name}</Dropdown.Item>
                }) }
              </Dropdown.Menu>
            </Dropdown>
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Location
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {locations?.map((item) => {
                  <Dropdown.Item onClick={() => setLocation(item)}>{item.name}</Dropdown.Item>
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