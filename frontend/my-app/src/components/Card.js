import React, {useState} from 'react';
import '../App.css';

function Card(props) {

  const [open, setOpen] = useState(false);

  const openAbout = () => {
    setOpen(!open);
  }

  return (
    <div >
      <p>{props}</p>
    </div>
  );
}

export default Card;