import { Component } from "react";

export class ErrorBoundary extends Component{
    constructor(){
        super();
        this.state = { error: null, errorInfo: null };
    }
    componentDidCatch(error, errorInfo){
        console.log(error);
        console.log(errorInfo);
        this.setState({ error: error, errorInfo: errorInfo });
    }
    render(){
        if(this.state.error){
            return <h1>Something went wrong</h1>;
        }
        return this.props.children;
    }
}