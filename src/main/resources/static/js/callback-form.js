$(document).ready(function () {

    //ajax-отправка данных

    jQuery("#callback-form").submit(function () {

        var formID = jQuery(this).attr('id');

        var formNm = jQuery('#' + formID);

        jQuery.ajax({

            type: "POST",

            url: 'send-mail.php',

            data: formNm.serialize(),

            success: function (data) {

                jQuery(formNm).html(data);

            },

            error: function (jqXHR, text, error) {

                jQuery(formNm).html(error);

            }

        });

        return false;

    });

});
