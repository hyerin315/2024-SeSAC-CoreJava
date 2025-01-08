import { useState } from 'react';

function CounterWithoutRef() {
  const [count, setCount] = useState(0); // 상태를 사용하여 카운트 값 관리
  let countVar = 0; // 일반 변수로 카운트 값 관리

  const increment = () => {
    setCount(count + 1); // 상태 값을 1 증가
    countVar += 1; // 일반 변수 값도 1 증가
    console.log("count (state):", count); // 상태 값 출력
    console.log("countVar (variable):", countVar); // 일반 변수 값 출력 : 결과 0 -> 이유는 렌더링 될 때 0으로 초기화됨
  };

  return (
    <div>
      <p>상태로 관리하는 카운트: {count}</p>
      <p>변수로 관리하는 카운트: {countVar}</p>
      <button onClick={increment}>증가</button>
    </div>
  );
}

export default CounterWithoutRef;