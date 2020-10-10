let index = {
    init: function (){
        $("#btn-write").on("click", ()=>{
            this.save();
        })
    },
    save: function (){
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            deadline: $("#deadline").val()
        };
        if(data.title==""){
            alert("title을 작성해주세요.");
            return;
        }
        $.ajax({
            type:"POST",
            url:"/api/writeProc",
            data: JSON.stringify(data),
            contentType:"application/json;utf-8",
        })
        .done(function (response){
            if(response.status===500){
                alert("작성에 실패하였습니다.");
            }
            else{
                alert("작성에 성공하였습니다.");
            }
            location.href="/todolist/proceeding?page=0";
        })
        .fail(function (error){
           JSON.stringify(error);
        })
    }
}

index.init();