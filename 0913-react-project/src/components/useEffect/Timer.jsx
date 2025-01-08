import React, { useState, useEffect } from 'react';

function Timer() {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    // 컴포넌트가 처음 마운트될 때 실행
    console.log('타이머 시작');
    const intervalId = setInterval(() => {
      setSeconds(prevSeconds => prevSeconds + 1); // 1초마다 시간 증가
    }, 1000);

    // 컴포넌트가 언마운트될 때 실행 (cleanup)
    return () => {
      console.log('타이머 정리');
      clearInterval(intervalId); // 타이머 정리
    };
  }, [seconds]); // 빈 배열: 처음 한 번만 실행

  return (
    <div>
      <p>{seconds}초</p>
    </div>
  );
}

export default Timer;
