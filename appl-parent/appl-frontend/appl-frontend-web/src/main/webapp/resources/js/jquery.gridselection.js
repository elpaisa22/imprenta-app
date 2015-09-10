function gridBehavior() {
	jQuery('#form-main\\:dataTable').find('tbody').find('tr').mousedown(function(){ return false; });
	jQuery('#form-main\\:dataTable').find('tbody').find('tr').bind('dblclick', function(event){
			    dobleClick();
			});
	jQuery('#form-main\\:dataTable').find('tbody').find('tr').bind('click', function(event){
			if (jQuery(this).hasClass("ui-selected")) {
				jQuery(this).removeClass("ui-selected");
			}
	});
	//El texto dentro de la grilla no podra seleccionarse
	jQuery('#form-main\\:dataTable').bind('selectstart', function(event){return false;});
}

jQuery(document).ready(function(){gridBehavior();});