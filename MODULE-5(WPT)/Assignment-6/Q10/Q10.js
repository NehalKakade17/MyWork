
const fruits1 = ["Apple", "Banana", "Cherry"];
const fruits2 = ["Guava", "Papaya", "Watermelon", "Grape"];


document.getElementById('mergeFruits').addEventListener('click', () => {
   
    const mergedFruits = [...fruits1, ...fruits2];

    
    let fruitHtml = "<h3>Merged Fruit List:</h3><ul>";
    mergedFruits.forEach(fruit => {
        fruitHtml += `<li>${fruit}</li>`;
    });
    fruitHtml += "</ul>";

    document.getElementById('fruitList').innerHTML = fruitHtml;
});
