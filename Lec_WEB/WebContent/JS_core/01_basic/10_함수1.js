
// function 함수이름 (매개변수...)

function add (a,b){
    return a+b;
}

var sum = add(1,2);
console.log("sum =", sum);

// JS에서 '함수(function)'도 데이터다!
console.log(typeof add);
console.log(add);

// 따라서, 함수를 변수에 대입할 수도 있고 함수를 매개변수로 넘겨줄 수도 있고 함수를 리턴할 수도 있다.
// ------------------------------------------------------------------------------------------
// JS 는 함수 정의시 아래와 같은 표현식을 더 선호함.
// 이름없는 함수 사용 
var sub = function(a,b){ 
    return a-b;
}

console.log(sub(10, 3));

let mul = function(a,b){return a*b;}
console.log(mul(4,5));

let bbb = mul; // 이제 bbb도 함수, 변수의 대입처럼
console.log(bbb(100,2));

var arr = [add, sub, mul];

console.log(arr[0](10, 20))
console.log(arr[1](10, 20))
console.log(arr[2](10, 20))




