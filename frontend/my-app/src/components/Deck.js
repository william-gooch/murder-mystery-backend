import React, {useState, useEffect} from 'react';
import Card from './Card';
import '../App.css';

function Deck(props) {

  useEffect(() => {
    let timer1 = setTimeout(() =>  props.dispatch("START_GAME", { }), 5 * 1000);

      return () => {
        clearTimeout(timer1);
      };
  }, [props.dispatch])

  return (
    <div >
      <h2>{props.name}'s Deck</h2>
      <div className="deck">
        {props.state?.me?.deck?.map?.(card => (
          <Card state={props.state} dispatch={props.dispatch} {...card} />
        ))}
      </div>
    </div>
  );
}

export default Deck;