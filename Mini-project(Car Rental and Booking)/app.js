require('dotenv').config({ path: './admin.env' });
const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();
const port = process.env.PORT || 3000;
app.use(express.json());


app.use(bodyParser.json());
app.use(cors()); 


const db = mysql.createConnection({
    host: process.env.DB_HOST,       
    user: process.env.DB_USER,       
    password: process.env.DB_PASSWORD, 
    database: process.env.DB_NAME    
});


db.connect((err) => {
    if (err) {
        console.error('Error connecting to MySQL:', err);
        process.exit(1);
    }
    console.log('Connected to MySQL database.');
});


app.get('/api/unavailable-cars', (req, res) => {
    const query = 'SELECT carModel FROM cars WHERE available = 0';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Error fetching unavailable cars:', err);
            return res.status(500).json({ message: 'Unable to fetch unavailable cars' });
        }
        res.json(results.map(car => car.carModel)); 
    });
});



app.post('/api/bookings', (req, res) => {
    const { carModel, location, startDate, endDate } = req.body;

    
    if (!carModel || !location || !startDate || !endDate) {
        return res.status(400).json({ message: 'All fields are required.' });
    }

    const startDateObj = new Date(startDate);
    const endDateObj = new Date(endDate);

    
    if (isNaN(startDateObj.getTime()) || isNaN(endDateObj.getTime())) {
        return res.status(400).json({ message: 'Invalid date format. Please use YYYY-MM-DD.' });
    }

    
    if (startDateObj < new Date()) {
        return res.status(400).json({ message: 'Start date cannot be in the past.' });
    }

    
    if (startDateObj >= endDateObj) {
        return res.status(400).json({ message: 'Start date must be before the end date.' });
    }

    const startDateFormatted = startDateObj.toISOString().slice(0, 10);
    const endDateFormatted = endDateObj.toISOString().slice(0, 10);

    
    const queryCheckAvailability = `
        SELECT * FROM bookings WHERE carModel = ?
        AND (
            (startDate < ? AND endDate > ?)   -- Booking starts before and ends after selected start date
            OR
            (startDate < ? AND endDate > ?)   -- Booking starts before and ends after selected end date
        );
    `;
    db.query(queryCheckAvailability, [carModel, startDateFormatted, startDateFormatted, endDateFormatted, endDateFormatted], (err, result) => {
        if (err) {
            console.error('Error checking car availability:', err);
            return res.status(500).json({ message: 'Error checking car availability', error: err });
        }

        if (result.length > 0) {
            return res.status(400).json({ message: 'The car is already booked for the selected dates.' });
        }

        
        const queryInsertBooking = 'INSERT INTO bookings (carModel, location, startDate, endDate) VALUES (?, ?, ?, ?)';
        db.query(queryInsertBooking, [carModel, location, startDateFormatted, endDateFormatted], (err, result) => {
            if (err) {
                console.error('Error inserting booking:', err);
                return res.status(500).json({ message: 'Error saving the booking', error: err });
            }

            
            const queryUpdateCar = 'UPDATE cars SET available = 0 WHERE carModel = ?';
            db.query(queryUpdateCar, [carModel], (err, result) => {
                if (err) {
                    console.error('Error updating car availability:', err);
                    return res.status(500).json({ message: 'Error updating car availability' });
                }

                console.log(`Car ${carModel} marked as unavailable.`);
            });

            
            res.status(201).json({ message: 'Booking created successfully!', bookingId: result.insertId });
        });
    });
});




app.get('/api/bookings', (req, res) => {
    const query = 'SELECT * FROM bookings';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Error fetching bookings:', err);
            return res.status(500).json({ message: 'Unable to fetch bookings' });
        }
        res.json(results);  
    });
});




app.put('/api/bookings/:id/payment', (req, res) => {
    const bookingId = req.params.id;
    const { paid } = req.body;

    
    if (typeof paid !== 'number' || (paid !== 0 && paid !== 1)) {
        return res.status(400).json({ message: "'paid' field must be 0 or 1" });
    }

    
    const query = `UPDATE bookings SET paid = ? WHERE id = ?`;

    db.query(query, [paid, bookingId], (err, result) => {
        if (err) {
            console.error('Error updating booking:', err);
            return res.status(500).json({ message: 'Error updating booking.' });
        }

        
        if (result.affectedRows === 0) {
            return res.status(404).json({ message: 'Booking not found.' });
        }

        
        res.status(200).json({ message: 'Booking updated successfully!' });
    });
});



app.delete('/api/bookings/:id', (req, res) => {
    const bookingId = req.params.id;

    const querySelectBooking = 'SELECT carModel FROM bookings WHERE id = ?';
    db.query(querySelectBooking, [bookingId], (err, results) => {
        if (err) {
            console.error('Error fetching booking:', err);
            return res.status(500).json({ message: 'Error fetching booking.' });
        }

        if (results.length === 0) {
            return res.status(404).json({ message: 'Booking not found.' });
        }

        const carModel = results[0].carModel;

        
        const queryDeleteBooking = 'DELETE FROM bookings WHERE id = ?';
        db.query(queryDeleteBooking, [bookingId], (err, result) => {
            if (err) {
                console.error('Error deleting booking:', err);
                return res.status(500).json({ message: 'Error deleting booking.' });
            }

            
            const queryUpdateCar = 'UPDATE cars SET available = 1 WHERE carModel = ?';
            db.query(queryUpdateCar, [carModel], (err, result) => {
                if (err) {
                    console.error('Error updating car availability:', err);
                } else {
                    console.log(`Car ${carModel} marked as available.`);
                }
            });

            res.status(200).json({ message: 'Booking canceled successfully.' });
        });
    });
});


app.get('/api/bookings/:id', (req, res) => {
    

    const bookingId = parseInt(req.params.id, 10);
    console.log(`Hit the /api/bookings/:id route`);
    if (isNaN(bookingId)) {
        return res.status(400).json({ message: 'Invalid booking ID.' });
    }

    console.log(`Handling GET request for booking ID: ${bookingId}`);
    console.log(`Executing query: SELECT * FROM bookings WHERE id = ${bookingId}`);

    db.query('SELECT * FROM bookings WHERE id = ?', [bookingId], (err, result) => {
        if (err) {
            console.error('Database query error:', err.message);  
            return res.status(500).json({ message: 'Error fetching booking' });
        }

        if (result.length === 0) {
            console.log(`No booking found with ID: ${bookingId}`);
            return res.status(404).json({ message: 'Booking not found' });
        }

        console.log(`Booking found:`, result[0]);
        res.status(200).json(result[0]);  
    });
});




app.put('/api/bookings/:id', (req, res) => {
    const { id } = req.params;  
    const { carModel, location, startDate, endDate } = req.body;

   
    if (!carModel || !location || !startDate || !endDate) {
        return res.status(400).json({ message: 'All fields are required.' });
    }

    const startDateObj = new Date(startDate);
    const endDateObj = new Date(endDate);

    
    if (isNaN(startDateObj.getTime()) || isNaN(endDateObj.getTime())) {
        return res.status(400).json({ message: 'Invalid date format. Please use YYYY-MM-DD.' });
    }

    
    if (startDateObj < new Date()) {
        return res.status(400).json({ message: 'Start date cannot be in the past.' });
    }

    
    if (startDateObj >= endDateObj) {
        return res.status(400).json({ message: 'Start date must be before the end date.' });
    }

    const startDateFormatted = startDateObj.toISOString().slice(0, 10);
    const endDateFormatted = endDateObj.toISOString().slice(0, 10);

    
    const queryCheckBookingExists = 'SELECT * FROM bookings WHERE id = ?';
    db.query(queryCheckBookingExists, [id], (err, result) => {
        if (err) {
            console.error('Error checking booking existence:', err);
            return res.status(500).json({ message: 'Error checking booking existence', error: err });
        }

        if (result.length === 0) {
            console.log(`No booking found with ID: ${id}`);
            return res.status(404).json({ message: 'Booking not found' });
        }

        console.log(`Booking found:`, result[0]);

        
        const queryCheckAvailability = `
            SELECT * FROM bookings WHERE carModel = ? 
            AND id != ?  -- Exclude the current booking
            AND (
                (startDate < ? AND endDate > ?)   -- Booking starts before and ends after selected start date
                OR
                (startDate < ? AND endDate > ?)   -- Booking starts before and ends after selected end date
            );
        `;
        db.query(queryCheckAvailability, [carModel, id, startDateFormatted, startDateFormatted, endDateFormatted, endDateFormatted], (err, result) => {
            if (err) {
                console.error('Error checking car availability:', err);
                return res.status(500).json({ message: 'Error checking car availability', error: err });
            }

            if (result.length > 0) {
                return res.status(400).json({ message: 'The car is already booked for the selected dates.' });
            }

            
            const queryUpdateBooking = `
                UPDATE bookings
                SET carModel = ?, location = ?, startDate = ?, endDate = ?
                WHERE id = ?;
            `;
            db.query(queryUpdateBooking, [carModel, location, startDateFormatted, endDateFormatted, id], (err, result) => {
                if (err) {
                    console.error('Error updating booking:', err);
                    return res.status(500).json({ message: 'Error updating booking', error: err });
                }

                if (result.affectedRows === 0) {
                    console.log('No booking updated, it may not exist.');
                    return res.status(404).json({ message: 'Booking not found' });
                }

                
                const queryUpdateCar = 'UPDATE cars SET available = 0 WHERE carModel = ?';
                db.query(queryUpdateCar, [carModel], (err, result) => {
                    if (err) {
                        console.error('Error updating car availability:', err);
                        return res.status(500).json({ message: 'Error updating car availability' });
                    }

                    console.log(`Car ${carModel} availability updated.`);
                });

                
                res.status(200).json({ message: 'Booking updated successfully!' });
            });
        });
    });
});





app.use(express.static('public'));
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/home.html');
});


app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});

