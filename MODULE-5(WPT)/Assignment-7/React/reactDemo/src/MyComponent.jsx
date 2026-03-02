import  {Component}  from "react";
import { Greet } from "./Greet";

export class MyComponent extends Component{
    render(){
        return (
            <div>
                <h1>Hello MyComponent</h1>
                <p>This is para in MyComponent</p>
                <Greet personName="Rahul" email="rahul@gmail.com"></Greet>
            </div>
        )    
    }
}