// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
//   ..

//---------------------------------------------------------------------
// boolean 타입
// true / false
{
    const isTrue = true;
    const isFalse = false;

    console.log(`isTrue = ${isTrue}`, typeof isTrue);
    console.log(`isFalse = ${isFalse}`, typeof isFalse);

    if(isTrue){
        console.log(isTrue, '참 입니다');
        
    } else {
        console.log(isFalse, '거짓입니다');
        
    }
    // 객체 생성 가능!
    // 가능은 하지만 비추.
    const a = new Boolean(false); // false 값을 갖는 Boolean 객체
    console.log('a=',a, typeof a); //a= [Boolean: false]

    if(a) {  // <- new를 사용하여 생성하면 조건식에서 '참'으로 판정된다?!
        console.log(a, '참입니다');
        
    }   else {
        console.log(a, '거짓입니다');
        
    }
    
    // new를 사용하지 않고 boolean 만들기
    const b = Boolean(false);  // Boolean 함수 JS는 객체지향언어가 아니다. 함수가 객체의 역할을 한다
    console.log('b=', b, typeof b);
    
    if(b) {  
        console.log(b, '참입니다');
        
    }   else {
        console.log(b, '거짓입니다');
        
    }
}

//------------------------------------------------------------------------------------------------
// null
// 값이 없는 object
console.log('\n<null>');

{
    const a = null;
    console.log('a= ', a, typeof a); // null 은 object 타입
    
}

//------------------------------------------------------------------------------------------------
// undefined
// 아무 값도 대입 안 된 상태
{
    let b; // 아무값도 대입 안 된 상태, undefined
    console.log('b= ',b, typeof b);

    let a = 10;
    a = undefined; // 다시 undefined로 대입 가능
    console.log('a = ', a, typeof a); //a =  undefined undefined
    
    a = null; b=undefined;
    if(a == b){ // ==: 값이 같은지만 비교
        console.log('== 같습니다');
        
    } else{
        console.log('== 다릅니다');
        
    } // == 같습니다

    if(a===b){ // ===: 값뿐 아니라 타입까지 비교
        console.log('== 같습니다');
        
    } else{
        console.log('== 다릅니다');
    } // == 다릅니다

    // 가급적 JS 프로그래밍 작성시 == 보다 === 추천
    // != 보다 !== 추천
}

//----------------------------------------------------------------
// number
console.log('\n<number>');
{   // 실수이든 정수이든 모두 number 타입
    const a = 37;
    console.log('a= ', a, typeof a);
    const b = 3.14;
    console.log('b = ', b, typeof b);

    const c = NaN; // Not a Number
    console.log('c=', c, typeof c);

    let d = Number(123);
    console.log('d = ', d, typeof d); // number
    
    d = Number('123'); // number로 형변환 됨
    console.log('d = ', d, typeof d); // number
    
    d = Number('Mark'); 
    console.log('d = ', d, typeof d); // NaN number 타입이지만 number 아닌 값

    d= parseInt('123'); // 이 또한 number로 형변환
    console.log('d=', d, typeof d); // number
    
    d= parseInt('Alice'); // 이 또한 number로 형변환
    console.log('d=', d, typeof d); // NaN

    d=parseFloat('3.14'); // number로 형변환
    d *= 2;
    console.log('d=', d, typeof d); //d= 6.28 number
    
    d=parseInt('3.14'); 
    console.log('d=', d, typeof d); //d= 3 number 3.14 => 3으로 형변환
    
    
    d=parseFloat('300'); 
    console.log('d=', d, typeof d); // d= 300 number

    num1 = 100; num2 ='100';

    if(num1 == num2){ // ==: 값만 비교 (타입 비교하지 않음)
        console.log(`${num1} == ${num2} 같다`);
        
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    }

    if(num1 === num2){  //===: 값과 타입을 비교
        console.log(`${num1} === ${num2} 같다`);
        
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    }
    
}


// ------------------------------------------------------------------------

// String(문자열)
// '~' "~"
console.log('\n<string>');
{
    let a = 'Mark'
    console.log('a= ',a, typeof a);

    a = "Mark" // 쌍따옴표
    console.log('a= ',a, typeof a);

    // She's gone
    a = "She's gone" //'She's gone' 은 에러
    console.log('a= ',a, typeof a);

    // He says "Hello"
    a = 'He says "Hello"'
    console.log('a= ',a, typeof a);

    //He says "I'm fine"
    a = "He says \"I'm fine\"" // 이스케이프 문자(\) 사용
    console.log('a= ',a, typeof a);
    
    // + 문자열 연산
    a = "Mark"
    let b = a + "Hamill";
    console.log('b= ',b, typeof b);

    console.log(a*2); // 곱셈은 Number여야 하지만 String이 있으므로 NaN 출력

    //  문자열 비교연산 가능! 사전 순 비교
    console.log("a" > "b"); // 거짓
    console.log("a" < "b"); // 참
    console.log("abc" < "abd"); // 참
    console.log("AAaa" > "AaAa"); // 거짓 (대문자 < 소문자)
}

//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용

console.log('\n<symbol>');
{
    const a = Symbol(); // new 사용하면 안 됨. TypeError: Symbol is not a constructor
    const b = Symbol(37); // Symbol(매개변수)
    const c = Symbol('Mark');
    const d = Symbol('Mark'); // c, d는 같은 것이 아니다. // 고유한 Symbol 객체로 만들어진다.

    console.log('a= ', a, typeof a); // a=  Symbol() symbol
    console.log('b= ', b, typeof b); 
    console.log('c= ', c, typeof c); 
    console.log('d= ', d, typeof d); 

    console.log(c == d); // 거짓
    console.log(c === d); // 거짓

    // 일반 문자열
    let e='Mark', f='Mark';
    console.log(f ==e); // 참
    console.log(f ===e); // 참
    
    
    
    
}
