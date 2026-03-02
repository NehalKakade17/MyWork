
const cartItems = [
    { name: "Apple", price: 10 },
    { name: "Banana", price: 5 },
    { name: "Orange", price: 10 },
    { name: "Mango", price: 80 },
];

document.getElementById('calculateTotal').addEventListener('click', () => {
    
    const totalPrice = cartItems.reduce((total, item) => total + item.price, 0).toFixed(2);

    
    let cartHtml = "<h3>Items in Cart:</h3><ul>";
    cartItems.forEach(item => {
        cartHtml += `<li>${item.name}: RS${item.price.toFixed(2)}</li>`;
    });
    cartHtml += `</ul><h3>Total Price: RS${totalPrice}</h3>`;

    document.getElementById('cartInfo').innerHTML = cartHtml; 
});
