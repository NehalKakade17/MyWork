
function executeAfterDelay(callback, delay) {
    setTimeout(callback, delay);
}

document.getElementById('executeCallback').addEventListener('click', () => {
    const delay = parseInt(document.getElementById('delayInput').value, 10); 

    
    if (isNaN(delay) || delay < 0) {
        document.getElementById('result').innerText = "Please enter a valid positive number.";
        return;
    }

    
    const callback = () => {
        document.getElementById('result').innerText = `Callback executed after ${delay} ms!`;
    };

    
    executeAfterDelay(callback, delay);
});
