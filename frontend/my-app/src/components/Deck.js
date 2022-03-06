import React, {useState, useEffect} from 'react';
import Card from './Card';
import '../App.css';
import { Button } from 'react-bootstrap';

function Deck(props) {
  const endTurn = () => {
    props.dispatch("END_TURN");
  }

  const isMyTurn = props.state && (props.state.currentPlayerId === props.state.me.id);

  return (
    <div >
      <h2>{props.name}'s Deck</h2>
      {isMyTurn && <Button onClick={endTurn}>End Turn</Button>}
      <div className="deck">
        {props.state?.me?.deck?.map?.(card => (
          <Card state={props.state} dispatch={props.dispatch} canPlay={isMyTurn} {...card} />
        ))}
      </div>
    </div>
  );
}

export default Deck;