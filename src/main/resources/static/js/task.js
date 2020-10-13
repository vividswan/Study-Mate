let index = {
    init: function (){
        $("#btn-write").on("click", ()=>{
            this.save();
        });
        $("#btn-delete").on("click", ()=>{
            this.delete();
        })
    },
    delete: function (){
       let data = {
           id: $("#id").val()
       }
       $.ajax({
           type:"DELETE",
           url:`/api/taskDelete/${data.id}`,
           contentType: "application/json;utf-8"
       })
           .done(function (response){
               if(response===500){
                   alert("삭제에 실패했습니다.");
               }
               else{
                   alert("삭제에 성공했습니다.");
               }
               history.back();
           })
           .fail(function (error){
               alert(JSON.stringify(error));
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