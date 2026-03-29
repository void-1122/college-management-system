function uploadFile() {
    let file = document.getElementById("file").files[0];
    let title = document.getElementById("title").value;
    let subject = document.getElementById("subject").value;
    let sem = document.getElementById("sem").value;

    fetch("http://localhost:9090/add", {
        method: "POST",
        headers: {
            "title": title,
            "subject": subject,
            "semester": sem
        },
        body: file
    })
    .then(res => res.text())
    .then(alert);
}

function loadResources() {
    fetch("http://localhost:9090/get")
    .then(res => res.text())
    .then(data => document.getElementById("output").innerText = data);
}

function searchResource() {
    let key = document.getElementById("search").value;

    fetch("http://localhost:9090/search?key=" + key)
    .then(res => res.text())
    .then(data => document.getElementById("output").innerText = data);
}
