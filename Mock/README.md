# Mock

[Mocks Aren't Stubs](https://www.martinfowler.com/articles/mocksArentStubs.html)

[TestDouble](https://www.martinfowler.com/bliki/TestDouble.html#:~:text=Test%20Double%20is%20a%20generic,used%20to%20fill%20parameter%20lists)



#### Mock 용어 정리

Mock - 테스트 **대상의 내부의 동작 행위까지 어떠한가**를 확인하고 싶을 때 사용 
mock이 stub과 같은 역할을 해주기도 한다.

- objects pre-programmed with expectations which form a specification of the calls they are expected to receive

Dummy - 

- Dummy objects are passed around but never actually used. Usually they are just used to fill parameter lists

Fake - 동작하도록 구현하였지만 실제로는 동일하지 않은 객체

- Fake objects actually have working implementations, but usually take some shortcut which makes them not suitable for production ( an in memory database is a good example)

Stubs - 테스트 대상이 처리하는 결과, 즉 **상태를 테스트할 때** 도움을 주기 위함

- Stubs provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test

Spy - stub의 역할을 가지면서 호출된 내용에 대해 약간의 정보

- Spies are stubs that also record some information based on how they were called.

  One form of this might be an email service that records how many messages it was sent

Double - 스턴트 더블(스턴트 대역 배우)에서 아이디어를 얻어서 만든 용어

테스트 더블은 의존 구성요소를 사용할 수 없을 때 테스트 대상 코드와 상호작용 하는 객체이다.



stub message가 보내지면 된다. 기능 처리만 확인

mock 정상적인 사람에게 전달 되었는지 확인



**Choosing Between the Differences** 

classic TDD 는 실제 데이터를 이용 mockist 는 mock을 이용 상황에 맞춰서 적절하게 사용할 수 있어야한다.



