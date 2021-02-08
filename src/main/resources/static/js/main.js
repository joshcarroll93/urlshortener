$(document).ready(function(){
    $("button").click(function(){
    console.log("button click");
        $.ajax({
            type : "POST",
            url : "http://localhost:8080/shorturl",
            data : JSON.stringify({
                "originalurl" : $("#urlInput").val()
            }),
            contentType : "application/json; charset = utf-8",
            success : function(data){
                if(data != "URL not valid! try again."){
                     console.log(data);
                     $("#clickableLink").text(data);
                     var link = $("#urlInput").val();
                     $("a#clickableLink").attr("href", link);
                }
                else{
//                    $("#shortUrl").text("Short URL:");

                    $("#shortUrl").text(data);
                    console.log(data);
                }
            },
            error: function(){
                $("#shortenedurl").val("Request Failed");
            }
        });
    });
});