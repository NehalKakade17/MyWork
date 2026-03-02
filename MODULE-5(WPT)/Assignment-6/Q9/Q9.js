
function calculateSum(...numbers) {
    return numbers.reduce((total, num) => total + Number(num), 0);
}

document.getElementById('calculateSum').addEventListener('click', () => {
    const input = document.getElementById('numberInput').value;
    const numbers = input.split(',').map(num => num.trim()); 

    const sum = calculateSum(...numbers); 

    
    document.getElementById('result').innerHTML = `Total Sum: ${sum}`;
});
