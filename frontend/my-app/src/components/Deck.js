import React, {useState, useEffect} from 'react';
import Card from './Card';
import '../App.css';

function Deck(props) {

  const [cards, setCards] = useState(props.state.cards);

  return (
    <div >
      <h2>{props.name}'s Deck</h2>
      <Card name="test" desc="test2" />
    </div>
  );
}

export default Deck;