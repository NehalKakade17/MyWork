import { useState } from 'react'
import { Header } from './Header'
import { ScoreBoard } from './ScoreBoard'
import './App.css';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <Header heading="Welcome to app" description="This is dummy react app"></Header>
        <ScoreBoard></ScoreBoard>
      </div>
    </>
  )
}

export default App
