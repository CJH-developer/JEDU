
var sum = document.querySelectorAll(".pb__tbody__four");
var allSum = 0;

for(var i=0; i<sum.length; i++){
	
	var price = parseFloat(sum[i].getAttribute("data-value"));
	if (!isNaN(price)) {
        allSum += price;
    }
}

document.getElementById("total__all__price").value = allSum + " 원";


var count = document.querySelectorAll(".pb__tbody__three");
var allCount = 0;

for(var i=0; i<count.length; i++){
	
	var value = parseFloat(count[i].getAttribute("data-value"));
	
	if(!isNaN(value)){
		allCount += value;
	}
	
}

document.getElementById("total__all__count").value = allCount + " 건";