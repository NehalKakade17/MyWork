import React from 'react';
import { useParams } from 'react-router-dom';

const TaskDetails = () => {
  const { id } = useParams();
  const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
  const task = tasks.find((task) => task.id === id);

  if (!task) {
    return <div>Task not found</div>;
  }

  return (
    <div>
      <h1>{task.title}</h1>
      <p>{task.description}</p>
      <p><strong>Priority:</strong> {task.priority}</p>
      <p><strong>Due Date:</strong> {task.dueDate}</p>
      <p><strong>Status:</strong> {task.completed ? 'Completed' : 'Incomplete'}</p>
    </div>
  );
};

export default TaskDetails;
