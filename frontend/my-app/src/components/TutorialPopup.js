import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function TutorialPopup(props) {

  const [open, setOpen] = useState(false);

  const openPopup = () => {
    setOpen(true);
    props.setTutOpen(true);
  }

  const close = () => {
    setOpen(false);
    props.setTutOpen(false);
  }

  return (
    <div>
      <Button variant="secondary" onClick={openPopup}>Tutorial</Button>

      {open && (
        <Modal.Dialog className='nameModal'>
          <Modal.Header closeButton onClick={close}>
            <Modal.Title>Tutorial</Modal.Title>
          </Modal.Header>

          <Modal.Body>

            Bla bla
          </Modal.Body>
        </Modal.Dialog>
      )}

    </div>
  );
}

export default TutorialPopup;