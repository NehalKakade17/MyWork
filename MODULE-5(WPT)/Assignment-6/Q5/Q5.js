
const numbers = [2,30,1,5,7,8];

document.getElementById('extractNumbers').addEventListener('click', () => {
    
    const [firstNumber, secondNumber] = numbers;

   
    const numberDetails = `First Number: ${firstNumber}<br>Second Number: ${secondNumber}`;
    document.getElementById('numberInfo').innerHTML = numberDetails; 
});
