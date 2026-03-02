import express from 'express';
import cors from 'cors';
import mongoose from 'mongoose';
import { Product } from './ProductModel.js';

async function connectDb(){
    try {
        await mongoose.connect("mongodb://127.0.0.1:27017/demodb")
        console.log('Database connected successfully');
    } catch (error) {
        console.log(error);
    }
}
const app = express();

app.use(cors())
app.use(express.json());

app.post("/save-product",async (request,response)=>{
    try {
        const data = request.body;
        const p = new Product(data);
        const savedProduct = await p.save();
        console.log(savedProduct);
        response.status(201).send(savedProduct);
    } catch (error) {
        response.status(500).send({message:'Error saving product'});
    }
});

app.get("/get-all",async (request,response)=>{
    try {
        const data =await Product.find();
        response.status(200).send(data);
    } catch (error) {
        response.status(500).send({message:'Error saving product'});
    }
});


app.listen(9600,()=>{
    console.log('Server started on port 9600');
    connectDb();
});