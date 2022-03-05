import React, {useState} from 'react';
import { Card as BCard, Button } from 'react-bootstrap';
import '../App.css';

function Card(props) {

  const [open, setOpen] = useState(false);

  const openAbout = () => {
    setOpen(!open);
  }

  return (
    <div>

      <BCard style={{ width: "8rem", boxShadow: "0px 3px 8px -4px #000000" }}>
        <BCard.Img variant="top" src="holder.js/100px180" />
        <BCard.Body>
          <BCard.Title>{props.name}</BCard.Title>
          <BCard.Text>
            {props.desc}
          </BCard.Text>
          <Button variant="primary">Play</Button>
        </BCard.Body>
      </BCard>
    </div>
  );
}

export default Card;