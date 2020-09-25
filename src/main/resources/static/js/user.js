let index ={
    init : function() {
        $("#btn-join").on("click",()=>{
            this.save();
        });
    },
    save : function(){
        let data = {
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val(),
            nickname:$("#nickname").val(),
        };

        $.ajax({
            type:"POST",
            url:"/api/joinProc",
            data:JSON.stringify(data),
            dataType:"application/json;charset=utf-8"
        })
        .done(function(response){
            if(response.status === 500){
                alert("로그인에 실패하였습니다.");
            }
            else{
                alert("로그인에 성공하였습니다.");
            }
            location.href="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
    }
}
index.init();