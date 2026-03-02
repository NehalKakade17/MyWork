import { Section } from "./Section";

export function Footer(){
    return (
        <div>
            <nav>
                <div><a href="#">Social Media</a></div>
                <div><a href="#">Youtube</a></div>
                <div><a href="#">Map location</a></div>
                <Section leftBox={<h1>Left heading</h1>} rightBox={<h4>Para at right</h4>}></Section>
            </nav>
        </div>
    )
}