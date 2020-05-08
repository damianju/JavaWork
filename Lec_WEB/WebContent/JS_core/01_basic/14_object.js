// object
console.log('object');

// property: value 쌍
x = {firstName: "John", lastName: "Doe"};

console.log(x, typeof x);

// value 접근하는 방법
console.log(x['firstName'], x.firstName, typeof x.firstName); // John John string
//console.log(x[firstName]) // ReferenceError: firstName is not defined 변수값으로 찾음

// object 는 lenght 값 없다.
console.log(x.length); // undefined

// for ~ in 사용 : 모든 key 뽑아냄
for(key in x){ // property 가 추출됨 (String)
    console.log(`x[${key}]= ${x[key]}`)
}

// value는 어떤한 타입이라도 가능!
x = {
    name: 'kim'
    , age: 34
    , height: 172.3
    , score: [94, 35, 79]
    , sayhello: function(){
        console.log("hello");    
    }
    , getScore: function(n){
        return this.score[n]; // 같은 property 접근할 때 this 빼면 에러 ReferenceError: score is not defined
    }
    , getTotal: function(){
        var total=0;
        for(i=0; i< this.score.length; i++){
            total += this.score[i];
        }
        return total;
    }

    , getAvg: function(){
       
        var avg = this.getTotal()/ this.score.length;
       return avg.toFixed(2);
    }
};

console.log(x['name'], typeof x['name']);
console.log(x['age'], typeof x['age']);
console.log(x.height, typeof x.height);
console.log(x.score, typeof x.score, x.score.length);
x.sayhello();
console.log(x.getScore(0)); 
console.log(x.getTotal()); // score 점수 합계
console.log(x.getAvg());
console.log(x['getAvg']());


console.log();
// p:v 추가/ 삭제 / 변경

x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName='Mike' // 변경
console.log(x);

x['age'] = 45; // 없던 property 추가
console.log(x);

delete x.firstName;
console.log(x);

// 없는 property 접근하면
console.log(x.firstName); // undefined

//--------------------------------------
//console.log(a); // 에러: a가 존재하지 않음
var b
console.log(b); // undefined : 존재하지만 값이...
b= '김재현';
console.log(b); 


// '함수'가 'object 생성자'로 사용 가능.
function Person(firstName, lastName, age){
    // 함수 안에서 this
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;

    //console.log(this);
    
}

Person('aaa', 'bbb', 30); // 호출
var p1= new Person('aaa', 'bbb', 30);// 생성자
console.log(p1);
var p2 = new Person("김", "재현", 25);
console.log(p2);



















console.log("\n프로그램 종료");

