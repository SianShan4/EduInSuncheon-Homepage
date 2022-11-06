let index = {
    init: function () {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },

    save: function () {
        let user = {
            username: $("#username").val(),
            password: $("#password").val(),
            phone: $("#phone").val(),
        };

        console.log(user);

        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8", //body가 어떤 타입인지
            dataType: "json", //응답이 어떤 타입인지
        }).done(function (resp) {
                alert("회원가입이 완료되었습니다.");
            location.href = "/blog";
            }).fail(function (error) {
                alert(JSON.stringify(error))
        }); //ajax로 user객체의 3개의 변수를 json형태로 변환하여 insert 요청을 보낸다.

    }
}

index.init();