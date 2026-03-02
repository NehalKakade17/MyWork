
function getQueryParams() {
    const params = {};
    window.location.search.substring(1).split("&").forEach(param => {
        const [key, value] = param.split("=");
        params[decodeURIComponent(key)] = decodeURIComponent(value);
    });
    return params;
}

const params = getQueryParams();
if (params.car) {
    document.getElementById('carModel').value = params.car;
}

const carModelSelect = document.getElementById('carModel');
const priceDisplay = document.getElementById('priceDisplay');
const totalBillDisplay = document.getElementById('totalBillDisplay');
const gstRate = 0.18; 


carModelSelect.addEventListener('change', function () {
    const selectedOption = this.options[this.selectedIndex];
    const pricePerDay = parseFloat(selectedOption.getAttribute('data-price')); 

    if (isNaN(pricePerDay)) {
        priceDisplay.innerText = 'Please select a valid car model'; 
    } else {
        priceDisplay.innerText = `Price: ₹${pricePerDay} per day`; 
        updateTotal(pricePerDay); 
    }
});


document.getElementById('startDate').addEventListener('change', function () {
    const pricePerDay = parseFloat(carModelSelect.options[carModelSelect.selectedIndex].getAttribute('data-price'));
    updateTotal(pricePerDay);
});

document.getElementById('endDate').addEventListener('change', function () {
    const pricePerDay = parseFloat(carModelSelect.options[carModelSelect.selectedIndex].getAttribute('data-price'));
    updateTotal(pricePerDay);
});


function updateTotal(pricePerDay) {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;

    if (startDate && endDate) {
        const start = new Date(startDate);
        const end = new Date(endDate);

        
        if (end < start) {
            totalBillDisplay.innerText = 'Error: End date must be after the start date';
            return; 
        }

        
        const days = Math.ceil((end - start) / (1000 * 60 * 60 * 24));

        if (days > 0) {
            const totalCost = pricePerDay * days;
            const gstAmount = totalCost * gstRate; 
            const totalBill = totalCost + gstAmount; 

            totalBillDisplay.innerText = `Total Bill (including GST): ₹${totalBill.toFixed(2)}`; 
        } else {
            totalBillDisplay.innerText = 'Error: Duration must be at least 1 day'; 
        }
    }
}


document.getElementById('bookingForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const carModel = document.getElementById('carModel').value;
    const location = document.getElementById('location').value;
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;

    
    if (!carModel || !location || !startDate || !endDate) {
        alert('All fields are required.');
        return;
    }

    
    const unavailableCars = ['Kia Seltos']; 
    if (unavailableCars.includes(carModel)) {
        alert("Sorry, the selected car is currently not available for booking.");
        return;
    }

    const booking = {
        carModel,
        location,
        startDate,
        endDate
    };

    try {
        
        const response = await fetch('/api/bookings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(booking)
        });

        const data = await response.json();

        if (response.ok) {
            alert(data.message); 
            window.location.href = 'bookingmanagement.html'; 
        } else {
            alert('Error: ' + (data.message || 'An unknown error occurred.'));
        }
    } catch (error) {
        alert('Error submitting booking: ' + error.message); 
    }
});









