const taxRate = 0.10; 
let subtotal = 0; 
let cartItems = []; 

document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', () => {
        const price = parseFloat(button.getAttribute('data-price')); 
        const productName = button.previousElementSibling.previousElementSibling.textContent; 

        
        cartItems.push({ name: productName, price });
        subtotal += price; 

        updateCart(); 
    });
});

function updateCart() {
    const cart = document.getElementById('cart');
    cart.innerHTML = ''; 

   
    cartItems.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.name}: RS ${item.price.toFixed(2)}`;
        cart.appendChild(li);
    });

    
    const tax = subtotal * taxRate;
    const total = subtotal + tax;

    
    document.getElementById('subtotal').textContent = subtotal.toFixed(2);
    document.getElementById('tax').textContent = tax.toFixed(2);
    document.getElementById('total').textContent = total.toFixed(2);
}
