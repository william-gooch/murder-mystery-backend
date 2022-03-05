import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function TutorialPopup(props) {

  const [open, setOpen] = useState(false);

  const openPopup = () => {
    setOpen(true);
    props.setTutOpen(true);
  }



  return (
    <div>
      <Button variant="secondary" onClick={openPopup}>Tutorial</Button>

    </div>
  );
}

export default TutorialPopup;