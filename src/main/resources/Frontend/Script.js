var hardcover = document.getElementById("hardcoverList");

let data = {
    "title": "I am a title",
    "author": "",
    "genre": "",
    "isbn": "",
    "price": "",
};

function priceWatcher(hardcover) {
    if (hardcover.value == "paperback") {
        set("price", "11.00");
    } else {
        set("price", "14.00")
    }
};

function set(key, value, updateUI = true) {
    data[key] = value;
    if (updateUI) {
        update();
    }
}

function update() {
    let nodes = document.querySelectorAll('[data]');
    console.log(nodes);

    for (let i = 0; i < nodes.length; i++) {
        console.log(nodes[i].getAttribute("data"));
        if (data[nodes[i].getAttribute("data")] != undefined) {
            let value = data[nodes[i].getAttribute("data")];
            nodes[i].innerText = value;
            nodes[i].setAttribute("data-type", typeof value);
        }
    }
}

var jsonData;

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function randomButtonClicked() {
    console.log("button clicked");

    var randomBookID = getRandomInt(1, 90);

    var promise1 = new Promise(function (resolve, reject) {
        var xhr = new XMLHttpRequest(),
            method = "GET",
            url = "http://localhost:8080/books/allbooks/" + randomBookID;
        console.log("through promise half");

        xhr.open(method, url, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                jsonData = JSON.parse(xhr.responseText);
                updateDataAndUI(jsonData);
                window.location.href="BookPage.html";
                resolve({ responseData: xhr.responseText, jsonData: jsonData });
            }
        };
        xhr.send();
        console.log("through promise completely");
    });
    console.log("Pre promise1");

    promise1.then(function (value) {
        console.log("Data from the server: " + value.responseData);
        console.log("ISBN: " + JSON.parse(value.responseData).isbn);
        console.log("ISBN (2): " + value.responseData[0].isbn);
        console.log(typeof value.responseData);
        console.log(typeof value.jsonData);
        console.log("Data: " + data);

        var myArray = value.responseData.split(",");
        console.log(typeof myArray);
        console.log("myArray " + myArray);
        myArray.forEach(function(item){
            var settee = item.split(":");
            if(data[settee[0]] === true){
                set(settee[0], settee[1]);
            };
        });
        data = myArray;
        update();




    }).catch(function (error) {
        console.error("Error: " + error);
    });
    console.log("Post promise1");

    promise1.catch(() => {
        console.log("Error: caught the missing :)");
    });
}

function updateDataAndUI(newData) {
    Object.keys(newData).forEach(function (field) {
        data[field] = newData[field];
        console.log("new Data: " + newData);
    });

    update();
}
