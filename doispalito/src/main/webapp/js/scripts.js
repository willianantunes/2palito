$(document).ready(function(){
	
	// --------------------- Efeitos nas categorias notificação e pedidos

	$("li.categoria-notificacao > a").click(function(){
		if($("li.categoria-notificacao div.menu-principal-dropdown").css("display") == "none")
		{
			$("li.categoria-notificacao > a").css({
				"background": "#FFFFFF",
				"color": "#003399"
			});
			$("li.categoria-pedidos > a").css({
				"background": "linear-gradient(#bec1bd, #D1D1CF 65%, #DBDBDB)",		
				"color": "#000000"
			});			
		}
		else
		{
			$("li.categoria-notificacao > a").css({
				"background": "linear-gradient(#bec1bd, #D1D1CF 65%, #DBDBDB)",		
				"color": "#000000"
			});
		}	
		$("li.categoria-notificacao div.menu-principal-dropdown").slideToggle("slow");
		$("li.categoria-pedidos div.menu-principal-dropdown").slideUp();
	});
	
	$("li.categoria-pedidos > a").click(function(){
		if($("li.categoria-pedidos div.menu-principal-dropdown").css("display") == "none")
		{
			$("li.categoria-pedidos > a").css({
				"background": "#FFFFFF",
				"color": "#003399"
			});	
			$("li.categoria-notificacao > a").css({
				"background": "linear-gradient(#bec1bd, #D1D1CF 65%, #DBDBDB)",		
				"color": "#000000"
			});				
		}
		else
		{
			$("li.categoria-pedidos > a").css({
				"background": "linear-gradient(#bec1bd, #D1D1CF 65%, #DBDBDB)",		
				"color": "#000000"
			});	
		}	
		$("li.categoria-pedidos div.menu-principal-dropdown").slideToggle("slow");
		$("li.categoria-notificacao div.menu-principal-dropdown").slideUp();
	});
	
	// --------------------- Functions
	
	// http://joquery.com/2012/string-format-for-javascript
	String.format = function()
	{
	    // The string containing the format items (e.g. "{0}")
	    // will and always has to be the first argument.
	    var theString = arguments[0];
	    
	    // start with the second argument (i = 1)
	    for (var i = 1; i < arguments.length; i++) {
	        // "gm" = RegEx options for Global search (more than one instance)
	        // and for Multiline search
	        var regEx = new RegExp("\\{" + (i - 1) + "\\}", "gm");
	        theString = theString.replace(regEx, arguments[i]);
	    }
	    
	    return theString;
	};
	
	// --------------------- Diálogo de confirmação
	
	$("#___dialogConfirmation").dialog({
		autoOpen: false,
		modal: true
	});
	
	$(".___confirmLink").click(function(e) {
	    e.preventDefault();
	    var targetUrl = $(this).attr("href");

	    $("#___dialogConfirmation").dialog({
	      buttons : {
	        "Sim" : function() {
	          window.location.href = targetUrl;
	        },
	        "Não" : function() {
	          $(this).dialog("close");
	        }
	      }
	    });

	    $("#___dialogConfirmation").dialog("open");
	});
	
	// --------------------- AJAX
	
	$("#___refreshPortal").click(function(e){
		e.preventDefault();
		
		// Seria melhor utilizar algum XML ou algum campo que fique no rodapé da página, cookie, entre outros.
		var url = $(this).data("url");
		
		// Esse método chama, caso seja completado, a atualização da categoria de pedidos.
		// Refator/desacoplar para trabalhar melhor.
		window._notificationsRefresh(url);
	});
	
});

//CustomerOrder details pop-up

// http://stackoverflow.com/questions/5660700/javascript-to-open-popup-window-and-disable-parent-window
function focusPopup() 
{
	if(_popupWindow && !_popupWindow.closed)
	{
		_popupWindow.focus();
	} 
} 

function openCustomerOrderDetails(url)
{
	_popupWindow = window.open
		(
			url,
			'window',
			'width=800, height=400, location=yes, menubar=yes, scrollbars=yes, resizable=yes'
		); 
	_popupWindow.focus();
}

// --------------------- Validações

jQuery(document).ready(function(){
	// https://github.com/posabsolute/jQuery-Validation-Engine
	jQuery("#___frmProcurar").validationEngine();
	jQuery("#___frmLogin").validationEngine();
	jQuery("#___frmUsuario").validationEngine();
	jQuery("#___frmFornecedor").validationEngine();
	jQuery("#___frmProdutos").validationEngine();
});

// --------------------- AJAX

// Global variable
var _popupWindow = null;
var _ajaxRequestObject = function(type, url, data, dataType, evBeforeSend, evSucess, evComplete, evError)
{
	$.ajax
	({
		type: type,
		url: url,
		data: data,
		dataType: dataType,
		beforeSend: evBeforeSend,
		success: evSucess,
		complete: evComplete,
		error: evError
	});
};

// Notifications and requests

var _notificationsRefresh = function(url)
{
	window._ajaxRequestObject
	(
		'get',
		url + "IN_ANALYSIS/AWAITING_PAYMENT",
		"",
		"json",
		function(xhr, settings)
		{
			$("#___dialogRefresh").fadeIn("slow");
		},
		function(data, textStatus, xhr)
		{
			var html = "<ul>";
			if(data.list.length == 0)
			{
				html += String.format('<li><p class="{0}">Nenhuma notificação no sistema.</p></li>', "menu-one-item");
				$(".circleNotification").fadeOut("slow");
			}
			else
			{
				$.each(data.list, function(){
					html += String.format('<li><p><strong>Cliente:</strong> {0}</p>', this.user.name);
					// Arrumar link detalhes do pedido
					// html += String.format('<p>Detalhes do pedido: <a href="{0}">{1}</a></p>', this.id, this.idOrder);
					html += String.format('<p>Detalhes do pedido: <a href="#" onclick="{0}">{1}</a></p>', "openCustomerOrderDetails('" + (url.replace("/json","") + this.id) + "'); return false;", this.idOrder);
					if(this.customerOrderStatus == "AWAITING_PAYMENT")
					{
						html += String.format('<p><a href="{0}" class="{1}" title="{2}">Pagamento realizado!</a></p>', (url + this.id + "/changeTo/IN_PRODUCTION"), "___notificacoesPagamentoRealizado", "O cliente será notificado de que será produzido os itens do pedido.");
					}
					else
					{
						html += String.format('<p><a href="{0}" class="{1}">Aceitar pedido</a> e esperar o pagamento</p>', (url + this.id + "/changeTo/AWAITING_PAYMENT"), "___notificacoesEsperarPagamento");
					}
					html += String.format('<p><a href="{0}" class="{1}">Cancelar</a> pedido</p></li>', (url + this.id + "/changeTo/CANCELLED"), "___notificacoesCancelarPedido");
				});
				$(".circleNotification").html(String.format('<p>{0}</p>', data.list.length));
				$(".circleNotification").fadeIn("slow");					
			}
		
			html += "</ul>";
			
			$("#___notificacoes").html(html);
		},
		function(xhr, textStatus, errorThrown)
		{
			$("#___dialogRefresh").fadeOut();
			window._requestsRefresh(url);
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível atualizar!");
		}						
	); // Fim Ajax das notificações.	
};

var _requestsRefresh = function(url)
{
	window._ajaxRequestObject
	(
		'get',
		url + "IN_PRODUCTION",
		"",
		"json",
		function(xhr, settings)
		{
			$("#___dialogRefresh").fadeIn("slow");
		},
		function(data, textStatus, xhr)
		{
			var html = "<ul>";
			if(data.list.length == 0)
			{
				html += String.format('<li><p class="{0}">Nenhuma pedido no sistema.</p></li>', "menu-one-item");
				$(".circleRequests").fadeOut("slow");
			}
			else
			{
				$.each(data.list, function(){
					html += String.format('<li><p><strong>Cliente:</strong> {0}</p>', this.user.name);
					// Arrumar link detalhes do pedido
					html += String.format('<p>Pedido <a href="#" onclick="{0}">{1}</a> - <a href="{2}" class="{3}" title="{4}">Finalizar</a></p></li>', "openCustomerOrderDetails('" + (url.replace("/json","") + this.id) + "'); return false;", this.idOrder, (url + this.id + "/changeTo/DONE"), "___pedidosPedidoFeito", "O cliente será notificado de que o pedito foi feito.");
				});
				$(".circleRequests").html(String.format('<p>{0}</p>', data.list.length));
				$(".circleRequests").fadeIn("slow");					
			}
		
			html += "</ul>";
			
			$("#___pedidos").html(html);
		},
		function(xhr, textStatus, errorThrown)
		{
			$("#___dialogRefresh").fadeOut();
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível atualizar!");
		}						
	); // Fim Ajax dos pedidos.	
};

// http://stackoverflow.com/questions/9272438/jquery-click-event-not-firing-on-ajax-loaded-html-elements
$(document).on("click", ".___notificacoesEsperarPagamento", function(e){
    e.preventDefault();
    var targetUrl = $(this).attr("href");
    
	window._ajaxRequestObject
	(
		'get',
		targetUrl,
		"",
		"json",
		"",
		"",
		function(xhr, textStatus, errorThrown){
			$("#___refreshPortal").click();
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível aceitar o pedido e esperar o pagamento!");
		}
	);
});

$(document).on("click", ".___notificacoesPagamentoRealizado", function(e){
    e.preventDefault();
    var targetUrl = $(this).attr("href");

	window._ajaxRequestObject
	(
		'get',
		targetUrl,
		"",
		"json",
		"",
		"",
		function(xhr, textStatus, errorThrown){
			$("#___refreshPortal").click();
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível notificar que o pagamento foi realizado!");
		}
	);
});

$(document).on("click", ".___notificacoesCancelarPedido", function(e){
    e.preventDefault();
    var targetUrl = $(this).attr("href");
    
	window._ajaxRequestObject
	(
		'get',
		targetUrl,
		"",
		"json",
		"",
		"",
		function(xhr, textStatus, errorThrown){
			$("#___refreshPortal").click();
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível notificar que o pagamento foi realizado!");
		}
	);
});

$(document).on("click", ".___pedidosPedidoFeito", function(e){
    e.preventDefault();
    var targetUrl = $(this).attr("href");
    
	window._ajaxRequestObject
	(
		'get',
		targetUrl,
		"",
		"json",
		"",
		"",
		function(xhr, textStatus, errorThrown){
			$("#___refreshPortal").click();
		},
		function(xhr, textStatus, errorThrown)
		{
			alert("Não foi possível finalizar o pedido!");
		}
	);
});

//////////////////////////////////////
// TESTE
//////////////////////////////////////

$(function() 
		{
		    var availableTags = 
			[
		      "ActionScript",
		      "AppleScript",
		      "Asp",
		      "BASIC",
		      "C",
		      "C++",
		      "Clojure",
		      "COBOL",
		      "ColdFusion",
		      "Erlang",
		      "Fortran",
		      "Groovy",
		      "Haskell",
		      "Java",
		      "JavaScript",
		      "Lisp",
		      "Perl",
		      "PHP",
		      "Python",
		      "Ruby",
		      "Scala",
		      "Scheme"
		    ];
		    function split(val) 
			{
		      return val.split(/,\s*/);
		    }
		    function extractLast(term) 
			{
		      return split(term).pop();
		    }
		 
		    $( "#productTypes" )
		      // Don't navigate away from the field on tab when selecting an item
		      .bind
			  (
				"keydown", function(event) 
				{
					if (event.keyCode === $.ui.keyCode.TAB && $(this).data("ui-autocomplete").menu.active ) 
					{
						event.preventDefault();
					}
				}
			  )
		      .autocomplete
			  ({
		        minLength: 0,
		        source: function(request, response) 
				{
					// delegate back to autocomplete, but extract the last term
					response($.ui.autocomplete.filter(availableTags, extractLast(request.term)));
		        },
		        focus: function() 
				{
					// prevent value inserted on focus
					return false;
		        },
		        select: function(event, ui) 
				{
					var terms = split(this.value);
					// remove the current input
					terms.pop();
					// add the selected item
					terms.push(ui.item.value);
					// add placeholder to get the comma-and-space at the end
					terms.push("");
					this.value = terms.join(", ");
					return false;
		        }
		      });
		  });

	