// email 패턴에 대한 정규표현식
var emailPat = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;


function vaildateInfo() {

    var frm = document.forms.form1;

    if(frm['name'].value.trim()==""){
        alert("※ 기본 정보 누락: 이름을 입력해주세요");
        frm['name'].focus();
        return false;
    }

    if(frm['birthday'].value.trim()==""){
        alert("※ 기본 정보 누락: 생녕월일을 입력해주세요");
        frm['birthday'].focus();
        return false;
    }

    if(frm['id'].value.trim()==""){
        alert("※ 기본 정보 누락: 아이디를 입력해주세요");
        frm['id'].focus();
        return false;
    }

    if(frm['password'].value.trim()==""){
        alert("※ 기본 정보 누락: 비밀번호를 입력해주세요");
        frm['password'].focus();
        return false;
    }

    if(frm['chkPassword'].value.trim()==""){
        alert("※ 기본 정보 누락: 비밀번호를 확인해주세요");
        frm['chkPassword'].focus();
        return false;
    }

    if(frm['password'].value.trim() !== frm['chkPassword'].value.trim()){
        alert("※ 비밀번호 불일치: 비밀번호가 일치하지 않습니다");
        frm['chkPassword'].focus();
        return false;
    }

    if(frm['email_id'].value.trim()==""){
        alert("※ 기본 정보 누락: 이메일을 입력해주세요");
        frm['email_id'].focus();
        return false;
    }

    if(frm['email_address'].value.trim()==""){
        alert("※ 기본 정보 누락: 이메일을 입력해주세요");
        frm['email_address'].focus();
        return false;
    }

    var email = frm['email_id'].value.trim()+"@"+frm['email_address'].value.trim();
    
    document.getElementById("emailwarn").innerHTML = "";

    // 매칭 여부 확인
    if(!emailPat.test(email)){
        alert("※ 이메일 형식 오류: 이메일을 확인해주세요");
        frm['email_id'].focus();
        return false;
        }
    
    return true;
}

function onlyNumber(){
    if((event.keyCode<48)||(event.keyCode>57)) event.returnValue = false;
}



