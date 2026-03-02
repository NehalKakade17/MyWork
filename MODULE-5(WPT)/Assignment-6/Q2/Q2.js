
function calculateAreaRegular(length, width) {
    return length * width;
}

const calculateAreaArrow = (length, width) => length * width;

document.getElementById('calculate').addEventListener('click', () => {
    const length = parseFloat(document.getElementById('length').value);
    const width = parseFloat(document.getElementById('width').value);
    
    if (isNaN(length) || isNaN(width) || length <= 0 || width <= 0) {
        alert("Please enter valid positive numbers for length and width.");
        return;
    }

    const areaRegular = calculateAreaRegular(length, width);
    const areaArrow = calculateAreaArrow(length, width);

    // Display the results
    document.getElementById('area').textContent = areaRegular; 
    document.getElementById('area-regular').innerText = areaRegular.toFixed(2); 
    document.getElementById('area-arrow').innerText = areaArrow.toFixed(2);
});
