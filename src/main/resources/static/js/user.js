let index ={
    init : function() {
        $("#btn-join").on("click",()=>{
            this.save();
        }),
        $("#btn-update").on("click", ()=>{
            this.update();
        })
    },

    update: function (){
        let data={
            userId:parseInt($("#userId").val(),10),
            nickname: $("#nickname").val(),
            password: $("#password").val(),
            email:$("#email").val(),
        };
        if(data.password=="" || data.nickname=="" || data.email==""){
            alert("공백인 칸이 존재합니다.");
            return;
        }
       $.ajax({
           type:"PUT",
           url:"/api/userProc/"+data.userId,
           contentType: "application/json;charset=utf-8",
           data: JSON.stringify(data)
            })
           .done(function (response){
               alert("회원 수정이 완료되었습니다.");
               window.history.back();
           })
           .fail(function (error){
               alert(JSON.stringify(error));
           });
    },

    save : function(){
        let data = {
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val(),
            nickname:$("#nickname").val(),
        };
        if(data.password=="" || data.nickname=="" || data.email=="" || data.username ==""){
            alert("공백인 칸이 존재합니다.");
            return;
        }

        $.ajax({
            type:"POST",
            url:"/api/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8"
        })
        .done(function(response){
            if(response.status === 500){
                alert("회원 가입에 실패하였습니다.");
            }
            else if(response==false){
                alert("중복된 아이디입니다.");
                return;
            }
            else{
                alert("회원 가입에 성공하였습니다.");
            }
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}
index.init();