/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function mySearchBuses() {

    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[2];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


function deleteId(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Không thể xóa!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}



function getBus(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myBuses");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td><img src="${data[i].image}" width="120" /></td>
                    <td>${data[i].name}</td>
                    <td>${data[i].active}</td>
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteId('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xoa</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }

        let d2 = document.getElementById("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}



function getGara(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myGara");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td></td>
                    <td>${data[i].name}</td>
                    <td>${data[i].status}</td>
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteId('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xoa</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }

        let d2 = document.getElementById("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}

function mySearchGarageStatus() {

    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("my-input");
    filter = input.value.toUpperCase();
    table = document.getElementById("my-garage");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[3];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function mySearchBusesStatus() {

    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("my-input-2");
    filter = input.value.toUpperCase();
    table = document.getElementById("my-buses");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[4];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}