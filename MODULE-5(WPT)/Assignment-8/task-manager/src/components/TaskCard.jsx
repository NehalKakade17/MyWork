import React from 'react';
import { Card, Button } from 'react-bootstrap';

const TaskCard = ({ task, onDelete, onToggleComplete }) => {
  return (
    <Card className="task-card mb-3">
      <Card.Body>
        <Card.Title>{task.title}</Card.Title>
        <Card.Text>{task.description}</Card.Text>
        <Card.Text><strong>Priority:</strong> {task.priority}</Card.Text>
        <Card.Text><strong>Due Date:</strong> {task.dueDate}</Card.Text>
        <div className="d-flex">
        <Button onClick={() => onToggleComplete(task.id)} variant={task.completed ? 'success' : 'warning'}style={{ marginRight: '10px' }}>
          {task.completed ? 'Mark Incomplete' : 'Mark Complete'}
        </Button>
        <Button variant="danger" className="ml-2" onClick={() => onDelete(task.id)}>Delete</Button>
        </div>
      </Card.Body>
    </Card>
  );
};

export default TaskCard;
