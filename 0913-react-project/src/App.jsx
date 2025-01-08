import './App.css'
import Timer from './components/useEffect/Timer'
import Counter from './components/useEffect/Counter'
import CounterWithoutRef from './components/useRef/CounterWithoutRef'
import CounterWithRef from './components/useRef/CounterWithRef'
import InputWithoutRef from './components/useRef/InputWithoutRef'
import InputWithRef from './components/useRef/InputWithRef'
import TodoRoot from './components/contextapi/TodoRoot'

function App() {
  return (
    <>
      {/* <Counter />
      <CounterWithoutRef />
      <CounterWithRef />
      <InputWithoutRef />
      <InputWithRef /> */}
      <TodoRoot />
    </>
  )
}

export default App
