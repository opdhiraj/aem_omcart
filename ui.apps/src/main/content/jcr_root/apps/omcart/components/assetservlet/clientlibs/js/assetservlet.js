console.log("assetservlet top");

$('.assetservletbutton').click(function () {
           $.ajax({
                type: "GET",
                url: "/bin/omcart/assetservlet",

                success: function (response) {
                   console.log("response");
                },
                error: function (err) {
                     console.log("err",err);
                },
            });
        });

console.log("assetservlet button");