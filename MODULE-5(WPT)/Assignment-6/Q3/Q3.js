
const book = {
    title: "Into the Dark",
    author: "Kaguya Sama",
    yearPublished: 2002,
    
    displayDetails: function() {
        return `<span>Title:</span> ${this.title}<br><span>Author:</span> ${this.author}<br><span>Year Published:</span> ${this.yearPublished}`;
    }
};

document.getElementById('showBookDetails').addEventListener('click', () => {
    
    const bookDetails = book.displayDetails();
    document.getElementById('bookInfo').innerHTML = bookDetails; 
});

