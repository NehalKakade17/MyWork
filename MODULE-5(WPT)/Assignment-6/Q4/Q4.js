
const car = {
    make: "Tata",
    model: "Swift",
    year: 2008,
    color: "White",
    
    
    displayDetails: function() {
        const { make, model, year, color } = this; 
        return `Make: ${make}<br>Model: ${model}<br>Year: ${year}<br>Color: ${color}`;
    }
};

document.getElementById('showCarDetails').addEventListener('click', () => {
    
    const carDetails = car.displayDetails();
    document.getElementById('carInfo').innerHTML = carDetails; 
});
