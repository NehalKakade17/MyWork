export function Section(props){
    return (
        <div>
            <div className="left-box">
                {props.leftBox}
            </div>
            <div className="right-box">
                {props.rightBox}
            </div>
            {props.children}
        </div>
    )
}