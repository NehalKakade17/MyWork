
function processNumbers(numbers) {
    return numbers
        .filter(num => num % 2 === 0) 
        .map(num => num * 2) 
        .reduce((total, num) => total + num, 0);
}


document.getElementById('processNumbers').addEventListener('click', () => {
    const input = document.getElementById('numberInput').value;
    const numberArray = input.split(',').map(num => parseInt(num.trim(), 10)); 

    const total = processNumbers(numberArray); 

    
    document.getElementById('result').innerText = `Total of doubled even numbers: ${total}`;
});
