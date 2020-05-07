var str1, str2, str3;

str1 = "John";
str2 = new String("John"); // 비추

console.log(str1);
console.log(str2);
console.log(str2.toString());

console.log(str1 == str2); // 참
console.log(str1 === str2); // 거짓

console.log(str1.length); // 문자의 개수

str2 = "Hello Java Web FrameWork";
console.log(str2);
// 문자열 리터럴 중간을 끊어서 작성할 경우..
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);

// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 \nindexOf(), lastIndexOf(), search()");
str1 = "Please locate where 'locate' occurs!";
console.log(str1.indexOf("locate")); // 7번째 위치
console.log(str1.lastIndexOf("locate")); // 21번째 위치 (마지막 문자열 위치)
console.log(str1.lastIndexOf("John")); // 문자열이 없으면 -1 리턴
console.log(str1.indexOf("locate", 10)); // 10번째부터 검색 시작 21
console.log(str1.indexOf("locate", 25)); // -1

//search(): 문자열 안에서 문자열 찾기
console.log(str1.search('locate')); // 7

// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다 (정규표현식 사용 가능. 특정패턴 찾을 수 있음)
// 	indexOf() : regexp 사용 불가

//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)
console.log("문자열 추출 \nslice(), substring(), substr()");
str1 = "Apple, Banana, Kiwi";
console.log(str1.slice(7,13)); // 7부터 13전까지
console.log(str1.slice(-12,-6)); // 음수 인덱싱 가능(맨 오른쪽이 -1)
console.log(str1.slice(7)); // 7부터 끝까지
console.log(str1.slice(-12)); // -12부터 끝까지

console.log(str1.substring(7,13)); // slice()와 유사하나 음수인덱싱은 없음
console.log(str1.substring(7)); // 7부터 끝까지

console.log(str1.substr(7, 6)); // 7부터 6글자
console.log(str1.substr(7)); // 7부터 끝까지


// 문자열 치환
// replace() : 치환한 결과 문자열 리턴, 정규표현식 사용 가능
// 기본적으로 첫번째 '매칭된 문자열 만 치환
console.log("문자열 치환 replace()");
str1 = "Please visit Japan!";

console.log(str1.replace("Japan", "Korea")); // 원본 str1 변경 안함.
console.log(str1.replace("JAPAN", "Korea")); // 대소문자 구분 //Please visit Japan!
console.log(str1.replace(/JAPAN/i, "Korea")); // 정규표현식 대소문자 구분없이 치환(/~/i) // Please visit Korea!

str2 = "Please visit Japan! Go Japan";
console.log(str2.replace("Japan", "Korea")); //Please visit Korea! Go Japan // 기본적으로 첫번째만 치환됨.
console.log(str2.replace(/Japan/g, "Korea")); // 정규표현식 global match (/~/g) //Please visit Korea! Go Korea

str3 = "Hello World!";
console.log(str3.toUpperCase()); //대문자 변환
console.log(str3.toLowerCase()); //소문자 변환

str1 = "Hello"; str2 = "World";
console.log(str1 + " " + str2);
console.log(str1.concat(" ", str2));

// trim(): 좌우 공백 제거 (사용 빈도 높음)
str1 = "            Hello World!      "
console.log(`str1 = [${str1}]`); // 좌우 공백 포함
str2 = str1.trim();
console.log(`str2= [${str2}]`); 

// split(): String -- > array
str3 = "2020-05-07";
console.log(str3.split("-"));

























