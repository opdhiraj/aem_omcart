console.log("navbar");
let modelform = document.querySelector(".modelform");

function loginform() {
  console.log("from loginform function");
  let loginform = document.querySelector(".loginform");
  let formdata = document.querySelector("#modeldata");

  document.querySelector(".modelform").classList.add("open");
  //to stop submitting form bydefault
  formdata.addEventListener("submit", function (e) {
    e.preventDefault();

    // document.querySelector(".modelform").style.setProperty("display", "block");
    // loginform.innerHTML = `<input type= <input type="text" id="fname" name="fname"></br>`;
  });
}

function modeldata() {
  console.log("modeldata-------");
  modelform.classList.remove("open");
}
