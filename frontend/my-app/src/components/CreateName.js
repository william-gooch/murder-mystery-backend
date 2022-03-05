import React, {useState, useEffect} from 'react';
import {Form, Button, Modal} from 'react-bootstrap'; 
import '../App.css';

function CreateName(props) {

  const handleSubmit = (event) => {
    event.preventDefault();
    props.dispatch("SET_NAME", { name: props.name });
    props.close();
  }

  return (
    <div className="nameModal">
      <Modal.Dialog>
        <Modal.Header>
          <Modal.Title>Create Name</Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="gameName">
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                value={props.name}
                onChange={(e) => props.setName(e.target.value)}
              />
              <Form.Text className="text-muted">Create a fun name!</Form.Text>
            </Form.Group>
            <Button variant="primary" type="submit">
              Submit
            </Button>
          </Form>
        </Modal.Body>
      </Modal.Dialog>
    </div>
  );
}

export default CreateName;