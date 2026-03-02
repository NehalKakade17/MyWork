import Router from "express";
import { adminLogin, registerAdmin } from "./adminController.js";
const rt = Router();
rt.post("/register", registerAdmin);
rt.post("/login", adminLogin);
export default rt;
