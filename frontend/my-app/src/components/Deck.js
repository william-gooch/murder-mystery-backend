import React, {useState, useEffect} from 'react';
import Card from './Card';
import '../App.css';

function Deck(props) {

  return (
    <div >
      <h2>{props.name}'s Deck</h2>
      {props.state?.me?.deck?.map?.(card => (
        <Card state={props.state} dispatch={props.dispatch} {...card} />
      ))}
    </div>
  );
}

export default Deck;