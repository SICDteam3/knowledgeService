<div class="row gallery-row">
        <div class="form-group">
         <label for="inputEmail3" class="col-sm-2 control-label">选择ipc号：</label>
          <div class="col-sm-2">
                <select id="first-menu" class="form-control" onchange="selectSecondChild();"></select>
          </div>
          <div class="col-sm-2">
                <select id="second-menu" class="form-control" onchange="selectThirdChild();"></select>	
          </div>
          
          <div class="col-sm-2">
                <select id="third-menu" class="form-control" onchange="submitIPC();"></select>
          </div>
          
          <!-- <div class="col-sm-2">
                <select id="third-menu" class="form-control" onchange="selectForthChild();"></select>
          </div> -->
          
          <!-- <div class="col-sm-2">
                <select id="forth-menu" class="form-control" onchange="submitIPC();"></select>
          </div> -->
                    
		</div>
		
</div>

<script>
$(document).ready(
   function(){
         $.ajax({
             type: "GET",
             url: "${path}/getFirstLevel.html",            
             dataType: "json",
             success: function(data){              	
             			 for(var i in data){ 
             			 	 document.getElementById("first-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });
    })
</script>
<script>
	function selectSecondChild(){
		var element = document.getElementById("first-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
             			 document.getElementById("second-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("second-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });         
	}
	
	function selectThirdChild(){
		var element = document.getElementById("second-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
            			 document.getElementById("third-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("third-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_NUMBER));					        
					      }                                                                      
                      }
         });         
	}
	
	function selectForthChild(){
		var element = document.getElementById("third-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
             		document.getElementById("forth-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("forth-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_NUMBER));					        
					      }                                                                      
                      }
         });         
	}		
</script>
<script>
	function submitIPC(){
		var element = document.getElementById("third-menu");
		var classId = element.options[element.selectedIndex].value;
		location.href="${path}/patent/holderVisiual.html?IPC="+classId;		
	}
</script>