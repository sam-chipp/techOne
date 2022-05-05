import "./styles.css";
import { useState } from "react";
import { useGetWords } from "./api/Api";
import { Card, Button, InputGroup, FormControl} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';

/**
 * Displays the input card for the user.
 * @param {*} onGetWords Call back used to pass state to the parent component.
 * @returns The input card.
 */
const InputCard = ({ onGetWords }) => {
  const [input, setInput] = useState("");

  return (
    <div className="inputCard">
      <Card>
        <Card.Header>NUMBER TO WORDS</Card.Header>
        <Card.Body>
          <InputGroup className="mb-3">
            <FormControl type="number" min={0} aria-label="inputNumber" placeholder="Enter number" value={input} onChange={(e) => setInput(e.target.value)}/>
          </InputGroup>
          <Button className="mb-3" variant="info" onClick={() => onGetWords(input)}>
            Submit
          </Button>
        </Card.Body>
        <Card.Footer className="text-muted">Enter a number greater than 0 and less than 1 trillion</Card.Footer>
      </Card>
    </div>
  )
}

/**
 * Displays the output of words we received.
 * @param {*} words The word equivalent of the provided number.
 * @returns The output card.
 */
const OutputCard = ({words}) => {

  return (
    <Card>
      <Card.Body>{words}</Card.Body>
    </Card>
  )
}

/**
 * The Application.
 * @returns The Application.
 */
export default function App() {
  const [getData, setDataType] = useState("");
  const { data, loading, error } = useGetWords(getData);

  const onGetWords = (input) => {
    const num = Number(input);

    // enforce our program conditions before requesting data from backend.

    if (num > 0 && num < 1000000000) {
      setDataType(num.toFixed(2))
    }
  };

  if (loading) {
    return (
      <div className="App">
        <div className="container">
          
          <InputCard onGetWords={onGetWords} />
          <OutputCard words="... loading"/>
        </div>
      </div>
    )
  } else if (error) {
    return (
      <div className="App">
        <div className="container">
          
          <InputCard onGetWords={onGetWords} />
          <OutputCard words={"... error: " + error.message}/>
        </div>
      </div>
    )
  }

  return (
    <div className="App">
      <div className="container">
        
        <InputCard onGetWords={onGetWords} />
        {getData != "" ? <OutputCard words={data.words} /> : <></> }
      </div>
    </div>
  );
}
