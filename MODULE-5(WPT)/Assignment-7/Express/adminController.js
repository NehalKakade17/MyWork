import bcrypt from "bcrypt";
import { getConnectionObject } from "./database.js";

// Register Admin Function
export async function registerAdmin(req, res) {
    try {
        const { user_name, password } = req.body;
        
        // Hash password asynchronously
        const hashedPassword = await bcrypt.hash(password, 12);

        const db = getConnectionObject();
        
        // Use parameterized query to prevent SQL injection
        const query = "INSERT INTO admin (user_name, password) VALUES (?, ?)";
        
        db.query(query, [user_name, hashedPassword], (error, result) => {
            if (error) {
                console.error("Error in registering admin: ", error);
                return res.status(500).send({ error: "Something went wrong during registration" });
            }
            res.status(201).send({ message: "Admin registered successfully", result });
        });
    } catch (error) {
        console.error("Error in registerAdmin: ", error);
        res.status(500).send({ error: "Something went wrong during registration" });
    }
}

// Admin Login Function
export async function adminLogin(req, res) {
    try {
        const { user_name, password } = req.body;
        
        const db = getConnectionObject();
        
        // Use parameterized query to prevent SQL injection
        const query = "SELECT * FROM admin WHERE user_name = ?";
        
        db.query(query, [user_name], async (error, result) => {
            if (error) {
                console.error("Error in login query: ", error);
                return res.status(500).send({ error: "Database error occurred" });
            }

            if (result.length === 0) {
                return res.status(401).send({ error: "Invalid username or password" });
            }

            // Use bcrypt's async compare function to compare the password
            const isPasswordValid = await bcrypt.compare(password, result[0].password);
            
            if (isPasswordValid) {
                res.status(200).send({ message: "Login successful" });
            } else {
                res.status(401).send({ error: "Invalid username or password" });
            }
        });
    } catch (error) {
        console.error("Error in adminLogin: ", error);
        res.status(500).send({ error: "Something went wrong during login" });
    }
}
