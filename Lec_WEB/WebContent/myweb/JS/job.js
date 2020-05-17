var dobType=""; // 1:해외취업,2:해외연수,4:해외봉사
var dsptcKsco=""; // 01:전산,컴퓨터,02:전기/전자,06:기계/금속,07:건설/토목,08:사무/서비스,09:의료,10:기타
var continent=""; // 2: 북미, 3: 남미
var epmt61="";
var pageIndex="";
var showItemListCount=10;


$(document).ready(function(){
    
    $("#btn_load").click(function(){
    
        dobType = document.getElementById("dobType").value.trim();
        continent = document.getElementById("continent").value.trim();
        pageIndex = document.getElementById("pageIndex").value.trim();
        var url = "http://www.worldjob.or.kr/openapi/openapi.do?dobType="+dobType+"&dsptcKsc="+dsptcKsco+"&continent="+continent+"&epmt61=&pageIndex="+pageIndex+"&showItemListCount="+showItemListCount;
        
        $.ajax({
            url:url
            , type: "GET"
            , cache: false
            , success: function(data, status) {
                if(status == "success") {
                    parseXML(data);
                } 
            }
        });

    });
});


function parseXML(xmlDOM){
    var table= "<tr><th>제목</th><th>국가</th><th>경력</th><th>마감기한</th></tr>;"
    $(xmlDOM).find("ITEM").each(function(){
		table += "<tr>";
		table += "<td>" + $(this).find("rctntcSj").text().substring(0,25)+"..."+"</td>";
		table += "<td>" + $(this).find("dsptcNationScd").text() + "</td>";	
		table += "<td>" + $(this).find("joDemandCareerStleScd").text() + "</td>";	
		table += "<td>" + $(this).find("rctntcEndDay").text().substring(0,10) + "</td>";		
		table += "</tr>";
	});
	$("#demoXML").html(table);
}
