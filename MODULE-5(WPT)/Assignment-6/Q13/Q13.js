
function createGreeter(greeting) {
    return function(name) {
        return `${greeting}, ${name}!`;
    };
}


document.getElementById('createFunction').addEventListener('click', () => {
    const greetHello = createGreeter("Hello"); 
    
    
    const resultMessage = greetHello("Everyone"); 
    
    
    document.getElementById('result').innerText = resultMessage;
});
