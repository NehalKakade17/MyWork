import { getConnectionObject } from "./database.js";

export const s = (req, res) => {
    const data = req.body;
    const db = getConnectionObject();

    // Ensure the column names are specified in the query
    const query = `INSERT INTO product (name, price, quantity) VALUES (?, ?, ?)`;

    // Use parameterized query to prevent SQL injection
    db.query(query, [data.name, data.price, data.quantity], (error, result) => {
        if (error) {
            // Handle error
            console.error(error);
            res.status(500).send({ error: 'An error occurred while inserting the product.' });
        } else {
            // Respond with success message or inserted result
            res.status(200).send({ message: 'Product inserted successfully', result });
        }
    });
};
