import { useState } from 'react'
import { MyComponent } from './MyComponent';
import { NavigationBar } from './NavigationBar';
import { Greet } from './Greet';
import { Home } from './Home';
import { About } from './About';
import './App.css';

function App() {
  return (
    <>
      <NavigationBar>Hi Links</NavigationBar>
      <h1>Hello World</h1>
      <MyComponent></MyComponent>
      <Greet personName="Anuj" email="anuj@gmail.com"></Greet>
      <Home></Home>
      <About></About>
    </>
  )
}

export default App
