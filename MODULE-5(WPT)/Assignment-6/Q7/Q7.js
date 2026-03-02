
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,22];

document.getElementById('filterEven').addEventListener('click', () => {
    
    const evenNumbers = numbers.filter(num => num % 2 === 0);

    
    let resultHtml = "<h3>Even Numbers:</h3><ul>";
    evenNumbers.forEach(num => {
        resultHtml += `<li>${num}</li>`;
    });
    resultHtml += "</ul>";

    document.getElementById('result').innerHTML = resultHtml; 
});
