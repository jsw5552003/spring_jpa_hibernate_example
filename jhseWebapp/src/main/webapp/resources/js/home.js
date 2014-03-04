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



/**
 * function returns "true" if default option is selected for comboboxes.
 * 
 * @param dropDownId
 * @returns {Boolean}
 */
function checkDefaultSelected(dropDownId){
if ($(dropDownId).find('option:selected[value = 0]').length>0)
	  {return true;}
else {return false;}
}

function setDefaultList(comboBoxType)
{
	$.ajaxSetup({ cache: false });
	var callName = "json/getAll" + comboBoxType + ".do";
	var comboBox = "comboBox" + comboBoxType;
	//make AJAX call
	$.getJSON(callName, function(obj) {
        var jsonData = obj;
        populateDropDown(jsonData, comboBox);                     
        });
}

/**
 * Function which takes care of the searchable dropdown/ autocomplete combobox
 * 
 */
(function( $ ) {
    $.widget( "custom.combobox", {
      _create: function() {
    	  var a,input;
        this.wrapper = $( "<span>" )
          .addClass( "custom-combobox" )
          .insertAfter( this.element );
 
        this.element.hide();
        this._createAutocomplete();
        this._createShowAllButton();
        //this.input.attr( 'id', $('.select').attr( 'id' )+'-input' );
      },
 
      _createAutocomplete: function() {
        var selected = this.element.children( ":selected" ),
          value = selected.val() ? selected.text() : "Select or Type a Value...";
 
          input= this.input = $( "<input>" )
          .appendTo( this.wrapper )
          .val( value )
          .attr( "title", "" )
          .addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
          .autocomplete({
            delay: 0,
            minLength: 0,
            source: $.proxy( this, "_source" )
          })
          .tooltip({
            tooltipClass: "ui-state-highlight"
          });
 
        this._on( this.input, {
          autocompleteselect: function( event, ui ) {
            ui.item.option.selected = true;
            this._trigger( "select", event, {
              item: ui.item.option
            });
          },
 
          autocompletechange: "_removeIfInvalid"
        });
      },
 
      _createShowAllButton: function() {
        var input = this.input,
          wasOpen = false;
 
        a = this.a = $( "<a>" )
          .attr( "tabIndex", -1 )
          .attr( "title", "Show All Items" )
          .tooltip()
          .appendTo( this.wrapper )
          .button({
            icons: {
              primary: "ui-icon-triangle-1-s"
            },
            text: false
          })
          .removeClass( "ui-corner-all" )
          .addClass( "custom-combobox-toggle ui-corner-right" )
          .mousedown(function() {
            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
          })
          .click(function() {
            input.focus();
 
            // Close if already visible
            if ( wasOpen ) {
              return;
            }
 
            // Pass empty string as value to search for, displaying all results
            input.autocomplete( "search", "" );
          });
        input.click(function() { 
          	$(this).find('input').select(); $(this).select(); 
          	});
      },
 
      _source: function( request, response ) {
        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
        response( this.element.children( "option" ).map(function() {
          var text = $( this ).text();
          if ( this.value && ( !request.term || matcher.test(text) ) )
            return {
              label: text,
              value: text,
              option: this
            };
        }) );
      },
 
      _removeIfInvalid: function( event, ui ) {
 
        // Selected an item, nothing to do
        if ( ui.item ) {
          return;
        }
 
        // Search for a match (case-insensitive)
        var what = this;
        var value = this.input.val(),
          valueLowerCase = value.toLowerCase(),
          valid = false;
        this.element.children( "option" ).each(function() {
          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
            this.selected = valid = true;
            return false;
          }
        });
 
        // Found a match, nothing to do
        if ( valid ) {
          return;
        }
        alert("start");
        // Remove invalid value
        this.input
          .val( "" )
          .attr( "title", value + " didn't match any item" )
          .tooltip( "open" );
        this.element.val( "" );
        this._delay(function() {
          this.input.tooltip( "close" ).attr( "title", "" );
        }, 2500 );
        this.input.data( "ui-autocomplete" ).term = "";
        //this.input.val("Select or Type a Value...");
        var resetValue = "Select or Type a Value...";
        alert("what");
        this.element.children( "option" ).each(function() {
            if ( $( this ).text() === resetValue ) {
              this.selected = valid = true;
              return false;
            }
          });this.element[0].id
        alert(valid);
        selectExistingBU();
      },
 
      _destroy: function() {
        this.wrapper.remove();
        this.element.show();
      },
      disable: function() {
    	    this.input.prop('disabled',true);
    	    this.input.autocomplete("disable");
    	    this.a.button("disable");
    	},
    	enable: function() {
    	    this.input.prop('disabled',false);
    	    this.input.autocomplete("enable");
    	    this.a.button("enable");
    	}
    });
  })(jQuery);

$(function() {
	//Event for selecting a league
	$("#comboBoxLeagues").combobox({select : function(event, ui){
		var jsonparam =  "prodId="+ $("#comboBoxLeagues").val();
		if(checkDefaultSelected("#comboBoxLeagues")==true){
			alert("Just the default");
		}
		else
		{
			alert("Real Selection");
		}
	}
	}); 
	
	//Event for selecting a city
	$("#comboBoxCities").combobox({select : function(event, ui){
		var jsonparam =  "prodId="+ $("#comboBoxCities").val(); 
		if(checkDefaultSelected("#comboBoxCities")==true){
			alert("Just the default");
		}
		else
		{
			alert("Real Selection");
		}
		}
	});
	
	//Event for selecting a team
	$("#comboBoxTeams").combobox({select : function(event, ui){
		var jsonparam =  "prodId="+ $("#comboBoxTeams").val(); 
		if(checkDefaultSelected("#comboBoxTeams")==true){
			alert("Just the default");
		}
		else
		{
			alert("Real Selection");
		}
		}
	}); 
	
	//Event for selecting a player
	$("#comboBoxPlayers").combobox({select : function(event, ui){
		var jsonparam =  "prodId="+ $("#comboBoxPlayers").val(); 
		if(checkDefaultSelected("#comboBoxPlayers")==true){
			alert("Just the default");
		}
		else
		{
			alert("Real Selection");
		}
		}
	}); 
});