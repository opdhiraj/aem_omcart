console.log("assetservlet top");

$(".assetservletbutton").click(function () {
  $.ajax({
    type: "GET",
    url: "/bin/omcart/assetservlet",

    success: function (response) {
      console.log(response);
      displayResponse(response);
    },
    error: function (err) {
      console.log("err", err);
    },
  });
});

function displayResponse(res) {
  let assetpath = document.querySelector(".assetPath");
  //   for (let i = 0; i < res.length; i++) {
  //     console.log(res[i]);

  res.forEach((r) => {
    let message = "this will download asset";
    let h1 = document.createElement("h1");
    let anc = document.createElement("a");
    anc.href = r;
    anc.textContent = message;
    h1.textContent = r;
    assetpath.append(h1);
    assetpath.append(anc);
  });
}

//for coral component
var alert = new Coral.Alert();
alert.header.innerHTML = "Hey!";
alert.content.innerHTML = "This is an alert.";
alert.variant = "info";
