/**
 * Created by Philip Fursov on 29.03.2015.
 * version 1.0
 */

$(document).ready(function(){

	// Validate
	// http://bassistance.de/jquery-plugins/jquery-plugin-validation/
	// http://docs.jquery.com/Plugins/Validation/
	// http://docs.jquery.com/Plugins/Validation/validate#toptions
	$.validator.addMethod(
	        "regexp",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Please check your input."
	);
	$.validator.addMethod('filesize', function(value, element, param) {
	    // param = size (en bytes) 
	    // element = element to validate (<input>)
	    // value = value of the element (file name)
	    return this.optional(element) || (element.files[0].size <= param) 
	});
	$.validator.addMethod("aFunction",
		    function(value, element) {
		        if (value == "0")
		            return false;
		        else
		            return true;
		    },
		    "Please select a value");
		$('#addUserPhysicalForm').validate({
			
	    rules: {
	    	login: {
		        required: true,
		        email: true
		    },
		    phones: {
			    required: true,
			    regexp: /^(\+375)?[0-9]{9}$/
			},
			confirm: {
				required: true
			},
			confirmPassword: {
			    equalTo: "#password",
			    required: true 	  
			},
			password: {
				rangelength: [8, 32],
			    regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
			    required: true
			}
		   
},
messages:  {
	//messages
	login: {
		required: 'Поле не можеты быть пустым',
		email: 'Неверный e-mail'
		},
	phones: {
		regexp: 'Некорретный номер телефона',
		required: 'Поле не можеты быть пустым',
		},
	confirm: {
		required: 'Для регистрации необходимо согласиться с правилами пользования сайтом'
		},
	confirmPassword: {
		     equalTo: "Пароли не совпадают",
		     required: 'Поле не можеты быть пустым',	  
	    },
	 password: {
			rangelength: 'Пароль должен содержать от 8 до 32 символов.',
		    regexp: 'Пароль должен содержать прописные и строчные символы латинского алфавита.',
		    required: 'Поле не можеты быть пустым'
	 }
	 },	

			highlight: function(element) {
				$(element).closest('.control-group').removeClass('success').addClass('error');
			},
			success: function(element) {
				element
				.text('Успешно').addClass('valid')
				.closest('.control-group').removeClass('error').addClass('success');
			}
	  });
		

}); // end document.ready
