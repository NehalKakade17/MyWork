export function Header(props){
    const {heading,text} = props;
    return (
        <div>
            <h1>{heading}</h1>
            <p>{text}</p>
        </div>
    )
}