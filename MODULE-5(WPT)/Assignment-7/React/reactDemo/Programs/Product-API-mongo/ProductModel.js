import { Schema, model } from "mongoose";

const productSchema = new Schema({
    productId: Number,
    name: String,
    quantity: Number,
    price: Number,
    description:String
});

export const Product = model("product",productSchema);
