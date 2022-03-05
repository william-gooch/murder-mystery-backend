import React, {useState, useEffect} from 'react';
import {Form, Button} from 'react-bootstrap'; 
import '../App.css';

function SendMessage(props) {

  const [msg, setMsg] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    props.socket.send({event: "SEND_MESSAGE", value: msg});
    props.close();
  }

  return (
    <div>
      <Form onSubmit={handleSubmit} >
        <Form.Group className="mb-3 input-group sendMessage" controlId="gameName">
          <Form.Control
            type="text"
            placeholder='Send a message'
            value={msg}
            onChange={(e) => setMsg(e.target.value)}
          />
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form.Group>

      </Form>
    </div>
  );
}

export default SendMessage;