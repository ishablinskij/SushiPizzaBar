let response =  fetch('http://localhost:8080/user/balance?id=1',  { mode: 'no-cors'}).then(data => {
    console.log(data);
});




