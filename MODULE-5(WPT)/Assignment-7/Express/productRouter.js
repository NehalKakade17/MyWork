import { Router } from "express";
import { s } from "./productController.js";
const rt = Router();
rt.post("/create", s);
export default rt;