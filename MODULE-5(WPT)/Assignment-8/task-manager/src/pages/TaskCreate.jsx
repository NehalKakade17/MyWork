import React from 'react';
import TaskForm from '../components/TaskForm';
import { v4 as uuidv4 } from 'uuid';  // To generate unique IDs

const TaskCreate = () => {
  const handleCreateTask = (task) => {
    const newTask = { ...task, id: uuidv4() };
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    tasks.push(newTask);
    localStorage.setItem('tasks', JSON.stringify(tasks));
  };

  return (
    <div>
      <h1>Create Task</h1>
      <TaskForm onSubmit={handleCreateTask} />
    </div>
  );
};

export default TaskCreate;
