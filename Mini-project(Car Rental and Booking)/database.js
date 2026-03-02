
const express = require('express');
const path = require('path');
const mysql = require('mysql'); 
const app = express();
const port = 3000;


const pool = mysql.createPool({
    host: 'localhost',     
    user: 'root',          
    password: 'cdac',          
    database: 'car_rental' 
});


app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));


app.get('/bookingform', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'bookingform.html'));
});


app.post('/api/bookings', (req, res) => {
    const { carModel, location, startDate, endDate } = req.body;

    // Basic validation
    if (!carModel || !location || !startDate || !endDate) {
        return res.status(400).json({ message: 'All fields are required' });
    }

    
    pool.query(
        'INSERT INTO bookings (carModel, location, startDate, endDate) VALUES (?, ?, ?, ?)',
        [carModel, location, startDate, endDate],
        (err, result) => {
            if (err) {
                console.error(err);
                return res.status(500).json({ message: 'Error occurred while saving the booking' });
            }

            res.status(201).json({
                message: 'Booking created successfully',
                booking: { carModel, location, startDate, endDate }
            });
        }
    );
});


app.get('/api/bookings', (req, res) => {
    pool.query('SELECT * FROM bookings', (err, results) => {
        if (err) {
            console.error(err);
            return res.status(500).json({ message: 'Error occurred while fetching bookings' });
        }

        res.status(200).json(results);
    });
});


app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
