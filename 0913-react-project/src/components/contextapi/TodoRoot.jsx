import React from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import { TodoProvider } from './TodoContext'; // TodoProvider 임포트

function TodoRoot() {
  return (
    <TodoProvider>
      <div>
        <h1>To-do List</h1>
        <TodoInput />
        <TodoList />
      </div>
    </TodoProvider>
  );
}

export default TodoRoot;
