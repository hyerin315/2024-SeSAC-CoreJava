import React, { useContext } from 'react';
import { TodoContext } from './TodoContext';

function TodoItem({ todo, index }) {

  const { deleteTodo } = useContext(TodoContext);

  return (
    <li>
      <span>{todo}</span>
      <button onClick={() => deleteTodo(index)}>삭제</button> {/* 삭제 버튼 추가 */}
    </li>
  );
}

export default TodoItem;