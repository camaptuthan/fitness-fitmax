
    $(document).ready(function () {
    $("#login-form").validate({
        // Specify validation rules
        rules: {
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
            email: "Please enter a valid email",
            password: {
                required: "Please provide a password",
                minlength: "Password must be at least 6 characters "
            },
        },

        // Submit form if validation passes
        submitHandler: function (form) {
            form.submit();
        }
    });
});
