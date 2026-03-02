import React, { useState, useEffect } from 'react';
import TaskList from '../components/TaskList';
import { Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';

const Home = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    // Fetch tasks from local storage or API
    const savedTasks = JSON.parse(localStorage.getItem('tasks')) || [];
    setTasks(savedTasks);
  }, []);

  const deleteTask = (id) => {
    const updatedTasks = tasks.filter(task => task.id !== id);
    setTasks(updatedTasks);
    localStorage.setItem('tasks', JSON.stringify(updatedTasks));
  };

  const toggleTaskCompletion = (id) => {
    const updatedTasks = tasks.map(task =>
      task.id === id ? { ...task, completed: !task.completed } : task
    );
    setTasks(updatedTasks);
    localStorage.setItem('tasks', JSON.stringify(updatedTasks));
  };

  return (
    <div>
      <h1>Task List</h1>
      <Link to="/create">
        <Button variant="primary">Create Task</Button>
      </Link>
      <TaskList tasks={tasks} onDelete={deleteTask} onToggleComplete={toggleTaskCompletion} />
    </div>
  );
};

export default Home;
