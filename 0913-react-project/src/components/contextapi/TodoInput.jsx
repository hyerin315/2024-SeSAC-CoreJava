import React, { useState, useContext } from 'react';
import { TodoContext } from './TodoContext'; // Context에서 필요한 값 가져오기

function TodoInput() {
  const [newTodo, setNewTodo] = useState('');
  const { addTodo } = useContext(TodoContext); // Context에서 addTodo 사용

  const handleSubmit = (e) => {
    e.preventDefault();
    if (newTodo.trim() !== '') {
      addTodo(newTodo);
      setNewTodo('');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
        placeholder="할 일 추가하기"
      />
      <button type="submit">추가</button>
    </form>
  );
}

export default TodoInput;
