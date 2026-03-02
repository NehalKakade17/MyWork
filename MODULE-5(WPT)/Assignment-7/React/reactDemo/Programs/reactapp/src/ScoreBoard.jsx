import { useState } from "react";

export function ScoreBoard(){

    const [counter, setCounter] = useState(0);

    const handleIncrement = ()=>{
        setCounter(counter + 1);
    }

    if(counter === 5 ){
        throw new Error("Invalid Counter Value");
    }

    return (
        <div>
            <h1>{counter}</h1>
            <button onClick={handleIncrement}> increment </button>
        </div>
    )
}