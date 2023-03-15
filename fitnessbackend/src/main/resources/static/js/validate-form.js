function inputValidation(inputTxt) {
    var textField = document.getElementById("textFieldName");
    if (inputTxt.value != '') {
        textField.textContent = 'Good input';
        textField.style.color = 'Green';
    } else {
        textField.textContent = 'Field not empty';
        textField.style.color = 'Red';
    }
}

function inputValidationDes(inputTxt) {
    var textFieldDes = document.getElementById("textFieldDes");
    if (inputTxt.value != '') {
        textFieldDes.textContent = 'Good input';
        textFieldDes.style.color = 'Green';
    } else {
        textFieldDes.textContent = 'Field not empty';
        textFieldDes.style.color = 'Red';
    }
}

function inputValidationPrice(inputTxt) {
    var textFieldPrice = document.getElementById("textFieldPrice");
    if (inputTxt.value != '') {
        textFieldPrice.textContent = 'Good input';
        textFieldPrice.style.color = 'Green';
    } else {
        textFieldPrice.textContent = 'Field not empty';
        textFieldPrice.style.color = 'Red';
    }
}

function inputValidationDuration(inputTxt) {
    var textFieldDuration = document.getElementById("textFieldDuration");
    if (inputTxt.value != '') {
        textFieldDuration.textContent = 'Good input';
        textFieldDuration.style.color = 'Green';
    } else {

        textFieldDuration.textContent = 'Field not empty';
        textFieldDuration.style.color = 'Red';
    }
}


