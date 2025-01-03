package me.hwangjisun.springbootdeveloper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
    1.스프링 부트 3 구조 살펴보기
        각 계층이 양 옆의 계층고 통신하는 구조
        계층 : 각자의 역할과 책임이 있는 어떤 소프트웨어의 구성 요소
            -> 각 계층은 고통할 수는 있지만 다른 계층에 직접 간섭하거나 영향을 미치진 않음

        ex) 카페와 빵집
            카페에서는 커피를 팔고, 빵집에서는 빵을 파는데, 필요한 경우 서로 협업 관계를 맺어
            어떤 손님이 커피를 사면 빵을 할인해 줄 수는 있음 -> 계층 간 소통
            그런데 빵집 점원이 커피를 서빙해줄 수는 없음

        스프링 부트에서의 계층
            1) 프레젠테이션(Presentation)
                HTTP 요청을 받고 이 요청을 비지니스 계층으로 전송하는 역할 -> Controlloer가
                    프레젠테이션 계층 역할
                TestControlloer 클래스와 같은 것을 의미하며 스프링 부트 내에 여러 개가 있을 수 있음

            2) 비지니스(Business)
                모든 비지니스 로직 : 서비스를 만들기 위한 로직을 의미하며, 웹 사이트에서 벌어지는
                    모든 작업 -> 주문 서비스라고 한다면 주문 개수, 가겨 등의 데이터를 처리하기
                    위한 로직, 주문 처리를 하다가 발생하는 예외 처리 로직, 주문을 받거나 취소하는
                    등 프로세스를 구현하기 위한 로직 등을 위미
                서비스가 비지니스 계층의 역할을 함

            3) 퍼시스턴스(Persistence)
                모든 데이터베이스 관련 로직을 처리. 이 과정에서 데이터베이스에 접근하는
                DAO(추후 수업 예정) 객체를 사용할 '수도' 있음.
                    * DAO - 데이터베이스 계층과 상호작용하기 위한 객체라고 이해하면 편리합니다. 일단은
                    -> Repository가 퍼시스턴스 계층의 역할을 함
             계층을 개념의 영역이고 Controlloer, Service, Repository는 실제 구현을 위한 영역
              -> 추후 수업(아마 목요일) 예정입니다
         스프링 부트 프로젝트 디렉토리 구성
            : 스프링 부트에는 정해진 구조가 없지만, 추천 프로젝트 구조가 있고, 이를 많은 개발자들이 따르므로
                수업 시에도 해당 구조를 따라 개발할 예정.

                main : 실제 코드를 작성하는 공간, 프로젝트 실행에 필요한 소스 코드나 리소스 파일은
                    모우 이 폴더 안에 들어있음 (프로젝트 생성시 자동 구현됨)
                test : 프로젝트의 소스 코드를 테스트할 목적의 코드나 리소스 파일이 들어있음
                    (원래는 자동생성되는데 어제 제가 만들었을 때 안만들어지는 걸로 보아 설정 따라
                    다른듯합니다.)
                build.gradle : 빌드를 설정하는 파일. 의존성이나 플러그인 설정과 같이 빌드에 필요한
                    설정을 할 때 사용
                setting.gradle : 빌드할 프로젝트의 정보를 설정하는 파일

                지시 사항
                main 디렉토리 구성하기
                    : main 디렉토리 내에 java와 resources로 구성돼 있음. 여기에 아직 추가하지 못했던
                        스프링 부트 프로젝트의 구성 요소를 추가합니다.
                    01 단계 - HTML과 같은 뷰 관련 파일(chapter07에서 수업 예정)을 넣을 templates 디렉토리 생성
                        resources 우클릭 -> new directory -> templates
                    02 단계 - static 디렉토리 JS, CSS, 이미지와 같은 정적 파일을 넣는 용도로 사용
                        -> 이미 만들었으므로 생략합니다.
                    03 단계 - 스프링 부트 설정을 할 수 있는 application.yml 파일을 생성
                        -> 해당 파일은 스프링 부트 서버가 실행되면 자동으로 로딩되는 파일로,
                        데이터베이스의 설정 저보, 로깅 설정 정보 등이 들어갈 수도 있고, 직접 정의할 때
                        사용하기도 함. 앞으로 프로젝트를 진행하며 자주 사용할 파일입니다.
                        resources 우클릭 -> new file -> application.yml

    2. 스프링 부트 3 프로젝트 발전시키기

        각 계층의 코드를 추가할 예정 -> 이를 통해 계층이 무엇이고, 스프링 부트에서는 계층을 어떻게
            나누는지를 감을 잡아나가실 수 있도록 수업하겠습니다.(목요일에 이루어질 예정)
        지금은 의존성을 추가한 다음에 -> 프레젠테이션 계층, 비니지스 계층, 퍼시스턴스 계층 순서로
            코드를 추가할 예정입니다.

        build.gradle 파일로 이동하세요.

        의존성 주입 끝나고 작성하는 부분입니다.

        아직은 의존성이 무슨 역할을 하는지 몰라도 괜찮습니다.

        implementation : 프로젝트 코드가 컴파일 시점과 런타임에 모두 해당 라이브러리를 필요로 할 때 사용
        testImplementation : 프로젝트의 테스트 모드를 컴파일하고 실행할 때만 필요한 의존성 설정
            테스트 코드에서만 사용, 메인 애플리케이션에서는 사용하지 않음
        runtimeOnly : 런타임에만 필요한 의존성을 지정, 컴파일 시에는 필요하지 않지만,
            애플리케이션을 실행할 때 필요한 라이브러리 설정
        complieOnly : 컴파일 시에만 필요, 런타임에는 포함되지 않아야 하는 의존성 지정
        annotationProcessor : 컴파일 시에 애너테이션을 처리할 때 사용하는 도구의 의존성 지정

    지시 사항
        프레젠테이션, 서비스, 퍼시스턴스 계층 만들기

            1. 프레젠테이션 계층에 속하는 컨트롤러 관련 코드를 작성 -> TestController가 있으므로 생략
            2. 비지니스 계층 코드 -> TestController와 같은 위치에 TestService.java 생성하세요.
            3. 퍼시스턴스 계층 코드 작성 -> 같은 위치에 Member.java 생성하세요 -> 실제 DB에 접근하는 코드 작성
            4. 매핑 작업에는 '인터페이스' 파일이 필요. MemberRepository 인터페이스를 같은 위치에 생성하세요.


        작동을 확인해보겠습니다.

 */
/*
5장. '데이터베이스' 조작이 편해지는 'ORM'
    1. 데이터베이스(database)란?
        데이터를 효율적으로 보관하고 꺼내볼 수 있는 곳.

        DBMS(DataBase Management System) : 기본적으로 데이터베이스는 많은 사람이 공유할 수 있어야 하고,
            동시 접근이 가능해야 하는 등 많은 요구 사항이 존재함.
                이를 만족시키면서도 효율적으로 데이터베이스를 관리하는 체계가 DBMS.
                대부분 개발자들이 편하게 DB라고 이야기하는 MySQL, Oracle, DBeaver와 같은 것들은
                실제로는 DB가 아니라 DBMS에 해당.

            관계형 DBMS
                Relational DBMS를 줄여서 RDBMS라고 부름. 테이블 형태로 이루어진 데이터 저장소.
                RDBMS는 테이블('표'를 의미) 형태로 이루어진 데이터 저장소로, 예를 들어
                이하오 같은 회원 테이블이 있다고 가정할 때,
                각 행은 고유의 키(PK), 즉 ID를 가지고 있고, 이메일, 나이와 같은 회원과
                관련된 값들이 들어감(Java를 기준으로는 User 클래스의 인스턴스를 떠올리면 됩니다.)
                
               회원 테이블
                1열           2열           3열
               +----------------------------------+
               | ID         | 이메일       | 나이  | - header / column
               ------------------------------------
               | 1          | a@test.com  | 10    | - 1행
               | 2          | b@test.com  | 20    | - 2행
               | 3          | c@test.com  | 30    | - 3행
               +----------------------------------+
               
                기본키(PK) :
                Prime Key
                
            H2, MySQL
                해당 수업에서 사용할 RDMBS는 H2, MySQL\
                H2 - 자바로 작성되어 있는 RDMS : 스프링 부트가 지원하는 인메모리 관계형 데이터베이스
                     데이터를 다른 공간에 따로 보관하는 것이 아니라 애플리케이션 자체 내부에 데이터를 저장하는 특징
                     그래서 애플리케이션 재실행시 데이터는 초기화됨(서버 재실행을 기준으로).
                     간편하게 사용하기 좋아서 테스트용도로 자주 사용됨.
                     실제 서비스에서는 사용하지 않습니다.
                MySQL - 실제 서비스로 올릴 때 사용할 RDBMS - 추후 수업 예정
                
            필수 용여
                1) 테이블 : DB에서 데이터를 구성하기 위한 가장 기본적인 단위 행과 열로 구성되며
                    '행'은 여러 속성으로 이루어져있습니다.
                2) 행(row) : 테이블의 구성 요소 중 하나이며 테이블의 가로로 배열도니 데이터의 집합을 의미
                    행은 반드시 고유한 식별자인 기본키(PK)를 가짐. 행을 레코드(Record)라고 부르기도 함.
                3) 열(column) : 테이블의 구성 요소 중 하나이며, 행에 저장되는 유형의 데이터.
                    예를 들어 회원 테이블이 있다고 할 때, 열은 각 요소에 대한 속성을 나타내며 (Java에서는 field),
                    무경성을 보장함. 이상의 표를 기준으로 할 때는, 이메일은 문자열일 것, 나이는 숫자 유형을 가짐.
                    이메일 열에 숫자가 들어가거나, 나이 열에 문자열이 들어갈 수 없기 때문에 데이터에 대한 무결성을 보장.
                4) 기본키(Primary Key) : 행을 구분할 수 있는 식별자. 이 값은 테이블에서 유일해야 하며 '중복값을 가질 수 없음'
                    보통 데이터를 수정하거나 삭제하고, 조회할 때 사용되며 다른 테이블과 관계를 맺어 데이터를 가져올 수도 있음 (join개념)
                    또한 기본키의 값은 수정되어서는 안 되며 유효한 값이어야 함. 즉 NULL이 될 수 없음
                        -> 이전 수업에서 nullable = false
                5) 쿼리(query) : 데이터베이스에서 데이터를 조회하거나 삭제, 생성, 수정과 같은 처리를 하기 위해 사용하는 명령문
                    SQL이라는 데이터베이스 전용 언어를 사용하여 작성함.
                    
                    SQL(Structured Query Language) : 구조화된 질의 언어

    2. ORM이란?
        Object-Relational Mapping이라고 하며 자바의 객체와 데이터베이스를 연결하는 프로그래밍 기법
            예를 들어 데이터베이스에 age, name 컬럼에 20, 홍길동이라는 값이 있다고 가정했을 때, 이것을 자바에서 사용하려면
            SQL을 이용하여 데이터를 꺼내 사용하지만, ORM이 있다면 데이터베이스의 값을 마치 객체처럼 사용할 수 있음.
            즉, SQL에 어려움을 겪는다고 하더라도 자바 언어로만 데이터베이스에 접근해서 원하는 데이터를 받아올 수 있는 방식.
            즉, 객체와 데이터베이스를 연결해 자바 언어로만 데이터베이스를 다룰 수 있도록 하는 도구는 ORM이라고 함.

        장점 :
            1) SQL을 직접 작성하지 않고 사용하는 언어(여기서는 Java)로 데이터베이스에 접근 가능
            2) 객체지향적으로 코드를 작성할 수 있기 때문에 비지니스 로직에만 집중 가능
            3) 데이터베이스 시스템이 추상화되어있기 때문에 MySQL에서 PostgreSQL로 전환을 하더라도 추가로 드는 작업이 거의 없음.
            4) 매핑하는 정보가 명확하기 때문에(DB 값과 인스턴스 변수의 값), ERD에 대한 의존도를 낮출 수 있고 유지보수시 유리

        단점 :
            1) 프로젝트의 복잡성이 커질수록 사용 난이도가 올라감.
            2) 복잡하고 무거원 쿼리는 ORM으로 해결이 불가능한 경우가 있음. (join이 여러 번 들어가거나 / 서브쿼리가 복잡한 경우)

    스프링 데이터 JPA에서 제공하는 메서드 사용
        MemberRepository.java 파일에서 create test 해주세요.


                
 */




@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
