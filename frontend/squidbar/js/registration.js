let telephone;

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


    addFood : function (basketId, name, type, cost, weight, size, description, ingredients, picturePath) {
        size.toUpperCase();
        let request = {
            "basketId": basketId,
            "food": {
            "name": name,
                "type": type,
                "cost": cost,
                "weight": weight,
                "size": size,
                "description": description,
                "ingredients": ingredients,
                "picture": picturePath
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
            contentType:'application/x-www-form-urlencoded; charset=utf-8'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    },

    //types: pizza, sushi, rolls
    getFoodByTypeAndPage : function (type, pageNumber, foodCount) {
        let request = {
            'pageNumber': pageNumber,
            'foodCount': foodCount
        }

        let response = $.ajax({
            url:'http://localhost:8080/category/' + type,
            type: 'GET',
            data: jQuery.param(request),
            contentType: 'application/x-www-form-urlencoded; charset=utf-8'
        }).done(function (data) {
            // it can be replaced on another logic
            console.log(data);
        });
    }
};

let signUp = {

    submitForms : function () {
        let formIsCorrect = this.telephoneCodeIsCorrect() === true
            && this.telephoneIsCorrect() === true
            && this.usernameIsCorrect() === true
            && this.cityIsCorrect() === true
            && this.addressIsCorrect() === true;
        if (formIsCorrect === true) {
            telephone = $('#telephoneCodeInput').val() + $('#telephoneInput').val;
            window.location.replace('http://localhost:63342/SushiPizzaBar/frontend/squidbar/registration2.html');
        } else {
            console.log("pipa")
        }

    },

    telephoneCodeIsCorrect : function () {
        let telephoneCodeInput = $('#telephoneCodeInput');
        let telephoneCode = telephoneCodeInput.val();
        if (telephoneCode !== '+375') {

        }
        return telephoneCode === '+375';
    },

    telephoneIsCorrect : function () {
        let regex = new RegExp(/^d+$/);
        let telephoneInput = $('#telephoneInput');
        let telephoneCode = telephoneInput.val();
        if (telephoneCode.length > 20 || regex.test(telephoneCode)) {
            telephoneInput.css('border', '3px solid red');
        }
        return telephoneCode.length <= 20;
    },

    usernameIsCorrect : function () {
        let regex = new RegExp(/^\D+$/);
        let usernameInput = $('#usernameInput');
        let username = usernameInput.val();
        if (regex.test(username)) {
            return true;
        } else {
            return false;
        }
    },

    cityIsCorrect : function () {
        let regex = new RegExp(/^\D+$/);
        let cityInput = $('#cityInput');
        let city = cityInput.val();
        if (regex.test(city)) {
            return true;
        } else {
            return false;
        }
    },

    addressIsCorrect : function () {
        let regex = new RegExp(/^\D+[.]\s\D+\s\d+$/);
        let addressInput = $('#addressInput');
        let address = addressInput.val();
        if (regex.test(address)) {
            return true;
        } else {
            return false;
        }
    }
};

/*$("telephone").ready(function () {
    this.text(telephone);
})*/




