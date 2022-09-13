/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteTram(endpoint, id, btn) {
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

function getTram(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("tableTram");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].idtram}">
                    <td>${data[i].idtram}</td>
                    <td>${data[i].tenTram}</td>
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].idtram}"></div>
                        <button class="btn btn-danger" onclick="deleteTram('${endpoint + "/" + data[i].idtram}', ${data[i].idtram}, this)">Xoa</button>
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

function mySearchTram() {

    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
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
