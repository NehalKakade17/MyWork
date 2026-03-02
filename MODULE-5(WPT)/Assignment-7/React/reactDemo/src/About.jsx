import { Header } from "./Header";

export function About() {
    return (
        <div>
            <Header heading="Welcome to About" text="this is text for about"></Header>

            <table border={1}>
                <tr>
                    <td>11</td>
                    <td>Rocky Bhai</td>
                    <td>+91-888176166</td>
                </tr>
            </table>
        </div>
    )
}