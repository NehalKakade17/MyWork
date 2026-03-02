export function Greet(props){

    return (
        <div>
            <h1>Hi {props.personName}, Good Afternoon</h1>
            <h2>Your email: {props.email}</h2>
        </div>
    )
}