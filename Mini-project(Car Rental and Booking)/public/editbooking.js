async function editBooking(id) {
    const booking = await getBookingById(id);
    console.log(`Attempting to edit booking with ID: ${id}`);
    
    if (!booking) {
        alert('Booking not found!');
        return;
    }
    
   
    const newCarModel = prompt("Edit Car Model:", booking.carModel);
    const newLocation = prompt("Edit Location:", booking.location);
    const newStartDate = prompt("Edit Start Date (YYYY-MM-DD):", formatDate(booking.startDate));  
    const newEndDate = prompt("Edit End Date (YYYY-MM-DD):", formatDate(booking.endDate));  

    
    if (!newCarModel || !newLocation || !newStartDate || !newEndDate) {
        alert("All fields are required.");
        return;
    }

    if (new Date(newStartDate) >= new Date(newEndDate)) {
        alert("Start date must be before the end date.");
        return;
    }

    
    const updatedBooking = {
        carModel: newCarModel,
        location: newLocation,
        startDate: newStartDate,
        endDate: newEndDate
    };

    try {
        
        const response = await fetch(`http://localhost:3000/api/bookings/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updatedBooking)
        });

        const data = await response.json();
        if (response.ok) {
            alert('Booking updated successfully!');
            
            updateBookingInUI(id, updatedBooking);
        } else {
            alert('Error updating booking: ' + data.message);
        }
    } catch (error) {
        alert('Error updating booking: ' + error.message);
    }
}


function formatDate(date) {
    const d = new Date(date);
    const year = d.getFullYear();
    const month = String(d.getMonth() + 1).padStart(2, '0'); 
    const day = String(d.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`; 
}


function updateBookingInUI(id, updatedBooking) {
    const row = document.querySelector(`#booking-${id}`);
    if (row) {
        row.querySelector(".carModel").textContent = updatedBooking.carModel;
        row.querySelector(".location").textContent = updatedBooking.location;
        row.querySelector(".startDate").textContent = updatedBooking.startDate;
        row.querySelector(".endDate").textContent = updatedBooking.endDate;
    }
}




