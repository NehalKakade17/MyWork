
const names = ["Nehal", "Sham", "Shrutika", "Prashik", "Ajay"];

document.getElementById('calculateLengths').addEventListener('click', () => {
    
    const nameLengths = names.map(name => name.length);

    
    let resultHtml = "<h3>Name Lengths:</h3><ul>";
    names.forEach((name, index) => {
        resultHtml += `<li>${name}: ${nameLengths[index]} characters</li>`;
    });
    resultHtml += "</ul>";

    document.getElementById('nameLengths').innerHTML = resultHtml; 
});
