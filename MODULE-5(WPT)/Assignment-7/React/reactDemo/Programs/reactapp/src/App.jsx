import { ErrorBoundary } from "./ErrorBoundary"
import { Footer } from "./Footer"
import { Navbar } from "./Navbar"
import { ScoreBoard } from "./ScoreBoard"


function App() {
  return (
    <div>
      <Navbar />
      <ErrorBoundary>
        <ScoreBoard />
      </ErrorBoundary>

      <Footer />
    </div>
  )
}

export default App
