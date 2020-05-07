// 논리연산자
// && and 연산자
// || or 연산자
// ! not 연산자

// 논리연산자를 이용한 조건문 실행
// Short Circuit Evaluation

// 표현식1 && 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식1
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식2

// 표현식1 || 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식2
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식1


console.log(true && true);
console.log(true && false);

let a = 100;
console.log(a > 10 || a + 10 < 10);
console.log(a < 10 || a + 10 < 10);

console.log(a > 10 && a + 10 < 10);
console.log(a < 10 && a + 10 < 10);

console.log("Hello" || "world"); // 결과값: Hello 왼쪽이 결과값
console.log( 0 || "world"); // 결과값: world 왼쪽이 false이므로


console.log(5 && 100) // 100
console.log(5 && 0) // 0 
console.log(null && 'hello'); //null 왼쪽이 거짓으므로 왼쪽
console.log(100- 100&& [10, 20, 30]); //0 왼쪽이 거짓으므로 왼쪽

let n = 15;
(n % 5 === 0)&& console.log('5의 배수 입니다');

n = 7;
(n % 5 === 0)|| console.log('5의 배수 아닙니다');


