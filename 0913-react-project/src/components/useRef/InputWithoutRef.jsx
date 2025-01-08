import { useEffect, useState } from 'react';

function InputWithoutRef() {
  const [value, setValue] = useState('');

  useEffect(() => {
    // document.querySelector를 사용해 DOM에 접근
    const inputElement = document.querySelector('#myInput');
    inputElement.focus(); // input에 포커스를 설정
  }, []); // 컴포넌트가 마운트될 때 한 번만 실행

  return (
    <div>
      <input
        id="myInput"
        type="text"
        value={value}
        onChange={(e) => setValue(e.target.value)}
        placeholder="일반 DOM 접근 방식"
      />
    </div>
  );
}

export default InputWithoutRef;
