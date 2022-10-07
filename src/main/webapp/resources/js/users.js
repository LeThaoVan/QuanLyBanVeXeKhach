/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function deleteUsers(endpoint, id, btn) {
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


function getUsers(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myUsers");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                  <tr id="row${data[i].id}">
                      <td>${data[i].id}</td>
                      <td><img src="${data[i].avata}" width="120" /></td>
                      <td>${data[i].userName}</td>
                       <td>${data[i].firstName}</td>
                       <td>${data[i].lastName}</td>
                       <td>${data[i].email}</td>
                       <td>${data[i].sdt}</td>
                       <td>${data[i].role}</td>
                        <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteUsers('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xóa</button>
                    </td>
                  </tr>
              `
            d.innerHTML = h;
        }

        let d2 = document.getElemenByItd("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}



