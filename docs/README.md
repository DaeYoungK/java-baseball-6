### 구현해야할 기능

1. view
   1. InputView
   - [ ] 사용자가 입력하는 기능 구현
   2. OutputView
   - [ ] 컴퓨터가 출력하는 기능 구현

2. controller
   1. GameController
   - [ ] 숫자야구 게임의 핵심 로직을 호출하는 기능 구현
   - [ ] 재시작 기능 구현

3. domain
   1. BaseballStore
   - [ ] 숫자야구 정답을 가지는 객체 구현
   2. Verifier
   - [ ] 플레이어가 입력한 번호와 정답을 비교하여 스트라이크, 볼 개수를 구하는 기능 구현
   3. Hint
   - [ ] 플레이어에게 보여줄 힌트를 만드는 기능 구현

4. validation
   1. Validator : 플레이어가 입력한 데이터 검증하는 기능 구현
   - [ ] 숫자인지 검증
   - [ ] 3자리 숫자인지 검증
   - [ ] 중복된 숫자가 있는지 검증
   - [ ] 0이 포함되어 있는지 검증

5. utility
   1. RandomNumber
   - [ ] 임의의 숫자 3개 생성하는 기능 구현
   2. Retry
   - [ ] 입력 재시도 기능 구현
