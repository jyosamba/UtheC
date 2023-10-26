var hardcover = document.getElementById("hardcoverList");
var jsonData = [
    {title: "steppenwolf", author: "Hermann Hesse", genre: "Philosophical Fiction"},
    {title: "fantastic beasts", author: "J. K. Rowling", genre: "Fantasy"},
    {title: "a brief history of time", author: "Stephen Hawking", genre: "Science"},
    {title: "the davinci code", author: "Dan Brown", genre: "Mystery"},
    {title: "kafka on the shore", author: "Haruki Murakami", genre: "Magical Realism"},
    {title: "neuromancer", author: "William Gibson", genre: "Sci Fi"},
    {title: "the litigators", author: "John Grisham", genre: "Thriller"},
    {title: "the fellowship of the ring", author: "J. R. R. Tolkien", genre: "Fantasy"},
    {title: "the silmarillion", author: "J. R. R. Tolkien", genre: "Fantasy"},
];
var genre = "Fantasy";
const allBooks = document.getElementById("allBooks");
const genreBooks = document.getElementById("genreBooks");

let data = {
    "title": "Steppenwolf",
    "author": "Hermann Hesse",
    "genre": "Philosophical Fiction",
    "publisher": "Penguin Modern Classics",
    "ISBN": "0312278675",
    "price": "14.00",
    "secretDeal": "Halloween"
};

function priceWatcher(hardcover){
    if(hardcover.value == "paperback"){
        set("price", "11.00");
        update();
    }
    else{
        set("price", "14.00")
        update();
    }
};

function set(key, value, updateUI=true){
	data[ key ] = value;
	update();	// if updateUI is true then update()
};

function update(){
	let nodes = document.querySelectorAll('[data]');
	console.log(nodes);

	for(let i=0; i<nodes.length; i=i+1){
		console.log( nodes[i].getAttribute("data") );
		if(data[ nodes[i].getAttribute("data") ] != undefined){
			let value = data[ nodes[i].getAttribute("data") ];
			nodes[i].innerText = value;
			nodes[i].setAttribute("data-type", typeof value);
		}
	}
};

update();

jsonData.forEach(item => {
    const newDiv = document.createElement("div");
    newDiv.innerHTML = `
        <img th:src="'Images/' + ${item.title} + '.jpg'" alt="${item.title}" width="300" height="400">
    `;
    allBooks.appendChild(newDiv);

    if(item.genre === genre)
    newDiv.innerHTML = `
    <img th:src="'Images/' + ${item.title} + '.jpg'" alt="${item.title}" width="300" height="400">
    `;

    genreBooks.appendChild(newDiv);

    if(item.author === author)
    newDiv.innerHTML = `
    <img th:src="'Images/' + ${item.title} + '.jpg'" alt="${item.title}" width="300" height="400">
    `;

    authroBooks.appendChild(newDiv);
});

