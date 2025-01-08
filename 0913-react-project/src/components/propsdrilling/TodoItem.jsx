import React from 'react';

function TodoItem({ todo, index, deleteTodo }) {
  return (
    <li>
      <span>{todo}</span>
      <button onClick={() => deleteTodo(index)}>삭제</button> {/* 삭제 버튼 추가 */}
    </li>
  );
}

export default TodoItem;