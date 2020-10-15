let index = {
    init: function (){
        $("#btn-write").on("click", ()=>{
            this.save();
        });
        $("#btn-delete").on("click", ()=>{
            this.delete();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
        });
        $("#btn-success").on("click", ()=>{
            this.success();
        })
    },
    success: function (){
        let id = $("#id").val();
         let  isSuccess = $("#isSuccess").val();
        $.ajax({
            type:"PUT",
            url:`/api/taskSuccess/${id}`,
            data : JSON.stringify(isSuccess),
            contentType:"application/json;utf-8"
        })
            .done(function (response){
                if(response===500){
                    alert("수정에 실패했습니다.");
                }
                else {
                    alert("수정에 성공했습니다.");
                }
                location.href=`http://localhost:8080/task/detail/${id}`;
            })
            .fail(function (error){
                alert(JSON.stringify(error));
            });
    },
    update:function (){
        let data = {
            id : $("#id").val(),
            title: $("#title").val(),
            content : $("#content").val(),
            deadline:  $("#deadline").val()
        };
        $.ajax({
            type : "PUT",
            url : `/api/taskUpdate/${data.id}`,
            data : JSON.stringify(data),
            contentType : "application/json;utf-8"
        })
            .done(function (response){
                if(response===500){
                    alert("수정에 실패했습니다.");
                }
                else {
                    alert("수정에 성공했습니다.");
                }
                location.href = `/task/detail/${data.id}`;
            })
            .fail(function (error){
                JSON.stringify(error);
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
               history.back("");
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