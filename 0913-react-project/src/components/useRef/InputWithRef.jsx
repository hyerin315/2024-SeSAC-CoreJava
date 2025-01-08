import { useEffect, useRef, useState } from 'react';

function InputWithRef() {
  const [value, setValue] = useState('');
  const inputRef = useRef(null); // useRef를 사용해 DOM에 접근할 준비

  useEffect(() => {
    // useRef를 사용해 input에 포커스 설정 -> DOM 대신 작용
    inputRef.current.focus();
  }, []); // 컴포넌트가 마운트될 때 한 번만 실행

  return (
    <div>
      <input
        ref={inputRef} // input 요소에 ref 연결
        type="text"
        value={value}
        onChange={(e) => setValue(e.target.value)}
        placeholder="useRef로 DOM 접근"
      />
    </div>
  );
}

export default InputWithRef;
