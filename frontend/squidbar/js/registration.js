let db = {
    addUserToDB : function() {
        origin='*';

        let user = {
            "telephone": "+9655555555",
            "name": "SPOd",
            "password": 'spo',
            "passwordRetry": 'spo',
            "address": {
                "city": "New York",
                "street": "lowre",
                "houseNumber": 0
            }
        };

        let response = $.ajax({
            url:'http://localhost:8080/registration',
            type:'POST',
            data:JSON.stringify(user),
            contentType:'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    getBalance : function () {
        let response = $.ajax({
            url:'http://localhost:8080/user/balance?id=1',
            type:'GET',
            contentType:'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    login : function () {
        let user = {
            "telephone": '+9655555555',
            "password": 'spo'
        };

        let response = $.ajax({
            url:'http://localhost:8080/login',
            type:'POST',
            data:JSON.stringify(user),
            contentType:'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    addFood : function () {
        let request = {
            "basketId": 1,
            "food": {
            "name":"imya",
                "type":"SUSHI",
                "cost":20202.0,
                "weight":30.0,
                "size":"SMALL",
                "description":"lalala",
                "ingredients":["la", "la", "la"]
            }
        }
        let response = $.ajax({
            url:'http://localhost:8080/basket',
            type:'POST',
            data:JSON.stringify(request),
            contentType:'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    }
};






