// 변수의 유효범위
// scope

// const, let 의 유효범위
//  ==> Block Scope
//    { ... }


// 블럭
{
    const name = 'Mark' // 블럭 안에서만 사용가능
    console.log(`name = ${name}`);

}
// 블럭 밖에서 사용하면 에러!
// console.log(`name = ${name}`); //name is not defined

{   
    //console.log('name = ', name); //Cannot access 'name' before initialization
    const name = 'Mark'
}

{   
    console.log(`value1 = ${value1}`); //value1 = undefined 에러는 아니다
    var value1 = 200;
   // console.log(`value2 = ${value2}`); //ReferenceError: value2 is not defined 에러! 선언된 적이 없음

}

// Hoisting
// https://developer.mozilla.org/ko/docs/Glossary/Hoisting

// 이러한 현상을 hoisting 이라 하는데
// hoisting 현상은 함수에서만 발생하는게 아니다.

// hoising 
// 아래에 있는 선언을(만) 끌어올린다.

// hoising 때문에 동작의 오류처럼 보이는 증상 겪게 됨

// hoising 현상은 처음부터 있었으나
// 용어 자체는 ES2015 및 그 이전에는 사용되지 않음

{
    console.log(`nick= ${nick}`); //1.ReferenceError: nick is not defined 2.nick= undefined => (2) hoisting 됨

    nick ='Mighty' // var를 생략해도 var와 동일한 효과 (1)
    console.log(`nick= ${nick}`);  //(1)
    var nick = '아이언맨'; //따라서 var를 명시하고 변수 선언 권장 (2)
    // (1)nick 과 (2) nick은 변수 scope이 다르다
    
}

age= 6;
age++;
console.log('1.age=', age); // age= 7

{
    console.log(`2.age = ${age}`); //age = 7 블록 바깥쪽 scope 의 변수 사용 가능.
    age= 30;
    console.log(`3.age = ${age}`); //age = 30
    // var age; // var는 hoisting 발생
    // let age; // let은 hoisting이 발생 안 한다.
}

console.log(`4.age = ${age}`); //4.age = 30



