let db = {
    addUserToDB : function(telephone, name, password, passwordRetry, city, street, houseNumber) {
        origin='*';

        let user = {
            "telephone": telephone,
            "name": name,
            "password": password,
            "passwordRetry": passwordRetry,
            "address": {
                "city": city,
                "street": street,
                "houseNumber": houseNumber
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

    getBalance : function (id) {
        let response = $.ajax({
            url:'http://localhost:8080/user/balance?id=' + id,
            type:'GET',
            contentType:'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    login : function (telephone, password) {
        let user = {
            "telephone": telephone,
            "password": password
        };

        let response = $.ajax({
            url:'http://localhost:8080/login',
            type:'POST',
            data:jQuery.param(user),
            contentType:'application/x-www-form-urlencoded; charset=utf-8',
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    addFood : function (basketId, name, type, cost, weight, size, description, ingredients) {
        let request = {
            "basketId": basketId,
            "food": {
            "name": name,
                "type": type,
                "cost": cost,
                "weight": weight,
                "size": size,
                "description": description,
                "ingredients": ingredients
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
    },

    getBasketByUserId : function (id) {
        let request = {
            'id':id
        }

        let response = $.ajax({
            url:'http://localhost:8080/user/basket',
            type:'GET',
            data:jQuery.param(request),
            contentType:'application/x-www-form-urlencoded; charset=utf-8',
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    }
};

let signUp = {

    submitForms : function () {
        let formIsCorrect = false;
        formIsCorrect = this.telephoneCodeIsCorrect && this.telephoneIsCorrect && this.usernameIsCorrect && this.cityIsCorrect && this.addressIsCorrect;
        if (formIsCorrect) {
            window.location.replace('http://localhost:63342/SushiPizzaBar/frontend/squidbar/registration2.html');
        }

    },

    telephoneCodeIsCorrect : function () {
        let telephoneCodeInput = $('#telephoneCodeInput');
        let telephoneCode = telephoneCodeInput.val();
        if (telephoneCode !== '+375') {
            telephoneCodeInput.focus();
        }
        return telephoneCode === '+375';
    },

    telephoneIsCorrect : function () {
        let telephoneInput = $('#telephoneInput');
        let telephoneCode = telephoneInput.val();
        if (telephoneCode.length > 20 || telephoneCode.match(/^\d+$/)) {
            telephoneInput.focus();
        }
        return telephoneCode.length <= 20;
    },

    usernameIsCorrect : function () {
        let usernameInput = $('#usernameInput');
        let username = usernameInput.val();
        if (username.match(/^\D+$/)) {
            return true;
        } else {
            usernameInput.focus();
            return false;
        }
    },

    cityIsCorrect : function () {
        let cityInput = $('#cityInput');
        let city = cityInput.val();
        if (city.match(/^\D+$/)) {
            return true;
        } else {
            cityInput.focus();
            return false;
        }
    },

    addressIsCorrect : function () {
        let addressInput = $('#addressInput');
        let address = addressInput.val();
        if (address.match(/^\D+[.]\s\D+\s\d+$/)) {
            return true;
        } else {
            addressInput.focus();
            return false;
        }
    }
};






