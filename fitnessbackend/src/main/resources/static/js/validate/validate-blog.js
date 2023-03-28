
// validate for register form----------------------------
$(document).ready(function () {
    $("#blog_writer_form").validate({
        // Specify validation rules
        rules: {
            blog_title: "required",
        },

        // Specify validation error messages
        messages: {
            blog_title: "Please enter title",
        },

        // Submit form if validation passes
        submitHandler: function (form) {
            form.submit();
        }
    });
});

//validate for login form------------------

