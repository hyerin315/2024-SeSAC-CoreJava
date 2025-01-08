import React, { useContext } from 'react';
import TodoItem from './TodoItem';
import { TodoContext } from './TodoContext'; // Context에서 todos와 deleteTodo 가져오기

function TodoList() {
  const { todos, deleteTodo } = useContext(TodoContext); // Context에서 todos와 deleteTodo 사용

  return (
    <ul>
      {todos.map((todo, index) => (
        <TodoItem key={index} todo={todo} index={index} deleteTodo={deleteTodo} />
      ))}
    </ul>
  );
}

export default TodoList;
