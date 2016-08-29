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
	
	
	//Валидация на добавление и обновление работы
	$('#addLotForm, #updateLotForm').validate({
		ignore: ".ignore",
		rules: {
			name: {
				required: true,
				regexp: /^[A-Za-zа-яА-ЯёЁ0-9\.\,\-\ ]+$/,
				rangelength: [1, 100]		    
			},
			description: {
				required: true,
				regexp: /^[^\{\}\<\>\']*$/,
				rangelength: [1, 500]	
			},
			idCategory: {
				aFunction: true,
			},
			idSubcategory: {
				aFunction: true
			},
			Date: {
				required: true,
				date: true
			},
			budget: {
				required: true,
			},
			timeInputName: {
				range: [0,24]
			}
			
		},
		messages: {
			name: {
				required: 'Поле не может быть пустым.',
				regexp: 'Некорректный ввод.',
				rangelength: 'Не более 100 символов.'
			},
			description: {
				required: 'Поле не может быть пустым.',
				regexp: 'Некорректный ввод.',
				rangelength: 'Не более 500 символов.'	
			},
			idCategory: {
				aFunction: 'Пожалуйста, выберите категорию.',
			},
			idSubcategory: {
				aFunction: 'Пожалуйста, выберите подкатегорию.'
			},
			Date: {
				required: 'Пожалуйста, укажите дату.',
				date: 'Пожалуйста, укажите дату в формате ГГГГ-ММ-ДД.'
			},
			budget: {
				required: 'Поле не может быть пустым.',
			},
			timeInputName: {
				range: 'Некорректный ввод'
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
	//Валидация на добавление и обновление работы конец
		
		$('#addUserPhysicalForm,#rejectMessageForm, #addUserLegalForm, #contact-form, #addModeratorForm, #updatePersonalPhysicalForm, #updatePersonalLegalForm').validate({
	    rules: {
	    	login: {
		        required: true,
		        email: true,
		        rangelength: [1, 50]
		    },
		    //phones: {
			//    required: true,
			//  regexp: /^(\+375)?[0-9]{9}$/
			//},
			confirm: {
				required: true
			},
			confirmPassword: {
			    equalTo: "#password",
			    required: true 	  
			},
			password: {
			    regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
			    rangelength: [8, 32],
			    required: true
			},
			nameEnterprise: {
				required: true,
				regexp: /^[^\{\}\<\>\']*$/
			},
			unp: {
				required: true,
				regexp: /^[0-9]{9}$/
			},
			address: {
				required: true,
				regexp: /^[^\{\}\<\>\']*$/,
				rangelength: [1, 150]
			},
			zipCode: {
				required: true,
				regexp: /^[0-9]{6}$/
			},
			j_username: {
				 required: true,
			     email: true
			},
			j_password: {
				required: true,
			},
			oldPassword: {
				required: true,
				regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
				rangelength: [8, 32],
			},
			name: {
				required: true,
				regexp: /^[А-яёЁ\\-]{2,40}$/,
				rangelength: [2, 40]
			},
			surname: {
				required: true,
				regexp: /^[А-яёЁ\\-]{2,40}$/,
				rangelength: [2, 40]
			},
			text: {
				required: true,
				regexp: /^[^\{\}\<\>\']*$/,
				rangelength: [1, 500],
			},
			"phones[0]": {
				require_from_group: [1, ".phone-group"],
				regexp: /^(\+375)?[0-9]{9}$/
	         },
			"phones[1]": {
				require_from_group: [1, ".phone-group"],
				regexp: /^(\+375)?[0-9]{9}$/
			},
			"phones[2]": {
				require_from_group: [1, ".phone-group"],
				regexp: /^(\+375)?[0-9]{9}$/
			}
			
		   
},
messages:  {
	//messages
	login: {
		required: 'Поле не может быть пустым.',
		email: 'Неверный e-mail.',
		rangelength: "Не более 50 символов"
		},
	"phones[0]": {
		require_from_group: "Пожалуйста, укажите телефон в одном из полей",
        regexp: "Введите номер в формате +375XXXXXXXXX"
	},
	"phones[1]": {
		require_from_group: "Пожалуйста, укажите телефон в одном из полей",
		regexp: "Введите номер в формате +375XXXXXXXXX"
	},
	"phones[2]": {
		require_from_group: "Пожалуйста, укажите телефон в одном из полей",
		regexp: "Введите номер в формате +375XXXXXXXXX"
	},
	confirm: {
		required: 'Для регистрации необходимо согласиться с правилами пользования сайтом.'
		},
	confirmPassword: {
		     equalTo: "Пароли не совпадают.",
		     required: 'Поле не может быть пустым.',	  
	    },
	 password: {
			rangelength: 'Пароль должен содержать от 8 до 32 символов.',
		    regexp: 'Пароль должен содержать прописные и строчные символы латинского алфавита.',
		    required: 'Поле не может быть пустым.'
	 },
	 nameEnterprise: {
			required: 'Поле не может быть пустым.',
			regexp: 'Проверьте корректность ввода.'
		},
	unp: {
			required: 'Поле не может быть пустым.',
			regexp: 'Некорректный УНП.'
	   },
	   address: {
			required: 'Поле не может быть пустым.',
			regexp: 'Проверьте корректность ввода.',
			rangelength: 'Не более 150 символов.'
		},
		zipCode: {
			required: 'Поле не может быть пустым.',
			regexp: 'Некорректный ввод.'
		},
		j_username: {
			 required: 'Поле не может быть пустым.',
		     email: 'Некорректный e-mail.'
		},
		j_password: {
			required: 'Поле не может быть пустым.'
		},
		oldPassword: {
			required: 'Поле не может быть пустым.',
			regexp: 'Пароль должен содержать прописные и строчные символы латинского алфавита.',
			rangelength: 'Пароль должен содержать от 8 до 32 символов.'
		},
		name: {
			required: 'Поле не может быть пустым.',
			regexp: 'Некорректный ввод.',
			rangelength: 'Не более 40 символов'
		},
		surname: {
			required: 'Поле не может быть пустым.',
			regexp: 'Некорректный ввод.',
			rangelength: 'Не более 40 символов'
		},
		text: {
			required: 'Поле не может быть пустым.',
			regexp: 'Некорректный ввод.',
			rangelength: 'Не более 500 символов.',
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
		
		//Валидация телефона	
		/*$("#phone1").rules("add", 
				{
				required:true,
				regexp: /^(\+375)?[0-9]{9}$/
				});
			$("#phone2").rules("add", 
					{
					regexp: /^(\+375)?[0-9]{9}$/
					});
			$("#phone3").rules("add", 
					{
					regexp: /^(\+375)?[0-9]{9}$/
					});	       */
		/*$.validator.messages.regexp = 'Введите номер в формате +375XXXXXXXXX';
		$.validator.messages.required = 'Поле не может быть пустым'; 
		$.validator.addClassRules({
		        phone1:{
		            required: true,
		            regexp: /^(\+375)?[0-9]{9}$/
		        },
		        phone2:{
			        regexp: /^(\+375)?[0-9]{9}$/
		        },
		        phone3:{
			        regexp: /^(\+375)?[0-9]{9}$/
		        }		        
		    });
		//Конец валидации телефона*/
}); // end document.ready