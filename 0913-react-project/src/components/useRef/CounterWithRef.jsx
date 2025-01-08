import { useState, useRef } from 'react';

function CounterWithRef() {
  const [count, setCount] = useState(0); // 상태를 사용하여 카운트 값 관리
  const countRef = useRef(0); // useRef로 카운트 값 관리

  const increment = () => {
    setCount(count + 1); // 상태 값을 1 증가 : 주석을 풀면 렌더링 진행됨 (useState가 렌더링 시킴)
    countRef.current += 1; // useRef의 current 값도 1 증가
    console.log("count (state):", count); // 상태 값 출력
    console.log("countRef (ref):", countRef.current); // ref 값 출력 : 증가 -> 화면상에선 변함이 없지만 log상에서 변함 (렌더링이 되진 않지만 상태 값은 유지됨)
  };

  return (
    <div>
      <p>상태로 관리하는 카운트: {count}</p>
      <p>useRef로 관리하는 카운트: {countRef.current}</p>
      <button onClick={increment}>증가</button>
    </div>
  );
}

export default CounterWithRef;
