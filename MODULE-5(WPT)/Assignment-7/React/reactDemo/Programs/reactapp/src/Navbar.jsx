import { Section } from "./Section";

export function Navbar(){
    return (
        <div>
            <nav>
                <Section leftBox={<a href="#">Left Link</a>} rightBox={<a href="#">Right Link</a>}>
                    <h1>Child heading</h1>
                </Section>
                <div><a href="#">Home</a></div>
                <div><a href="#">About</a></div>
                <div><a href="#">Contact</a></div>

            </nav>
        </div>
    )
}