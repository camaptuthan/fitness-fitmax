
// validate for register form----------------------------
$(document).ready(function () {
    $("#registration-form").validate({
        // Specify validation rules
        rules: {
            firstname: "required",
            lastname: "required",
            email: {
                email: true
            },
            password: {
                required: true,
                minlength: 6
            },
        },

        // Specify validation error messages
        messages: {
            firstname: "Please enter  first name",
            lastname: "Please enter  last name",
            email: "Please enter a valid email ",
            password: {
                required: "Please provide a password",
                minlength: "Password must be at least 6 characters"
            },
        },

        // Submit form if validation passes
        submitHandler: function (form) {
            form.submit();
        }
    });
});

//validate for login form------------------

