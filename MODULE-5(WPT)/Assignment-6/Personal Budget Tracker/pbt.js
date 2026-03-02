// State variables
let expenses = [];
let totalExpense = 0;

// Function to fetch initial expenses from "API"
const fetchInitialExpenses = () => {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { description: 'Groceries', amount: 50, date: '2023-10-01' },
                { description: 'Utilities', amount: 30, date: '2023-10-02' },
                { description: 'Transport', amount: 15, date: '2023-10-03' },
            ]);
        }, 1000);
    });
};

// Function to add expense
const addExpense = (description, amount, date) => {
    const newExpense = { description, amount, date };
    expenses = [...expenses, newExpense]; // Use spread operator
    totalExpense += amount; // Update total
    displayExpenses(); // Refresh display
};

// Function to display expenses
const displayExpenses = () => {
    const expenseList = document.getElementById('expenseList');
    expenseList.innerHTML = ''; // Clear existing expenses
    expenses.forEach(({ description, amount, date }) => { // Destructuring
        const li = document.createElement('li');
        li.textContent = `${description} - $${amount.toFixed(2)} on ${date}`;
        expenseList.appendChild(li);
    });
    document.getElementById('totalExpense').innerText = `Total Expenses: $${totalExpense.toFixed(2)}`;
};

// Function to filter expenses
const filterExpenses = () => {
    const filteredExpenses = expenses.filter(expense => expense.amount > 20); // Filter for expenses > $20
    const expenseList = document.getElementById('expenseList');
    expenseList.innerHTML = ''; // Clear existing expenses
    filteredExpenses.forEach(({ description, amount, date }) => {
        const li = document.createElement('li');
        li.textContent = `${description} - $${amount.toFixed(2)} on ${date}`;
        expenseList.appendChild(li);
    });
};

// Closure to maintain state of total expenses
const maintainTotal = (() => {
    let currentTotal = 0;
    return (amount) => {
        currentTotal += amount;
        return currentTotal;
    };
})();

// Event listener for form submission
document.getElementById('expenseForm').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent form submission
    const description = document.getElementById('description').value;
    const amount = parseFloat(document.getElementById('amount').value);
    const date = document.getElementById('date').value;

    addExpense(description, amount, date); // Add expense and display
    document.getElementById('expenseForm').reset(); // Reset form fields
});

// Event listener for filter button
document.getElementById('filterBtn').addEventListener('click', filterExpenses);

// Async function to initialize expenses
const init = async () => {
    const initialExpenses = await fetchInitialExpenses(); // Fetch initial expenses
    initialExpenses.forEach(({ description, amount, date }) => {
        addExpense(description, amount, date); // Add each initial expense
    });
};

// Initialize the application
init();

