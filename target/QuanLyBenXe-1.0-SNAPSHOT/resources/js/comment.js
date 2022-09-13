
function addComment(routeBusesId, userId){
    let commentare= document.getElementById("commentId");
    console.log(commentare.value);
    fetch('http://localhost:8080/QuanLyBenXe/api/addcomment', 
    {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "routeBusesId": routeBusesId,
            "userId": userId
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res){
        
        return res.json();
    }).then(function(data){
        console.info(data);
        
        let areaComment = document.getElementById("areaComment");
        console.log(areaComment);
        
        areaComment.innerHTML = `
        
        <div class="col-md-2" style="padding:10px;">
                <img alt="anh user comment" 
                     class="img-fluid"
                     style="border-radius: 50%;"s
                     src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/OOjs_UI_icon_userAvatar-constructive.svg/2048px-OOjs_UI_icon_userAvatar-constructive.svg.png" />
        </div>
        
         <div class="col-md-10 mydate">
            <p>${data.context}</p>
            <span>${moment(data.creatdatetime).locale("vi").fromNow()}</span>
        </div>
            ` + areaComment.innerHTML;
    
    })
}


