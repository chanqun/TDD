# TDD



### 테스트의 원칙!!!

각각의 테스트는 서로 영향을 주면 안 된다.
a->b 성공 but b->a 실패? 테스트라고 할 수 없다.
(테스트에서 외부 서비스를 사용한다면? 외부 서비스 죽음, api 서버 에러 ==> 항상 결과는 동일해야한다.)

추가적으로 위의 테스트를 가능하게 해주는 테스트 기법을 익히고 장단점을 파악해야한다.