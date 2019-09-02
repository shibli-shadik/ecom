/*<![CDATA[*/
$(document).ready(function() 
{ 
    $("#banks").DataTable();
    
    $("#bankCode").keypress(function() {
	$("#lblStatus").text('');
        $("#msgBankCode").text('');
    });
    
    $("#bankName").keypress(function() {
	$("#lblStatus").text('');
        $("#msgBankName").text('');
    });
    
    /*
    $("#bankCode").focusout(function() 
    {
        if($("#bankCode").val().trim() !== '')
        {
            checkDuplicate($("#id").val().trim(), "CODE" ,$("#bankCode").val().trim());
        }
    });
    
    $("#bankName").focusout(function() 
    {
        if($("#bankName").val().trim() !== '')
        {
            checkDuplicate($("#id").val().trim(), "NAME" ,$("#bankName").val().trim());
        }
    });
    */
});

function validateForm() {
    
    if($("#bankCode").val() === "" || $("#bankCode").val() === null)
    {
        $("#lblStatus").text('Please enter bank code');
        return false;
    }
    else if($("#bankName").val() === "" || $("#bankName").val() === null)
    {
        $("#lblStatus").text('Please enter bank name');
        return false;
    }
    
    /*
    if ($("#msgBankCode").text() === "Code already exists") 
    {
        return false;
    }
    
    if ($("#msgBankName").text() === "Name already exists") 
    {
        return false;
    }
    */
}

function checkDuplicate(id, toCheck, value) 
{
    $.ajax({
        url : "/banks/checkDuplicate",
        type : "POST",
        dataType : "json",
        data : {
            "id" : id,
            "toCheck" : toCheck,
            "value" : value
        },
        success : function(data) {
            $.each(data, function(index, element) 
            {
                if(toCheck === "CODE")
                {
                    $("#msgBankCode").text(element.status);
                }
                else
                {
                    $("#msgBankName").text(element.status);
                }
            });
        },
        error : function() {
        }
    });
}

/*]]>*/