$(document).ready(function () {
    $("#slider-form").validate({
        // Specify validation rules
        rules: {
            title: {
                required:true,
            },
           content: {
                required: true,
            },
        },

        // Specify validation error messages
        messages: {
            title: "Please enter a valid title",
            content: {
                required: "Please provide a content",
            },
        },

        // Submit form if validation passes
        submitHandler: function (form) {
            form.submit();
        }
    });
});
