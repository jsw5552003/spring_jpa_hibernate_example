/**
 * Populates all the dropdowns on the home page
 * 
 * @param obj
 * @param dropDownId
 */
function populateDropDown(obj, dropDownId){	
	  $("#"+dropDownId).append("<option value='0' selected='selected'>" + "Select or Type a Value..." + "</option>"); 
	  $.each(obj,function(key,value)
	            {
	               $("#"+dropDownId).append("<option value=" +value.id +">" + value.name + "</option>"); 
	            });
	    }