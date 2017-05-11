function gridBehavior() {
	jQuery('#dataTable').find('tbody').find('tr').mousedown(function(){ return false; });
	jQuery('#dataTable').find('tbody').find('tr').bind('dblclick', function(event){
			    dobleClick();
			});
	jQuery('#dataTable').find('tbody').find('tr').bind('click', function(event){
			if (jQuery(this).hasClass("ui-selected")) {
				jQuery(this).removeClass("ui-selected");
			}
	});
	//El texto dentro de la grilla no podra seleccionarse
	jQuery('#dataTable').bind('selectstart', function(event){return false;});
}

jQuery(document).ready(function(){gridBehavior();});