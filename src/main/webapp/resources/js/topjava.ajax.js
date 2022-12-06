let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        alert(this.readyState);
    }
}

xhttp.open("GET", "http://localhost:8080/topjava/meals", true)
xhttp.send();