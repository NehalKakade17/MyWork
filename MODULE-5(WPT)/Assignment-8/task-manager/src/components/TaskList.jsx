import React from 'react';
import TaskCard from './TaskCard';
import { ListGroup } from 'react-bootstrap';

const TaskList = ({ tasks, onDelete, onToggleComplete }) => {
  return (
    <ListGroup>
      {tasks.map((task) => (
        <TaskCard
          key={task.id}
          task={task}
          onDelete={onDelete}
          onToggleComplete={onToggleComplete}
        />
      ))}
    </ListGroup>
  );
};

export default TaskList;
