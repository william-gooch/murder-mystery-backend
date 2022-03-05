import React, {useState, useEffect} from 'react';
import Card from './Card';
import '../App.css';

function Deck(props) {

  const [cards, setCards] = useState([]);

  useEffect(() => {
    props.socket.onmessage = function(event) {
      const data = JSON.parse(event.data);
      try { //CHECK IF CARDS DATA
        setCards(arr => [...arr, data])
      } catch (err) {
        console.log(err);
      }
    }
  }, []);

  return (
    <div >
      <h2>{props.name}'s Deck</h2>
      <Card name="test" desc="test2" />
    </div>
  );
}

export default Deck;