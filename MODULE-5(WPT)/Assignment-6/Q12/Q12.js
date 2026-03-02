
function createPromise() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve("Promise resolved after 3 seconds!");
        }, 3000);
    });
}


document.getElementById('startPromise').addEventListener('click', () => {
    
    createPromise().then((message) => {
        
        document.getElementById('message').innerText = message;
    });
});
