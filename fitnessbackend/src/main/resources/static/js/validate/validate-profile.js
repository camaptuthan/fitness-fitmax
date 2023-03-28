
// validate for profile form----------------------------
$(document).ready(function () {
    $("#profile-form").validate({
        // Specify validation rules
        rules: {
            firstname: "required",
            lastname: "required",
            address: "required",
            phone: "required",
        },

        // Specify validation error messages
        messages: {
            firstname: "Please enter first name",
            lastname: "Please enter last name",
            address:
                 "Please provide address",

            phone:
                "Please provide phone",

        },

        // Submit form if validation passes
        submitHandler: function (form) {
            form.submit();
        }
    });
});

//validate for login form------------------

