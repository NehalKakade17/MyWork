const express = require('express');
const path = require('path');

const app = express();
const port = 3000;


app.use(express.static(path.join(__dirname, 'public')));


app.use(express.json());


app.post('/api/submit', (req, res) => {
  const { name, email } = req.body;
  
  console.log('Form submitted:', name, email);

  res.status(200).json({ message: 'Form submitted successfully' });
});


app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'home.html'));
});


app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});






