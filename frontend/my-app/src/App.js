import './App.css';
import { Container, Row, Col} from 'react-bootstrap';

function App() {
  return (
    <div className="App">

      <Container fluid>
        <Row className="row1">
          <Col xs={9}>Game Progress (chat based?)</Col>
          <Col xs={3}>Tutorial</Col>
        </Row>
        <Row className="row2">
          <Col>Decks</Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
