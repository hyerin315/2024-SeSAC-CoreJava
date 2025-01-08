import { useState, useEffect } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  // useEffect를 사용해 count가 변경될 때마다 콘솔에 로그 출력
  useEffect(() => {
    console.log(`현재 카운트: ${count}`);

    return () => {
      console.log(`카운트가 변경되기 전에: ${count}`);
    };
  });

  return (
    <div>
      <h1>Counter: {count}</h1>
      <button onClick={() => setCount(count + 1)}>증가</button>
      <button onClick={() => setCount(count - 1)}>감소</button>
    </div>
  );
}

export default Counter;
