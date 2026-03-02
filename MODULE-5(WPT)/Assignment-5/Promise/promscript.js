document.getElementById('fetchDataBtn').addEventListener('click', async () => {
    // Function to fetch data from a public API
    const fetchData = async (url) => {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Error fetching data: ' + response.statusText);
        }
        return await response.json();
    };

    // Using async/await to handle multiple fetch calls
    try {
        const results = await Promise.all([
            fetchData('https://jsonplaceholder.typicode.com/posts/1'),  // Fetch post 1
            fetchData('https://jsonplaceholder.typicode.com/posts/2'),  // Fetch post 2
            fetchData('https://jsonplaceholder.typicode.com/posts/3')   // Fetch post 3
        ]);

        // Display the results
        document.getElementById('result').textContent = results
            .map(post => `Title: ${post.title}\nBody: ${post.body}`)
            .join('\n'); // Add some space between posts
    } catch (error) {
        // Handle any error that occurred during the fetch calls
        document.getElementById('result').textContent = error.message;
    }
});




