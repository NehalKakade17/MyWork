import { createConnection } from "mysql2";
import { config } from "dotenv";
config();
export function getConnectionObject() {
    const connectConfig = createConnection({
        host: process.env.DB_HOST,
        user: process.env.DB_USER,
        password: process.env.DB_PASSWORD,
        database: process.env.DB_NAME
    });
    return connectConfig;
}
export function connectToDb() {
    const connectConfig = getConnectionObject();
    connectConfig.connect((error) => {
        if (error) {
            console.log(error);
        }
        else {
            console.log("successfully connected");
        }
    });
}
