import express from "express";
import productRouter from "./productRouter.js";
import { connectToDb } from "./database.js";
import adminRouter from "./adminRouter.js"
const app = express();
app.use(express.json());
app.use("/product", productRouter);
app.use("/admin", adminRouter);
app.listen(9800, () => {
    console.log("welecome to the product server");
    connectToDb();
});